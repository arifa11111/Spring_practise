package com.Thymeleaf.thymeleaf.service;

import com.Thymeleaf.thymeleaf.Entity.Passenger;
import com.Thymeleaf.thymeleaf.Entity.User;

import java.util.List;

public interface UserService {

	public List<User> findAll();

	public static User findById(int theId) {
		return null;
	}

	public void save(User thePassenger);
	
	public void deleteById(int theId);
	
}