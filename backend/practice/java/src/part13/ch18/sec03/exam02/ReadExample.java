package part13.ch18.sec03.exam02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {
    public static void main(String[] args) {
        String PATH = "/Users/eunwoolee/vscode_workspace/ITYL/backend/practice/java/src/part13/ch18/test2.db";
        byte[] data = new byte[1024];

        try (InputStream is = new FileInputStream(PATH)) {
            int idx = 0, n;
            while ((n = is.read()) != -1)
                data[idx++] = (byte)n;
            for (byte b : data) {
                if (b == 0) break;
                System.out.println(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
