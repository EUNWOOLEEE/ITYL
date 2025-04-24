package part07.ch12.sec05;

import java.util.StringTokenizer;

public class StringTokenizerExample {
    public static void main(String[] args) {
        String data1 = "홍길동&이수홍,박연수";
        String[] parsedData = data1.split("&|,");

        for (String name : parsedData)
            System.out.println(name);
        System.out.println();

        String data2 = "홍길동/이수홍/박연수";
        StringTokenizer tokenizer = new StringTokenizer(data2, "/");

        while (tokenizer.hasMoreTokens() == true)
            System.out.println(tokenizer.nextToken());
    }
}
