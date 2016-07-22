package com.synechron.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.synechron.model.Account;
import com.synechron.service.AccountService;


@Controller
@RequestMapping(value="/accounts")
public class AccountController {
	@Autowired
	AccountService accountService;
	
	
	@RequestMapping(value="/{accountType}")
	public ResponseEntity<List<Account>> getAllAccountsByType(@PathVariable ("accountType") String accountType){
		
		List<Account> accounts= accountService.getAccountsByType( accountType);
		
		if(accounts.isEmpty()){
			return new ResponseEntity<List<Account>>(HttpStatus.NO_CONTENT);
		}
		
		
		return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
		
	}
	
	
	
	

}
