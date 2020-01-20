package com.springboot.learn.SBLearn;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
class TestEndPointCases {

	@Autowired(required = true)
	WebClient webClinet;
	
	
	@Test
	void test() {
		this.webClinet = WebClient.builder().baseUrl("http://localhost:8080").build();
		
		System.out.println(webClinet.post().uri("addData").retrieve());
	}

}
