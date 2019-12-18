package com.udemy.microservice.rest01.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	
	public List<PostEntity> findAll() {
		return postRepository.findAll();
	}
	
	public PostEntity save(PostEntity post) {
		return postRepository.save(post);
	}
}
