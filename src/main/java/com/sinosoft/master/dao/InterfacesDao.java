package com.sinosoft.master.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sinosoft.master.dao.support.IBaseDao;
import com.sinosoft.master.entity.Interfaces;

/**
 * 持久层
 * @author xujian
 * @Date 2019-12-30
 */
@Repository
public interface InterfacesDao extends IBaseDao<Interfaces, Integer>{

	
	
	@Modifying
	@Query(value = "replace into tb_interfaces (id, bussiness_desc, inconfig_field, outconfig_field, remark, valid_status, xml_name) values (?5, ?1, ?3, ?4, '', '1', ?2)", nativeQuery = true)
	void replace(String bussiness_desc, String xmlName, String inconfigField, String outconfigField, Integer id);

}
