package part07.ch11.sec03.exam01;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        try {
            String[] array = {"100", "1oo"};
//            String[] array = {"100", "100"};
            for(int i=0; i<=array.length; i++) {
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "]: " + value);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
