package com.teksystems;

public class Arr {
	
	
	public static void main(String [] args ) {
		String[] arr = new String[3];
		
		arr[0] = "a";
		arr[1] = "b";
		arr[2] = "c";
		
		String a = arr[0];
		a = a.toUpperCase();
		
		String same = arr[0].toUpperCase();
	
	}
}
