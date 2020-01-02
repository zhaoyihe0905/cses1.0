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

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

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
	 * @param xml
	 * @param strBuff
	 * @return
	 */
	 public  Response doPost(String url, String xml, StringBuffer strBuff){
		 Response response = new Response();
		 strBuff.append("开始调用核心接口，url: " + url);
		HttpURLConnection httpConnection = null;
		OutputStream outputStream = null;
		BufferedReader bufferedReader1 = null;
		BufferedReader bufferedReader2 = null;
		InputStreamReader inputStreamReader = null;
		strBuff.append(" 请求核心系统URL: " + url);
		

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
			
			response.setResMessage("success");

//			logger.info(strBuff.toString());
			return response;
		} catch (Exception e) {
			strBuff.append("调用接口失败，错误信息：" + e.getMessage());
//			logger.info(strBuff.toString());
			//日志strBuff
			response.setStrBuff(strBuff);
			e.printStackTrace();
			response.setResult("0");
			response.setResMessage(e.getMessage());
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

	/**
	 * 读取本地文件
	 * @param path
	 * @return
	 */
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

	/**
	 * xml 转为 dto
	 * @param result xml报文
	 * @param c xml对应的对象类，通过类.class获取，或者对象.getClass()获取
	 * @return 返回对象为Object，需要转换
	 * @throws Exception
	 */
	public Object xmlToObject(String result,Class c) throws Exception{
		Object o = null;
		JAXBContext context = JAXBContext.newInstance(c);
		Unmarshaller unmarshal = context.createUnmarshaller();
		StringReader sr = new StringReader(result.trim());
		o =  unmarshal.unmarshal(sr);
		return  o;
	}

	/**
	 * dto 转 xml
	 * @param o 组织好的需要转换为xml的实体类对象
	 * @return 返回xml报文
	 * @throws Exception
	 */
	public String objectToXml(Object o) throws Exception {
		JAXBContext context = JAXBContext.newInstance(o.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		StringWriter writer = new StringWriter();
		marshaller.marshal(o, writer);
		return  o.toString();
	}
}
