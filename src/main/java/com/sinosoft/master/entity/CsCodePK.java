package com.sinosoft.master.entity;


import javax.persistence.Embeddable;

import com.sinosoft.master.entity.support.BaseEntity;

import lombok.Data;

@Data
@Embeddable
public class CsCodePK extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codeType;
	private String codeCode;
	

}
