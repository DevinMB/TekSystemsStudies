import java.util.Scanner;

public class Assignment {

	public static void main(String[] args) {

		System.out.print("\n QUESTION 1------------------------------------------------------------------");
//
//		for (int i = 1; i <= 12; i++) {
//			for (int j = 1; j <= 12; j++) {
//				System.out.print((i * j) + "\t");
//			}
//			System.out.print("\n");
//		}
//
//	
//		
		System.out.print("\n QUESTION 2------------------------------------------------------------------");
//		
//		Scanner scan = new Scanner(System.in);
//		System.out.println("enter two postifive ints : ");
//		int number1 = scan.nextInt();
//		int number2 = scan.nextInt();
//		int gcd = 1;
//	    for (int i = 1; i <= number1 && i <= number2; i++) {
//	        if (number1 % i == 0 && number2 % i == 0) {
//	            gcd = i;
//	        }
//	    }
//	    System.out.println("GCD is : "+ gcd);
//		
//	    
	    System.out.print("\n QUESTION 3------------------------------------------------------------------ \n");
		
	    
	    int tuition = 10000;
	    double increasePercent = 1.07;
	    int year = 0;
	    while(tuition <= 20000) {
	    	
	    	System.out.println("year: " + year + " tuition: " + tuition);
	    	tuition = (int) (tuition * increasePercent); 
	    	year++;
	    
	    }
	    
	    

	}

}
