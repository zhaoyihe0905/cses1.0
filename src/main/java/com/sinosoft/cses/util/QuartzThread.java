package com.sinosoft.cses.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
		//AppCache appCache =new AppCache();
		Map<String, String> globalVariable = AppCache.globalVariable;
		int id =0;

		//不同业务场景串行
		for(int i =0;i<ids.length;i++){
			//重置 避免数据覆盖
			map = new HashMap<>();
			List<Execution> executions =AppCache.executions;
			for(int k=0;k<executions.size();k++){
        		Execution execution = executions.get(k);
        		if(execution.getName().equals(ids[i])){
        			id = execution.getId();
        		}
        	}
			/*for(int j=0;j<ids.length;j++){
				if (ids[j].contains("商业")){
					//用户名密码添加
					map.put("<User>", prop.getProperty(area+".username"));
					map.put("<Password>", prop.getProperty(area+".password"));
				}else if (ids[j].contains("交强")){
					//用户名密码添加
					map.put("<USER>", prop.getProperty(area+".username"));
					map.put("<PASSWORD>", prop.getProperty(area+".password"));
				}
			}*/
			//需要从配置文件中读取并修改的字段
			String configFields = prop.getProperty(area+".carInfo");
			if(!configFields.isEmpty()){
				String[] fileds =configFields.split(",");
				for(int h =0;h<fileds.length;h++){
					//map.put("<"+fileds[i]+">", prop.getProperty(area+"."+id+"."+fileds[i]));
					System.out.println(prop.getProperty(area+"."+id+"."+fileds[h]));
					map.put("<"+fileds[h]+">", prop.getProperty(area+"."+id+"."+fileds[h]));
				}
			}

			Date date = new Date();
			//遍历map中的键
			/*for(String key:globalVariable.keySet()){
				if (key.equalsIgnoreCase("<START_DATE>")){
					String startDate = globalVariable.get(key);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
					try {
						Date parse = sdf.parse(startDate);
						while (date.getTime() > parse.getTime()){
							Calendar c = Calendar.getInstance();
							c.setTime(parse);
							c.add(Calendar.DAY_OF_MONTH, 1);          //利用Calendar 实现 Date日期+1天
							parse = c.getTime();
							String newStartDate = sdf.format(parse);
							globalVariable.put("<START_DATE>",newStartDate);
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				if (key.equalsIgnoreCase("<END_DATE>")){
					String endDate = globalVariable.get(key);
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmm");
					try {
						Date parse1 = sdf1.parse(endDate);
						if (date.getTime() > parse1.getTime()){
							Calendar c = Calendar.getInstance();
							c.setTime(parse1);
							c.add(Calendar.YEAR, 1);          //利用Calendar 实现 Date日期+1年
							parse1 = c.getTime();
							String newEndDate = sdf1.format(parse1);
							globalVariable.put("<END_DATE>",newEndDate);
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}*/
			//遍历map中的值
			/*for(String value:globalVariable.values()){
				System.out.println("value ="+value);
			}*/
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
