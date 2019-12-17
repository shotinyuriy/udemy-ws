package com.udemy.microservice.rest01.user;

import java.util.List;

public interface UserService {

	List<User> findAll();

	User save(User user);

	User findById(int id);
	
	User deleteById(int id);
}
