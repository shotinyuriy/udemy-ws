package com.udemy.microservice.rest01.post;

public class UserPostNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 7798822324923190137L;
	
	public UserPostNotFoundException(String message) {
		super(message);
	}
}
