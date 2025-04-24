package part02.basic.ch05.sec06;

public class ArrayCreateByValueListExample2 {
    public static void printItem(int[] items) {
        for (int i = 0; i < items.length; i++)
            System.out.printf("score[%d]: %d\n", i, items[i]);
    }

    public static void main(String[] args) {
        int[] scores = new int[] { 83, 90, 87 };
        printItem(scores);
    }
}