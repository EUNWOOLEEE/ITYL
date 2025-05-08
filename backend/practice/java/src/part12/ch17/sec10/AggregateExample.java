package part12.ch17.sec10;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AggregateExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("2의 배수 개수: " + Arrays.stream(arr).filter(n -> n % 2 == 0).count());
        System.out.println("2의 배수의 합: " + Arrays.stream(arr).filter(n -> n % 2 == 0).sum());
        System.out.println("2의 배수의 평균: " + Arrays.stream(arr).filter(n -> n % 2 == 0).average().getAsDouble());
        System.out.println("최대값: " + Arrays.stream(arr).filter(n -> n % 2 == 0).max().getAsInt());
        System.out.println("최소값: " + Arrays.stream(arr).filter(n -> n % 2 == 0).min().getAsInt());
        System.out.println("첫 번째 3의 배수: " + Arrays.stream(arr).filter(n -> n % 3 == 0).findFirst().getAsInt());
    }
}
