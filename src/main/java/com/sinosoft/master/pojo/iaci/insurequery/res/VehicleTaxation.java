/**
  * Copyright 2020 bejson.com 
  */
package com.sinosoft.master.pojo.iaci.insurequery.res;

/**
 * Auto-generated: 2020-01-06 11:17:17
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
    private String DeclareDate;
    private String PromptMessage;
    private CurrentTaxDue CurrentTaxDue;
    private DelinquentTaxDue DelinquentTaxDue;
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

    public void setDeclareDate(String DeclareDate) {
         this.DeclareDate = DeclareDate;
     }
     public String getDeclareDate() {
         return DeclareDate;
     }

    public void setPromptMessage(String PromptMessage) {
         this.PromptMessage = PromptMessage;
     }
     public String getPromptMessage() {
         return PromptMessage;
     }

    public void setCurrentTaxDue(CurrentTaxDue CurrentTaxDue) {
         this.CurrentTaxDue = CurrentTaxDue;
     }
     public CurrentTaxDue getCurrentTaxDue() {
         return CurrentTaxDue;
     }

    public void setDelinquentTaxDue(DelinquentTaxDue DelinquentTaxDue) {
         this.DelinquentTaxDue = DelinquentTaxDue;
     }
     public DelinquentTaxDue getDelinquentTaxDue() {
         return DelinquentTaxDue;
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