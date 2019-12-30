package com.sinosoft.master.response;

import java.util.Date;

public class Response {
	private Date startTime;
	
	private Date stopTime;
	
	private String queryPolicyNo;
	
	private Integer responseTime;
	
	private String resXml;
	

	public String getResXml() {
		return resXml;
	}

	public void setResXml(String resXml) {
		this.resXml = resXml;
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

	public String getQueryPolicyNo() {
		return queryPolicyNo;
	}

	public void setQueryPolicyNo(String queryPolicyNo) {
		this.queryPolicyNo = queryPolicyNo;
	}

	public Integer getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Integer responseTime) {
		this.responseTime = responseTime;
	}


	
	

}
