package org.scoula.controller;

import javax.servlet.http.HttpSession;
import org.scoula.ex03.dto.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 싱글톤으로 만들어줌
// 스프링에 이 클래스가 컨트롤러 역할을 하는 클래스라고 등록함
@Controller
public class HomeController {
    // 요청 하나 당 함수 하나
    // 요청이 어떻게 들어오는지 설정
    // 어떤 함수를 부를지 정의함

    @GetMapping("/") // root로 get요청이 들어오면 home() 호출
    // SampleDTO: 가방 역할, 필요할 때만 생성 후 필요없어지면 제거함, 싱글톤x
    // HttpSession: 로그아운 전까지, 브라우저를 완전히 닫기 전까지 유지
    public String home(Model model, HttpSession session, SampleDTO sampleDTO) {
        // Model: 서버에서 forward할 때 request, response 객체가 계속 전달됨
        // request 객체에 속성으로 지정
        // forward 시 전달됨. jsp에서 꺼내서 출력할 예정
        model.addAttribute("name", "홍길동");
        model.addAttribute("age", 100);

        // 스프링이 핸들러 매퍼에 주소와 방식에 따른 어떤 컨트롤러의 메서드를 불러야할지 자동으로 등록시켜줌
        System.out.println("HomeController ===== ");
        return "index"; // view 파일 이름 프론트컨트롤러에서 리턴

        // 뷰 리졸버가 /WEB-INF/wives/index.jsp를 붙여서
        // 프론트 컨트롤러가 불러야 할 파일명으로 만듦(렌더링)
    }
}
