package part02.basic.ch04.sec05;

public class SumFrom1To100Example {
    public static void main(String[] args) {
        int i = 0, sum = 0;
        while (i++ < 100)
            sum += i;
        System.out.println("1~100 합 : " + sum);
    }
}