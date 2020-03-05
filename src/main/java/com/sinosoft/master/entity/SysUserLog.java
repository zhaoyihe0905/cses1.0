package com.sinosoft.master.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.alibaba.fastjson.annotation.JSONField;
import com.sinosoft.master.entity.support.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_user_log")
@Data
@Proxy(lazy = false)
public class SysUserLog extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
    private Integer id;
	
	private Integer uid;
	
	private String usercode;
	
	 
	private String ipaddr;
	
	
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	
	/** 登录信息 */
	private String message;

}
