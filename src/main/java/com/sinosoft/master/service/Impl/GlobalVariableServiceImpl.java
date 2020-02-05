package com.sinosoft.master.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.master.dao.GlobalVariableDao;
import com.sinosoft.master.dao.support.IBaseDao;
import com.sinosoft.master.entity.GlobalVariable;
import com.sinosoft.master.service.GlobalVariableService;
import com.sinosoft.master.service.support.impl.BaseServiceImpl;

@Service
public class GlobalVariableServiceImpl extends BaseServiceImpl<GlobalVariable, Integer> implements GlobalVariableService{
	
	@Autowired
	private GlobalVariableDao globalVariableDao;

	@Override
	public IBaseDao<GlobalVariable, Integer> getBaseDao() {
		// TODO Auto-generated method stub
		return globalVariableDao;
	}

	@Override
	public void replave(GlobalVariable global) {
//		globalVariableDao.replave(global);
		globalVariableDao.replave(global.getVariable_code(), global.getVariable_name());
		
	}

}
