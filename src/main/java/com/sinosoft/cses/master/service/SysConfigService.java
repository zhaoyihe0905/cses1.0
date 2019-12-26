package com.sinosoft.cses.master.service;

import com.sinosoft.cses.master.entity.SysConfig;
import com.sinosoft.cses.master.service.support.IBaseService;

public interface SysConfigService extends IBaseService<SysConfig, Integer>{
	
	String findvalueByCode(String parametercode);

}
