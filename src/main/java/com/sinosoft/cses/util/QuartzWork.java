package com.sinosoft.cses.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
	private Integer id =null;
	private JTextArea textArea_1 = null;
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		//获取传入的参数
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		id = Integer.parseInt(jobDataMap.get("id").toString());
		textArea_1 =(JTextArea)jobDataMap.get("textArea");
		ThreadPoolExecutor executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
			    60L, TimeUnit.SECONDS,new SynchronousQueue());
		Map<String, String>  map = AppCache.globalVariable;
		Map<String,String[]> mapArray =new HashMap<>();
		int length = 0;
		char start ="*".toCharArray()[0];
		for(Map.Entry<String, String> a:map.entrySet()){
			if(start==a.getKey().charAt(a.getKey().length()-1)){
				mapArray.put(a.getKey().substring(0, a.getKey().length()-1), a.getValue().split(","));
				//字符串数组大小排序
				if(a.getValue().split(",").length>length){
					length = a.getValue().split(",").length;
				}
			}
		}
		if(length==0){
			textArea_1.append("******************定时任务启动成功******************");
			textArea_1.append("\n");
			textArea_1.append(new Date()+": 未定义定时任务变量，不进行接口访问,请关闭定时任务");
			textArea_1.append("\n");
		}else{
			//创建线程
			for(int i =0;i<length;i++){
				//单个线程使用的map，对于业务场景执行方法，等同于非定时情况下从全局变量获取的map
				Map<String,String> mapSingle = new HashMap<>();
				for(Entry<String, String[]> arr:mapArray.entrySet()){
					mapSingle.put(arr.getKey(), arr.getValue()[i].substring(4,  arr.getValue()[i].length()-1));
				}
				QuartzThread thread= new QuartzThread();
				thread.setMap(mapSingle);
				thread.setTextArea_1(textArea_1);
				thread.setId(id);
				executor.execute(thread);
				textArea_1.append("******************定时任务启动成功******************");
				textArea_1.append("\n");
				textArea_1.append(new Date()+": 开始进行接口访问");
				textArea_1.append("\n");
			}
		}
		
		
		
	}

}
