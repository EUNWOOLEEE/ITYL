package part04.basic.ch07.sec07.exam02;

public class ChildExample {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent = child;

        parent.method1();
        parent.method2();
        // parent.method3();
        // 자식에서 부모로 형변환했기 때문에 부모의 메서드만 사용 가능함
    }
}
