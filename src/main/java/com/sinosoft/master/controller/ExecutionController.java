package com.sinosoft.master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sinosoft.master.service.ExecutionService;

@Controller
public class ExecutionController {
	
	@Autowired
	private ExecutionService executionService;
	
	
	
}

