package com.sinosoft.master.controller;

import com.sinosoft.cses.util.AppCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Hashtable;

/**
 * Created by MrZhong on 2020/2/26.
 * 系统参数控制层
 */

@Controller
public class SysConfigController {
    /** 日志*/
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Object[][] sysConfigListToObject() {
        Hashtable<String, String> hashSysConfig = AppCache.hashSysConfig;
        try {
            int i = 0;
            Object[][] objects = new Object[hashSysConfig.size()][3];
            for (String key : hashSysConfig.keySet()) {
                objects[i][0] = key;
                objects[i][1] = hashSysConfig.get(key);
                i++;
            }
            return objects;
        } catch (Exception e) {
            logger.info("系统参数列表数据展现失败");
        }
        return null;
    }
}
