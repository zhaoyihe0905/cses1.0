package com.sinosoft.master.service;

import com.sinosoft.master.entity.SysConfig;
import com.sinosoft.master.service.support.IBaseService;

public interface SysConfigService extends IBaseService<SysConfig, Integer>{
	
	/** 根据配置项名字查询数据库*/
	String findvalueByCode(String parametercode);

}
