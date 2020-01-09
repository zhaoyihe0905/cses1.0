package com.sinosoft.master.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.master.dao.CsCodeDao;
import com.sinosoft.master.dao.support.IBaseDao;
import com.sinosoft.master.entity.CsCode;
import com.sinosoft.master.service.CsCodeService;
import com.sinosoft.master.service.support.impl.BaseServiceImpl;

@Service
public class CsCodeServiceImpl extends BaseServiceImpl<CsCode, Integer> implements CsCodeService{

	@Autowired
	private CsCodeDao csCodeDao;
	@Override
	public IBaseDao<CsCode, Integer> getBaseDao() {
		// TODO Auto-generated method stub
		return this.csCodeDao;
	}

}
