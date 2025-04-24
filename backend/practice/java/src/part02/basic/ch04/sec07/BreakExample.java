package part02.basic.ch04.sec07;

import java.util.Random;

public class BreakExample {
    public static void main(String[] args) throws Exception {
        while (true) {
            int num = new Random().nextInt(6) + 1;
            System.out.println(num);
            if (num == 6)
                break;
        }
    }
}