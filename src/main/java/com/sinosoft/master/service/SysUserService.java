package com.sinosoft.master.service;

import com.sinosoft.master.entity.SysUser;
import com.sinosoft.master.service.support.IBaseService;

public interface SysUserService extends  IBaseService<SysUser, Integer>{

	SysUser findByUserCode(String usernameText);

}
