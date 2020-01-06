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
public class HEAD {

    private String REQUEST_TYPE;
    private String RESPONSE_CODE;
    private String ERROR_CODE;
    private String ERROR_MESSAGE;
    public void setREQUEST_TYPE(String REQUEST_TYPE) {
         this.REQUEST_TYPE = REQUEST_TYPE;
     }
     public String getREQUEST_TYPE() {
         return REQUEST_TYPE;
     }

    public void setRESPONSE_CODE(String RESPONSE_CODE) {
         this.RESPONSE_CODE = RESPONSE_CODE;
     }
     public String getRESPONSE_CODE() {
         return RESPONSE_CODE;
     }

    public void setERROR_CODE(String ERROR_CODE) {
         this.ERROR_CODE = ERROR_CODE;
     }
     public String getERROR_CODE() {
         return ERROR_CODE;
     }

    public void setERROR_MESSAGE(String ERROR_MESSAGE) {
         this.ERROR_MESSAGE = ERROR_MESSAGE;
     }
     public String getERROR_MESSAGE() {
         return ERROR_MESSAGE;
     }

}