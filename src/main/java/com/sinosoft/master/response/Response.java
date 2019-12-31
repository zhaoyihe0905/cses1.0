package com.sinosoft.master.response;

import java.util.Date;

public class Response {
	//请求开始时间
	private Date startTime;
	//请求结束时间
	private Date stopTime;
	//请求结果
	private String result;
	//相应使劲按
	private Integer responseTime;
	//返回报文
	private String resXml;
	//日志对象
	private StringBuffer strBuff;
	

	public StringBuffer getStrBuff() {
		return strBuff;
	}

	public void setStrBuff(StringBuffer strBuff) {
		this.strBuff = strBuff;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStopTime() {
		return stopTime;
	}

	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Integer responseTime) {
		this.responseTime = responseTime;
	}

	public String getResXml() {
		return resXml;
	}

	public void setResXml(String resXml) {
		this.resXml = resXml;
	}
	
	


}
