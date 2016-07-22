package com.synechron.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synechron.model.User;
import com.synechron.service.UserService;


@Controller
@RequestMapping(value="/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers(){
		
	System.out.println("**********List All users*********");
	List<User> userList= userService.getAllUser();
	
	if(userList.isEmpty())
	{
		return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
	}		
	
	return new ResponseEntity<List<User>>(HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}/{accType}")
	public ResponseEntity<User>findUsersById(@PathVariable ("id") int id,@PathVariable("accType") String accType){
		System.out.println("**********User details by UserId and AccountType*********");
		User user= userService.getUserDetailsById(id, accType);
		if(user== null){
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}
	
	

}
