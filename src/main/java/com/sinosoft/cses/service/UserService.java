package com.sinosoft.cses.service;

import com.sinosoft.cses.entity.User;

import java.util.List;

public interface UserService {
    public User getUserById(String id);
    public List<User> getUserInfo();
}
