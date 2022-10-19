package FirstFileExample;

import java.nio.file.Path;
import java.nio.file.Paths;




public class FileExample  {
    public static void main(String[] args)  {
        start();
    }

    public static void start() {
        Path path = Paths.get("src/main/resources/test.txt");

        FileHelperMethods helper = new FileHelperMethods();
        helper.createFile(path);

        int count = 10;
        for (int i = 0; i <= count; i++) {
            helper.addLineToFile(path,Integer.toString(i));
        }


    }











}
