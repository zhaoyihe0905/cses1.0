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
public class VehicleTaxation_NB {

    private String TAXTERMTYPECODE;
    private String TAXCONDITIONCODE;
    private String TAXREGISTRYNUMBER;
    private String TAXPAYERNAME;
    private String TAXPAYERIDENTIFICATIONCODE;
    private String PromptMessage;
    private CurrentTaxDue CURRENTTAXDUE;
    private DelinquentTaxDue DELINQUENTTAXDUE;
    private String ANNUALTAXDUE;
    private String SUMTAXDEFAULT;
    private String SUMOVERDUE;
    private String SUMTAX;
    private String TAXDESCRIPTION;
    public void setTAXTERMTYPECODE(String TAXTERMTYPECODE) {
         this.TAXTERMTYPECODE = TAXTERMTYPECODE;
     }
     public String getTAXTERMTYPECODE() {
         return TAXTERMTYPECODE;
     }

    public void setTAXCONDITIONCODE(String TAXCONDITIONCODE) {
         this.TAXCONDITIONCODE = TAXCONDITIONCODE;
     }
     public String getTAXCONDITIONCODE() {
         return TAXCONDITIONCODE;
     }

    public void setTAXREGISTRYNUMBER(String TAXREGISTRYNUMBER) {
         this.TAXREGISTRYNUMBER = TAXREGISTRYNUMBER;
     }
     public String getTAXREGISTRYNUMBER() {
         return TAXREGISTRYNUMBER;
     }

    public void setTAXPAYERNAME(String TAXPAYERNAME) {
         this.TAXPAYERNAME = TAXPAYERNAME;
     }
     public String getTAXPAYERNAME() {
         return TAXPAYERNAME;
     }

    public void setTAXPAYERIDENTIFICATIONCODE(String TAXPAYERIDENTIFICATIONCODE) {
         this.TAXPAYERIDENTIFICATIONCODE = TAXPAYERIDENTIFICATIONCODE;
     }
     public String getTAXPAYERIDENTIFICATIONCODE() {
         return TAXPAYERIDENTIFICATIONCODE;
     }

    public void setPromptMessage(String PromptMessage) {
         this.PromptMessage = PromptMessage;
     }
     public String getPromptMessage() {
         return PromptMessage;
     }

    public CurrentTaxDue getCURRENTTAXDUE() {
		return CURRENTTAXDUE;
	}
	public void setCURRENTTAXDUE(CurrentTaxDue cURRENTTAXDUE) {
		CURRENTTAXDUE = cURRENTTAXDUE;
	}
	public DelinquentTaxDue getDELINQUENTTAXDUE() {
		return DELINQUENTTAXDUE;
	}
	public void setDELINQUENTTAXDUE(DelinquentTaxDue dELINQUENTTAXDUE) {
		DELINQUENTTAXDUE = dELINQUENTTAXDUE;
	}
	public void setANNUALTAXDUE(String ANNUALTAXDUE) {
         this.ANNUALTAXDUE = ANNUALTAXDUE;
     }
     public String getANNUALTAXDUE() {
         return ANNUALTAXDUE;
     }

    public void setSUMTAXDEFAULT(String SUMTAXDEFAULT) {
         this.SUMTAXDEFAULT = SUMTAXDEFAULT;
     }
     public String getSUMTAXDEFAULT() {
         return SUMTAXDEFAULT;
     }

    public void setSUMOVERDUE(String SUMOVERDUE) {
         this.SUMOVERDUE = SUMOVERDUE;
     }
     public String getSUMOVERDUE() {
         return SUMOVERDUE;
     }

    public void setSUMTAX(String SUMTAX) {
         this.SUMTAX = SUMTAX;
     }
     public String getSUMTAX() {
         return SUMTAX;
     }

    public void setTAXDESCRIPTION(String TAXDESCRIPTION) {
         this.TAXDESCRIPTION = TAXDESCRIPTION;
     }
     public String getTAXDESCRIPTION() {
         return TAXDESCRIPTION;
     }

}