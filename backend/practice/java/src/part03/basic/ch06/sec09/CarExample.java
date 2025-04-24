package part03.basic.ch06.sec09;

public class CarExample {
    public static void main(String[] args) {
        Car car = new Car("곰돌이");

        car.setSpeed(50);
        System.out.println(car.getSpeed());
        car.run();
    }
}