package com.sinosoft.master.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sinosoft.master.dao.support.IBaseDao;
import com.sinosoft.master.entity.SysConfig;

@Repository
public interface SysConfigDao extends IBaseDao<SysConfig, Integer>{

	@Query( "select parametervalue from SysConfig where parametercode = ?1 and validstatus = '1'")
	String sysConfigDao(String parametercode);

}
