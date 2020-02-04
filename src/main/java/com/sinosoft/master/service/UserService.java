package com.sinosoft.master.service;


import java.util.List;

import com.sinosoft.master.entity.SysUser;

public interface UserService {
    public SysUser getUserById(Integer id);
    public List<SysUser> getUserInfo();
    public String updateUser(String name,String age);
}
