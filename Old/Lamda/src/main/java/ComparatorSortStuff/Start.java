package ComparatorSortStuff;

import java.util.*;

public class Start {

    public static void main(String[] args) {

        List<MenuItem> menu = new ArrayList<MenuItem>() {
            {
                Arrays.asList(
                        new MenuItem("ah", "drink", 2.13),
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
                        new MenuItem("cinnamon roll", "food", 1.05)
                );
            }


        };

        Collections.sort(menu, new Comparator<MenuItem>() {
            @Override
            public int compare(MenuItem o1, MenuItem o2) {

                int eq = o1.getItem().compareTo(o2.getItem());
                if(eq == 0) {
                    double comp = o1.getPrice() - o2.getPrice();

                    if(comp>0){
                        eq = 1;
                    }
                    if(comp<0){
                        eq = -1;
                    }
                    if(comp==0){
                        eq = 0;
                    }


                }

                return eq;
            }
        });

        for (MenuItem m : menu) {
            System.out.println(m.getItem() + m.getPrice());
        }

    }
}
