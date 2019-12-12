package com.udemy.microservice.rest01.swagger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("rest-01 API Info", "Awesome rest-01 API Info", "1.0",
			"https://google.com", new Contact("Yuriy", "https://google.com", "shotinyuriy@gmail.com"),
			"GNU GPL License", "https://google.com");

	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(
				Arrays.asList("application/json", "application/xml")
			);
	
	@Bean
	public Docket api() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		docket.apiInfo(DEFAULT_API_INFO);
		docket.produces(DEFAULT_PRODUCES_AND_CONSUMES);
		docket.consumes(DEFAULT_PRODUCES_AND_CONSUMES);

		return docket;
	}
}