package SortingExamples;

import ComparatorSortStuff.MenuItem;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingExamples {


    private MenuItem[] menu = new MenuItem[]{new MenuItem("orange juice", "drink", 2.13),
            new MenuItem("lemonade", "drink", 0.85), new MenuItem("cranberry juice", "drink", 3.36),
            new MenuItem("lemonade", "drink", 0.65), new MenuItem("cranberry juice", "drink", 3.36),
            new MenuItem("pineapple juice", "drink", 1.89), new MenuItem("lemon iced tea", "drink", 1.28),
            new MenuItem("apple iced tea", "drink", 1.28), new MenuItem("vanilla chai latte", "drink", 2.48),
            new MenuItem("hot chocolate", "drink", 0.99), new MenuItem("iced coffee", "drink", 1.12),
            new MenuItem("tuna sandwich", "food", 0.95), new MenuItem("ham and cheese sandwich", "food", 1.35),
            new MenuItem("bacon and egg", "food", 1.15), new MenuItem("steak", "food", 3.28),
            new MenuItem("hamburger", "food", 1.05), new MenuItem("cinnamon roll", "food", 1.05),
            new MenuItem(null, "food", 1.05)};


    public static void main(String[] args) {
        SortingExamples se = new SortingExamples();
        se.start();
    }


    public void start() {
        // first we convert the array to a list
        List<MenuItem> list = Arrays.asList(menu);

        // do these using collections sort or list sort or by stream

        // TODO - sort the list by name in descending order  (z to a)

//              USING LAMBDAS
//            list.sort((MenuItem m1, MenuItem m2) ->
//            {
//                if (m1.getItem() == null || m2.getItem() == null) {
//                    return 0;
//                } else {
//                    return m2.getItem().compareTo(m1.getItem());
//                }
//            });


        Collections.sort(list, new Comparator<MenuItem>() {

            @Override
            public int compare(MenuItem m1, MenuItem m2) {
                if (m1.getItem() == null || m2.getItem() == null) {
                    return 0;
                } else {
                    return m2.getItem().compareTo(m1.getItem());
                }
            }
        });

        //print(list);


        // TODO - sort the list by name in ascending order with nulls last


        // print(list);


        // TODO - sort the list by name in ascending order with nulls first


        Collections.sort(list, new Comparator<MenuItem>() {
            @Override
            public int compare(MenuItem o1, MenuItem o2) {
                if (o1.getItem() == null) {
                    return (o2.getItem() == null) ? 0 : -1;
                }
                if (o2.getItem() == null) {
                    return 1;
                }
                return o2.getItem().compareTo(o1.getItem());
            }
        });

        //print(list);

        // TODO - filter the list and remove all food items - will produce a list of drinks in alphabetical order

        List<MenuItem> foodOnlyList = list.stream().filter(f -> f.getType().equalsIgnoreCase("food")).collect(Collectors.toList());

        print(foodOnlyList);


    }

    private void print(List<MenuItem> list) {
        // TODO implement this

        for (MenuItem mi : list) {
            System.out.println(mi.getItem());
        }
    }
}



