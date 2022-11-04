package com.teksystems;

import java.util.Arrays;

public class ArrayExample {

	public static void main(String[] args) {
		String[] days = { "Mon", "Tues", "W", "Thurs", "Fried" };
		double[] values = new double[10];

		System.out.println("Before " + Arrays.toString(days));
		// remember that the sort will modify the content of the existing
		// and will not create a new array. An array is mutable
		Arrays.sort(days);
		System.out.println("Sorted " + Arrays.toString(days));

		System.out.println("==========================");
				   // positio 0, 1, 2
		int[] sourceArray = { 1, 2, 3 };
		int[] targetArray = sourceArray.clone();
		
		sourceArray[2] = 500;
		
		System.out.println("Source Array: " + Arrays.toString(sourceArray));
		System.out.println("Target Array: " + Arrays.toString(targetArray));
		
		// now we change the pointer of the source array to be equal to the
		// target array.  NOTE .. when printing both arrays are the same we
		// have lost our update to source array position 2 we did a few 
		// lines above ... Slide 16 in 303.4.1
		sourceArray = targetArray;

		System.out.println("Source Array: " + Arrays.toString(sourceArray));
		System.out.println("Target Array: " + Arrays.toString(targetArray));
		
		
	}
	
	
}
