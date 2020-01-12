package com.springboot.learn.SBLearn;

import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
class SbLearnApplicationTests {

	@Autowired
	MockMvc mvc;
	
	@Test
	void contextLoads() throws Exception {
	mvc.perform(get("/getInfo")).andReturn();	
	}

}
