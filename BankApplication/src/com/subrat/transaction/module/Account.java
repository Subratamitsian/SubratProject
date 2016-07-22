package com.subrat.transaction.module;

public class Account {
	private double balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void addAmount(double amount){
		
		synchronized (this){
			double temp= balance;
		try{
			Thread.sleep(10);
		}
		catch (InterruptedException ie){
			ie.printStackTrace();
		}
		temp+=amount;
		balance=temp;
		}
	}
	
	public  void subtractAmount(double amount){
		
		synchronized (this){
			double temp= balance;
		try{
			Thread.sleep(10);
		}
		catch (InterruptedException ie){
			ie.printStackTrace();
		}
		temp-=amount;
		balance=temp;
		}
	}
	

}
