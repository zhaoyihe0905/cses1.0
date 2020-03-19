package com.sinosoft.cses.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.JTextArea;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzWork implements Job{
	private String[] id =null;
	private JTextArea textArea_1 = null;
	//自定义配置文件
	Properties prop = AppCache.prop;
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		//获取传入的参数
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		id = (String[]) jobDataMap.get("id");
		textArea_1 =(JTextArea)jobDataMap.get("textArea");
		ThreadPoolExecutor executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
			    60L, TimeUnit.SECONDS,new SynchronousQueue());
		Map<String, String>  map = AppCache.globalVariable;
		//如:<四川,510000>
		Map<String, String> areaCode = AppCache.areaEng;
		Map<String,String> mapArray =new HashMap<>();

		char start ="*".toCharArray()[0];
		for(Map.Entry<String, String> a:map.entrySet()){
			if(!a.getKey().isEmpty()&&start==a.getKey().charAt(a.getKey().length()-1)){
				mapArray.put(a.getKey().substring(0, a.getKey().length()-1), a.getValue());
			}
		}
		//获取配置文件地区代码
		String[] areaChines = prop.getProperty("area").split(",");
		//创建线程
		for(int i =0;i<areaChines.length;i++){
			//单个线程使用的map，对于业务场景执行方法，等同于非定时情况下从全局变量获取的map			
			QuartzThread thread= new QuartzThread();
			thread.setMap(mapArray);
			thread.setTextArea_1(textArea_1);
			thread.setId(id);
			thread.setArea(areaChines[i]);
			executor.execute(thread);
			textArea_1.append("******************定时任务启动成功******************");
			textArea_1.append("\n");
			textArea_1.append(new Date()+": 开始进行接口访问");
			textArea_1.append("\n");
		}							
	}

}
