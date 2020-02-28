package com.sinosoft.master.controller;

import java.util.Date;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import com.sinosoft.cses.util.AppCache;
import com.sinosoft.cses.util.BusinessFun;
import com.sinosoft.cses.util.DateUtils;
import com.sinosoft.master.entity.Execution;
import com.sinosoft.master.entity.Interfaces;
import com.sinosoft.master.response.Response;
import com.sinosoft.master.service.ExecutionService;
import com.sinosoft.master.service.InterfacesService;
import com.sinosoft.master.service.specification.SimpleSpecificationBuilder;
import com.sinosoft.master.service.specification.SpecificationOperator.Operator;

@Controller
public class ExecutionController {
	
	/** 日志*/
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ExecutionService executionService;
	
	@Autowired
	private InterfacesService intefacerService;
	
	@Autowired
	private AppCache appCache;
	
	@Autowired
	private BusinessFun businessFun;
	
	/**
	 * 返回业务流程的集合
	 * @param list
	 * @return
	 */
	public String[] ExecutionsToObject(List<Execution> list){
		try {
			String[] objects = new String[list.size()-1];
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
	 * @param id
	 * 
	 */
	public void del(Integer id) {
		try {
			executionService.delete(id);
		} catch (Exception e) {
			logger.info("业务数据删除失败");
		}
		//初始化缓存
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
		//初始化缓存
		appCache.initExceution();
	}
	
	/**
	 * 执行业务场景
	 * @param textArea2 
	 * @param executionList
	 */
	public void doExecution(Integer id, String area, JTextArea textArea2) {
		try {
			//清空数据
			textArea2.setText("");
			Execution execution = executionService.find(id);
			//判断当前业务场景需要执行那些接口
			String orders = execution.getOrders();
			String areaCode = AppCache.areaEng.get(area);
			
			String[] interfaces = orders.split(",");
			for (String string : interfaces) {
				//根据业务id查询接口
				
				
				SimpleSpecificationBuilder<Interfaces> builder = new SimpleSpecificationBuilder<Interfaces>();
					builder.add("bussiness_desc", Operator.eq.name(), string);
				List<Interfaces> page = intefacerService.findAll(builder.generateSpecification());
				
				Interfaces interfac = page.get(0);
//				Interfaces interfac = intefacerService.find(Integer.valueOf(string));
				String xml = businessFun.readFile(interfac.getXmlName());
				//进行第一步处理
				xml = businessFun.firstXmlHandle(xml, areaCode);
				//设置自动换行
				textArea2.setLineWrap(true);
				//根据全局变量对变量进行处理
				textArea2.append("开始执行 " + interfac.getBussiness_desc() + "    \b\n");
				textArea2.append("执行时间开始时间 " + DateUtils.toString(new Date(), DateUtils.YYYYMMDDDETAIL) + " \b\n");
				textArea2.append(" \b\n");
				Response s = businessFun.doPost(interfac.getUrl(), xml, new StringBuffer());
				System.out.println();
				
				
				
				
			}
			
			
			//初始化缓存
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		appCache.initExceution();
	}

}

