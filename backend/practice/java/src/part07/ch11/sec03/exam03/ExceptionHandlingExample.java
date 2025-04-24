package part07.ch11.sec03.exam03;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        try {
//            String[] array = {"100", "1oo", null, "200"};
            String[] array = {"100", "100", null, "200"};
            for (int i = 0; i <= array.length; i++) {
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "]: " + value);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
