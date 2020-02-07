package com.sinosoft.master.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sinosoft.master.dao.support.IBaseDao;
import com.sinosoft.master.entity.SysUser;

/**
 * 持久层
 * @author xujian
 * @Date 2019-12-30
 */
@Repository
public interface SysUserDao extends IBaseDao<SysUser, Integer>{

	/** 根据用户名去查*/
	@Query( "select new com.sinosoft.master.entity.SysUser(id, userCode, areaCode, username, password, companyCode, companyType, userGrade, validStatus) from SysUser where userCode = ?1 and valid_status = '1'")
	SysUser findByUserCode(String usernameText);

}
