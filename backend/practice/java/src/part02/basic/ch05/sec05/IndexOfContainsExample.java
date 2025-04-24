package part02.basic.ch05.sec05;

public class IndexOfContainsExample {
    public static void main(String[] args) {
        String subject = "자바 프로그래밍";
        int idx = subject.indexOf("프로그래밍");
        if (idx != -1) {
            System.out.println(idx);
            System.out.println("자바와 관련된 책이군요.");
        }
        else
            System.out.println("자바와 관련되지 않은 책이군요.");
    }
}