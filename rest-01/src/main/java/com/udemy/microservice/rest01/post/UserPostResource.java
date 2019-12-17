package com.udemy.microservice.rest01.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.microservice.rest01.user.User;
import com.udemy.microservice.rest01.user.UserNotFoundException;
import com.udemy.microservice.rest01.user.UserService;

@RestController
@RequestMapping("/jpa")
public class UserPostResource {

	@Autowired
	private PostService postService;
	
	@Qualifier("Jpa")
	@Autowired
	private UserService userService;
	
	@GetMapping("/users/{id}/posts")
	public ResponseEntity<List<PostEntity>> getPosts(@PathVariable("id")int userId) {
		User user = userService.findById(userId);
		if (user == null) {
			throw new UserNotFoundException("id-"+userId);
		}
		return ResponseEntity.ok(user.getPosts());
	}
}
