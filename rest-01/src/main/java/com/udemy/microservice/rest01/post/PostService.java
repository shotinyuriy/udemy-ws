package com.udemy.microservice.rest01.post;

import java.util.List;

public interface PostService {

	public List<PostEntity> findAll();
	
	public PostEntity save(PostEntity post);
}
