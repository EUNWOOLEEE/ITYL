package part05.ch08.sec10.exam02;

public class CastingExample {
    public static void main(String[] args) {
        Vehicle vehicle = new Bus();

        vehicle.run();
//        vehicle.checkFare();
//        checkFare 메서드는 인터페이스로부터 상속받은 것이 아니기 때문에 Vehicle 형으로는 호출할 수 없음

        Bus bus = (Bus)vehicle;
        bus.run();
        bus.checkFare();
    }
}
