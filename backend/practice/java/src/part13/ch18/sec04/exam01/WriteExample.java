package part13.ch18.sec04.exam01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteExample {
    public static void main(String[] args) {
        char a = 'A';
        char b = 'B';
        char[] arr = {'C', 'D', 'E'};
        String PATH = "/Users/eunwoolee/vscode_workspace/ITYL/backend/practice/java/src/part13/ch18/sec04/test.txt";

        try (Writer writer = new FileWriter(PATH)) {
            writer.write(a);
            writer.write(b);
            writer.write(arr);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
