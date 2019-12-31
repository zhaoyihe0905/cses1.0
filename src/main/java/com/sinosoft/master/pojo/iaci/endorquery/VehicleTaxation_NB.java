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
public class VehicleTaxation_NB {

    private String TaxTermTypeCode;
    private String TaxConditionCode;
    private String TaxRegistryNumber;
    private String TaxPayerName;
    private String TaxPayerIdentificationCode;
    private CurrentTaxDue CurrentTaxDue;
    private DelinquentTaxDue DelinquentTaxDue;
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

    public void setDelinquentTaxDue(DelinquentTaxDue DelinquentTaxDue) {
         this.DelinquentTaxDue = DelinquentTaxDue;
     }
     public DelinquentTaxDue getDelinquentTaxDue() {
         return DelinquentTaxDue;
     }

}