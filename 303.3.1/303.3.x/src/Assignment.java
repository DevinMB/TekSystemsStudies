import java.util.Scanner;
import java.util.*;

public class Assignment {

	public static void main(String[] args) {

				Scanner sc = new Scanner(System.in);
				// reading the number of elements for the size of the array
				System.out.print("Enter the number of elements you want to store: ");		
				int n = sc.nextInt();
				
				// creates an array in the memory of length 10
				int[] array = new int[n];
				
				// reading array elements from the user
				for (int i = 0; i < n; i++) {
					//System.out.println("Enter element " + i + " of the array: ");	
					array[i] = sc.nextInt();
				}
				
				// print out the results
				//System.out.println("Array elements are: ");
				//System.out.println(Arrays.toString(array));
				for (int i = 0; i < n; i++) {
					System.out.println(array[i]);
				}
				sc.close();
				
			

				StringJoiner sj = new StringJoiner(",");
				
				for(int i: array) {
					sj.add(Integer.toString(i));
				}
				
				System.out.print(sj.toString());
				
				
	    

	}

}
