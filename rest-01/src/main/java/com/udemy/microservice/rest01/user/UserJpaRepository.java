package com.udemy.microservice.rest01.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("Jpa")
@Service
public class UserJpaRepository implements UserRepository {

	@Override
	public List<User> findAll() {
		return new ArrayList<>();
	}

	@Override
	public User save(User user) {
		return null;
	}

	@Override
	public User findById(int id) {
		return null;
	}

	@Override
	public User deleteById(int id) {
		return null;
	}
}
