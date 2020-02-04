package com.sinosoft.cses.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.sinosoft.master.entity.CsCode;
import com.sinosoft.master.service.CsCodeService;

import lombok.Data;

//@Data
@Component
@Order(1) //指定顺序
public class AppCache implements CommandLineRunner{
	/** 日志*/
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	Example<CsCode> example1 = null;
	
	/** 地区代码*/
	private final static String INSURE_AREA = "InsurerArea";
	/** 全局变量*/
	private final static String GLOBAL_VAIBALE = "GlobalVariable";
	
	/** 地区代码得到中文*/
	public static Map<String, String> areaChin = new HashMap<>();
	/** 地区代码得到英文*/
	public static Map<String, String> areaEng = new HashMap<>();
	/** 全局变量*/
	public static Map<String, String> globalVariable = new HashMap<>();
	
	@Autowired
	private CsCodeService csCodeService;
	
	

	@Override
	public void run(String... args) throws Exception {
//		csCodeService.find
		try {
			//清空
			areaChin.clear();
			areaEng.clear();
			globalVariable.clear();
			logger.info("开始进行通用代码表的初始化");
			//查询条件对象
			
			
			
			
			//查询数据
			List<CsCode> findAll = csCodeService.findAll();
			for (CsCode csCode : findAll) {
				if("1".equals((csCode.getValidStatus())) && INSURE_AREA.equals(csCode.getCodeType())){
					areaChin.put(csCode.getCodeCode(), csCode.getCodeName());
					areaEng.put(csCode.getCodeName(), csCode.getCodeCode());
				}
				if("1".equals((csCode.getValidStatus())) && GLOBAL_VAIBALE.equals(csCode.getCodeType())){
					globalVariable.put(csCode.getCodeCode(), csCode.getCodeName());
				}
			}
			
		
			
			
			
			
			logger.info("通用代码表初始化成功");
			
			
			
		} catch (Exception e) {
			logger.info("通用代码表初始化失败");
			e.printStackTrace();
		}
		
	}




	
	
	
	
	
	

}
