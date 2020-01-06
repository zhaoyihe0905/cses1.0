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
public class TaxAmount {

    private String TaxAmount_Flag;
    private String AnnualTaxDue;
    private String SumTaxDefault;
    private String SumOverdue;
    private String SumTax;
    public void setTaxAmount_Flag(String TaxAmount_Flag) {
         this.TaxAmount_Flag = TaxAmount_Flag;
     }
     public String getTaxAmount_Flag() {
         return TaxAmount_Flag;
     }

    public void setAnnualTaxDue(String AnnualTaxDue) {
         this.AnnualTaxDue = AnnualTaxDue;
     }
     public String getAnnualTaxDue() {
         return AnnualTaxDue;
     }

    public void setSumTaxDefault(String SumTaxDefault) {
         this.SumTaxDefault = SumTaxDefault;
     }
     public String getSumTaxDefault() {
         return SumTaxDefault;
     }

    public void setSumOverdue(String SumOverdue) {
         this.SumOverdue = SumOverdue;
     }
     public String getSumOverdue() {
         return SumOverdue;
     }

    public void setSumTax(String SumTax) {
         this.SumTax = SumTax;
     }
     public String getSumTax() {
         return SumTax;
     }

}