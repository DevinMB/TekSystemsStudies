package NIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;


public class Start {

    public static void main(String[] args) throws IOException {
        // initializing two files in Array;
        String[] inputFiles = {"src/main/resources/file1.txt","src/main/resources/file2.txt"};

        // Specify out file with path location
        //Files contents will be written in these files
        String outputFile = "src/main/resources/file3.txt";

        // Get Channel for destination or outputFile
        FileOutputStream fos = new FileOutputStream(outputFile);
        FileChannel targetChannel = fos.getChannel();

        for (int i = 0; i < inputFiles.length; i++) {
            // Get channel for inputFiles
            FileInputStream fis = new FileInputStream(inputFiles[i]);
            FileChannel inputchannel = fis.getChannel();
            long size = inputchannel.size();

            ByteBuffer buf = ByteBuffer.allocate((int) size);

            //System.out.print((int) buf.get());


            //Loads stuff into buffer, while stuff is in buffer continue
            while (inputchannel.read(buf) > 0) {
                //set buffer position to 0
                //needed because after reading the buffer the position is incremented until the end
                buf.flip();
                //while there is stuff in the buffer continue
                while (buf.hasRemaining()) {

                    //pull bytes off of the buffer and write to targetChannel
                    targetChannel.write(buf);
                }
            }
            //fis.close();
        }
    }
}
