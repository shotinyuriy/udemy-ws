package com.udemy.microservice.rest01.user;

import java.util.List;

import com.udemy.microservice.rest01.post.PostEntity;

public interface BlogUser extends User {
	public List<PostEntity> getPosts();
	public void setPosts(List<PostEntity> posts);
}
