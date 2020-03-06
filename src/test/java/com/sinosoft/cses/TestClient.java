package com.sinosoft.cses;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 【功能简介】调试接口的程序<br>
 * 【已知问题】<br>
 * 1、很多字符串需要常量化。 <br>
 * 2、检查每一个打开的文件和链接是否关闭。
 * 3、line1和line2使用迭代构造。
 * 
 * @author 中科软科技
 * @version 1.0.0 build0829 李子扬 整理成适用于本地调试。
 * @version 1.0.1 build0829 李子扬 修改输入按照行文件读取。
 */
public class TestClient {

	/**
	 * 客户端主函数。 <br>
	 * args[0] - URL地址，如：http://192.168.60.30:8001/sinoiaci/CommServer。 <br>
	 * args[1] - 文件名称，如：./postbatch.xml。<br>
	 * args[2] - 日志名称，如：./postbatch.log。<br>
	 * 
	 * @param args：
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String logFile = null;
		String url = "http://localhost:8080/sinoiaci/commserver";
		String xml = "你好阿斯蒂芬";
		HttpURLConnection httpConnection = null;
		OutputStream outputStream = null;
		BufferedReader bufferedReader1 = null;
		BufferedReader bufferedReader2 = null;
		InputStreamReader inputStreamReader = null;

		try {
			String lineString = "";

			SimpleDateFormat formatter = new SimpleDateFormat(
					"[yyyy-MM-dd HH:mm:ss.SSS] - ");

			/*******************************************************************
			 * 0、参数信息
			 ******************************************************************/

			/*******************************************************************
			 * 1、打开连接
			 ******************************************************************/
			httpConnection = (HttpURLConnection) new URL(url).openConnection();

			httpConnection.setRequestMethod("POST");
			httpConnection.setDoOutput(true);
			httpConnection.setDoInput(true);
			httpConnection.setAllowUserInteraction(true);

			httpConnection.connect();

			/*******************************************************************
			 * 2、发送数据
			 ******************************************************************/
			outputStream = httpConnection.getOutputStream();
			
			

			lineString.getBytes("GBK");

			// - 记录文件
			lineString = xml;
			outputStream.write(lineString.getBytes("GBK"));


			/*******************************************************************
			 * 3、接收数据
			 ******************************************************************/
			inputStreamReader = new InputStreamReader(httpConnection
					.getInputStream());
			bufferedReader2 = new BufferedReader(inputStreamReader);

			StringBuffer sbOutput = new StringBuffer(1024);
			while ((lineString = bufferedReader2.readLine()) != null) {
				sbOutput.append(lineString);
			}

			/*******************************************************************
			 * 4、记录日志
			 ******************************************************************/
			lineString = sbOutput.toString();


		} catch (Exception e) {
			e.printStackTrace();

			// 记录错误信息。
			if (logFile != null) {
			}
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


}