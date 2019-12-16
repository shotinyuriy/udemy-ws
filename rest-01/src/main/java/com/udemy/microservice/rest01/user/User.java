package com.udemy.microservice.rest01.user;

import java.util.Date;

public interface User {

	public Integer getId();
	public void setId(Integer id);
	
	public String getName();
	public void setName(String name);
	
	public Date getBirthDate();
	public void setBirthDate(Date birthDate);
}
