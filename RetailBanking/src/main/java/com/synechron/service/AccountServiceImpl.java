package com.synechron.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.synechron.model.Account;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	private static List<Account> allAccounts;
	private static List<Account> savingAccounts;
	private static List<Account> cardAccounts;

	private static final AtomicInteger counter = new AtomicInteger();

	static {

		allAccounts = populateDummyAccount();
		savingAccounts = populateDummySavingAccounts();
		cardAccounts = populateDummyCardAccounts();

	}

	public static List<Account> populateDummySavingAccounts() {

		List<Account> savingAccountsList = new ArrayList<Account>();
		savingAccountsList.add(new Account(counter.incrementAndGet(), 101.50,
				"SAVINGS"));
		savingAccountsList.add(new Account(counter.incrementAndGet(), 601.50,
				"SAVINGS"));
		savingAccountsList.add(new Account(counter.incrementAndGet(), 201.50,
				"SAVINGS"));

		return savingAccountsList;
	}

	public static List<Account> populateDummyCardAccounts() {

		List<Account> cardAccountsList = new ArrayList<Account>();

		cardAccountsList.add(new Account(counter.incrementAndGet(), 301.50,
				"CARD"));
		cardAccountsList.add(new Account(counter.incrementAndGet(), 401.50,
				"CARD"));
		cardAccountsList.add(new Account(counter.incrementAndGet(), 501.50,
				"CARD"));

		return cardAccountsList;
	}

	public static List<Account> populateDummyAccount() {

		List<Account> accountList = new ArrayList<Account>();
		accountList.add(new Account(counter.incrementAndGet(), 101.50,
				"SAVINGS"));
		accountList.add(new Account(counter.incrementAndGet(), 601.50,
				"SAVINGS"));
		accountList.add(new Account(counter.incrementAndGet(), 201.50,
				"SAVINGS"));
		accountList.add(new Account(counter.incrementAndGet(), 301.50, "CARD"));
		accountList.add(new Account(counter.incrementAndGet(), 401.50, "CARD"));
		accountList.add(new Account(counter.incrementAndGet(), 501.50, "CARD"));

		return accountList;
	}

	public List<Account> getAccountsByType(String accountType) {

		if (accountType.equalsIgnoreCase("savings")) {
			return savingAccounts;
		} else if (accountType.equalsIgnoreCase("Card")) {
			return cardAccounts;
		}

		return allAccounts;
	}

}
