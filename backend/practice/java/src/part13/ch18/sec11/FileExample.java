package part13.ch18.sec11;

import java.io.File;

public class FileExample {
    public static void main(String[] args) {
//        String PATH = "/Users/eunwoolee/vscode_workspace/ITYL/backend/practice/java/src/part13/ch18/sec11/file1.txt";
//        String PATH = "/Users/eunwoolee/vscode_workspace/ITYL/backend/practice/java/src/part13/ch18/sec11/test";
        String PATH = "/Users/eunwoolee/vscode_workspace/ITYL/backend/practice/java/src/part13/ch18/sec11/temp";

        File file = new File(PATH);

        if (file.exists() == false)
            System.out.println("해당 파일은 없는 파일입니다.");
        else if (file.isFile() == true) {
            System.out.println("Path: " + file.getPath());
            System.out.println("Size: " + file.length());
        }
        else if (file.isDirectory() == true) {
            System.out.println("<" + file.getName() + "> " + file.getPath());
        }
    }
}
