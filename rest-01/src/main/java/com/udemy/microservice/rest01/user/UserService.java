package com.udemy.microservice.rest01.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	private static final AtomicInteger userIdCount = new AtomicInteger(0);
	private static Map<Integer, User> users = new ConcurrentHashMap<Integer, User>();

	static {
		addUser("Peter Zayats", new Date());
		addUser("Semen Korshun", new Date());
		addUser("Olga Lisa", new Date());
	}

	private static void addUser(String name, Date birthDate) {
		int userId = userIdCount.incrementAndGet();
		users.put(userId, new User(userId, name, birthDate));
	}

	public List<User> findAll() {
		List<User> allUsers = new ArrayList<>(users.size());
		allUsers.addAll(users.values());
		return allUsers;
	}

	public User save(User user) {
		if (!users.containsValue(user)) {
			int userId = userIdCount.incrementAndGet();
			user.setId(userId);
			users.put(userId, user);
		}
		return user;
	}
	
	public User findById(int id) {
		return users.get(id);
	}
	
	public User deleteById(int id) {
		User removedUser = users.remove(id);
		return removedUser;
	}
}
