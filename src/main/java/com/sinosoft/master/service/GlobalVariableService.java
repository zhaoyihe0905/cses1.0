package com.sinosoft.master.service;

import com.sinosoft.master.entity.GlobalVariable;
import com.sinosoft.master.service.support.IBaseService;

public interface GlobalVariableService extends IBaseService<GlobalVariable, String>{

	void replave(GlobalVariable global);

}
