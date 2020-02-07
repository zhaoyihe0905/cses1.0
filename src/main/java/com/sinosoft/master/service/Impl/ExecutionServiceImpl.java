package com.sinosoft.master.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.master.dao.ExecutionDao;
import com.sinosoft.master.dao.support.IBaseDao;
import com.sinosoft.master.entity.Execution;
import com.sinosoft.master.service.ExecutionService;
import com.sinosoft.master.service.support.impl.BaseServiceImpl;

@Service
public class ExecutionServiceImpl extends BaseServiceImpl<Execution, Integer> implements ExecutionService{

	@Autowired
	private ExecutionDao executionDao;

	@Override
	public IBaseDao<Execution, Integer> getBaseDao() {
		// TODO Auto-generated method stub
		return this.executionDao;
	}
}
