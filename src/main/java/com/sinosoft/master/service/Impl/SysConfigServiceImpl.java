package com.sinosoft.master.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.master.dao.SysConfigDao;
import com.sinosoft.master.dao.support.IBaseDao;
import com.sinosoft.master.entity.SysConfig;
import com.sinosoft.master.service.SysConfigService;
import com.sinosoft.master.service.support.impl.BaseServiceImpl;

@Service 
public class SysConfigServiceImpl extends BaseServiceImpl<SysConfig, Integer> implements SysConfigService{

	@Autowired
	private SysConfigDao sysConfigDao;
	
	@Override
	public IBaseDao<SysConfig, Integer> getBaseDao() {
		// TODO Auto-generated method stub
		return this.sysConfigDao;
	}

	/** 根据配置项名字查询数据库*/
	@Override
	public String findvalueByCode(String parametercode) {
		// TODO Auto-generated method stub
		return sysConfigDao.sysConfigDao(parametercode);
	}

}
