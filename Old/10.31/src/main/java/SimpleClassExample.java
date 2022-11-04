import org.apache.commons.validator.routines.EmailValidator;

public class SimpleClassExample {

    public boolean isEmailValid(String name) {

        boolean valid = EmailValidator.getInstance().isValid(name);
        return valid;
    }


    public boolean isPhoneValid(String number){

        if(number == null || number.equals("")){
            return false;
        }

        String s1 = number.replaceAll(" ","");
        String s2 = s1.replaceAll("-","");
        String s3 = s2.replaceAll("\\.","");

        if(s3.length()!=10){
            return false;
        }

        if(s3.substring(0,2).equalsIgnoreCase("555")){
            return false;
        }

        return true;
    }
}








//
//        boolean valid = true;
//
//        String[] invalidCharArray = "!@#$%^&*()".split("");
//
//        List<String> invalidChars = Arrays.asList(invalidCharArray);
//
//        String[] userNameCharacterArray = name.split("");
//
//        for (String currentChar : userNameCharacterArray) {
//            if (invalidChars.contains(currentChar)) {
//                System.out.println("invalid username!");
//                return false;
//            }
//        }


        //USING STRING UTILS
//        String[] separated = name.split("@");
//
//        if(separated.length == 1){
//            String[] firstsection = separated[0].split("");
//            //check first half for alphanumeric
//            for(String currentChar : firstsection){
//                if(invalidChars.contains(currentChar)){
//                    return false;
//                }
//            }
//            String lastFour = separated[1].substring(separated[1].length() - 4);
//            System.out.println(lastFour);
//            if(!lastFour.startsWith(".")){
//                return false;
//            }
//            for(String currentChar : lastFour.split("")){
//                if(invalidChars.contains(currentChar)){
//                    return false;
//                }
//            }
//        }else{
//            valid = false;
//        }
//        return valid;
//    }

//    public static boolean isAlphanumeric(char c) {
//        String alphanumericChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.";
//        boolean found = false;
//        for (int i = 0; i < alphanumericChars.length(); i++) {
//            if (alphanumericChars.charAt(i) == c)  {
//                found = true;
//                break;
//            }
//        }
//        return found;
//    }

