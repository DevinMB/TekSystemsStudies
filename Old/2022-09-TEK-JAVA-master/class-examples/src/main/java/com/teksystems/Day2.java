package com.teksystems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Day2 {

	public static void ifStatements() {
		int mark = 91;

		if (mark >= 90) {
			System.out.println("A");
		} else if (mark >= 80 && mark < 90) {
			System.out.println("B");
		} else if (mark >= 70 && mark < 80) {
			System.out.println("C");
		} else if ( mark <= 50 ) {
			mark = mark + 10;
		} else {
			System.out.println("Failing grade");
		}
		

		boolean even = false;
		if ( mark % 2 == 0 ) {
			even = true;
		}
		
		Scanner sc = new Scanner(System.in);
	       System.out.print("Input weight in kilogram: ");
		
		// try this with even and odd numbers in the debugger
		if (even) {
			System.out.println("mark (" + mark + ") is an even number");
		}

		System.out.println("Life goes on!");
	}

	public static final void main(String[] args) {
		ifStatements();
	}

	public static final void stringFunctions() {
		boolean b = true || false;
		
		String word = "Word";
		String word1 = "Word";
		String fileName = "image.jpg";
		String trim = "    \t our text     asdfasdfad       ";

		// convert an integer string into an actual int value
		String intValueString = "100";
		int intValue = Integer.parseInt(intValueString);

		System.out.println("Is file a jpg? " + fileName.endsWith(".jpg"));
		System.out.println("Is file a txt? " + fileName.endsWith(".txt"));

		System.out.println("This is a trim ->" + trim.trim() + "<-");

		System.out.println("Memory location original  " + Integer.toHexString(word.hashCode()));
		System.out.println("Memory location original1 " + Integer.toHexString(word1.hashCode()));
		System.out.println("Memory location lowercase " + Integer.toHexString(word.toLowerCase().hashCode()));
		System.out.println("Memory location uppercase " + Integer.toHexString(word.toUpperCase().hashCode()));

		word = word.toLowerCase();

		String w = word.substring(0, 1);

		System.out.println(w);
		System.out.println(word);
		System.out.println(word.toLowerCase());
		System.out.println(word.toUpperCase());

		StringBuffer buffer = new StringBuffer();
		buffer.append("This is the first string to add ");
		buffer.append(word.toLowerCase());

		List<String> list = new ArrayList<>();

		list.add("Java");
		list.add("Python");
		list.add("C Sharp");
		list.add("Javascript");

		// "Java, Python, C Sharp, Javascript"

		// System.out.format(" This is an integer: " + number + " and this is a byte: "
		// + nbyte");

		// System.out.println(joinNames);

	}

}
