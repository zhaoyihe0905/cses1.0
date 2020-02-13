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
	public Object[][] ExecutionsToObject(List<Execution> list){
		try {
			Object[][] objects = new Object[list.size()][];
			int i = 0;
			for (Execution key : list) {
				objects[i][0] = key.getProcess();
				i++;
			}
			return objects;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		appCache.initInterface();
	}
	
	
	
}

