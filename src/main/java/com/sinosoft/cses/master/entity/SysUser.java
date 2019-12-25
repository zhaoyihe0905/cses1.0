package com.sinosoft.cses.master.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_sys_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
    private Integer id;
    /** 用户代码 */
    private String usercode;
    /** 地区代码 */
    private String areacode;
    /** 用户名称 */
    private String username;
    /** 密码 */
    private String password;
    /** 公司代码 */
    private String companycode;
    /** 机构类型 1保险公司 2 杨业协会 3 交管员*/
    private String companytype;
    /** 人员级别  0普通  1管理员*/
    private String usergrade;
    /** 有效失效 0失效 1有效*/
    private String validstatus;

}
