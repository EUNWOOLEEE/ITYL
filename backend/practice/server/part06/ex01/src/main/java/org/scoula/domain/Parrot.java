package org.scoula.domain;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

// 핵심 요소(객체지향에서 핵심요소 객체임)
// 프로그래머가 클래스를 직접 만들었을 때 사용
// 스프링이 싱글톤으로 만들어서 관리함
@Component
public class Parrot {
    private String name;

    // 의존성 주입이 완료된 후 자동으로 실행하는 어노테이션
    // 매개변수가 없어야하고 반환 타입이 void여야 함
    @PostConstruct
    public void init() {
        this.name = "Kiki";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}