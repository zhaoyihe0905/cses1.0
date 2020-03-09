package com.sinosoft.cses.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.master.controller.GlobalVariableController;
import com.sinosoft.master.controller.InterfacesController;
import com.sinosoft.master.entity.CsesLog;
import com.sinosoft.master.entity.GlobalVariable;
import com.sinosoft.master.entity.Interfaces;
import com.sinosoft.master.response.Response;
import com.sinosoft.master.service.GlobalVariableService;
import com.sinosoft.master.service.InterfacesService;

import javax.swing.JTable;
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
	
	@Autowired
	private GlobalVariableService globalVariableService;
	@Autowired
	private GlobalVariableController globalVariableController;
	
	@Autowired
	private InterfacesService interfacesService;
	
	@Autowired
	private AppCache appCache;
	
//	@Autowired
//	BusinessFun businessFun
	
//	@Autowired
//	private InterfacesController interfacesController;
	
	
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
			outputStream.write(xml.getBytes("GBK")); 
			/*******************************************************************
			 * 3、接收数据
			 ******************************************************************/
			Date startTime = new Date();
			strBuff.append("请求核心系统接口开始时间 " + startTime);
			// 请求开始时间
			response.setStartTime(startTime);
			//开始调用接口 
//			inputStreamReader = new InputStreamReader(httpConnection.getInputStream());
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
			response.setResult(1);
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
			response.setResult(0);
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

	/**
	 * 此方法是替换指定的变量
	 * @param xml 报文
	 * @param column 需要替换的字段
	 * @param value 需要替换的值
	 * @return
	 * @author xujian
	 * @since 2020-02-21
	 */
	public String replaceVariable(String xml, String column, String value) {
		
		int beginIndex = xml.indexOf(column);// 得到开始标记<tag>中的"<"的起始位置
		int endIndex = -1;
		
		String tagValue = "";
		
		if (beginIndex >= 0) {
			String endTag = "</" + column.substring(1);
			endIndex = xml.indexOf(endTag) + column.length() +1; // 得到结束标记</tag>中的"<"的起始位置
			tagValue = xml.substring(beginIndex , endIndex);
			
			String newValue = column +  value + endTag;
			
			tagValue = tagValue.replaceAll("\r", "");
			tagValue = tagValue.replaceAll("\n", "");
			tagValue = tagValue.replaceAll("\t", "");
			tagValue = tagValue.trim();
			
			newValue = newValue.replaceAll("\r", "");
			newValue = newValue.replaceAll("\n", "");
			newValue = newValue.replaceAll("\t", "");
			newValue = newValue.trim();
			
			
			xml = xml.replaceAll(tagValue, newValue);
		}

		
		
		return xml;
		
	}
	
    /**
     * 获取标签值
     * 
     * @param message
     * @param tag
     * @return the value between beginTag and endTag
     */
	public String getTagValue(String message, String tag) {

		int beginIndex = message.indexOf(tag);// 得到开始标记<tag>中的"<"的起始位置
		int endIndex = -1;
		
		String tagValue = "";
		
		if (beginIndex >= 0) {
			String endTag = "</" + tag.substring(1);
			endIndex = message.indexOf(endTag); // 得到结束标记</tag>中的"<"的起始位置
			tagValue = message.substring(beginIndex + tag.length(), endIndex);
			
			tagValue = tagValue.replaceAll("\r", "");
			tagValue = tagValue.replaceAll("\n", "");
			tagValue = tagValue.replaceAll("\t", "");
			tagValue = tagValue.trim();
		}

        return tagValue;
    }
    
    /**
     * 获取标签加值
     * 
     * @param message
     * @param tag
     * @return the value between beginTag and endTag
     */
	public String getALLTagValue(String message, String tag) {


		
		
        int beginIndex = message.indexOf(tag);// 得到开始标记<tag>中的"<"的起始位置
        int endIndex = -1;

        String tagValue = "";

        if (beginIndex >= 0) {
            String endTag = "</" + tag.substring(1);
            endIndex = message.indexOf(endTag) + tag.length() + 1;// 得到结束标记</tag>中的"<"的结束位置
            tagValue = message.substring(beginIndex , endIndex);

            tagValue = tagValue.replaceAll("\r", "");
            tagValue = tagValue.replaceAll("\n", "");
            tagValue = tagValue.replaceAll("\t", "");
            tagValue = tagValue.trim();
        }

        return tagValue;
    }
    
    public static void main (String [] args) {
    	String xml = "<USER>123456</USER><PASSWORD></PASSWORD><LALA>sdf</LALA>";
    	String user = "<USER>";
    	String lala = (new BusinessFun()).getTagValue(xml, user);
    	String aa = (new BusinessFun()).getALLTagValue(xml, user);
    	
    }
	
	/**
	 * 进行Xml报文的第一步处理（如一些起保日期， 终保日期，保单归属地等）
	 * @param xml
	 * @param areaCode 
	 * @return
	 * @throws Exception 
	 */
	public String firstXmlHandle(String xml, String areaCode) throws Exception {
		
		//保单归属地市的处理
		String cityCode = areaCode.substring(0, 2) + "0100";
		xml = replaceVariable(xml, AppConst.CITY_CODE, cityCode);
		
		//保单归属地县的处理
		String countyCode = cityCode.substring(0, 4) + "05";
		xml = replaceVariable(xml, AppConst.COUNTRY_CODE, countyCode);
		
		//起保日期的处理
		
		Date start_date = DateUtils.addDay(new Date(), +5);
		xml = replaceVariable(xml, AppConst.START_DATE, DateUtils.toString(start_date, DateUtils.YYYYMMDDHHmm));
		
		//终包日期的处理
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(start_date);
        calendar.add(Calendar.YEAR, 1);
        Date stop_date = calendar.getTime();
        xml = replaceVariable(xml, AppConst.STOP_DATE, DateUtils.toString(stop_date, DateUtils.YYYYMMDDHHmm));
        
        
		//签单日期的处理
        Date pill_date = DateUtils.addDay(new Date(), -7);
        xml = replaceVariable(xml, AppConst.BILL_DATE, DateUtils.toString(pill_date, DateUtils.YYYYMMDD));
        
        //用户名的处理
        xml = replaceVariable(xml, AppConst.USER, appCache.getParameterStringValue(SystemConfig.USER, areaCode));
        
        
        //密码的处理
        xml = replaceVariable(xml, AppConst.PASSWORD, appCache.getParameterStringValue(SystemConfig.PASSWORD, areaCode));
        
		return xml;
	}

	/** 对报文进行第二部处理
	 * @param map 
	 * @param logger2 */
	public String SecondXmlHandle(String xml, Interfaces interfac, Map<String, String> map, Logger logger2) {
		String[] split = interfac.getInconfigField().split(",");
		// TODO Auto-generated method stub
		for (String string : split) {
			if (!"".equals(string)) {
				if(map.containsKey(string)) {
					  try {
						xml = replaceVariable(xml, string, map.get(string));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						logger2.info("没有这个配置项" + string);
					}
				}
				
			}
		}
		return xml;
	}

	/**
	 * 第三步处理 把返回的报文中的某些字段赋值
	 * @param xml
	 * @param interfac
	 * @param map
	 */
	public void thirdXmlHandle(String xml, Interfaces interfac, Map<String, String> map) {
		String[] spilt = interfac.getOutconfigField().split(",");
		for (String key : spilt) {
			if (!"".equals(key)) {
				map.put(key, getTagValue(xml, key));
			}
		}
		
	}
	
	
	


}
