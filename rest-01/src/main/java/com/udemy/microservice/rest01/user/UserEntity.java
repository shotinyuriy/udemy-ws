package com.udemy.microservice.rest01.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.udemy.microservice.rest01.post.PostEntity;

@Entity(name="user")
public class UserEntity implements BlogUser {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private Date birthDate;
	
	@OneToMany(mappedBy="user")
	private List<PostEntity> posts;
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Date getBirthDate() {
		return birthDate;
	}

	@Override
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<PostEntity> getPosts() {
		return posts;
	}

	public void setPosts(List<PostEntity> posts) {
		this.posts = posts;
	}
}
