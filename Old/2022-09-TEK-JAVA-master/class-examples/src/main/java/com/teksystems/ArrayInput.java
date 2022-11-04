package com.teksystems;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayInput {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// reading the number of elements for the size of the array
		System.out.print("Enter the number of elements you want to store: ");
		int n = sc.nextInt();

		// creates an array in the memory of length 10
		int[] array = new int[n];

		// reading array elements from the user
		for (int i = 0; i < n; i++) {
			System.out.println("Enter element " + i + " of the array: ");
			array[i] = sc.nextInt();
		}

		// print out the results
		System.out.println("Array elements are: ");
		System.out.println(Arrays.toString(array));
		for (int i = 0; i < n; i++) {
			System.out.println(array[i]);
		}

		// use a for loop to print out a comma seperated list of the
		// elements such "1, 2, 3, 4, 5"
		for (int i = 0; i < n; i++) {
			System.out.print(array[i]);
			if (i < n - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
		
		// using the new for loop type
		// in this case i is the value not the position in the array
		for (int i : array) {
			System.out.print(i);
			if (i < n - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();

		// out of bounds exception
		int[] oob = new int[3];
		oob[4] = 20;
	}

}
