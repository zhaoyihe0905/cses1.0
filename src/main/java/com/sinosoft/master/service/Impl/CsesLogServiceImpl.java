package com.sinosoft.master.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.master.dao.CsesLogDao;
import com.sinosoft.master.dao.support.IBaseDao;
import com.sinosoft.master.entity.CsesLog;
import com.sinosoft.master.service.CsesLogService;
import com.sinosoft.master.service.support.impl.BaseServiceImpl;

@Service
public class CsesLogServiceImpl extends BaseServiceImpl<CsesLog, Integer> implements CsesLogService{

	@Autowired
	private CsesLogDao csesLogDao;
	
	@Override
	public IBaseDao<CsesLog, Integer> getBaseDao() {
		// TODO Auto-generated method stub
		return this.csesLogDao;
	}

}
