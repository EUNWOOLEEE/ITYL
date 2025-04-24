package part02.basic.ch05.sec04;

public class NullPointerExceptionExample {
    public static void main(String[] args) {
        int[] intArray = null; //참조하고있지 않음
        intArray[0] = 10;
        String str = null;
        System.out.println("총 문자 수: " + str.length() );
    }
}