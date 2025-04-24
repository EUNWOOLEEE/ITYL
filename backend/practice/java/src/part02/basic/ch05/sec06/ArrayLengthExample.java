package part02.basic.ch05.sec06;

public class ArrayLengthExample {
    public static void main(String[] args) {
        int[] arr = {84, 90, 96};

        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        System.out.println(sum);
        System.out.println(sum / arr.length);
    }
}