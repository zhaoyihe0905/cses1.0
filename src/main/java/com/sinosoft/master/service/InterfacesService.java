package com.sinosoft.master.service;

import com.sinosoft.master.entity.Interfaces;
import com.sinosoft.master.service.support.IBaseService;

public interface InterfacesService extends IBaseService<Interfaces, Integer>{

	void replace(Interfaces interfaces);
	
}
