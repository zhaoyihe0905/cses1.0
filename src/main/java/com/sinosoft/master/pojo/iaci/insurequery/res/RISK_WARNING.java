/**
  * Copyright 2020 bejson.com 
  */
package com.sinosoft.master.pojo.iaci.insurequery.res;
import java.util.List;

/**
 * Auto-generated: 2020-01-06 11:17:17
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class RISK_WARNING {

    private String RISK_WARNING_TYPE;
    private List<RISK_WARNING_CLAIM_ITEM> RISK_WARNING_CLAIM_ITEM;
    public void setRISK_WARNING_TYPE(String RISK_WARNING_TYPE) {
         this.RISK_WARNING_TYPE = RISK_WARNING_TYPE;
     }
     public String getRISK_WARNING_TYPE() {
         return RISK_WARNING_TYPE;
     }

    public void setRISK_WARNING_CLAIM_ITEM(List<RISK_WARNING_CLAIM_ITEM> RISK_WARNING_CLAIM_ITEM) {
         this.RISK_WARNING_CLAIM_ITEM = RISK_WARNING_CLAIM_ITEM;
     }
     public List<RISK_WARNING_CLAIM_ITEM> getRISK_WARNING_CLAIM_ITEM() {
         return RISK_WARNING_CLAIM_ITEM;
     }

}