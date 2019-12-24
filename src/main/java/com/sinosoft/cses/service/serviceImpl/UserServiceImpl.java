package com.sinosoft.cses.service.serviceImpl;

import com.sinosoft.cses.dao.UserDao;
import com.sinosoft.cses.entity.User;
import com.sinosoft.cses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
