package com.teksystems.inheritance;

public class SavingsAccount extends BankAccount {


	@Override
	public void deposit(double amount) {
		System.out.println("Running deposit in savings account class");
		
		// special offer when you deposit to savings you get 5%
		amount = amount * 1.05;
		
		super.deposit(amount);
	}
	
}
