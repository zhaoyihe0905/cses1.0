package com.sinosoft.master.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import com.sinosoft.cses.util.AppCache;
import com.sinosoft.cses.util.AppConst;
import com.sinosoft.cses.util.BusinessFun;
import com.sinosoft.cses.util.ChineseCharacterUtil;
import com.sinosoft.cses.util.DateUtils;
import com.sinosoft.cses.util.SystemConfig;
import com.sinosoft.master.entity.CsesLog;
import com.sinosoft.master.entity.Execution;
import com.sinosoft.master.entity.Interfaces;
import com.sinosoft.master.response.Response;
import com.sinosoft.master.service.CsesLogService;
import com.sinosoft.master.service.ExecutionService;
import com.sinosoft.master.service.InterfacesService;
import com.sinosoft.master.service.specification.SimpleSpecificationBuilder;
import com.sinosoft.master.service.specification.SpecificationOperator.Operator;

@Controller
public class ExecutionController {

	/** 日志 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ExecutionService executionService;

	@Autowired
	private InterfacesService intefacerService;

	@Autowired
	private AppCache appCache;

	@Autowired
	private BusinessFun businessFun;

	@Autowired
	private CsesLogService csesLogService;

	/**
	 * 返回业务流程的集合
	 * 
	 * @param list
	 * @return
	 */
	public String[] ExecutionsToObject(List<Execution> list) {
		try {
			String[] objects = new String[list.size() - 1];
			int i = 0;
			for (Execution key : list) {
				objects[i] = key.getName();
				i++;
			}
			return objects;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("返回业务流程数组错误");
		}

		return null;
	}

	/**
	 * 删除业务场景
	 * 
	 * @param id
	 * 
	 */
	public void del(Integer id) {
		try {
			executionService.delete(id);
		} catch (Exception e) {
			logger.info("业务数据删除失败");
		}
		// 初始化缓存
		appCache.initExceution();
	}

	public Object[][] selectExecution(int column) {
		List<Execution> interfaces = AppCache.executions;
		try {
			Object[][] objects = new Object[interfaces.size()][column];
			int i = 0;
			for (Execution key : interfaces) {
				objects[i][0] = key.getName();
				objects[i][1] = key.getOrders();
				objects[i][2] = key.getId();
				i++;
			}
			return objects;
		} catch (Exception e) {
			logger.info("接口列表数据展现失败");
		}

		return null;
	}

	public void saveExecution(List<Execution> executionList) {
		for (Execution execution : executionList) {
			executionService.replace(execution);
		}
		// 初始化缓存
		appCache.initExceution();
	}

	/**
	 * 
	 * @param id             业务场景id、
	 * @param area           地区 中文 如 （四川）
	 * @param textArea2      日志对象
	 * @param identification 定时标识： 0 非定时 1 定时
	 * @param map            全局变量map
	 */
	public void doExecution(Integer id, String area, JTextArea textArea2, Integer identification, Map<String, String> map) {

		
		//判断是不是定时
			// 获得当前的拼音
			try {
				
				String uuid = UUID.randomUUID().toString().replaceAll("-","");
				String pinyin = ChineseCharacterUtil.convertHanzi2Pinyin(area, true);
				Logger logger = LoggerFactory.getLogger(pinyin);
				// 清空数据
				textArea2.setText("");
				Execution execution = executionService.find(id);
				// 判断当前业务场景需要执行那些接口
				String orders = execution.getOrders();
				String areaCode = AppCache.areaEng.get(area);

				textArea2.append("当前业务场景是" + execution.getName() + " \n");
				textArea2.append("当前地区是" + area + ":" + areaCode + " \n");
				textArea2.append("当前业务场景的uuid是" + uuid + " \n");
				textArea2.append(" \n");
				textArea2.append(" \n");
				
				logger.info("当前业务场景是" + execution.getName());
				logger.info("当前地区是" + area + ":" + areaCode );
				logger.info("当前业务场景的uuid是" + uuid );
				
				String[] interfaces = orders.split(",");
				for (String string : interfaces) {
					// 根据业务id查询接口

					SimpleSpecificationBuilder<Interfaces> builder = new SimpleSpecificationBuilder<Interfaces>();
					builder.add("name", Operator.eq.name(), string);
					List<Interfaces> page = intefacerService.findAll(builder.generateSpecification());

					Interfaces interfac = page.get(0);

					String xml = businessFun.readFile(interfac.getXmlName()).trim();

//					//进行第一步处理
//					xml = businessFun.firstXmlHandle(xml, areaCode);
					// 进行第二部处理， 和全局变量进行替换

					xml = businessFun.SecondXmlHandle(xml, interfac, map,logger);

					// 设置自动换行
					textArea2.setLineWrap(true);
					// 根据全局变量对变量进行处理
					textArea2.append("开始执行 " + interfac.getName() + "    \n");
					textArea2.append("执行时间开始时间 " + DateUtils.toString(new Date(), DateUtils.YYYYMMDDDETAIL) + " \n");
					logger.info("开始执行 " + interfac.getName());
					logger.info("执行时间开始时间 " + DateUtils.toString(new Date(), DateUtils.YYYYMMDDDETAIL));

					// 系统访问路劲的处理
//					String url = appCache.getParameterStringValue(SystemConfig.URL, areaCode).trim();
//					url = interfac.getUrl().replaceAll("localhost:8080", url).trim();
					String url = interfac.getUrl().trim();
//					System.out.println("---" + url + "----");
					logger.info("访问路劲是" + url);
					logger.info("请求报文 ：" + xml);
					Response res = businessFun.doPost(url, xml, new StringBuffer());

					//标识码
					String gidentification = "";
					//返货错误代码
					String judgeValue = "";
					//判断访问是否成功
					if (res.getResult() == 1) {
					// 获得返回报文
					String resXml = res.getResXml();
					logger.info("返回报文" + resXml);

					// 第三步处理 把返回报文中的业务字段存放到全局变量中
					businessFun.thirdXmlHandle(resXml, interfac, map);

					// 标识码
					 gidentification = businessFun.getTagValue(resXml, interfac.getIdentification());
					
				
						//业务错误代吗
						String[] judeCode = interfac.getJudgecode().split("-");
						 judgeValue = businessFun.getTagValue(resXml, judeCode[0]);
						if (!judgeValue.equals( judeCode[1])) {
							res.setResult(0); 
							res.setResMessage("接口业务上访问失败，错误代码是：" + judgeValue);
						} 
					textArea2.append("该接口标识码:" + interfac.getIdentification() + ":" + gidentification + "\n");
					textArea2.append("接口响应时间" + res.getResponseTime() + "毫秒  \n");
					textArea2.append("返回报文 " + resXml +" \n");
					textArea2.append("接口直接结束时间 " + DateUtils.toString(new Date(), DateUtils.YYYYMMDDDETAIL));
					
					logger.info("该接口标识码:" + interfac.getIdentification() + ":" + gidentification );
					logger.info("执行时间结束时间时间 " + DateUtils.toString(new Date(), DateUtils.YYYYMMDDDETAIL));
					logger.info("接口响应时间" + res.getResponseTime() + " 毫秒 \n");
					textArea2.append(" \n");
					textArea2.append(" \n");
					}else {
						textArea2.append("该接口访问失败 ，错误信息是 " + res.getResMessage() + " \n");
						logger.info("该接口访问失败 ，错误信息是 " + res.getResMessage());
					}
					
					
					
					
					//返回信息日志存库
					CsesLog  csesLog = new CsesLog();
					//标识码
					csesLog.setIdentification(gidentification);
					//响应时间
					csesLog.setResponseTime(res.getResponseTime());
					//接口结束时间
					csesLog.setReqEndTime(res.getStopTime());
					//开始时间
					csesLog.setReqStartTime(res.getStartTime());
					//接口名
					csesLog.setReqServiceName(interfac.getName());
					//返回信息
					csesLog.setResInfo(res.getResMessage());
					// 返回的错误代码如 （42510）
					csesLog.setJudgeCode(judgeValue);
					//返回状态 物理方面
					csesLog.setResult(res.getResult());
					//标识码类型
					csesLog.setIdentificationType(interfac.getIdentification());
					//业务场景uuid
					csesLog.setExecuteUUID(uuid);
					//业务场景名字
					csesLog.setExecuteName(execution.getName());
					//地区代码
					csesLog.setAreaCode(areaCode);
					//是否定时执行
					csesLog.setIsQuartz(identification);
					csesLogService.save(csesLog);
					
					//假设接口访问失败， 那就抛出异常
					if (res.getResult() == 0) {
						throw new Exception(res.getResMessage());
					}

				}

				// 初始化缓存
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				textArea2.append("接口访问失败" + e.getMessage().toString()+"\n");
				logger.info("接口访问失败:" + e.getMessage());
			}

			//假设是定时
	}

}
