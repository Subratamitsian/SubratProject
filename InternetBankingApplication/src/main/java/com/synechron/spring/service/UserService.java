package com.synechron.spring.service;

import java.util.List;

import com.synechron.spring.model.User;

public interface UserService {
	
	void saveUser(User user);
	
	List<User> findAllUsers(); 

}
