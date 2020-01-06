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
public class CurrentTaxDue {

    private String TaxConditionCode;
    private String TaxLocationCode;
    private String TaxStartDate;
    private String TaxEndDate;
    private String TaxUnitTypeCode;
    private String UnitRate;
    private String AnnualTaxAmount;
    private Paid Paid;
    private Derate Derate;
    private String TaxDue;
    private String ExceedDaysCount;
    private String OverDue;
    private String TotalAmount;
    public void setTaxConditionCode(String TaxConditionCode) {
         this.TaxConditionCode = TaxConditionCode;
     }
     public String getTaxConditionCode() {
         return TaxConditionCode;
     }

    public void setTaxLocationCode(String TaxLocationCode) {
         this.TaxLocationCode = TaxLocationCode;
     }
     public String getTaxLocationCode() {
         return TaxLocationCode;
     }

    public void setTaxStartDate(String TaxStartDate) {
         this.TaxStartDate = TaxStartDate;
     }
     public String getTaxStartDate() {
         return TaxStartDate;
     }

    public void setTaxEndDate(String TaxEndDate) {
         this.TaxEndDate = TaxEndDate;
     }
     public String getTaxEndDate() {
         return TaxEndDate;
     }

    public void setTaxUnitTypeCode(String TaxUnitTypeCode) {
         this.TaxUnitTypeCode = TaxUnitTypeCode;
     }
     public String getTaxUnitTypeCode() {
         return TaxUnitTypeCode;
     }

    public void setUnitRate(String UnitRate) {
         this.UnitRate = UnitRate;
     }
     public String getUnitRate() {
         return UnitRate;
     }

    public void setAnnualTaxAmount(String AnnualTaxAmount) {
         this.AnnualTaxAmount = AnnualTaxAmount;
     }
     public String getAnnualTaxAmount() {
         return AnnualTaxAmount;
     }

    public void setPaid(Paid Paid) {
         this.Paid = Paid;
     }
     public Paid getPaid() {
         return Paid;
     }

    public void setDerate(Derate Derate) {
         this.Derate = Derate;
     }
     public Derate getDerate() {
         return Derate;
     }

    public void setTaxDue(String TaxDue) {
         this.TaxDue = TaxDue;
     }
     public String getTaxDue() {
         return TaxDue;
     }

    public void setExceedDaysCount(String ExceedDaysCount) {
         this.ExceedDaysCount = ExceedDaysCount;
     }
     public String getExceedDaysCount() {
         return ExceedDaysCount;
     }

    public void setOverDue(String OverDue) {
         this.OverDue = OverDue;
     }
     public String getOverDue() {
         return OverDue;
     }

    public void setTotalAmount(String TotalAmount) {
         this.TotalAmount = TotalAmount;
     }
     public String getTotalAmount() {
         return TotalAmount;
     }

}