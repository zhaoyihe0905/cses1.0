package com.sinosoft.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sinosoft.cses.util.AppCache;
import com.sinosoft.master.entity.Execution;
import com.sinosoft.master.service.ExecutionService;

@Controller
public class ExecutionController {
	
	/** 日志*/
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ExecutionService executionService;
	
	@Autowired
	private AppCache appCache;
	
	
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
			logger.info("接口数据删除失败");
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
				objects[i][1] = key.getId();
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

}

