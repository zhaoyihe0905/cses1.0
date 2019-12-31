package com.sinosoft.view.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sinosoft.master.entity.CsesLog;
import com.sinosoft.master.response.Response;

/**
 * 公共类
 * @author xujian
 * @Date 2019-12-30
 */
@Component
public class BusinessFun {
	
	/** 日志*/
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 此方法post请求调用核心系统
	 * 
	 * @param url url
	 * @param file
	 * @param strBuff
	 * @return
	 */
	// public static String doPost(String url, String file, String logFile){
	// public static String doPost(String url, String file){
	 public  Response doPost(String url, String file, StringBuffer strBuff){
		 Response response = new Response();
		 strBuff.append("开始调用核心接口，url: " + url);
		file = "C:\\Users\\Administrator\\Desktop\\交强险V6.2.0测试工具sc\\XML\\insureconfirm1.xml";
		HttpURLConnection httpConnection = null;
		OutputStream outputStream = null;
		BufferedReader bufferedReader1 = null;
		BufferedReader bufferedReader2 = null;
		InputStreamReader inputStreamReader = null;
		strBuff.append(" 请求核心系统URL: " + url);
		

		try {
			String lineString = "";

			SimpleDateFormat formatter = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss.SSS] - ");

			/*******************************************************************
			 * 0、参数信息
			 ******************************************************************/

//		   strBuff.append(" 请求XLML：" + file);

			/*******************************************************************
			 * 1、打开连接
			 ******************************************************************/
			httpConnection = (HttpURLConnection) new URL(url).openConnection();
			
			//设置请求POST
			httpConnection.setRequestMethod("POST");
			httpConnection.setDoOutput(true);
			httpConnection.setDoInput(true);
			httpConnection.setAllowUserInteraction(true);
			httpConnection.connect();

			/*******************************************************************
			 * 2、发送数据
			 ******************************************************************/
			outputStream = httpConnection.getOutputStream();

//			bufferedReader1 = new BufferedReader(new FileReader(file));
			bufferedReader1 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file)), "GBK"));
			StringBuilder sbInput = new StringBuilder();

			// - 写入输出
			while ((lineString = bufferedReader1.readLine()) != null) {
				byte readByte[] = lineString.getBytes("GBK");
//				byte readByte[] = lineString.getBytes("GBK");
				outputStream.write(readByte, 0, readByte.length);
				sbInput.append(lineString.replaceAll("\t", "").trim());
			}
			outputStream.flush();

			// - 记录文件
			lineString = sbInput.toString();

			// writeLog(lineString, logFile, true, true);
			// writeLog(line1, logFile, true, true);
			// writeLog(lineString, logFile + ".i.xml", false, false);

			/*******************************************************************
			 * 3、接收数据
			 ******************************************************************/
			Date startTime = new Date();
			strBuff.append("请求核心系统接口开始时间 " + startTime);
			// 请求开始时间
			response.setStartTime(startTime);
			//开始调用接口 
			inputStreamReader = new InputStreamReader(httpConnection.getInputStream(), "GBK");
			Date stopTime = new Date();
			strBuff.append("请求核心系统接口结束时间" + stopTime);
			// 请求结束时间
			response.setStopTime(stopTime);
			response.setResponseTime((int) (stopTime.getTime() - startTime.getTime()));
			bufferedReader2 = new BufferedReader(inputStreamReader);

			StringBuffer sbOutput = new StringBuffer(1024);
			while ((lineString = bufferedReader2.readLine()) != null) {
				sbOutput.append(lineString);
			}

			
			/*******************************************************************
			 * 4、记录日志
			 ******************************************************************/
			lineString = sbOutput.toString();
			strBuff.append("接口返回数据： " + lineString);

			// 设置投保确认码
			response.setResXml(lineString);
			//成功
			response.setResult("1");
			//日志strBuff
			response.setStrBuff(strBuff);

			return response;
		} catch (Exception e) {
			strBuff.append("调用接口失败，错误信息：" + e.getMessage());
			//日志strBuff
			response.setStrBuff(strBuff);
			e.printStackTrace();
			response.setResult("0");
			return response;

		} finally {
			try {
				outputStream.close();
			} catch (Exception e) {
			}
			try {
				bufferedReader1.close();
			} catch (Exception e) {
			}
			try {
				bufferedReader2.close();
			} catch (Exception e) {
			}
			try {
				inputStreamReader.close();
			} catch (Exception e) {
			}
			try {
				httpConnection.disconnect();
			} catch (Exception e) {
			}
		}
	}
	public String readFile(String path){
		File file = new File(path);
		StringBuilder result = new StringBuilder();
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file),"GBK");
			BufferedReader  br = new BufferedReader(isr);
			String s = null;
			while((s=br.readLine())!=null){
				result.append(System.lineSeparator()+s);
			}
			br.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		return result.toString();
	}


}
