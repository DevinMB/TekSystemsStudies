package com.perscholas.java_basics;

public class JavaBasicsClass {
	
	public final static int CONSTANT = 9;
	public final static double SALES_TAX = .06;
	
	public static void main (String [] args) {
		
		//question 1
		System.out.println(addInts(1,3));
		
		//question 2
		System.out.println(addDoubles(1.5888,3.5454));
		
		//question 3
		System.out.println(addDoubleAndInt(1.5888,3));
		
		//question 4
		System.out.println(DivideDoubles(1.5888,3.555));
		
		//question 5
		System.out.println(DivideDoubleAndIntCastAsInt(1.5888,3.555));
		
		//question 6
		System.out.println(divideInts(6,2));
		System.out.println(divideIntsEndAsDouble(6,2));
		
		//question 7
		System.out.println(plusConstant(6));
		
		//question 8
		System.out.printf("%.2f",totalSale(6,3,5));	
		
	}
	
	public static int addInts(int i1, int i2) {
		int result = i1 + i2;
		return result;
	}
	
	public static double addDoubles(double d1, double d2) {
		double result = d1 + d2;
		return result;
	}

	public static double addDoubleAndInt(double d1, int i1) {
		double result = d1 + i1;
		return result;
	}
	
	public static double DivideDoubles(double d1, double d2) {
		double largerNumber = 0;
		double smallerNumber = 0;
		
		if (d1>d2) {
			largerNumber = d1;
			smallerNumber = d2;
			
		}else {
			largerNumber = d2;
			smallerNumber = d1;
		}
		
		double result = largerNumber/smallerNumber;		
		return result;
	}
	
	public static double DivideDoubleAndIntCastAsInt(double d1, double d2) {
		double largerNumber = 0;
		double smallerNumber = 0;
		
		if (d1>d2) {
			largerNumber = d1;
			smallerNumber = d2;
			
		}else {
			largerNumber = d2;
			smallerNumber = d1;
		}
		
		double result = largerNumber/smallerNumber;
		
		
		return (int) result;
	}
		
	public static int divideInts (int x, int y) {
		int q = y/x;
		return q;
	}
	
	public static double divideIntsEndAsDouble (int x, int y) {
		double q = (double)y/x;
		return q;
	}
	
	public static double plusConstant (int i) {
		int result = i + CONSTANT;
		return result;
	}
	
	public static double totalSale(int apple, int banana, int pie) {
		double totalSale = 0;
		double subtotal = 0;
		
		
		double applePrice = 3.4;
		double bananaPrice = 3.5;
		double piePrice = 5.8;
		
		
		subtotal = (applePrice * apple) + 
				   (bananaPrice * banana) + 
				   (piePrice * pie);
		
		totalSale = subtotal * SALES_TAX;
		
		return totalSale;
		
	}
	

}
