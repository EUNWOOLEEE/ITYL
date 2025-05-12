package part13.ch18.sec06;

import java.io.*;

public class CharacterConvertStreamExample {
    public static void main(String[] args) {
        String PATH = "/Users/eunwoolee/vscode_workspace/ITYL/backend/practice/java/src/part13/ch18/sec06/test.txt";
        String str = "문자 변환 스트림을 사용합니다.";

        try (
                OutputStream os = new FileOutputStream(PATH);
                Writer writer = new OutputStreamWriter(os, "UTF-8");

                InputStream is = new FileInputStream(PATH);
                Reader reader = new InputStreamReader(is, "UTF-8");
        ) {
            writer.write(str);
            writer.flush();

            char[] data = new char[1024];
            int size = reader.read(data);
            if (size > 0)
                System.out.println(new String(data, 0, size));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
