package SBAcodePract;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class One {

    static class InvalidStringException extends Exception{

        public InvalidStringException(String err){

            super(err);

        }

    }




    public static void main(String[] args) {

        String[] strings = new String[]{
                "8","7","2235", "stvyb", "225", "pd", "dxvcr", "wvmg", "xvnj"
        };

        ArrayToList atl = new ArrayToList();

        atl.convert(strings);

        System.out.println(atl.arrayToList.toString());

        atl.replace(1);


        System.out.println(atl.arrayToList.toString());


        List<String> compact = atl.compact();
        System.out.println(compact.toString());


        for (int i = 0; i < compact.size(); i++) {
            if(compact.get(i).charAt(0) >= 97 && compact.get(i).charAt(0) <= 122){
                try{
                    throw new InvalidStringException("This is an invalid string");
                } catch (InvalidStringException e){
                    System.out.println(e.getMessage());
                }

            }
        }


    }

    static class ArrayToList  {

        ArrayList<String> arrayToList;

        public ArrayToList(){
            this.arrayToList = new ArrayList<>();
        }

        public void convert(String[] a){

            for(String s : a ){
                //adds the strings in the array to arrayToList
                arrayToList.add(s);
                //get last index
                int lastIndex = arrayToList.size()-1;
                //also print
                System.out.println("I have added the string: " + s + " at the index: " + lastIndex);;

            }

        }


        public void replace(int idx){
            //get current string data
            String preReplacementString = arrayToList.get(idx);

            //replaces the string at the index idx of arrayToList with an empty string:
            arrayToList.set(idx, "");

            //also prints "I have replaced the string: {string} with a null string"
            System.out.println("I have replaced the string: " + preReplacementString + " with a null string");

        }

        public ArrayList<String> compact(){

            ArrayList<String> resultingList = arrayToList;

            //should remove all empty string from the list and return resulting list
            for (int i = 0; i < resultingList.size(); i++) {
                String currentString = resultingList.get(i);
                if(currentString.equals("")){
                    resultingList.remove(i);
                }
            }
            return resultingList;
        }




    }

    }

