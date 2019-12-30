package com.sinosoft.master.service;

import com.sinosoft.master.entity.SysConfig;
import com.sinosoft.master.service.support.IBaseService;

public interface SysConfigService extends IBaseService<SysConfig, Integer>{
	
	String findvalueByCode(String parametercode);

}
