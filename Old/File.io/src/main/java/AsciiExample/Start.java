package AsciiExample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Start {

    public static void main(String[] args) throws IOException {

        String inputFile = "src/main/resources/file1.txt";

        String outputFile = "src/main/resources/file4.txt";

        // Get Channel for destination or outputFile
        FileOutputStream fos = new FileOutputStream(outputFile);
        FileChannel targetChannel = fos.getChannel();

        // Get channel for inputFiles
        FileInputStream fis = new FileInputStream(inputFile);
        FileChannel inputchannel = fis.getChannel();
        long size = inputchannel.size();

        ByteBuffer buf = ByteBuffer.allocate((int) size);

        //Loads stuff into buffer, while stuff is in buffer continue
        while (inputchannel.read(buf) > 0) {
            //set buffer position to 0
            //needed because after reading the buffer the position is incremented until the end
            buf.flip();
            //while there is stuff in the buffer continue

            //found a klasjdf
            for (int i = 0, start = 0, cap = buf.capacity(); i < cap; i++) {
                byte b = buf.get();
                buf.put(i, (byte) 0);
                if(Character.isAlphabetic((char) b)){
                    buf.put(start++, b);
            }

            buf.flip();

            targetChannel.write(buf);


        }
    }
}
