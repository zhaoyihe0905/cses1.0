package com.sinosoft.master.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.sinosoft.master.entity.support.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 全局变量表
 * @author xujian
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_variable")
@Proxy(lazy = false)
public class GlobalVariable extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 变量名
	 */
	@Id
	private String variable_code;
	
	/** 变量值*/
	private String variable_name;
	
	/** 状态*/
	 @Column(nullable=false,name="valide_status",columnDefinition="int default 1")
	private Integer valide_status;
	 
	/** 有效值*/
	 @Column(nullable=false,name="remark",columnDefinition="varchar(50) default \"\"")
	private String remark;

}
