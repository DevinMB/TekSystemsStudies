package com.teksystems.inheritance;

public class BankAccount {
	
	public static final double INTEREST_RATE = 0.10;
	
	
	private static double balance = 0.0;
	

	public static double calculateInterest(double amount) {
		return amount * INTEREST_RATE;
	}
	
	
	public void deposit(double amount) {
		System.out.println("Running deposit in bank account class");
		balance = balance + amount;
	}
	
	public boolean withdrawl( double amount ) {
		if ( amount <= balance ) {
			balance = balance - amount;
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return "The balance is " + balance;
	}
	
}
