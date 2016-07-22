package com.synechron.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.synechron.spring.model.User;

@Service("userService")

public class UserServiceImpl implements UserService{
	
	 private static final AtomicLong counter = new AtomicLong();
	 
	 private static List<User> users;
	 
	 static{
	        users= populateDummyUsers();
	    }

	public void saveUser(User user) {
        user.setId(counter.incrementAndGet());
        users.add(user);
    }
	
	public List<User> findAllUsers() {
        return users;
    }
	
	
	
	  private static List<User> populateDummyUsers(){
	        List<User> users = new ArrayList<User>();
	        users.add(new User(counter.incrementAndGet(),"Sam", "NY", "sam@abc.com"));
	        return users;
	    }

}
