package com.udemy.microservice.rest01.post;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.udemy.microservice.rest01.user.User;
import com.udemy.microservice.rest01.user.UserEntity;
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
	
	@GetMapping("/users/{id}/posts/{postId}")
	public ResponseEntity<PostEntity> getPostById(@PathVariable("id")int userId, @PathVariable("postId")int postId) {
		User user = userService.findById(userId);
		if (user == null) {
			throw new UserNotFoundException("id-"+userId);
		}
		
		Optional<PostEntity> foundPost = user.getPosts().stream()
			.filter(post -> post.getId().equals(postId))
			.findFirst();
		
		PostEntity foundPostEntity = foundPost.orElseThrow(() -> {
			return new UserPostNotFoundException("id-"+postId);
		});
		
		return ResponseEntity.ok(foundPostEntity);
	}
	
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<PostEntity> postUserPost(@PathVariable("id") int userId, @RequestBody @Valid PostEntity post) {
		
		User user = userService.findById(userId);
		if (user == null) {
			throw new UserNotFoundException("id-"+userId);
		}
		
		UserEntity userEntity = (UserEntity) user;
		post.setUser(userEntity);
		PostEntity savedPost = postService.save(post);
		
		URI postsUri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{postId}")
				.buildAndExpand(savedPost.getId())
				.toUri();
		
		return ResponseEntity.created(postsUri).build();
	}
}
