package com.springboot.learn.SBLearn;


import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestEndPoint {

	Logger logger = LogManager.getLogger(TestEndPoint.class);
	
	@RequestMapping("getInfo/{val}")
	public String getInfo(@PathVariable int val)
	{
		
		logger.info("Debug Application finally","val is ",val);
		if(val==1)
		{
			throw new CustomExceptions().new InvalidData();
			
		}else if(val==2)
		{
			throw new CustomExceptions().new InvalidUser();
			
		}
		return "good";
	}
}
