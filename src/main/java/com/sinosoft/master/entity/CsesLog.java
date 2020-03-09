package com.sinosoft.master.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import com.sinosoft.master.entity.support.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_cses_log")
@AllArgsConstructor
@NoArgsConstructor
@Proxy(lazy = false)
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
	
	/** 地区代码 */
	private String areaCode;
	
	/** 业务场景名字*/
	private String executeName;
	
	/** 业务场景UUID,表示同一次执行的业务场景*/
	private String executeUUID;
	
	/** 接口标识*/
	private String identification ;
	
	/** 接口标识类型*/
	private String identificationType ;
	
	/** 请求开始时间*/
	private Date reqStartTime = new Date();
	
	/** 请求结束时间*/
	private Date reqEndTime = new Date();

	/** 接口相应时间*/
	private Integer responseTime = 0;
	
	/** 返回错误代码 */
	private String judgeStatus;
	
	/** 请求成功或者失败(物理方面)*/
	private Integer result ;

	/** 请求接口名*/
	private String reqServiceName = "";
	
//	/** 险种类型(1 商业 0 交强) */
//	private String reqType = "";

	/** 请求结果*/
	private String resInfo = "";
	

}
