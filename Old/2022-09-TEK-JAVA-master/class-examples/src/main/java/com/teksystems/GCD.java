package com.teksystems;

import java.util.Scanner;

public class GCD {

	public static void main(String[] args) {
		//whileLoop();
		forLoop();		
	}
	
	public static void forLoop() {
		Scanner input = new Scanner(System.in);

		System.out.print("Number 1 ");
		int n1 = input.nextInt();

		System.out.print("Number 2 ");
		int n2 = input.nextInt();

		int k = 1;
		int gcd = 1;

		while (k <= n1 && k <= n2) {
			int r1 = n1 % k;
			int r2 = n2 % k;

			if ((r1 == 0) && (r2 == 0)) {
				gcd = k;
			}

			k = k + 1;
		}

		System.out.println("GCD = " + gcd);

	}
		
		
	public static void whileLoop() {
		Scanner input = new Scanner(System.in);

		System.out.print("Number 1 ");
		int n1 = input.nextInt();

		System.out.print("Number 2 ");
		int n2 = input.nextInt();

		int k = 1;
		int gcd = 1;

		while (k <= n1 && k <= n2) {
			int r1 = n1 % k;
			int r2 = n2 % k;

			if ((r1 == 0) && (r2 == 0)) {
				gcd = k;
			}

			k = k + 1;
		}

		System.out.println("GCD = " + gcd);

	}

}
