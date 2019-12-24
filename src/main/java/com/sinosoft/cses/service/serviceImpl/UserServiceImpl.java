package com.sinosoft.cses.service.serviceImpl;

import com.sinosoft.cses.dao.UserDao;
import com.sinosoft.cses.entity.User;
import com.sinosoft.cses.service.UserService;
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
    public User getUserById(String id) {
        Optional<User> user = userDao.findById(id);
        User userInfo = new User();
        return  userInfo;

    }

    @Override
    public List<User> getUserInfo() {
        List<User> userList = userDao.findAll();
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
