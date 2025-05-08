package part12.ch17.sec04.exam03;

import java.util.stream.IntStream;

public class SteamExample {
    public static int sum;

    public static void main(String[] args) {
        IntStream intStream = IntStream.rangeClosed(1, 100);
        intStream.forEach(num -> sum += num);
        System.out.println("총합: " + sum);
    }
}
