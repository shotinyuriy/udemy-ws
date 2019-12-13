package com.udemy.microservice.rest01.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@GetMapping("v1/person")
	public PersonV1 personV1() {
		PersonV1 person = new PersonV1();
		
		person.setFullName("Bob Charlie");
		
		return person;
	}
	
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		PersonV2 person = new PersonV2();
		FullName fullName = new FullName();
		
		fullName.setFirstName("Bob");
		fullName.setLastName("Charlie");
		person.setFullName(fullName);
		
		return person;
	}
	
	@GetMapping(value="person/param", params="version=1")
	public PersonV1 paramV1() {
		PersonV1 person = new PersonV1();
		
		person.setFullName("Bob Charlie");
		
		return person;
	}
	
	@GetMapping(value="person/param", params="version=2")
	public PersonV2 paramV2() {
		PersonV2 person = new PersonV2();
		FullName fullName = new FullName();
		fullName.setFirstName("Bob");
		fullName.setLastName("Marlie");
		person.setFullName(fullName);
		
		return person;
	}
	
	@GetMapping(value="person/header", headers="X-API-VERSION=1")
	public PersonV1 headerV1() {
		PersonV1 person = new PersonV1();
		
		person.setFullName("Bob Charlie");
		
		return person;
	}
	
	@GetMapping(value="person/header", headers="X-API-VERSION=2")
	public PersonV2 headerV2() {
		
		PersonV2 person = new PersonV2();
		FullName fullName = new FullName();
		fullName.setFirstName("Bob");
		fullName.setLastName("Marlie");
		person.setFullName(fullName);
		
		return person;
	}
	
	@GetMapping(value="person/producers", produces="application/vnd.company.app-v1+json")
	public PersonV1 producersV1() {
		PersonV1 person = new PersonV1();
		
		person.setFullName("Bob Charlie");
		
		return person;
	}
	
	@GetMapping(value="person/producers", produces="application/vnd.company.app-v2+json")
	public PersonV2 producersV2() {
		
		PersonV2 person = new PersonV2();
		FullName fullName = new FullName();
		fullName.setFirstName("Bob");
		fullName.setLastName("Marlie");
		person.setFullName(fullName);
		
		return person;
	}
}
