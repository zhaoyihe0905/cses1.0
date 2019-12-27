package com.sinosoft.cses.master.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.cses.master.dao.SysConfigDao;
import com.sinosoft.cses.master.dao.support.IBaseDao;
import com.sinosoft.cses.master.entity.SysConfig;
import com.sinosoft.cses.master.service.SysConfigService;
import com.sinosoft.cses.master.service.support.impl.BaseServiceImpl;

@Service 
public class SysConfigServiceImpl extends BaseServiceImpl<SysConfig, Integer> implements SysConfigService{

	@Autowired
	private SysConfigDao sysConfigDao;
	
	@Override
	public IBaseDao<SysConfig, Integer> getBaseDao() {
		// TODO Auto-generated method stub
		return this.sysConfigDao;
	}

	@Override
	public String findvalueByCode(String parametercode) {
		// TODO Auto-generated method stub
		return sysConfigDao.sysConfigDao(parametercode);
	}

}
