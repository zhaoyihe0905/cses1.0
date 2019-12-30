package com.sinosoft.master.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sinosoft.master.dao.support.IBaseDao;
import com.sinosoft.master.entity.SysConfig;

/**
 * 持久层
 * @author xujian
 * @Date 2019-12-30
 */
@Repository
public interface SysConfigDao extends IBaseDao<SysConfig, Integer>{

	/** 根据配置项名字查询数据库*/
	@Query( "select parametervalue from SysConfig where parametercode = ?1 and validstatus = '1'")
	String sysConfigDao(String parametercode);

}
