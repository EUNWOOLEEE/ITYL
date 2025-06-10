package org.scoula.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 싱글톤으로 만들어줌
// 스프링에 이 클래스가 컨트롤러 역할을 하는 클래스라고 등록함
@Controller
public class HomeController {
    // 요청 하나 당 함수 하나
    // 요청이 어떻게 들어오는지 설정
    // 어떤 함수를 부를지 정의함

    @GetMapping("/") // root로 get요청이 들어오면 home() 호출
    public String home() {
        // 스프링이 핸들러 매퍼에 주소와 방식에 따른 어떤 컨트롤러의 메서드를 불러야할지 자동으로 등록시켜줌
        System.out.println("HomeController ===== ");
        return "index"; // view 파일 이름 프론트컨트롤러에서 리턴

        // 뷰 리졸버가 /WEB-INF/wives/index.jsp를 붙여서
        // 프론트 컨트롤러가 불러야 할 파일명으로 만듦(렌더링)
    }
}
