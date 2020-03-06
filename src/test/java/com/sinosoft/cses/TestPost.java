package com.sinosoft.cses;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class TestPost {
	
	public static void main(String[] args) {
		String url = "http://localhost:8080/sinoiaci/commserver";
		String xml = "你好阿斯蒂芬";
		doPost(url, xml, new StringBuffer());
	}
	
	 public static  void doPost(String url, String xml, StringBuffer strBuff){
		HttpURLConnection httpConnection = null;
		OutputStream outputStream = null;
		BufferedReader bufferedReader2 = null;
		InputStreamReader inputStreamReader = null;
		
	

		try {
			String lineString = "";
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
			lineString = xml;
			outputStream.write(xml.getBytes()); 
			/*******************************************************************
			 * 3、接收数据
			 ******************************************************************/
			// 请求开始时间
			//开始调用接口 
			inputStreamReader = new InputStreamReader(httpConnection.getInputStream(), "GBK");
			// 请求结束时间
			bufferedReader2 = new BufferedReader(inputStreamReader);

			StringBuffer sbOutput = new StringBuffer(1024);
			while ((lineString = bufferedReader2.readLine()) != null) {
				sbOutput.append(lineString);
			}

			
			/*******************************************************************
			 * 4、记录日志
			 ******************************************************************/
			lineString = sbOutput.toString();

			// 设置投保确认码

//			logger.info(strBuff.toString());
		} catch (Exception e) {
	

		} finally {
			try {
				outputStream.close();
			} catch (Exception e) {
			}
			try {
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

}
