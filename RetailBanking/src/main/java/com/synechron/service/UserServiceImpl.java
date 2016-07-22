package com.synechron.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.synechron.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	private static List<User> users;
	private static final AtomicInteger counter = new AtomicInteger();

	static {
		users = populateDummyUser();

	}

	public static List<User> populateDummyUser() {
		List<User> userList = new ArrayList<User>();
		userList.add(new User("Subrat", "Panda", counter.incrementAndGet()));
		userList.add(new User("Rajesh", "Kumar", counter.incrementAndGet()));
		userList.add(new User("Samrat", "Ghosh", counter.incrementAndGet()));
		userList.add(new User("Sambit", "Sahoo", counter.incrementAndGet()));
		userList.add(new User("Mukesh", "Nanda", counter.incrementAndGet()));

		return userList;

	}

	public List<User> getAllUser() {

		return users;
	}

	public User getUserDetailsById(int id, String accountType) {
		if (accountType.equalsIgnoreCase("savings")) {
			for (User u : users) {
				if (u.getUserId() == id) {
					return u;
				}

			}
		}
		if (accountType.equalsIgnoreCase("card")) {
			for (User u : users) {
				if (u.getUserId() == id) {
					return u;
				}

			}
		}

		return null;
	}

}
