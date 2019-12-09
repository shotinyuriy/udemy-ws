package com.udemy.microservice.rest01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.udemy.microservice.rest01.hello.HelloWorldResource;

@SpringBootTest
class Rest01ApplicationTests {

	@Autowired
	HelloWorldResource helloWorldResource;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void helloWorldTest() {
		String result = helloWorldResource.helloWorld("Name");
		
		assert(result != null);
		assert(result.contains("Name"));
	}
}
