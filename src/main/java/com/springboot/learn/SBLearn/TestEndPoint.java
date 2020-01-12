package com.springboot.learn.SBLearn;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestEndPoint {

	Logger logger = LogManager.getLogger(TestEndPoint.class);
	
	@RequestMapping("getInfo")
	public String getInfo()
	{
		logger.info("Debug Application finally");
		return "App is running";
	}
}
