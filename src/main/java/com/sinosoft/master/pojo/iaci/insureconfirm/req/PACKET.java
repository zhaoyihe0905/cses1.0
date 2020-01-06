/**
  * Copyright 2019 bejson.com 
  */
package com.sinosoft.master.pojo.iaci.insureconfirm.req;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Auto-generated: 2019-12-30 15:20:0
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@XmlRootElement(name="PACKET")
public class PACKET {
    private HEAD HEAD;
    private BODY BODY;

    public void setHEAD(HEAD HEAD) {
         this.HEAD = HEAD;
     }
     public HEAD getHEAD() {
         return HEAD;
     }

    public void setBODY(BODY BODY) {
         this.BODY = BODY;
     }
     public BODY getBODY() {
         return BODY;
     }

}