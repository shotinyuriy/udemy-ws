package com.udemy.microservice.rest01.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	@Autowired
	private UserService userService;
	
	// GET /users
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {
		List<User> allUsers = getUserService().findAll();
		return ResponseEntity.ok(allUsers);
	}
	
	// GET /users/{id}
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) {
		User userById = getUserService().findById(id);
		return ResponseEntity.ok(userById);
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
