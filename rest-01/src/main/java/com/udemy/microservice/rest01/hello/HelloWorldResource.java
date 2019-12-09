package com.udemy.microservice.rest01.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
