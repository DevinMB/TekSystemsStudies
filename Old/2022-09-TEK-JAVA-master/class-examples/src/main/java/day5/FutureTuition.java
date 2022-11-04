package day5;

import java.awt.Dimension;
import java.text.NumberFormat;
import java.util.Locale;

public class FutureTuition {

	public static final double INCREASE_PERCENTAGE = 1.07;
	
	
	public double futureTution(int tuition, int years) {
		
		double futureTuition = tuition;
		int year = 0;
		
		System.out.println("Year\tTuition");
		while (futureTuition <= tuition * 2) {
			int var = 10;
			futureTuition = calculateTuition(futureTuition);
			year = year + 1;
			NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);		
			
			//System.out.printf("%d\t%s\n", year, nf.format(futureTuition) );			
			System.out.println(year + "\t" + nf.format(futureTuition));
		}
		
		return futureTuition;
	}
	
	// calculates the next years cost of tuition
	private double calculateTuition( double tuituin ) {
		double futureTuition = INCREASE_PERCENTAGE * tuituin;
		return futureTuition;
	}
	

	
}
