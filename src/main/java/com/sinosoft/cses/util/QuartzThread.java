package com.sinosoft.cses.util;

import java.util.HashMap;
import java.util.Map;

public class QuartzThread implements Runnable{
	private Map<String,String> map = new HashMap<>();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("多线程启动["+11+"]!!!!!!!");
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	
}
