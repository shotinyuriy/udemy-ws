package com.udemy.microservice.rest01.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("Jpa")
@Service
public class UserJpaServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		users.addAll(userRepository.findAll());
		return users;
	}

	@Override
	public User save(User user) {
		return null;
	}

	@Override
	public User findById(int id) {
		Optional<UserEntity> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}

	@Override
	public User deleteById(int id) {
		return null;
	}
}
