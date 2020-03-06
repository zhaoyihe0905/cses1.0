package com.sinosoft.master.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
				objects[i] = key.getProcess();
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
				objects[i][0] = key.getProcess();
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
	public void doExecution(Integer id, String area, JTextArea textArea2, Integer identification) {

		
		//判断是不是定时
		if (identification == 0) {
			// 获得当前的拼音
			try {
				//获得全局变量的map,区分是定时还是非定时的全局变量
				Map<String, String> map = new HashMap<>();
				for (String key : AppCache.globalVariable.keySet()) {
					if (!key.endsWith("*")) {
						map.put(key, AppCache.globalVariable.get(key));
					}
				}
				
				String pinyin = ChineseCharacterUtil.convertHanzi2Pinyin(area, true);
				Logger logger = LoggerFactory.getLogger(pinyin);
				// 清空数据
				textArea2.setText("");
				Execution execution = executionService.find(id);
				// 判断当前业务场景需要执行那些接口
				String orders = execution.getOrders();
				String areaCode = AppCache.areaEng.get(area);

				String[] interfaces = orders.split(",");
				for (String string : interfaces) {
					// 根据业务id查询接口

					SimpleSpecificationBuilder<Interfaces> builder = new SimpleSpecificationBuilder<Interfaces>();
					builder.add("bussiness_desc", Operator.eq.name(), string);
					List<Interfaces> page = intefacerService.findAll(builder.generateSpecification());

					Interfaces interfac = page.get(0);

					String xml = businessFun.readFile(interfac.getXmlName()).trim();

//					//进行第一步处理
//					xml = businessFun.firstXmlHandle(xml, areaCode);
					// 进行第二部处理， 和全局变量进行替换

					xml = businessFun.SecondXmlHandle(xml, interfac, map);

					// 设置自动换行
					textArea2.setLineWrap(true);
					// 根据全局变量对变量进行处理
					textArea2.append("开始执行 " + interfac.getBussiness_desc() + "    \n");
					textArea2.append("执行时间开始时间 " + DateUtils.toString(new Date(), DateUtils.YYYYMMDDDETAIL) + " \b\n");
					logger.info("开始执行 " + interfac.getBussiness_desc());
					logger.info("执行时间开始时间 " + DateUtils.toString(new Date(), DateUtils.YYYYMMDDDETAIL));

					// 系统访问路劲的处理
					String url = appCache.getParameterStringValue(SystemConfig.URL, areaCode).trim();
					url = interfac.getUrl().replaceAll("localhost", url).trim();
					System.out.println("---" + url + "----");
					logger.info("访问路劲是" + url);
					logger.info("请求报文 ：" + xml);
					Response s = businessFun.doPost(url, xml, new StringBuffer());

					// 获得返回报文
					String resXml = s.getResXml();
					logger.info("返回报文" + resXml);

					// 第三步处理 把返回报文中的业务字段存放到全局变量中
					businessFun.thirdXmlHandle(resXml, interfac, map);

					// 标识码
					String gidentification = businessFun.getTagValue(resXml, interfac.getIdentification());

					textArea2.append("该接口标识码:" + interfac.getIdentification() + ":" + gidentification + "\b\n");
					textArea2.append("返回报文 " + resXml +" \b\n");
					logger.info("执行时间开始时间 " + DateUtils.toString(new Date(), DateUtils.YYYYMMDDDETAIL));
					textArea2.append("接口响应时间" + s.getResponseTime() + " \b\n");
					logger.info("接口响应时间" + s.getResponseTime() + " \b\n");
					textArea2.append(" \b\n");

				}

				// 初始化缓存
			} catch (Exception e) {
				// TODO Auto-generated catch block
				textArea2.append("接口访问失败" + e.getMessage());
			}

			//假设是定时
		}else {
			
		}
	}

}
