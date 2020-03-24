package com.sinosoft.cses.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.swing.JTextArea;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.sinosoft.master.controller.ExecutionController;
import com.sinosoft.master.entity.Execution;

public class QuartzThread implements Runnable{
	private String[] ids =null;
	private Map<String,String> map = new HashMap<>();
	//日志打印对象
	private JTextArea textArea_1 = null;
	//地区中文
	String area ="";
	//配置文件读取
	public Properties prop = AppCache.prop;
	@Autowired
	ExecutionController executController = ApplicationContextProvider.getBean(ExecutionController.class);
	@Override
	public void run() {
		AppCache appCache =new AppCache();
		int id =0;
		//不同业务场景串行
		for(int i =0;i<ids.length;i++){
			List<Execution> executions =AppCache.executions;
			for(int k=0;k<executions.size();k++){
        		Execution execution = executions.get(k);
        		if(execution.getName().equals(ids[i])){
        			id = execution.getId();
        		}
        	}
			//用户名密码添加
			map.put("<USER>", prop.getProperty(area+".username"));
			map.put("<PASSWORD>", prop.getProperty(area+".password"));
			//需要从配置文件中读取并修改的字段
			String configFields = prop.getProperty(area+".carInfo"); 
			if(!configFields.isEmpty()){
				String[] fileds =configFields.split(",");
				for(int h =0;h<fileds.length;h++){
					map.put("<"+fileds[i]+">", prop.getProperty(area+"."+id+"."+fileds[i]));
				}
			}
        	
			executController.doExecution(id, area, textArea_1, 1, map);
		}
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	public JTextArea getTextArea_1() {
		return textArea_1;
	}
	public void setTextArea_1(JTextArea textArea_1) {
		this.textArea_1 = textArea_1;
	}
	
	public String[] getId() {
		return ids;
	}
	public void setId(String[] id) {
		this.ids = id;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	
}
