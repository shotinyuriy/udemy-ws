package com.udemy.microservice.rest01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.microservice.rest01.model.HelloBean;

@RestController
public class HelloWorldResource {

	@GetMapping("/hello/{name}")
	public String helloWorld(@PathVariable String name) {
		return "Hello World! Welcome "+name;
	}
	
	@GetMapping("/hello-bean/{name}")
	public HelloBean helloBean(@PathVariable String name) {
		return new HelloBean("Hello World! Welcome "+name);
	}
}
