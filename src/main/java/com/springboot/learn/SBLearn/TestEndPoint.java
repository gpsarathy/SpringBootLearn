package com.springboot.learn.SBLearn;


import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import reactor.core.publisher.Mono;

@RestController
public class TestEndPoint {

	WebClient webClient =WebClient.builder().baseUrl("http://localhost:8080").build();
	
	Logger logger = LogManager.getLogger(TestEndPoint.class);
	
	@RequestMapping(value="getInfo/{val}",method = RequestMethod.GET)
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
	
	@RequestMapping(value = "addData", method = RequestMethod.POST)
	public Card putSome() {
		
		return new Card("Derry", 438087,   new String[]{ "123444", "53330"} );
	} 
	
	@RequestMapping(value = "getTest")
	public Mono<Card> getSome() {
		
		
		
		return  webClient.post().uri("addData").retrieve().bodyToMono(Card.class);
		
	}

}
