

import coffee.CoffeeShop;

import java.util.Arrays;



public class Main {
	
	// hook this up to use a scanner to take user input
	// each of 1 to 4 should be implmented in its own sub function
	// should use a while loop to keep displaying the menu until the user selects exit
	// print a menu 1) order item 2) fulfillOrder 3) List menu 4) print total 5) exit
	// 1) print a message saying enter your order item .. then use the input to pass to addOrder
	// 2) show the message

	public static void main(String[] args) {
		CoffeeShop tcs = new CoffeeShop();
		
		// put a scanner to allow a person to enter a menu item

		System.out.println(tcs.addOrder("hot cocoa"));
		System.out.println(tcs.addOrder("iced tea"));
		System.out.println(tcs.addOrder("cinnamon roll"));
		System.out.println(tcs.addOrder("iced coffee"));
		System.out.println(Arrays.toString(tcs.listOrders()));
		System.out.println(tcs.dueAmount());
		
		// we know that we have 2 items ordered
		// so by fulfilling 3 times the 3rd time shuold be all orders fullfilled
		System.out.println(tcs.fulfillOrder());
		System.out.println(tcs.fulfillOrder());
		System.out.println(tcs.fulfillOrder());
		
		// now we sould get an empty array because we filled all orders 
		System.out.println(Arrays.toString(tcs.listOrders()));
		System.out.println(tcs.dueAmount());
		
		System.out.println(tcs.cheapestItem());
		System.out.println(Arrays.toString(tcs.drinksOnly()));
		System.out.println(Arrays.toString(tcs.foodOnly()));
	}

}
