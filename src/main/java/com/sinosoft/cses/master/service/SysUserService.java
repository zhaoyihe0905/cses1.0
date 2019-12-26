package com.sinosoft.cses.master.service;

import com.sinosoft.cses.master.entity.SysUser;
import com.sinosoft.cses.master.service.support.IBaseService;

public interface SysUserService extends  IBaseService<SysUser, Integer>{

	SysUser findByUserCode(String usernameText);

}
