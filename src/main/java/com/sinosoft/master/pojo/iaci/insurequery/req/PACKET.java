/**
  * Copyright 2019 bejson.com 
  */
package com.sinosoft.master.pojo.iaci.insurequery.req;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Auto-generated: 2019-12-30 14:53:21
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class PACKET {

    private HEAD HEAD;
    private BODY BODY;


    
    public com.sinosoft.master.pojo.iaci.insurequery.req.HEAD getHEAD() {
        return HEAD;
    }

    public void setHEAD(com.sinosoft.master.pojo.iaci.insurequery.req.HEAD HEAD) {
        this.HEAD = HEAD;
    }

    public com.sinosoft.master.pojo.iaci.insurequery.req.BODY getBODY() {
        return BODY;
    }

    public void setBODY(com.sinosoft.master.pojo.iaci.insurequery.req.BODY BODY) {
        this.BODY = BODY;
    }
}