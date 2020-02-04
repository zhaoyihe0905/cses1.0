package com.sinosoft.master.dao;

import org.springframework.stereotype.Repository;

import com.sinosoft.master.dao.support.IBaseDao;
import com.sinosoft.master.entity.Execution;

@Repository
public interface ExecutionDao extends IBaseDao<Execution, Integer>{

}