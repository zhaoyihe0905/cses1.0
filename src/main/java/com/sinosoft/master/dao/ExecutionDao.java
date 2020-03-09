package com.sinosoft.master.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sinosoft.master.dao.support.IBaseDao;
import com.sinosoft.master.entity.Execution;

@Repository
public interface ExecutionDao extends IBaseDao<Execution, Integer>{
    @Modifying
    @Query(value = "replace into tb_execution (id, orders, name, remark, valid_status) values (?2, ?3, ?1, '', '1')", nativeQuery = true)
    void replace(String Name, Integer id, String orders);
    //void replace(String Name, String xmlName, String inconfigField, String outconfigField, Integer id);



}
