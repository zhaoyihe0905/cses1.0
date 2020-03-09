package com.sinosoft.master.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.sinosoft.master.entity.support.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "tb_code")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Proxy(lazy = false)
public class CsCode extends BaseEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
    private Integer id;
	/** 代码类型*/
	private String codeType;
	
	/** 代码*/
	private String codeCode;
	
	/** 代码名*/
	private String codeName;
	
	/** 标识*/
	private String codeFlag;
	
	/** 备注*/
	private String remark;
	
	/** 有效状态*/
	private String validStatus;
	

}
