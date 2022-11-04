package com.teksystems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.teksystems.coffee.MenuItem;

public class MapsExamples {

	public static void main(String[] args) {
		// a list is ordered and can have duplicate elements in it
		List<String> list = new ArrayList<>();

		list.add("position 0");
		list.add("position 1");
		list.add("position 0");
		list.add("position 0");
		list.add("position 0");
		list.add("position 0");

		for (String s : list) {
			System.out.println(s);
		}

		System.out.println("############################");

		// a set is unordered and will not allow duplicates
		Set<String> set = new HashSet<>();
		set.add("position 0");
		set.add("position 1");
		set.add("position 0");
		set.add("position 0");

		for (String s : set) {
			System.out.println(s);
		}

		System.out.println("############################");

		// a hashmap is a key value pair
		HashMap<String, String> map = new HashMap<>();
		// key , value
		map.put("eric", "Eric Heilig");
		map.put("londen", "Londen Haskins");

		System.out.println(map.get("eric"));
		System.out.println(map.get("londen"));
		// someone does not exist in map as key so it returns null;
		System.out.println(map.get("someone"));

		System.out.println("############################");
		HashMap<String, Integer> grades = new HashMap<>();
		grades.put("eric", 100);
		grades.put("joe", 90);
		System.out.println("Eric gets a " + grades.get("eric") + " ");
		System.out.println(grades.get("joe"));

		grades.put(null, null);
		
		// map of menu items

		HashMap<String, MenuItem> menuItems = new HashMap<>();
		menuItems.put("lemonade", new MenuItem("lemonade", "drink", 0.85));
		menuItems.put("juice", new MenuItem("cranberry juice", "drink", 3.36));
		// at this point the juice will be cranberry
		System.out.println("1) Item name is " + menuItems.get("juice").getItem());

		// now we add another menu item with the same key .. which overwrites cranberry
		// with apple
		menuItems.put("juice", new MenuItem("apple juice", "drink", 2.36));

		MenuItem item1 = menuItems.get("juice");
		System.out.println("2) Item name is " + item1.getItem());

		MenuItem item = menuItems.get("lemonade");
		System.out.println("3) Item name is " + item.getItem());

		System.out.println("############################");
		// get all keys from map and print them
		Set<String> keys = menuItems.keySet();
		for (String s : keys) {
			System.out.println("key = " + s);
		}
		// can be done in 1 line
		for (String s : menuItems.keySet()) {
			System.out.println("key = " + s);
		}

		// loop over the values
		Collection<MenuItem> values = menuItems.values();
		for (MenuItem mi : values) {
			System.out.println("!!!!!! " + mi);
		}

		// loop over keys and get each value and print it
		for (String key : menuItems.keySet()) {
			System.out.println("key = " + key + " value = " + menuItems.get(key) );
		}

	}

}
