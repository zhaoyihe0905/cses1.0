/**
  * Copyright 2019 bejson.com 
  */
package com.sinosoft.master.pojo.iaci.endorquery;

/**
 * Auto-generated: 2019-12-30 15:27:23
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class CurrentTaxDue {

    private String TaxConditionCode;
    private String TaxStartDate;
    private String TaxEndDate;
    private Paid Paid;
    private Derate Derate;
    public void setTaxConditionCode(String TaxConditionCode) {
         this.TaxConditionCode = TaxConditionCode;
     }
     public String getTaxConditionCode() {
         return TaxConditionCode;
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

}