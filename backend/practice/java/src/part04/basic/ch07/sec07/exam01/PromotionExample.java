package part04.basic.ch07.sec07.exam01;

class A {
}
class B extends A {
}
class C extends A {
}
class D extends B {
}
class E extends C {
}

public class PromotionExample {
    public static void main(String[] args) {
        B b = new B();
        C c = new C();
        D d = new D();
        E e = new E();

        A a1 = b;
        A a2 = c;
        A a3 = d;
        A a4 = e;

        B b1 = d;
        C c1 = e;

        // B b3 = e;
        // C c2 = d;
        // 상속 관계에 있지 않은 것끼리 형변환을 시도했기 때문에 에러가 발생함
    }
}
