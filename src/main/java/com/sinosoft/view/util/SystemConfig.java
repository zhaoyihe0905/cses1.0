package com.sinosoft.view.util;

/**
 * 系统配置类
 * @author xujian
 * @Date 2019-12-26
 *
 */
public class SystemConfig {
	
	/** 商业URL */
	public final static String IACA_URL = "IacaUrl";
	/** 交强URL */
	public final static String IACI_URL = "IaciUrl";
	
	
	
	/** 投保查询：V0101 */
	public static final String INSURE_QUERY_TYPE = "V0101";
	
	/** 投保查询校验：V0121 */
	public static final String INSURE_QUERY_CHECK_TYPE = "V0121";
		
	/** 投保预确认：V0209 */
	public static final String INSURE_PRE_CONFIRM_TYPE = "V0209";

	/** 投保确认：V0201 */
	public static final String INSURE_CONFIRM_TYPE = "V0201";
	
	/** 保单号上传 V0309 */
	public static final String POLICYNO_UPLOAD_TYPE = "V0309";
	
	/** 投保注销 V04 */
	public static final String INSURE_CANCEL_TYPE = "V04";
	
	/** 投保注销 V04 */
	public static final String VEHICLE_QUERY_TYPE = "V42";
		/**车型及纯风险保费查询 V43*/
		
	public static final String CARPURERISKPRE_QUERY_TYPE = "V43";
	
	/**交强和商业保单关联关系上传 V44*/
	public static final String CIANDCA_POLICY_RALATION_TYPE = "V44";
	
	/** 直接承保接口 V05 add by sunmf 2010-12-29 Start*/
	public static final String INSURE_DIRECT_TYPE = "V05";
	
		/** 电子保单或批单生成 V45 */
	public static final String E_POLICY_OR_ENDOR_CREATE = "V45";
		
		/** 承保交管车辆查询校验 V46*/
    public static final String INSURE_PM_VEHICLE_QUERY_CHECK_TYPE = "V46";

    /** 承保交管车辆查询确认 V47*/
    public static final String INSURE_PM_VEHICLE_QUERY_CONFIRM_TYPE = "V47";

	/**交管新登记车辆号牌信息查询*/
	public static final String PM_VEHICLE_NEWCAR_INFO_TYPE = "V50";
	
	/** 验证码生成接口 V48*/
    public static final String INSURE_VERIFICATION_CODE_CREATE_TYPE= "V48";
	
	/** 缴费实名认证 V49 Certification **/
    public static final String PAY_CERTIFICATION_TYPE ="V49"; 
    
    
    
    
    
    
    

}
