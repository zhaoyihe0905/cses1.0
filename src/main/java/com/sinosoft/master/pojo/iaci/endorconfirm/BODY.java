/**
  * Copyright 2019 bejson.com 
  */
package com.sinosoft.master.pojo.iaci.endorconfirm;
import java.util.List;

/**
 * Auto-generated: 2019-12-30 15:36:4
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class BODY {

    private BASE_PART BASE_PART;
    private CHECK_VEHICLE CHECK_VEHICLE;
    private PH_LIST PH_LIST;
    private INSURED_LIST INSURED_LIST;
    private List<ENDOR_ACCOUNT_INFO> ENDOR_ACCOUNT_INFO;
    private COMPANY_INFO COMPANY_INFO;
    private VehicleTaxation VehicleTaxation;
    public void setBASE_PART(BASE_PART BASE_PART) {
         this.BASE_PART = BASE_PART;
     }
     public BASE_PART getBASE_PART() {
         return BASE_PART;
     }

    public void setCHECK_VEHICLE(CHECK_VEHICLE CHECK_VEHICLE) {
         this.CHECK_VEHICLE = CHECK_VEHICLE;
     }
     public CHECK_VEHICLE getCHECK_VEHICLE() {
         return CHECK_VEHICLE;
     }

    public void setPH_LIST(PH_LIST PH_LIST) {
         this.PH_LIST = PH_LIST;
     }
     public PH_LIST getPH_LIST() {
         return PH_LIST;
     }

    public void setINSURED_LIST(INSURED_LIST INSURED_LIST) {
         this.INSURED_LIST = INSURED_LIST;
     }
     public INSURED_LIST getINSURED_LIST() {
         return INSURED_LIST;
     }

    public void setENDOR_ACCOUNT_INFO(List<ENDOR_ACCOUNT_INFO> ENDOR_ACCOUNT_INFO) {
         this.ENDOR_ACCOUNT_INFO = ENDOR_ACCOUNT_INFO;
     }
     public List<ENDOR_ACCOUNT_INFO> getENDOR_ACCOUNT_INFO() {
         return ENDOR_ACCOUNT_INFO;
     }

    public void setCOMPANY_INFO(COMPANY_INFO COMPANY_INFO) {
         this.COMPANY_INFO = COMPANY_INFO;
     }
     public COMPANY_INFO getCOMPANY_INFO() {
         return COMPANY_INFO;
     }

    public void setVehicleTaxation(VehicleTaxation VehicleTaxation) {
         this.VehicleTaxation = VehicleTaxation;
     }
     public VehicleTaxation getVehicleTaxation() {
         return VehicleTaxation;
     }

}