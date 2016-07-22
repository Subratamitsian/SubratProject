package com.subrat.transaction;

import com.subrat.transaction.module.Account;

public class TestApplication {
	public static void main(String[] args) {
		
		Account account= new Account();
		account.setBalance(1000);
		
		Company company= new Company(account);
		Thread comapanyThread= new Thread(company);
		
		Bank bank= new Bank(account);
		Thread bankThread= new Thread(bank);
		
		System.out.printf("**** Account: Initial Balance: *** %f\n",account.getBalance());
		
		comapanyThread.start();
		bankThread.start();
		
		try{
			comapanyThread.join();
			bankThread.join();
			
			System.out.printf("**** Account: Final Balance: *** %f\n",account.getBalance());
		}
		catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}

}
