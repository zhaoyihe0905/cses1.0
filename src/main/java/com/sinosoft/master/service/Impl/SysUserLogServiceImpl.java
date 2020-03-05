package com.sinosoft.master.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.master.dao.SysUserLogDao;
import com.sinosoft.master.dao.support.IBaseDao;
import com.sinosoft.master.entity.SysUserLog;
import com.sinosoft.master.service.SysUserLogService;
import com.sinosoft.master.service.support.impl.BaseServiceImpl;

@Service
public class SysUserLogServiceImpl extends BaseServiceImpl<SysUserLog, Integer> implements SysUserLogService{

	@Autowired
	private SysUserLogDao sysUserLogDao;
	@Override
	public IBaseDao<SysUserLog, Integer> getBaseDao() {
		// TODO Auto-generated method stub
		return sysUserLogDao	;
				}

}
