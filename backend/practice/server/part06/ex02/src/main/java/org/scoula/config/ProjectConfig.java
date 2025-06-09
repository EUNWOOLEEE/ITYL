package org.scoula.config;

import org.scoula.beans.Parrot;
import org.scoula.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    // java context 파일로 주입하는 방법 2가지
    // 1. set() 메서드 이용
    // 먼저 Person이 만들어지고 나서 parrot을 만들어 나중에 집어넣는 방식
    // 나중에 주입하는 방식은 선호하지 않음
    // 2. 생성자 메서드 이용
    // 먼저 parrot을 만들어두고 Person을 만들 때 미리 만들어놓은 parrot 객체를 주입
    // 현재 제일 많이 사용하고 권장됨

    @Bean
    public Parrot parrot () {
        Parrot parrot = new Parrot();
        parrot.setName("Koko");
        return parrot;
    }

    @Bean
    // 객체 생성 시 인자를 반드시 전달해야 함
    public Person person (Parrot parrot) {
        Person person = new Person(); // 객체 생성 후 주입하는 경우 set 메서드 사용
        // Person person = new Person(parrot); // 보통은 이렇게 생성자에 전달(생성자 주입 방법)
        person.setName("Ella");
        // person.setParrot(parrot()); // 주입할 때 set메서드 호출 가능
        person.setParrot(parrot); // Person 생성 전 이미 만들어진 parrot 싱글톤 객체를 찾아서 주입
        return person;
    }
}
