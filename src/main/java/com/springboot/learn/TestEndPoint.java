package com.springboot.learn.SBLearn;


import java.io.File;
import java.nio.file.Files;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import reactor.core.publisher.Mono;

@RestController
public class TestEndPoint {

	@Autowired
	CustomBasicCardRepository customBasicCardRepository;
	
	
	WebClient webClient =WebClient.builder().baseUrl("http://localhost:8080").build();
	
	Logger logger = LogManager.getLogger(TestEndPoint.class);
	
	@RequestMapping(value="getInfo/{val}",method = RequestMethod.GET)
	public String getInfo(@PathVariable Long val)
	{
		Card card  =  customBasicCardRepository.findById(val).get();
		
		return card.toString();
	}
	
	@RequestMapping(value = "addData", method = RequestMethod.POST)
	public Card putSome() {
		
		return new Card("Derry", 438087,   new String[]{ "123444", "53330"} );
	} 
	
	@RequestMapping(value = "getTest")
	public Mono<Card> getSome() {
		
		
		File folder = new File(new File("").getAbsolutePath());
		System.out.println("Bef" +folder.getAbsolutePath()+"Aft");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
		    System.out.println("File " + listOfFiles[i].getName());
		  } else if (listOfFiles[i].isDirectory()) {
		    System.out.println("Directory " + listOfFiles[i].getName());
		  }
		}
		UriComponentsBuilder builder = MvcUriComponentsBuilder.fromController(TestEndPoint.class).path("getSome");
		System.out.println(builder.build().toString());
		return  webClient.post().uri("addData").retrieve().bodyToMono(Card.class);
		
	}

	@RequestMapping(value = "initDb")
	String initDb()
	{
		System.out.println("CALLED");
		customBasicCardRepository.save(new Card("Berry", 901087,   new String[]{ "123444", "53330"} ));
		customBasicCardRepository.save(new Card("Derry", 438087,   new String[]{ "123444", "53330"} ));
		customBasicCardRepository.save(new Card("Jerry", 838087,   new String[]{ "123444", "53330"} ));
		customBasicCardRepository.flush();
		return "Db init";
	}
	

}
