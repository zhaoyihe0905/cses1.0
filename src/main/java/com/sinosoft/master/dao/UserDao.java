package com.sinosoft.master.dao;

import org.springframework.data.jpa.mapping.JpaPersistentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sinosoft.master.entity.SysUser;

/**
 * 集成Jpa数据库操作接口
 */
public interface UserDao extends JpaRepository<SysUser,Integer>{
    @Modifying
    @Query("UPDATE SysUser SET age=?1 where name = ?2")
    Integer updateUser(String age,String name);
}
