package part13.ch18.sec02.exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
    public static void main(String[] args) {
        String PATH = "/Users/eunwoolee/vscode_workspace/ITYL/backend/practice/java/src/part13/ch18/test1.db";
        byte a = 65;
        byte b = 10;
        byte c = 97;

        try (OutputStream os = new FileOutputStream(PATH)) {
            os.write(a);
            os.write(b);
            os.write(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
