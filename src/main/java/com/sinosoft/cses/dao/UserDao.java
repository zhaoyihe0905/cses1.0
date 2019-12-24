package com.sinosoft.cses.dao;

import com.sinosoft.cses.entity.User;
import org.springframework.data.jpa.mapping.JpaPersistentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 集成Jpa数据库操作接口
 */
public interface UserDao extends JpaRepository<User,String>{
    @Modifying
    @Query("UPDATE User SET age=?1 where name = ?2")
    Integer updateUser(String age,String name);
}
