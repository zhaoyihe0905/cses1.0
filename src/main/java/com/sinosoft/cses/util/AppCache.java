package com.sinosoft.cses.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.swing.JTextArea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.sinosoft.master.entity.CsCode;
import com.sinosoft.master.entity.Execution;
import com.sinosoft.master.entity.GlobalVariable;
import com.sinosoft.master.entity.Interfaces;
import com.sinosoft.master.entity.SysConfig;
import com.sinosoft.master.entity.SysUser;
import com.sinosoft.master.service.CsCodeService;
import com.sinosoft.master.service.ExecutionService;
import com.sinosoft.master.service.GlobalVariableService;
import com.sinosoft.master.service.InterfacesService;
import com.sinosoft.master.service.SysConfigService;
import com.sinosoft.master.service.SysUserService;

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
//	private static H
	/** 系统配置项 */
	public  static Hashtable<String, String> hashSysConfig = new Hashtable<String, String>();
	/** 系统配置项 */
	public  static Hashtable<String, String> sysUser = new Hashtable<String, String>();
	/** 地区代码得到中文*/
	public static Map<String, String> areaChin = new HashMap<>();
	/** 地区代码得到英文*/
	public static Map<String, String> areaEng = new HashMap<>();
	/** 全局变量*/
	public static Map<String, String> globalVariable = new HashMap<>();
	/** 接口 */
	public static List<Interfaces> interfaces = new ArrayList<>();
	/** 业务场景 */
	public static List<Execution> executions = new ArrayList<>();
	/**自定义配置文件*/
	public static Properties prop = new Properties();
	
	@Autowired
	private CsCodeService csCodeService;
	
	@Autowired
	private GlobalVariableService globalVariableService;
	
	@Autowired
	private InterfacesService InterfacesService;
	
	@Autowired
	private ExecutionService executionService;
	
	@Autowired
	private SysConfigService sysConfigService;
	
	@Autowired
	private SysUserService sysUserService;
	
	

	@Override
	public void run(String... args) throws Exception {
		try {
			logger.info("开始初始化数据");
			initUser();
			initSystemConfig();
			initAreaCode();
			initGlobalVariable();
			initInterface();
			initExceution();
			initConfigProperties();
			logger.info("开始初始化数据成功");
		} catch (Exception e) {
			logger.info("初始化数据失败");
			e.printStackTrace();
		}
		
	}
	
	
	
	private void initSystemConfig() {
		try {
			logger.info("开始系统配置项初始化");
			hashSysConfig.clear();
			
			List<SysConfig> findAll = sysConfigService.findAll();
			for (SysConfig sysConfig : findAll) {
				hashSysConfig.put(sysConfig.getParametercode() + sysConfig.getAreaCode(), sysConfig.getParametervalue());
			}
			
			
			logger.info("系统配置项初始化成功");
		} catch (Exception e) {
			logger.info("系统配置项初始化失败");
		}
		
	}
	
	



	private void initUser() {
		try {
			logger.info("开始用户信息初始化");
			sysUser.clear();
			
			List<SysUser> findAll = sysUserService.findAll();
			for (SysUser sysUser : findAll) {
				AppCache.sysUser.put(sysUser.getUserCode() ,sysUser.getPassword());
			}
			
			
			logger.info("用户信息初始化成功");
		} catch (Exception e) {
			logger.info("用户信息初始化失败");
		}
		
	}



	/**
	 * 初始化业务场景信息
	 * @author xujian
	 * @Date 2020-02-07
	 */
	public void initExceution() {
		try {
			logger.info("开始业务场景初始化");
			executions.clear();
			
			executions = executionService.findAll();
			logger.info("业务场景初始化成功");
		} catch (Exception e) {
			logger.info("业务场景初始化失败");
		}
		
	}



	/**
	 * 初始化接口信息
	 * @author xujian
	 * @Date 2020-02-07
	 */
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


	
	/**
	 * 初始化地区代码信息
	 * @author xujian
	 * @Date 2020-02-07
	 */
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
	/**
	 * 初始化自定义配置文件
	 */
	public void initConfigProperties(){
		try {
			String configFileUrl = getParameterStringValue(SystemConfig.ConfigFileURL, AppConst.ALL);
			BufferedReader bufferedReader = new BufferedReader(new FileReader(configFileUrl+"/quartzConfig.properties"));
			 prop.load(bufferedReader);
			 logger.info("自定义配置文件初始化成功");
		} catch (Exception e) {
			logger.info("自定义配置文件初始化失败");
		}
	}
	
	/** 获得String
	 * @throws Exception */
	public String getParameterStringValue(String code, String areaCode) throws Exception {
		
		try {
			return hashSysConfig.get(code + areaCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("没有" + areaCode + "这个地区的配置项：" + code);
		}
		
	}


	
	
	
	
	
	

}

