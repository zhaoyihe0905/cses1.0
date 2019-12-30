package com.sinosoft.view.util;

/**
 * 常量类
 * @author xujian
 * @Data 2019-12-30
 *
 */
public class Appconst implements CARequestTypeConst, CIRequestTypeConst{
	
}
	
	/**
	 * 商业险核心接口名
	 * @author xujian
	 *
	 */
	interface CARequestTypeConst{
	
	/** 投保查询：V0101 */
	public static final String INSURE_QUERY_TYPE_CA = "V0101";
	
	/** 投保查询校验：V0121 */
	public static final String INSURE_QUERY_CHECK_TYPE_CA = "V0121";
		
	/** 投保预确认：V0209 */
	public static final String INSURE_PRE_CONFIRM_TYPE_CA = "V0209";

	/** 投保确认：V0201 */
	public static final String INSURE_CONFIRM_TYPE_CA = "V0201";
	
	/** 保单号上传 V0309 */
	public static final String POLICYNO_UPLOAD_TYPE_CA = "V0309";
	
	/** 投保注销 V04 */
	public static final String INSURE_CANCEL_TYPE_CA = "V04";
	
	/** 投保注销 V04 */
	public static final String VEHICLE_QUERY_TYPE_CA = "V42";
		/**车型及纯风险保费查询 V43*/
		
	public static final String CARPURERISKPRE_QUERY_TYPE_CA = "V43";
	
	/**交强和商业保单关联关系上传 V44*/
	public static final String CIANDCA_POLICY_RALATION_TYPE_CA = "V44";
	
	/** 直接承保接口 V05  */
	public static final String INSURE_DIRECT_TYPE_CA = "V05";
	
	/** 电子保单或批单生成 V45 */
	public static final String E_POLICY_OR_ENDOR_CREATE_CA = "V45";
		
	/** 承保交管车辆查询校验 V46*/
    public static final String INSURE_PM_VEHICLE_QUERY_CHECK_TYPE_CA = "V46";

    /** 承保交管车辆查询确认 V47*/
    public static final String INSURE_PM_VEHICLE_QUERY_CONFIRM_TYPE_CA = "V47";

	/**交管新登记车辆号牌信息查询*/
	public static final String PM_VEHICLE_NEWCAR_INFO_TYPE_CA = "V50";
	
	/** 验证码生成接口 V48*/
    public static final String INSURE_VERIFICATION_CODE_CREATE_TYPE_CA = "V48";
	
	/** 缴费实名认证 V49 Certification **/
    public static final String PAY_CERTIFICATION_TYPE_CA ="V49"; 
    
    /** 批改询价：V2101 */
	public static final String ENDOR_QUERY_TYPE_CA = "V2101";
	
	/** 批改预确认：V2109 */
	public static final String ENDOR_PRE_CONFIRM_TYPE_CA = "V2109";

	/** 批改确认：V22 */
	public static final String ENDOR_CONFIRM_TYPE_CA = "V22";
	
	/** 批改注销：V24 */
	public static final String ENDOR_CANCEL_TYPE_CA = "V24";
	
	}
	
    
	/**
	 * 交强险核心接口名
	 * @author xujian
	 *
	 */
	interface CIRequestTypeConst{
	
	/** 投保查询：01 */
	public static final String INSURE_QUERY_TYPE_CI = "01";
	
		/**投保查询校验：21 */
	public static final String INSURE_QUERY_CHECK_TYPE_CI = "21";
		
	/** 投保确认：02 */
	public static final String INSURE_CONFIRM_TYPE_CI = "02";

	/** 投保注销：03 */
	public static final String INSURE_CANCEL_TYPE_CI = "03";

	/** 直接投保：08 */
	public static final String INSURE_DIRECT_TYPE_CI = "08";




	/** 批改询价：04 */
	public static final String ENDOR_QUERY_TYPE_CI = "04";

	/** 批改确认：05 */
	public static final String ENDOR_CONFIRM_TYPE_CI = "05";

	/** 批改注销：06 */
	public static final String ENDOR_CANCEL_TYPE_CI = "06";

	/** 直接批改：09 */
	public static final String ENDOR_DIRECT_TYPE_CI = "09";

	/** 保险标志批量上传:70 */
	public static final String ENDOR_SALIMARK_TYPE_CI = "70";

	/** 保单号上传 71 */
	public static final String ENDOR_POLICYNO_TYPE_CI = "71";
	
		/** 承保交管车辆查询校验：72 */
	public static final String INSURE_PM_VEHICLE_QUERY_CHECK_TYPE_CI = "72";
	
		/** 承保交管车辆查询确认：73 */
	public static final String INSURE_PM_VEHICLE_QUERY_CONFIRM_TYPE_CI = "73";
		
		/**交管新登记车辆号牌信息查询*/
	public static final String PM_VEHICLE_NEWCAR_INFO_TYPE_CI = "77";
		
		/** 电子保单或批单生成*/
	public static final String E_POLICY_OR_ENDOR_CREATE_TYPE_CI = "76";
    

}
