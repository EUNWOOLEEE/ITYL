package org.scoula.app;

import org.scoula.config.ProjectConfig2;
import org.scoula.domain.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        // 설정파일(context file)에서 만든 싱글톤은 스프링 프로젝트 전체에서 사용됨
        // 싱글톤 객체를 가지고 오기 위해 context 객체가 필요함
        var context = new AnnotationConfigApplicationContext(ProjectConfig2.class);

        // Parrot이 3개 생성되었기 때문에 에러 발생
//        Parrot p1 = context.getBean(Parrot.class);

        // 설정값이 다른 싱글톤으로 여러 개 만들어야 하는 경우
        // 이름 지정하여 필터링
        Parrot p1 = context.getBean("miki", Parrot.class);
        System.out.println(p1.getName());
    }
}
