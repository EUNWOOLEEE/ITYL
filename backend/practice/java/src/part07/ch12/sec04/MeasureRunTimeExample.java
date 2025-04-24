package part07.ch12.sec04;

public class MeasureRunTimeExample {
    public static void main(String[] args) {
        int sum = 0;
        long start = System.nanoTime();
        for (int i = 1; i <= 1000000; i++)
            sum += i;
        long end = System.nanoTime();
        System.out.println("sum: " + sum);
        System.out.println("time: " + (end - start) + "ns");
    }
}
