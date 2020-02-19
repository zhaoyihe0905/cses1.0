package com.sinosoft.master.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sinosoft.master.entity.support.BaseEntity;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_interfaces")
public class Interfaces extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	@Id
//	/** 接口标识*/
//	private String bussinessType;
//	/** 需要从该环节取出的字段*/
//	private String outconfigField;
//	/** 需要从该环节存入的字段*/
//	private String inconfigField;
//	/** 请求险种类型 */
//	private String requestType;
//	/** 有效标识*/
//	private String validStatus;
//	/** 报文名字*/
//	private String xmlName;
//	/** 接口描述*/
//	@Column(length = 50)
//	private String bussiness_desc;
//	/** 备注*/
//	private String remark;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
    private Integer id;
	/** 需要从该环节取出的字段*/
	private String outconfigField;
	/** 需要从该环节存入的字段*/
	private String inconfigField;
//	private String requestType;
	/** 有效标识*/
	private String validStatus;
	/** 报文名字*/
	private String xmlName;
//	@Id
	/** 接口描述*/
	private String bussiness_desc;
	/** 备注*/
	private String remark;
	
	/** 接口访问路劲*/
	private String url;
	
	
	
	

}
