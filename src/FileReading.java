package src;
import java.io.*;

public class FileReading {
    public static Object read(File file) throws Exception {
        FileInputStream fileInput = new FileInputStream(file);
        ObjectInputStream objectInput = new ObjectInputStream(fileInput);
        return objectInput.readObject();
    }
}
