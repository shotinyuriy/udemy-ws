package com.udemy.microservice.rest01.hello;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldResource.class);
	
	@Autowired
	private MessageSource messageSource;
	
	private LocaleEditor localeEditor = new LocaleEditor();
	
	@GetMapping("/hello/{name}")
	public String helloWorld(@PathVariable String name) {
		
		return "Hello World! Welcome "+name;
	}
	
	@GetMapping("/hello-bean/{name}")
	public HelloBean helloBean(@PathVariable String name) {
		return new HelloBean("Hello World! Welcome "+name);
	}
	
	@GetMapping("/hello-i18n/{name}")
	public HelloBean helloI18n(
			@RequestHeader(name="Accept-Language", required=false) String acceptLanguage, 
			@PathVariable("name") String name) {
		
		Locale locale;
		if (acceptLanguage != null && acceptLanguage.matches("\\w\\w[-_]\\w\\w")) {
			localeEditor.setAsText(acceptLanguage);
			locale = (Locale)localeEditor.getValue();
		} else {
			locale = Locale.US;
		}
		
		String message = messageSource.getMessage("message.good.morning", null, locale);
		return new HelloBean(message+" "+name);
	}
	
	@GetMapping("/hello-i18n-context/{name}")
	public HelloBean helloI18nContext(@PathVariable("name") String name) {
		
		Locale locale = LocaleContextHolder.getLocale();
		
		String message = messageSource.getMessage("message.good.morning", null, locale);
		return new HelloBean(message+" "+name);
	}
}
