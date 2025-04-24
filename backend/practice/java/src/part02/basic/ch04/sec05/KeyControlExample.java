package part02.basic.ch04.sec05;

import java.util.Scanner;

public class KeyControlExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int speed = 0;

        while (str.equals("") == false) {
            System.out.println("""
                    -----------------------------
                    1. 증속 | 2. 감속 | 3. 중지
                    -----------------------------""");

            if (str.equals("1") == false && str.equals("2") == false && str.equals("3") == false)
                continue;

            System.out.println("선택: " + str);
            if (str.equals("1"))
                speed++;
            else if (str.equals("2"))
                speed = speed > 0 ? speed - 1 : 0;
            else if (str.equals("3")) {
                System.out.println("프로그램 종료");
                break;
            }

            System.out.println("현재 속도 = " + speed);
            str = scanner.nextLine();
        }
        scanner.close();
    }
}