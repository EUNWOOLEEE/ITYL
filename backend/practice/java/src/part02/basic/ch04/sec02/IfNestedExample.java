package part02.basic.ch04.sec02;

import java.util.Random;

public class IfNestedExample {
    public static void main(String[] args) {
        int score = new Random().nextInt(20) + 81;
        System.out.println("점수: " + score);
        String grade;

        if (80 < score && score < 90) {
            if (score < 85)
                grade = "학점: B";
            else
                grade = "학점: B+";
        }
        else {
            if (score < 95)
                grade = "학점: A";
            else
                grade = "학점: A+";
        }

        System.out.println(grade);
    }
}