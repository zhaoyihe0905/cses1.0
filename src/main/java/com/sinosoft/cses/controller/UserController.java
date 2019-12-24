package com.sinosoft.cses.controller;


import com.sinosoft.cses.entity.User;
import com.sinosoft.cses.service.serviceImpl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserServiceImpl impl;
    @ResponseBody
    @RequestMapping("/user")
    public String userInfo(String id){
        return impl.getUserById(id).toString();
    }
    @ResponseBody
    @RequestMapping("/getUsers")
    public List<User> getAllUsersInfo(){
        logger.info("开始获取所有用户信息");
        return impl.getUserInfo();
    }
}
