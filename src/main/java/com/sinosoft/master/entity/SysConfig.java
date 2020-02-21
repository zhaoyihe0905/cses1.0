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
@Table(name = "tb_sysconfig")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Proxy(lazy = false)
public class SysConfig extends BaseEntity{
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
    private Integer id;
	
	private String parametercode = "";

	private String parametertype = "";

	private String companyCode = "";

	private String parametervalue = "";

	private String areaCode = "";

	private String parameterdesc = "";

	private String remark = "";

	private String validStatus = "";
	
	private String flag= "";

}
