package com.sinosoft.master.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sinosoft.master.dao.support.IBaseDao;
import com.sinosoft.master.entity.GlobalVariable;

/**
 * 持久层
 * @author xujian
 * @Date 2019-12-30
 */
@Repository
public interface GlobalVariableDao extends IBaseDao<GlobalVariable, Integer>{

	
	@Modifying
	@Query(value = "replace into tb_variable (variable_code, remark, valide_status, variable_name) values(:#{#global.variable_code}, \"\", 1 ,:#{#global.variable_name})"  , nativeQuery=true)
	void replave(GlobalVariable global);

}
