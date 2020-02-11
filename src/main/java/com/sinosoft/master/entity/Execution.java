package com.sinosoft.master.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sinosoft.master.entity.support.BaseEntity;

import lombok.Data;

/**
 * 执行顺序表
 * @author xujian
 *
 */
@Data
@Entity
@Table(name = "tb_execution")
public class Execution extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	/** 业务流程 */
	private String process;
	
//	/** 接口标识*/
//	private String interfaces;

	/** 顺序*/
	private String orders;

	/** 有效状态*/
	private String  validStatus;
	
	/** 备注*/
	private String remark;
	

}

