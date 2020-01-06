/**
  * Copyright 2019 bejson.com 
  */
package com.sinosoft.master.pojo.iaci.insureconfirm.req;

/**
 * Auto-generated: 2019-12-30 15:20:0
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class VehicleTaxation {

    private String TaxTermTypeCode;
    private String TaxConditionCode;
    private String TaxRegistryNumber;
    private String TaxPayerName;
    private String TaxPayerIdentificationCode;
    private CurrentTaxDue CurrentTaxDue;
    private TaxAmount TaxAmount;
    private String Declare_Status_IA;
    private String Calc_Tax_Flag;
    public void setTaxTermTypeCode(String TaxTermTypeCode) {
         this.TaxTermTypeCode = TaxTermTypeCode;
     }
     public String getTaxTermTypeCode() {
         return TaxTermTypeCode;
     }

    public void setTaxConditionCode(String TaxConditionCode) {
         this.TaxConditionCode = TaxConditionCode;
     }
     public String getTaxConditionCode() {
         return TaxConditionCode;
     }

    public void setTaxRegistryNumber(String TaxRegistryNumber) {
         this.TaxRegistryNumber = TaxRegistryNumber;
     }
     public String getTaxRegistryNumber() {
         return TaxRegistryNumber;
     }

    public void setTaxPayerName(String TaxPayerName) {
         this.TaxPayerName = TaxPayerName;
     }
     public String getTaxPayerName() {
         return TaxPayerName;
     }

    public void setTaxPayerIdentificationCode(String TaxPayerIdentificationCode) {
         this.TaxPayerIdentificationCode = TaxPayerIdentificationCode;
     }
     public String getTaxPayerIdentificationCode() {
         return TaxPayerIdentificationCode;
     }

    public void setCurrentTaxDue(CurrentTaxDue CurrentTaxDue) {
         this.CurrentTaxDue = CurrentTaxDue;
     }
     public CurrentTaxDue getCurrentTaxDue() {
         return CurrentTaxDue;
     }

    public void setTaxAmount(TaxAmount TaxAmount) {
         this.TaxAmount = TaxAmount;
     }
     public TaxAmount getTaxAmount() {
         return TaxAmount;
     }

    public void setDeclare_Status_IA(String Declare_Status_IA) {
         this.Declare_Status_IA = Declare_Status_IA;
     }
     public String getDeclare_Status_IA() {
         return Declare_Status_IA;
     }

    public void setCalc_Tax_Flag(String Calc_Tax_Flag) {
         this.Calc_Tax_Flag = Calc_Tax_Flag;
     }
     public String getCalc_Tax_Flag() {
         return Calc_Tax_Flag;
     }

}