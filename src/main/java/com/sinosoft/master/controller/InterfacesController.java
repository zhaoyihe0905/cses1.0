package com.sinosoft.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sinosoft.cses.util.AppCache;
import com.sinosoft.master.entity.Interfaces;
import com.sinosoft.master.service.InterfacesService;

import javax.swing.*;

@Controller
public class InterfacesController {
	/** 日志*/
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private InterfacesService interfacesService;
	
	@Autowired
	private AppCache appCache;
	
	/**
	 * 此方法， List<Interfaces>转化为objects 
	 * @param lis
	 * @author xujian
	 * @param column 
	 * @Date 2020-02-04
	 * @return
	 */
	public  Object[][] interfacesListToObject(int column){
		logger.info("开始查询接口列表！");
		List<Interfaces> interfaces = AppCache.interfaces;
		try {
			Object[][] objects = new Object[interfaces.size()][column];
			int i = 0;
			for (Interfaces key : interfaces) {
				objects[i][0] = key.getXmlName();
				objects[i][1] = key.getName();
				objects[i][2] = key.getUrl();
				objects[i][3] = key.getInconfigField();
				objects[i][4] = key.getOutconfigField();
				objects[i][5] = key.getIdentification();
				objects[i][6] = key.getJudgecode();
				objects[i][7] = key.getId();
				i++;
			}
			logger.info("查询成功！");
			return objects;
		} catch (Exception e) {
			logger.info("接口列表数据展现失败"+e.toString());
		}
		return null;
	}
	
	/**
	 * 保存接口数据
	 * @param list
	 * @author xujian
	 * @Date 2020-02-04
	 */
	public void saveInterfaces(List<Interfaces> list) {
		for (Interfaces interfaces : list) {
			interfacesService.replace(interfaces);
		}
		//初始化缓存
		appCache.initInterface();
		
	}
	
	/**
	 * 删除接口数据
	 * @param name
	 * @author xujian
	 * @Date 2020-02-04
	 */
	public void deleteInterfaces(Integer id) {
		try {
			interfacesService.delete(id);
			logger.info("接口数据删除成功！");
		} catch (Exception e) {
			logger.info("接口数据删除失败");
		}
		//初始化缓存
		appCache.initInterface();
	}
	

}
