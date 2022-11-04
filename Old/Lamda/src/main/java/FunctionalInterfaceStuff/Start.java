package FunctionalInterfaceStuff;

public class Start {


    public static void main(String[] args){

        FunctionalInterfaceExample<Integer> funcExample = (Integer a,Integer b,Integer c) -> {
            int result = a + b + c;
            return result;
        };


        FunctionalInterfaceExample<Integer> funcExample2 = new FunctionalInterfaceExample<>() {
            @Override
            public Integer modifyThreeNumbers(Integer a, Integer b, Integer c) {
                return a + b + c;
            }
        };

        System.out.println(funcExample.modifyThreeNumbers(6,3,6));
        System.out.println(funcExample2.modifyThreeNumbers(6,3,6));

    }


}
