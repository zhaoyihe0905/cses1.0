package com.sinosoft.view.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.sinosoft.master.entity.CsesLog;

/**
 * 公共类
 * @author xujian
 * @Date 2019-12-30
 */
@Component
public class BusinessFun {

	
	/**
	 * 此方法post请求调用核心系统
	 * 
	 * @param url url
	 * @param file
	 * @param 接口标识
	 * @param 请求险种(1商业 0 交强)
	 * @return
	 */
	// public static String doPost(String url, String file, String logFile){
	// public static String doPost(String url, String file){
	// public static Response doPost(String url, String file){
	public static CsesLog doPost(String url, String file, String requestType, String reqType) {
		CsesLog response = new CsesLog();
		// 交强or商业
		response.setReqType(reqType);
		// 接口标识
		response.setRequestType(requestType);

		file = "C:\\Users\\Administrator\\Desktop\\交强险V6.2.0测试工具sc\\XML\\insureconfirm1.xml";
		HttpURLConnection httpConnection = null;
		OutputStream outputStream = null;
		BufferedReader bufferedReader1 = null;
		BufferedReader bufferedReader2 = null;
		InputStreamReader inputStreamReader = null;

		try {
			String lineString = "";

			SimpleDateFormat formatter = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss.SSS] - ");

			/*******************************************************************
			 * 0、参数信息
			 ******************************************************************/

			// writeLog(line0, logFile, true, true);
			// writeLog(line2, logFile, true, true);
			// writeLog(formatter.format(new Date()) + "CommClient start! ",
			// logFile, true, true);
			// writeLog(line1, logFile, true, true);
			//
			// writeLog("args[0] = " + url, logFile, true, true);
			// writeLog("args[1] = " + file, logFile, true, true);
			// writeLog("args[2] = " + logFile, logFile, true, true);
			// writeLog(line1, logFile, true, true);

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

			bufferedReader1 = new BufferedReader(new FileReader(file));
			StringBuilder sbInput = new StringBuilder();

			// - 写入输出
			while ((lineString = bufferedReader1.readLine()) != null) {
				byte readByte[] = lineString.getBytes("GBK");
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
			// 请求开始时间
			response.setReqStartTime(startTime);
			//开始调用接口 
			inputStreamReader = new InputStreamReader(httpConnection.getInputStream());
			Date stopTime = new Date();
			// 请求结束时间
			response.setReqEndTime(stopTime);
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

			// 设置投保确认码
			response.setQuerySequenceNo(lineString);
			response.setResInfo("1");

			// writeLog(lineString, logFile, true, true);
			// writeLog(line1, logFile, true, true);
			// writeLog(formatter.format(new Date()) + "CommClient finish! ",
			// logFile, true, true);
			// writeLog(line2, logFile, true, true);
			// writeLog(lineString, logFile + ".o.xml", false, false);
			// return lineString;
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			response.setResInfo("0");
			return response;

			// 记录错误信息。
			// if (logFile != null) {
			// try {
			// writeLog(e.toString(), logFile, true, true);
			// } catch (Exception e1) {
			// // TODO Auto-generated catch block
			// e1.printStackTrace();
			// }
			// }
		} finally {
			try {
				outputStream.close();
			} catch (Exception e) {
				// Nothing;
			}

			try {
				bufferedReader1.close();
			} catch (Exception e) {
				// Nothing;
			}

			try {
				bufferedReader2.close();
			} catch (Exception e) {
				// Nothing;
			}

			try {
				inputStreamReader.close();
			} catch (Exception e) {
				// Nothing;
			}

			try {
				httpConnection.disconnect();
			} catch (Exception e) {
				// Nothing;
			}
		}
	}

	/**
	 * 记录日志
	 * 
	 * @param text
	 * @return
	 * @throws Exception
	 */
	public static void writeLog(String text, String file, boolean append, boolean console) throws Exception {

		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(file, append);

			// 记录控制台
			if (console) {
				System.out.println(text);
			}

			// 记录文本
			fileWriter.write(text + System.getProperty("line.separator"));
			fileWriter.flush();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (Exception e) {
					// Nothing.
				}
			}
		}
	}

}
