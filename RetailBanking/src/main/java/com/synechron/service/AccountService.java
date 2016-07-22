package com.synechron.service;

import java.util.List;

import com.synechron.model.Account;

public interface AccountService {

	List<Account> getAccountsByType(String accountType);
}
