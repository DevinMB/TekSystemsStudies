package coffee;

import java.util.Arrays;

public class CoffeeShop {

	private String name = "Eric's coffee shop";
	private String[] orders = new String[0];
	
	private MenuItem[] menu = new MenuItem[] {
	  		new MenuItem("orange juice", "drink", 2.13), 
	  		new MenuItem("lemonade", "drink", 0.85), 
	  		new MenuItem("cranberry juice", "drink", 3.36), 
		    new MenuItem("pineapple juice", "drink", 1.89), 
		    new MenuItem("lemon iced tea", "drink", 1.28), 
		    new MenuItem("apple iced tea", "drink", 1.28), 
		    new MenuItem("vanilla chai latte", "drink", 2.48), 
		    new MenuItem("hot chocolate", "drink", 0.99), 
		    new MenuItem("iced coffee", "drink", 1.12), 
		    new MenuItem("tuna sandwich", "food", 0.95), 
		    new MenuItem("ham and cheese sandwich", "food", 1.35), 
		    new MenuItem("bacon and egg", "food", 1.15), 
		    new MenuItem("steak", "food", 3.28), 
		    new MenuItem("hamburger", "food", 1.05), 
		    new MenuItem("cinnamon roll", "food", 1.05) };


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

	public double dueAmount() {
		double totalPrice = 0.0;

		for (String itemName : orders) {
			for (MenuItem menuItem : menu) {
				if (menuItem.getItem().equals(itemName)) {
					totalPrice = totalPrice + menuItem.getPrice();
				}
			}
		}

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

	public MenuItem[] getMenu() {
		return menu;
	}
}
