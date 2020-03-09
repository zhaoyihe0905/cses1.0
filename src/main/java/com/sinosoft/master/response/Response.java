package com.sinosoft.master.response;

import java.util.Date;

import lombok.Data;

@Data
public class Response {
	//请求开始时间
	private Date startTime;
	//请求结束时间
	private Date stopTime;
	//请求结果
	private Integer result;
	//相应时间
	private Integer responseTime;
	//返回报文
	private String resXml;
	//日志对象
	private StringBuffer strBuff;
	// 错误信息
	private String resMessage;
	
	


	
	


}
