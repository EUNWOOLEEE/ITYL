package part13.ch18.sec03.exam03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {
    public static void main(String[] args) {
        String originalFileName = "/Users/eunwoolee/vscode_workspace/ITYL/backend/practice/java/src/part13/ch18/test_image.jpg";
        String targetFileName = "/Users/eunwoolee/vscode_workspace/ITYL/backend/practice/java/src/part13/ch18/test_image2.jpg";

        try (
                InputStream is = new FileInputStream(originalFileName);
                OutputStream os = new FileOutputStream(targetFileName);
        ) {
            int tmp;
            while ((tmp = is.read()) != -1)
                os.write(tmp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
