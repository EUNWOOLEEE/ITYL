package part07.ch11.sec02.exam01;

public class ExceptionHandlingExample1 {
    public static void printLength(String data) {
        int result = data.length();
        System.out.println("문자 수: " + result);
    }

    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        // null은 가르키는 메모리 공간이 없기 때문에 length 메서드를 사용할 수 없음
        try {
            printLength(null);
        } catch (Exception e) {
            System.out.println("error message: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("[프로그램 종료]");
    }
}
