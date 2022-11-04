package ListsOfStuff;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Start {
    public static void main(String[] args){
        List<String> strings = new ArrayList<>();

        strings.add("String 1");
        strings.add("String 2");
        strings.add("String 3");

        for( String s : strings){
            System.out.println(s);
        }

        List<String> linked = new LinkedList<>();

        linked.addAll(strings);






    }
}
