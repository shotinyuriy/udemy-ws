package com.udemy.microservice.rest01.user;

import java.util.List;

public interface UserRepository {

	List<User> findAll();

	User save(User user);

	User findById(int id);
	
	User deleteById(int id);
}
