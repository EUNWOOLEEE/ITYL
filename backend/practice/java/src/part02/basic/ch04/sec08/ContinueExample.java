package part02.basic.ch04.sec08;

public class ContinueExample {
    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 1)
                continue;
            System.out.print(i + " ");
        }
    }
}