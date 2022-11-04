package com.teksystems.coffee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingExamples {

	private MenuItem[] menu = new MenuItem[] { new MenuItem("orange juice", "drink", 2.13),
			new MenuItem("lemonade", "drink", 0.85), new MenuItem("cranberry juice", "drink", 3.36),
			new MenuItem("lemonade", "drink", 0.65), new MenuItem("cranberry juice", "drink", 3.36),
			new MenuItem("pineapple juice", "drink", 1.89), new MenuItem("lemon iced tea", "drink", 1.28),
			new MenuItem("apple iced tea", "drink", 1.28), new MenuItem("vanilla chai latte", "drink", 2.48),
			new MenuItem("hot chocolate", "drink", 0.99), new MenuItem("iced coffee", "drink", 1.12),
			new MenuItem("tuna sandwich", "food", 0.95), new MenuItem("ham and cheese sandwich", "food", 1.35),
			new MenuItem("bacon and egg", "food", 1.15), new MenuItem("steak", "food", 3.28),
			new MenuItem("hamburger", "food", 1.05), new MenuItem("cinnamon roll", "food", 1.05),
			new MenuItem(null, "food", 1.05) };

	public static void main(String[] args) {
		SortingExamples se = new SortingExamples();
		se.start();
	}

	public void start() {
		// first we convert the array to a list
		List<MenuItem> list = new ArrayList<>();
		list.addAll(Arrays.asList(menu));

		// do these using collections sort or list sort or by stream

		// TODO - sort the list by name in descending order (z to a)
		Collections.sort(list,
				Comparator.comparing(MenuItem::getItem, Comparator.nullsFirst(Comparator.naturalOrder())).reversed());	 
		

		// TODO - sort the list by name in ascending order with nulls last
		// TODO - sort the list by name in ascending order with nulls first

		// TODO - filter the list and remove all food items - will produce a list of
	   	//list = list.stream().filter(p -> p.getType().equals("food")).collect(Collectors.toList());
		list.removeIf(p -> p.getType().equals("food"));
	    print(list);
		// drinks in alphabetical order

	}

	private void print(List<MenuItem> list) {
		// TODO implement this
		for (MenuItem item : list) {
			System.out.println(item);
		}
	}
}
