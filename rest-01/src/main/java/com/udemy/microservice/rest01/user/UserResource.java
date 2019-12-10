package com.udemy.microservice.rest01.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		if (userById == null) {
			throw new UserNotFoundException("id="+id);
		}
		return ResponseEntity.ok(userById);
	}
	
	// POST /users
	@PostMapping("/users")
	public ResponseEntity<Object> postUser(@RequestBody User newUser) {
		User savedUser = getUserService().save(newUser);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId())
			.toUri();
		
		return ResponseEntity
				.created(location)
				.build();
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}