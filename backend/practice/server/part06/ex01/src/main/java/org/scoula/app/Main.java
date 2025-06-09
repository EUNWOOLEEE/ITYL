package org.scoula.app;

import org.scoula.config.ProjectConfig;
import org.scoula.domain.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 스프링을 쓰지 않으면 프로그래머가 new 키워드로 직접 객체 생성함
        Parrot p = new Parrot();
        p.setName("Test");
        System.out.println(p.getName());

        // 스프링이 객체를 생성한 것을 가지고 와서 사용
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot p2 = context.getBean(Parrot.class);
        System.out.println(p2.getName());
        Parrot p3 = context.getBean(Parrot.class);
        System.out.println(p3.getName());

        // 싱글톤으로 하나만 만들기 때문에 같은 객체
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p2 == p3);
    }
}
