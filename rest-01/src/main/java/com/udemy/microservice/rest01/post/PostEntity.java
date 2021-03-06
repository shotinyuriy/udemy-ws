package com.udemy.microservice.rest01.post;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udemy.microservice.rest01.user.UserEntity;

import io.swagger.annotations.ApiModelProperty;

@Entity(name="post")
public class PostEntity {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2)
	@ApiModelProperty(notes="Description should be at least 2 charachters")
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private UserEntity user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
}
