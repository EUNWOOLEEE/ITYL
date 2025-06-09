package org.scoula.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person2 {
    // 어노테이션으로 주입하는 3가지 방법
    // 1. 필드 위에 표시 -> 예전에 많이 사용된 방식, 아주 간단함
    // Person2 먼저 생성 후 나중에 Parrot을 주입, 비권장
    // 2. 생성자에 표시 -> 권장, 미리 만들어서 객체 생성 시 주입
    // 3. set메서드에 표시 -> 비권장, Parrot을 나중에 주입하고 싶을 때 사용(가끔 사용함)

    private String name = "Ella";

    // 싱긍톤 중에서 자동으로 Parrot2의 클래스로 만들어진 것 있으면 주입하도록 하는 어노테이션
    // @Autowired
    // private final Parrot2 parrot;
    // final로 선언하고 생성자에서 주입 시, 처음 주입한 객체로 고정되어 안정성 향상

    private Parrot2 parrot;

    // @Autowired
    public Person2(Parrot2 parrot) {
        this.parrot = parrot;
    }

    public String getName() {
        return name;
    }

    public Parrot2 getParrot() {
        return parrot;
    }

    public void setName(String name) {
        this.name = name;
    }

    // final로 할 경우 제거
    @Autowired
    public void setParrot(Parrot2 parrot) {
        this.parrot = parrot;
    }
}
