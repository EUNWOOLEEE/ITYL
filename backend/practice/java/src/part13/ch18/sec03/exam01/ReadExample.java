package part13.ch18.sec03.exam01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {
    public static void main(String[] args) {
        String PATH = "/Users/eunwoolee/vscode_workspace/ITYL/backend/practice/java/src/part13/ch18/test1.db";

        try (InputStream is = new FileInputStream(PATH)) {
            int n;
            while ((n = is.read()) != -1)
                System.out.println(n);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
