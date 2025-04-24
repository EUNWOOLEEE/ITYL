package part03.basic.ch06.sec08.exam01;

public class Calculator {
    public void powerOn() {
        System.out.println("전원을 켭니다.");
    }

    public void powerOff() {
        System.out.println("전원을 끕니다.");
    }

    public int plus(int a, int b) {
        return a + b;
    }

    public double divide(double a, double b) {
        if (b == 0)
            return 0;
        return a / b;
    }
}