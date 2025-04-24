package part04.basic.ch07.sec07.exam03;

public class ChildExample {
    public static void main(String[] args) {
        Parent parent = new Child();

        parent.field1 = "data1";
        parent.method1();
        parent.method2();
        // parent.field2 = "data2";
        // parent.method3();
        // 부모에서 자식 클래스의 필드에 접근하거나 메서드를 호출할 수 없음

        Child child = (Child) parent;

        child.field2 = "data2";
        child.method3();
    }
}
