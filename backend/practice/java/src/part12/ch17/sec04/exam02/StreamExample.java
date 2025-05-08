package part12.ch17.sec04.exam02;

import java.util.Arrays;

public class StreamExample {
    public static void main(String[] args) {
        String[] strArray = {"홍길동", "신용권", "김미나"};
        Arrays.stream(strArray).forEach(name -> System.out.print(name + ","));
        System.out.println();

        int[] intArray = {1, 2, 3, 4, 5};
        Arrays.stream(intArray).forEach(num -> System.out.print(num + ","));
    }
}
