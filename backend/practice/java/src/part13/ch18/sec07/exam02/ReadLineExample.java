package part13.ch18.sec07.exam02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReadLineExample {
    public static void main(String[] args) {
        String PATH = "/Users/eunwoolee/vscode_workspace/ITYL/backend/practice/java/src/part13/ch18/sec07/exam02/test3.db";

        try (
                Reader is = new FileReader(PATH);
                BufferedReader reader = new BufferedReader(is);
        ) {
            String str = "";
            while ((str = reader.readLine()) != null)
                System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
