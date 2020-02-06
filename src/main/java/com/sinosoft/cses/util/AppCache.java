package com.sinosoft.cses.util;

import java.util.ArrayList;
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
import com.sinosoft.master.entity.GlobalVariable;
import com.sinosoft.master.entity.Interfaces;
import com.sinosoft.master.service.CsCodeService;
import com.sinosoft.master.service.GlobalVariableService;
import com.sinosoft.master.service.InterfacesService;

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
	/** 接口 */
	public static List<Interfaces> interfaces = new ArrayList<>();
	
	@Autowired
	private CsCodeService csCodeService;
	
	@Autowired
	private GlobalVariableService globalVariableService;
	
	@Autowired
	private InterfacesService InterfacesService;
	
	

	@Override
	public void run(String... args) throws Exception {
		try {
			logger.info("开始初始化数据");
			initAreaCode();
			initGlobalVariable();
			initInterface();
			logger.info("开始初始化数据成功");
		} catch (Exception e) {
			logger.info("初始化数据失败");
			e.printStackTrace();
		}
		
	}
	
	
	
	public void initInterface() {
		try {
			logger.info("开始接口初始化");
			interfaces.clear();
			
			interfaces = InterfacesService.findAll();
			logger.info("接口初始化成功");
		} catch (Exception e) {
			logger.info("接口初始化失败");
		}
		
	}



	public  void initAreaCode() {
		try {
			logger.info("开始地区代码初始化");
			areaChin.clear();
			areaEng.clear();
			
			List<CsCode> cscCodes = csCodeService.findAll();
			for (CsCode csCode : cscCodes) {
				if("1".equals((csCode.getValidStatus())) && INSURE_AREA.equals(csCode.getCodeType())){
					areaChin.put(csCode.getCodeCode(), csCode.getCodeName());
					areaEng.put(csCode.getCodeName(), csCode.getCodeCode());
				}
			}
			logger.info("地区代码初始化成功");
		} catch (Exception e) {
			logger.info("地区代码初始化失败");
		}
		
	}

	public  void initGlobalVariable() {
		try {
			logger.info("开始全局变量初始化");
			globalVariable.clear();
			//全局变量
			List<GlobalVariable> variables = globalVariableService.findAll();
			for (GlobalVariable global : variables) {
				globalVariable.put(global.getVariable_code(), global.getVariable_name());
			}
			logger.info("全局变量初始化成功");
		} catch (Exception e) {
			logger.info("全局变量初始化失败");
		}
	}



	
	
	
	
	
	

}
