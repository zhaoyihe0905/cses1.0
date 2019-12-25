package com.sinosoft.cses.master.service;


import java.util.List;

import com.sinosoft.cses.master.entity.SysUser;

public interface UserService {
    public SysUser getUserById(Integer id);
    public List<SysUser> getUserInfo();
    public String updateUser(String name,String age);
}
