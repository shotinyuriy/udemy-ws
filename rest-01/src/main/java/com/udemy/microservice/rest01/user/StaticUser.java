package com.udemy.microservice.rest01.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="All details about a user")
public class StaticUser implements User {

	private Integer id;
	
	@Size(min=2, message="name should be at least 2 characters")
	@ApiModelProperty(notes="Name should be at least 2 characters")
	private String name;
	
	@Past(message="birthDate sbould be in the past")
	@ApiModelProperty(notes="Birth date should be in the past")
	private Date birthDate;

	public StaticUser(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

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

}
