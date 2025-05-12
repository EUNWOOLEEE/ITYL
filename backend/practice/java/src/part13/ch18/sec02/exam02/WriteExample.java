package part13.ch18.sec02.exam02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
    public static void main(String[] args) {
        String PATH = "/Users/eunwoolee/vscode_workspace/ITYL/backend/practice/java/src/part13/ch18/test2.db";
        byte[] array = { 65, 66, 67 };

        try (OutputStream os = new FileOutputStream(PATH)) {
            os.write(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
