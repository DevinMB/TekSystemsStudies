package com.teksystems;

import java.util.Scanner;

public class Day1 {
	
	private static final double PI = 3.14159;	
	private static final String SOME_CONSTANT = "string value";

	public static void main(String[] args) {
		double radius = 20.5;
		radius = radius + 10;
		double area;
	
		System.out.print("Enter an integer value : ");
		
		Scanner sc1 = new Scanner(System.in);
		int scanned = sc1.nextInt();

		System.out.println("User input = " + scanned);
		
		// Compute area - pi R squared
		area = radius * radius * PI;
		
		radius = 25;

		// Display results
		System.out.println("The area \t for the circle of \\ radius \"" + radius + "\" is " + area);
		
		boolean doWork = false;
		while(doWork) {
			// will this execute
			// it will not because doWork is false
		}
		
		do {
			// will this execute
			// it will run once because code is first
		} while (doWork);
		
		
		
		
	}

}
