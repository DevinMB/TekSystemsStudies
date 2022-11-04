package com.teksystems;

public class MultiplicationTable {

	public static void main(String[] args) {

		for (int row = 1; row <= 12; row++) {
			for (int col = 1; col <= 12; col++) {
				int value = row * col;
				System.out.print(value + "\t");
			}
			System.out.print("\n");
		}

	}
}
