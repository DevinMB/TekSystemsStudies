package com.teksystems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Generics {

	public static void main(String[] args) {
		
		// this is a pointer to a new string object in memory
		String str = new String("test string");
		System.out.println(str.toUpperCase());
		
		// this is a pointer to nothing
		String str1 = null;
		// this will cause a null pointer exception
		//System.out.println(str1.toUpperCase());
		
		if ( str1 == null ) {
			// do some work
			str1 = new String();
		} 
		

		List<String> list1 = new ArrayList<>();

		list1.add("String 1");
		list1.add("String 2");
		list1.add("String 3");

		// prints what is in list 1
		printList(list1);

		List<String> list2 = new ArrayList<>();

		list2.add("String 4");
		list2.add("String 5");
		list2.add("String 6");

		// prints what is in list 2
		printList(list2);

		// this will add all from list 2 to list 1
		list1.addAll(list2);

		// prints what is in list 1
		printList(list1);

		// remove the first item from the list
		list1.remove(4);
		printList(list1);

		String a = list1.get(3);
		System.out.println("a = " + a);

		// contains
		if (list1.contains("String 1")) {
			System.out.println("List 1 contains String 1");
		}

		// insert at a position in the list
		list1.add(1, "Inserted String");
		printList(list1);
		
		String[] arr = new String[5];
		arr[0] = "Java";
		arr[1] = "Python";
		arr[2] = "JavaScript"; 
		arr[3] = "ReactJs";
		
	    List<String> listObj = Arrays.asList(arr);
	    printList(listObj);
	    
	    List<Integer> intList = new ArrayList<Integer>();
	    intList.add(10);
	    intList.add(20);
	    intList.add(30);
	    
	    for ( int i = 0 ; i < intList.size() ; i++ ) {
	    	Integer val = intList.get(i);
	    	val = val + 10;
	    	
	    }
	    
	}

	public static void printList(List<String> list) {
		System.out.println("-------------------------");

		// here is how to do an iterator but dont worry about it
//		Iterator<String> it = list.iterator();
//		while (it.hasNext()) {
//			String s = it.next();
//			System.out.println(s);
//		}
		
		for ( String s : list ) {
			System.out.println(s);
		}
	}
}
