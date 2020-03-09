package com.sinosoft.master.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.master.dao.InterfacesDao;
import com.sinosoft.master.dao.support.IBaseDao;
import com.sinosoft.master.entity.Interfaces;
import com.sinosoft.master.service.InterfacesService;
import com.sinosoft.master.service.support.impl.BaseServiceImpl;

@Service
public class InterfacesServiceImpl extends BaseServiceImpl<Interfaces, Integer> implements InterfacesService {
	
	@Autowired
	private InterfacesDao interfacesDao;

	@Override
	public IBaseDao<Interfaces, Integer> getBaseDao() {
		// TODO Auto-generated method stub
		return this.interfacesDao;
	}

	@Override
	public void replace(Interfaces interfaces) {
		// TODO Auto-generated method stub
		interfacesDao.replace(interfaces.getName(), interfaces.getXmlName(), interfaces.getInconfigField(), interfaces.getOutconfigField(), interfaces.getId(),interfaces.getUrl(),interfaces.getIdentification());
		
	}

 




}
