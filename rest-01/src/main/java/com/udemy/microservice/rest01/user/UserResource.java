package com.udemy.microservice.rest01.user;

import java.net.URI;
import java.util.List;
import java.util.TreeMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public EntityModel<User> getUserById(@PathVariable Integer id) {
		User userById = getUserService().findById(id);
		if (userById == null) {
			throw new UserNotFoundException("id=" + id);
		}

		EntityModel<User> entityModel = new EntityModel<>(userById); // instead of Resource
		WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getUsers()); // instead of ControllerLinkBuilder
		
		entityModel.add(linkTo.withRel("all-users"));
		
		return entityModel;
	}

	// POST /users
	@PostMapping("/users")
	public ResponseEntity<Object> postUser(@Valid @RequestBody User newUser) {
		User savedUser = getUserService().save(newUser);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}

	// DELETE /users/{id}
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable Integer id) {
		User removedUser = getUserService().deleteById(id);
		if (removedUser == null) {
			throw new UserNotFoundException("id=" + id);
		}
		return ResponseEntity
				.status(HttpStatus.NO_CONTENT)
				.build();
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
