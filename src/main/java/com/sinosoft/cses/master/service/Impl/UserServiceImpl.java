package com.sinosoft.cses.master.service.Impl;

import com.sinosoft.cses.master.dao.UserDao;
import com.sinosoft.cses.master.entity.SysUser;
import com.sinosoft.cses.master.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public SysUser getUserById(Integer id) {
        Optional<SysUser> user = userDao.findById(id);
        SysUser userInfo = new SysUser();
        return  userInfo;

    }

    @Override
    public List<SysUser> getUserInfo() {
        List<SysUser> userList = userDao.findAll();
        return userList;
    }

    @Override
    @Transactional
    public String updateUser(String name, String age) {
        Integer res = userDao.updateUser(name,age);
        String resStr="";
        if(res==1){
            resStr="更新"+name+"的年龄为"+age+"成功";
        }else {
            resStr="更新"+name+"的年龄为"+age+"失败";
        }
        return resStr;
    }
}
