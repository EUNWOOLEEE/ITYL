package part02.basic.ch05.sec05;

public class SplitExample {
    public static void main(String[] args) {
        String board = "1,자바 학습,참조 타입 String을 학습합니다.,홍길동";
        String[] splited = board.split(",");

        System.out.println("번호: " + splited[0]);
        System.out.println("제목: " + splited[1]);
        System.out.println("내용: " + splited[2]);
        System.out.println("성명: " + splited[3]);
        System.out.println();

        for (int i = 0; i < splited.length; i++)
            System.out.println(splited[i]);
    }
}