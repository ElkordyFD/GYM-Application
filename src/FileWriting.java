package src;

import java.io.*;

public class FileWriting {
    public static void write(File file, Object object) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream(file,true);
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
        objectOutput.writeObject(object);
    }
}