package com.sinosoft.master.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sinosoft.cses.util.AppCache;
import com.sinosoft.master.entity.GlobalVariable;
import com.sinosoft.master.service.GlobalVariableService;

@Controller
public class GlobalVariableController {
	
	/** 日志*/
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private GlobalVariableService globalVariableService;
	
	@Autowired
	private AppCache appCache;
	
	/**
	 * 此方法， hashmap转化为objects 
	 * @param map
	 * @author xujian
	 * @Date 2020-02-04
	 * @return
	 */
	public Object[][] mapToObject(Map<String, String> map){
		
		try {
			Object[][] objects = new Object[map.size()][2];
			int i = 0;
			for (String key : map.keySet()) {
				objects[i][0] = key;
				objects[i][1] = map.get(key);
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
	 * 此方法为获取新增的全局变量值，然后存入数据库中
	 * @param table
	 * @param list
	 * @return
	 * @author xujian
	 * @Data 2020-02-06
	 */
	public void saveGlobalVariable(HashMap<String, String> map) {
		try {
			for (String key : map.keySet()) {
				
				GlobalVariable global = new GlobalVariable();
				global.setVariable_code(key);
				global.setVariable_name(map.get(key));
				globalVariableService.replave(global);
				
			}
		} catch (Exception e) {
			logger.info("全局变量保存失败");
		}
		//刷新缓存
		appCache.initGlobalVariable();
		
//		interfacesController.interfacesListToObject(4);
		
	}
	
	
	/**
	 * 此方法保存单个全局变量
	 * @param table
	 * @param list
	 * @return
	 * @author xujian
	 * @Data 2020-02-06
	 */
	public void save(GlobalVariable global) {
		try {
			globalVariableService.save(global);
		} catch (Exception e) {
			logger.info("全局变量保存失败");
		}
		//刷新缓存
		appCache.initGlobalVariable();
		
//		interfacesController.interfacesListToObject(4);
		
	}
	
	/**
	 * 删除全局变量数据
	 * @param key
	 * @author xujian
	 * @date 2020-02-06
	 */
	public void deleteGlobalVariable(String key) {
		try {
			globalVariableService.delete(key);
		} catch (Exception e) {
			logger.info("删除失败， 该数据可能不存在");
		}
		
		//刷新缓存
		appCache.initGlobalVariable();
	}
	

}
