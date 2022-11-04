package com.teksystems.coffee;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CoffeeShop {

	private String name = "Eric's coffee shop";

	private String[] orders = new String[0];

	private MenuItem[] menu = new MenuItem[] { new MenuItem("orange juice", "drink", 2.13),
			new MenuItem("lemonade", "drink", 0.85), new MenuItem("cranberry juice", "drink", 3.36),
			new MenuItem("lemonade", "drink", 0.65), new MenuItem("cranberry juice", "drink", 3.36),
			new MenuItem("pineapple juice", "drink", 1.89), new MenuItem("lemon iced tea", "drink", 1.28),
			new MenuItem("apple iced tea", "drink", 1.28), new MenuItem("vanilla chai latte", "drink", 2.48),
			new MenuItem("hot chocolate", "drink", 0.99), new MenuItem("iced coffee", "drink", 1.12),
			new MenuItem("tuna sandwich", "food", 0.95), new MenuItem("ham and cheese sandwich", "food", 1.35),
			new MenuItem("bacon and egg", "food", 1.15), new MenuItem("steak", "food", 3.28),
			new MenuItem("hamburger", "food", 1.05), new MenuItem("cinnamon roll", "food", 1.05) };

	// TODO - take in a string parameter that is the name of the field to sort on
	// so .. item, price
	// we want the menu we return to be sorted by the product name
	// put 2 user input option in your main menu for sorting by price and name
	public List<MenuItem> getMenu() {
		// first we convert the array to a list
		List<MenuItem> list = Arrays.asList(menu);
		
	
				
		// next we sort the list based on the item name using a custom comparator
		// this implementation is using an anonymous class
		Collections.sort(list, new Comparator<MenuItem>() {
			@Override
			public int compare(MenuItem p1, MenuItem p2) {
				// put if statement in here to sort based on the incoming parameter
				// TODO implement the code to order by the item name and then by price
				// do not use a lambda .. just write it using if statements
				// remember ( a < b ) returns -1
				//  ( a == b ) returns 0
				//  ( a > b ) returns 1
				int eq = p1.getItem().compareTo(p2.getItem());
				if ( eq == 0 ) {
					eq = p1.getPrice().compareTo(p2.getPrice());
				}
				return eq;
			}
		});
		
		// same sort as above using 1 line
		// this is a great use of a lambda because it allows you to implement a sort in 1 line
		// based on 2 properties of the MenuItem
		Collections.sort(list, Comparator.comparing(MenuItem::getItem).thenComparing(MenuItem::getPrice));
		// also the same as the above code
		list.sort(Comparator.comparing(MenuItem::getItem).thenComparing(MenuItem::getPrice));
		
		

		// block 1
		list.forEach(menuItem -> {
			System.out.println(menuItem.getItem() + " costs " + menuItem.getPrice());
		});
		
		// is the same as block 2
		for ( MenuItem menuItem : list ) {
			System.out.println(menuItem.getItem() + " costs " + menuItem.getPrice());
		}
		
		

		return list;
	}

	public String addOrder(String name) {
		boolean found = false;

		for (MenuItem menuItem : menu) {
			if (menuItem.getItem().equals(name)) {
				found = true;
				break;
			}
		}

		if (found) {
			// we can use the arrays library to make a copy of our
			// orders array and increase the length by 1.
			orders = Arrays.copyOf(orders, orders.length + 1);

			// assign the item name to last element of the array
			orders[orders.length - 1] = name;

			// for now we just return name
			return "Order added!";
		} else {
			return "This item is currently unavailable!";
		}
	}

	public String removeOrderItem(String removeItemName) {
		// i1, i2, i3, i4
		int index = 0;
		for (; index <= orders.length - 1; index++) {
			String orderItemName = orders[index];
			if (orderItemName.equals(removeItemName)) {
				orders[index] = null;
				break;
			}
		}

		// if we are removing i3 our index will be at the position in the array
		// from here we want to shift every element to the left 1 space
		for (; index < orders.length - 2; index++) {
			orders[index] = orders[index + 1];
		}

		orders = Arrays.copyOfRange(orders, 0, orders.length - 1);

		return "";
	}

	public String fulfillOrder() {
		if (orders.length == 0) {
			return "All orders have been fulfilled!";
		} else {
			// this is essentially a pop function
			String item = orders[0];
			orders = Arrays.copyOfRange(orders, 1, orders.length);
			return "The " + item + " is ready!";
		}
	}

	// this is called an accessor method
	public String[] listOrders() {
		return orders;
	}

	public Double dueAmount() {
		double totalPrice = 0.0;

		for (String itemName : orders) {
			for (MenuItem menuItem : menu) {
				if (menuItem.getItem().equals(itemName)) {
					totalPrice = totalPrice + menuItem.getPrice();
				}
			}
		}

		// if total price is 11.55
		// this would truncate the totalPrice to a whole integer value of 11.
		// means it will chop everything after the decimal number to make it a whole
		// number
		// this is not a floor or a round .. simply throwing away the decimal.
		int dollars = (int) totalPrice;
		// dollars will be 11 after this line of code

		return totalPrice;
	}

	public String cheapestItem() {
		if (menu.length == 0) {
			// temporary return null
			// will fix this code as we learn more by
			// reading requirements
			return null;
		}

		// if we get here we know that there is at least 1
		// element in the menu so we can get element 0
		// with no risk of error
		// we will use item 0 to initialize our search results
		// TODO : replace these 2 lines to use a MenuItem object
		double minPrice = menu[0].getPrice();
		String itemName = menu[0].getItem();

		for (MenuItem menuItem : menu) {
			if (menuItem.getPrice() < minPrice) {
				minPrice = menuItem.getPrice();
				itemName = menuItem.getItem();
			}
		}

		return itemName;
	}

	public String[] drinksOnly() {
		return findByType("drink");
	}

	public String[] foodOnly() {
		return findByType("food");
	}

	private String[] findByType(String type) {
		String[] result = new String[0];

		for (MenuItem menuItem : menu) {
			if (menuItem.getType().equalsIgnoreCase(type)) {
				result = Arrays.copyOf(result, result.length + 1);

				// assign the item name to last element of the array
				result[result.length - 1] = menuItem.getItem();
			}
		}

		return result;
	}

}
