package SortingOnComplexObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Start {

    public static void main(String[] args){

        List<ImVeryComplexObject> listOfObjects = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");

        try {
            listOfObjects.add(new ImVeryComplexObject("tod",1,new Date(String.valueOf(formatter.parse("12-31-2021")))));
            listOfObjects.add(new ImVeryComplexObject("devin",6,new Date(String.valueOf(formatter.parse("1-31-2021")))));
            listOfObjects.add(new ImVeryComplexObject("joey",5,new Date(String.valueOf(formatter.parse("2-28-2021")))));
            listOfObjects.add(new ImVeryComplexObject("sharey",7,new Date(String.valueOf(formatter.parse("6-15-2021")))));
            listOfObjects.add(new ImVeryComplexObject("lynn",4,new Date(String.valueOf(formatter.parse("7-21-2021")))));
            listOfObjects.add(new ImVeryComplexObject("chris",2,new Date(String.valueOf(formatter.parse("8-5-2021")))));
            listOfObjects.add(new ImVeryComplexObject("danny",9,new Date(String.valueOf(formatter.parse("9-25-2021")))));
            listOfObjects.add(new ImVeryComplexObject("justin",10,new Date(String.valueOf(formatter.parse("7-2-2021")))));
            listOfObjects.add(new ImVeryComplexObject("tori",11,new Date(String.valueOf(formatter.parse("5-16-2021")))));
            listOfObjects.add(new ImVeryComplexObject("ashley",15,new Date(String.valueOf(formatter.parse("3-5-2021")))));
            listOfObjects.add(new ImVeryComplexObject("josh",8,new Date(String.valueOf(formatter.parse("4-25-2021")))));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("unordered list:");
        for (ImVeryComplexObject o : listOfObjects){
            System.out.println(o.toString());
        }

        System.out.println("ordered list on ID: ");
        listOfObjects.sort((ImVeryComplexObject o1, ImVeryComplexObject o2) -> o1.getId() - o2.getId());
        for (ImVeryComplexObject o : listOfObjects){
            System.out.println(o.toString());
        }

        System.out.println("ordered list on Start Date: ");
        listOfObjects.sort((ImVeryComplexObject o1, ImVeryComplexObject o2) -> o1.getStartDate().compareTo(o2.getStartDate()));
        for (ImVeryComplexObject o : listOfObjects){
            System.out.println(o.toString());
        }

        System.out.println("ordered list on name(using collections and custom comparator: ");
        Collections.sort(listOfObjects, new Comparator<ImVeryComplexObject>() {
            @Override
            public int compare(ImVeryComplexObject o1, ImVeryComplexObject o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (ImVeryComplexObject o : listOfObjects){
            System.out.println(o.toString());
        }

    }

}
