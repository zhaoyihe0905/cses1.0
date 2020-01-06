/**
  * Copyright 2020 bejson.com 
  */
package com.sinosoft.master.pojo.iaci.insurequery.res;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Auto-generated: 2020-01-06 11:17:17
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