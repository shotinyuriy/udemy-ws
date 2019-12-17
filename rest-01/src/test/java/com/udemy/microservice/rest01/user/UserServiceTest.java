package com.udemy.microservice.rest01.user;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UserServiceTest {

	private UserServiceImpl userService = new UserServiceImpl();
	
	@Test
	public void testFindAll() {
		List<User> allUsers = userService.findAll();
		Assert.assertNotNull(allUsers);
		Assert.assertTrue(allUsers.size() > 0);
	}
	
	@Test
	public void testFindById() {
		User userById = userService.findById(1);
		Assert.assertNotNull(userById);
		Assert.assertEquals(Integer.valueOf(1), userById.getId());
	}
	
	@Test
	public void testSave() {
		User newUser = userService.save(new UserPojo(null, "Maria Medved", new Date()));
		Assert.assertNotNull(newUser);
		Assert.assertNotNull(newUser.getId());
		
		User newUserById = userService.findById(newUser.getId());
		Assert.assertNotNull(newUserById);
	}
}
