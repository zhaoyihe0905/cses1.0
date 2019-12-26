package com.sinosoft.cses.master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.cses.master.entity.SysUser;
import com.sinosoft.cses.master.service.SysUserService;

@RestController
@RequestMapping
public class LoginControl {
	
	@Autowired
	private SysUserService sysuser;
	
//	public 

}
