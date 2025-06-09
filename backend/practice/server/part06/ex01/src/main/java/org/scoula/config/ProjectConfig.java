package org.scoula.config;

import org.scoula.domain.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 객체 생성할 때 설정파일로 두 가지 중 하나를 사용함
// 1. xml 파일
// 2. java 파일

// 설정파일로 스프링 프레임워크에 알려주는 역할
@Configuration
public class ProjectConfig {
    // 스프링에 싱글톤으로 만들어야한다고 알려주는 어노테이션
    // 스프링이 함수를 호출해서 공장처럼 싱글톤으로 만듦
    // 직접 만든 클래스는 클래스 이름 위에 @Bean 어노테이션을 넣으면 싱글톤으로 만들어줌
    // 내가 만든 것이 아닌 경우에는 파일을 수정할 수 없기 때문에 Config 파일에 넣음
    @Bean
    public Parrot parrot() {
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }
}
