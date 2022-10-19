package FirstFileExample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class FileHelperMethods {

    public void createFile(Path path) {

        try {
            File temp = new File(path.toString());
            System.out.print(path.toString() + " : ");

            if (!temp.exists()) {
                if (temp.createNewFile()) {
                    System.out.print("FileCreated! \n");
                } else {
                    System.out.print("Error! FileNotCreated :( \n");
                }


            } else {
                System.out.print("AlreadyExists! \n");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public boolean addLineToFile(Path path, String s) {
        boolean success = false;
        try {
            FileWriter fw = new FileWriter(path.toString(), true);
            fw.write(s + "\n");
            fw.close();
            System.out.println("File appended with the number : " + s);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return success;
    }


}
