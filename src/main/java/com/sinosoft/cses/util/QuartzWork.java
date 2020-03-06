package com.sinosoft.cses.util;

import java.sql.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzWork implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
			    60L, TimeUnit.SECONDS,new SynchronousQueue());
		Map<String, String>  map = AppCache.globalVariable;
		Map<String,String[]> mapArray =new HashMap<>();
		int length = 0;
		for(Map.Entry<String, String> a:map.entrySet()){
			if("*".equals(a.getValue().charAt(a.getValue().length()-1))){
				mapArray.put(a.getKey(), a.getValue().split(","));
				//字符串数组大小排序
				if(a.getValue().split(",").length>length){
					length = a.getValue().split(",").length;
				}
			}
		}		
		//创建线程
		for(int i =0;i<length;i++){
			//单个线程使用的map，对于业务场景执行方法，等同于非定时情况下从全局变量获取的map
			Map<String,String> mapSingle = new HashMap<>();
			for(Entry<String, String[]> arr:mapArray.entrySet()){
				mapSingle.put(arr.getKey(), arr.getValue()[i]);
			}
			QuartzThread thread= new QuartzThread();
			thread.setMap(mapSingle);
			executor.execute(thread);
		}
		
		
	}

}
