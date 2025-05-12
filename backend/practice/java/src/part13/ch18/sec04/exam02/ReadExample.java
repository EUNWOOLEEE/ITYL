package part13.ch18.sec04.exam02;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadExample {
    public static void main(String[] args) {
        String PATH = "/Users/eunwoolee/vscode_workspace/ITYL/backend/practice/java/src/part13/ch18/sec04/test.txt";

        try (
                Reader reader1 = new FileReader(PATH);
                Reader reader2 = new FileReader(PATH);
        ) {
            int c;
            while ((c = reader1.read()) != -1)
                System.out.print((char)c);

            System.out.println();

            char[] arr = new char[1024];
            while (reader2.read(arr) != -1) {}
            for (int i = 0; arr[i] > 0; i++)
                System.out.print(arr[i]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
