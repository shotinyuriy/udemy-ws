package com.udemy.microservice.rest01.user;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.udemy.microservice.rest01.post.PostEntity;

import io.swagger.annotations.ApiModelProperty;

public interface User {

	public Integer getId();

	public void setId(Integer id);

	@Size(min = 2, message = "Name should have at least 2 characters")
	@ApiModelProperty(notes = "Name should have at least 2 characters")
	public String getName();

	public void setName(String name);

	@Past
	@ApiModelProperty(notes = "Birth date should be in the past")
	public Date getBirthDate();

	public void setBirthDate(Date birthDate);

	public List<PostEntity> getPosts();

	public void setPosts(List<PostEntity> posts);
}
