package part01.basic.test;

public class VariableTest {
    public static void main(String[] args) {
        byte age = 127;
        short year = 2025;
        int hit = 21000000;
        long money = 2200000000L;

        float w = 70.5f;
        double h = 170.0000000555;

        char gender = '여';

        boolean flag = false;

        System.out.println("내 나이는 " + age + "세야.");
        System.out.println("내 몸무게는 " + w + "kg이야.");
        System.out.println("내 성별은 " + gender + "야.");
        System.out.println("나는 오늘 아침을 먹었을까? " + age);

        String name = "유자";
        String plan = """
                유자랑
                주말에
                놀거다.
                """;

        System.out.println("내 이름은 " + name);
        System.out.println("내 계획은 " + plan);
        System.out.printf("내 이름은 %s야!", name);
        System.out.printf("내 몸무게는 %.2f, 내 키는 %10.3f", w, h);
    }
}