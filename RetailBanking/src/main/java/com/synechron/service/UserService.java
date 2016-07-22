package com.synechron.service;

import java.util.List;

import com.synechron.model.User;

public interface UserService {
	
	List<User> getAllUser();
	User getUserDetailsById(int id, String accountType);
	
	

}
