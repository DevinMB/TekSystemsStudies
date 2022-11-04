package com.teksystems.inheritance;

public class MainBanking {

	public static void main( String[] args ) {
		CheckingAccount ca = new CheckingAccount();
		SavingsAccount sa = new SavingsAccount();
		
		// we are casting a checking account to be a bank account
		// the variable ba only has access to the functions defined on bank account
		// 
		BankAccount ba = new SavingsAccount();
		ba.deposit(100);
		System.out.println("bank account " + ba.toString());
		
		// this is also possible to put checking and saving objects into an array of bankaccount objects
		BankAccount account[] = new BankAccount[2];
		account[0] = ca;
		account[1] = sa;
 		
		System.exit(0);
		
		// this is just wrong because we can not put a bank account into a savings variable
		// becuae the implmementation of savings account is not present in the bank account
		//SavingsAccount sa1 = new BankAccount();
		
		BankAccount.calculateInterest(100);
		sa.calculateInterest(100.0);
		
		sa.deposit(100.0);
		System.out.println("Savings " + sa.toString());
		
		ca.deposit(200.0);		
		System.out.println("Checking " + ca.toString());
		
		sa.deposit(100.0);
		System.out.println("Savings " + sa.toString());
	}
}
