package com.sinosoft.cses.master.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.sinosoft.cses.master.entity.support.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_cses_log")
@AllArgsConstructor
@NoArgsConstructor
public class CsesLog extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** uuid*/
	@Id
	@Column(name = "uuid")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String uuid;
	
	/** 投保查询码*/
	private String querySequenceNo = "";

	/** 请求开始时间*/
	private Date reqStartTime = new Date();
	
	/** 请求结束时间*/
	private Date reqEndTime = new Date();

	/** 接口相应时间*/
	private long responseTime = 0L;
	
	/** 业务代码*/
	private String businessType = "";

	/** 请求接口名*/
	private String reqServiceName = "";
	
	/** 险种类型(1 商业 0 交强) */
	private String reqType = "";

	/** 请求结果*/
	private String resInfo = "";
	

}
