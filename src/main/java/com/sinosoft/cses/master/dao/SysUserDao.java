package com.sinosoft.cses.master.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sinosoft.cses.master.dao.support.IBaseDao;
import com.sinosoft.cses.master.entity.SysUser;

@Repository
public interface SysUserDao extends IBaseDao<SysUser, Integer>{

	/** 根据用户名去查*/
	@Query( "select new com.sinosoft.cses.master.entity.SysUser(id, areacode, companycode, companytype, password, usercode, usergrade, username, validstatus) from SysUser where usercode = ?1 and validstatus = '1'")
	SysUser findByUserCode(String usernameText);

}
