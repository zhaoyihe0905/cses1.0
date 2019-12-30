package com.sinosoft.master.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.master.dao.SysUserDao;
import com.sinosoft.master.dao.support.IBaseDao;
import com.sinosoft.master.entity.SysUser;
import com.sinosoft.master.service.SysUserService;
import com.sinosoft.master.service.support.impl.BaseServiceImpl;

@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, Integer> implements SysUserService{

	@Autowired
	private SysUserDao sysUserDao;
	
	@Override
	public IBaseDao<SysUser, Integer> getBaseDao() {
		// TODO Auto-generated method stub
		return sysUserDao;
	}

	@Override
	public SysUser findByUserCode(String usernameText) {
		return 		sysUserDao.findByUserCode(usernameText);
	}

}
