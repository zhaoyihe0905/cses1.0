package com.sinosoft.master.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.master.entity.SysUser;
import com.sinosoft.master.service.Impl.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserServiceImpl impl;
    @ResponseBody
    @RequestMapping("/user")
    public String userInfo(Integer id){
        return impl.getUserById(id).toString();
    }
    @ResponseBody
    @RequestMapping("/getUsers")
    public List<SysUser> getAllUsersInfo(){
        logger.info("开始获取所有用户信息");
        return impl.getUserInfo();
    }
    @ResponseBody
    @RequestMapping("/updateUser")
    public String updateUser(String name,String age){
        logger.info("修改用户信息");
        return impl.updateUser(name,age);
    }
}
