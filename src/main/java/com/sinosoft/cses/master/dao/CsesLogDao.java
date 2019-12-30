package com.sinosoft.cses.master.dao;

import org.springframework.stereotype.Repository;

import com.sinosoft.cses.master.dao.support.IBaseDao;
import com.sinosoft.cses.master.entity.CsesLog;

@Repository
public interface CsesLogDao extends IBaseDao<CsesLog, Integer> {

}
