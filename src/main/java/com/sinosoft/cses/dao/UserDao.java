package com.sinosoft.cses.dao;

import com.sinosoft.cses.entity.User;
import org.springframework.data.jpa.mapping.JpaPersistentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 集成Jpa数据库操作接口
 */
public interface UserDao extends JpaRepository<User,String>{
}
