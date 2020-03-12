package com.sinosoft.cses.util;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextArea;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.sinosoft.master.controller.ExecutionController;

public class QuartzThread implements Runnable{
	private Integer id =null;
	private Map<String,String> map = new HashMap<>();
	//日志打印对象
	private JTextArea textArea_1 = null;
	//地区中文
	String area ="";
	@Autowired
	ExecutionController executController = ApplicationContextProvider.getBean(ExecutionController.class);
	@Override
	public void run() {
		
		// 获取地区代码
		Map<String, String> mapArea = AppCache.areaChin;
		//判断是否存在<USER>标签
		boolean flag =false;
		for(Map.Entry<String, String> a:map.entrySet()){
			if(a.getKey().equalsIgnoreCase("<USER>")){
				for(Map.Entry<String, String> b:mapArea.entrySet()){
					if(b.getKey().contains(a.getValue())){
						area =b.getValue();
						break;
					}
				}
				flag =true;
				break;
			}
		}
		if(flag==true){
			executController.doExecution(id, area, textArea_1, 1, map);
		}else{
			textArea_1.append("全局变量需要定义 USER 标签");
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
