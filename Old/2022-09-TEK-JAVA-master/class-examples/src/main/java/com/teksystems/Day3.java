package com.teksystems;

import java.util.Scanner;

public class Day3 {

	public static void main(String[] args) {
		exampleFunction();
	}

	public static void exampleFunction() {
		// for loop counting up
		for (int i = 1; i <= 10; i++) {
			System.out.println("Welcome to Java World! " + i);
		}

		System.out.println("================================");

		// for loop counting down
		for (int i = 10; i > 0; i--) {
			System.out.println("Welcome to Java World! " + i);
		}

		System.out.println("================================");

		// print all numbers divisible by 5 with no remainder between 1 and 100
		for (int i = 1; i <= 25; i++) {
			if (i % 5 == 0) {
				System.out.println(i);
			}
		}

		System.out.println("================================");

		// print all numbers divisible by 5 with no remainder between 1 and 100
		for (int i = 5; i <= 25; i = i + 5) {
			System.out.println(i);
		}

		System.out.println("================================");

		// nested loop
		int nestedMax = 5;
		for (int i = 1; i <= nestedMax; i++) {
			// at this point i = 1;
			for (int j = i; j > 0; j--) {
				System.out.println(i + "\t" + j);
			}
		}

		System.out.println("================================");
		example1();

		// System.out.println("================================");
		// palindrone();

		//System.out.println("================================");
		// whileLoop();
		
		System.out.println("================================");
		breakContinue();

		//System.out.println("================================");
		//subtractionLoop();
	}
	
	// try to change this so that ... any odd number will continue
	// if i = 4 then print the message and then break the loop
	// actual output should 2 and 4 
	public static void breakContinue() {
		System.out.println("Starting the loop");
		for ( int i = 1 ; i <= 5 ; i++ ) {
			if ( i % 2 == 1 ) {
				continue;
			}			

			System.out.println(i);	
			
			if ( i == 4 ) {
				break;
			}	
		}
		System.out.println("Ending the loop");		
	}

	// enhance this code to print out the number of correct answers
	// and the number of wrong answers

	public static void subtractionLoop() {
		final int NUMBER_OF_QUESTIONS = 5; // Number of questions
		Scanner input = new Scanner(System.in);

		// change this code to use a break statement when
		// the user does not want to play any more
		while (true) {
			long startTime = System.currentTimeMillis();
			
			int correctCount = 0; // Count the number of correct answers
			int incorrectCount = 0;
			int count = 0; // Count the number of questions		
			
			while (count < NUMBER_OF_QUESTIONS) {
				// 1. Generate two random single-digit integers
				int number1 = (int) (Math.random() * 10);
				int number2 = (int) (Math.random() * 10);
				// 2. If number1 < number2, swap number1 with number2
				if (number1 < number2) {
					int temp = number1;
					number1 = number2;
					number2 = temp;
				}
				// 3. Prompt the student to answer "What is number1 - number2?"
				System.out.print("What is " + number1 + " - " + number2 + "? ");
				int answer = input.nextInt();
				// 4. Grade the answer and display the result
				if (number1 - number2 == answer) {
					System.out.println("You are correct!");
					correctCount++;
				} else {
					System.out.println("Your answer is wrong.\n" + number1 + " - " + number2 + " should be "
							+ (number1 - number2));
					incorrectCount++;
				}
				// Increase the count
				count++;
				
			}

			System.out.println("You got " + correctCount + " answers correct and " + incorrectCount + " answers wrong");

			long endTime = System.currentTimeMillis();
			System.out.println("It took " + (endTime - startTime) / 1000 + " seconds");

			System.out.print("Do you want to play again?");
			String tryAgain = input.next();
			if ( ! tryAgain.equalsIgnoreCase("Y")) {
				break;
			}
		}

	}

	public static void whileLoop() {
		boolean exit = true;
		int counter = 0;

		// a while loop will continue to run as look as the exit condition is true
		while (exit) {
			counter = counter + 1;
			System.out.println("Execute this code " + counter);
			if (counter >= 10) {
				exit = false;
			}
		}
	}

	public static void example1() {
		int sum = 0;
		int n = 1000;

		// for loop
		for (int i = 1; i <= n; i++) {
			// body inside for loop
			sum += i; // sum = sum + i
		}
		System.out.println("Sum = " + sum);

	}

	public static void palindrone() {
		String original, reverse = ""; // Objects of String class

		// abcdef - value of the string
		// 012345 - the position of the character in a string is 0 base
		// 123456 - in a 1 based structure you have values 1 to 6

		Scanner in = new Scanner(System.in);
		System.out.println("Enter a string/number to check if it is a palindrome");
		original = in.nextLine();

		int length = original.length();
		for (int i = length - 1; i >= 0; i--) {
			char c = original.charAt(i);
			reverse = reverse + c;
		}

		if (original.equals(reverse)) {
			System.out.println("Entered string/number is a palindrome.");
		} else {
			System.out.println("Entered string/number isn't a palindrome.");
		}
	}

}
