package com.udemy.microservice.rest01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
public class Rest01Application {

	public static void main(String[] args) {
		SpringApplication.run(Rest01Application.class, args);
	}
}