package org.scoula.ex03.controller;

import java.util.ArrayList;
import lombok.extern.log4j.Log4j2;
import org.scoula.ex03.dto.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// 싱글톤으로 만들고, 클래스 안에서 설정한 주소(함수 매핑)를 핸들러 매퍼에게 등록시켜줌
// @Component + 컨트롤러 기능
@Controller
// sample 도메인을 위한 여러 요청에 대한 함수를 정의
// http://localhost:8080/sample/insert
// /sample/delete, /sample/update
@RequestMapping("/sample")
@Log4j2
public class SampleController {
    @RequestMapping("") // /sample
    public String sample() {
        log.info("SampleController ======================= ");
        return "sample";
        // /WEB-INF/views/sample.jsp -> 없으면 404에러
    }

    @GetMapping("/basicOnlyGet")
    public void basicOnlyGet() {
        // void인 경우에 호출한 주소를 사용해서 /WEB-INF/views/요청주소.jsp 로 찾음
        // 요청 주소와 views 밑에 파일 이름이 같다면 String으로 반환하지 않아도 됨
        // /sample/basicOnlyGet.jsp 를 찾음
        log.info("basic only get...........");
    }

    @RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
    // /sample/basic
    public void basic() {
        log.info("basic get..........");
        // 컨트롤러로 오면 그 다음은 무조건 jsp 파일을 호출함 -> forward, 결과를 넣는 jsp 페이지가 필요할 때
        // redirect해서 view로 안 갈 수도 있음 -> 다른 페이지로 전환
    }

    @GetMapping("/ex01")
    // http로 전달받은 데이터는 모두 String
    // 스프링이 형변환도 해줌
    public String ex01(@RequestParam("name") String name2, int age) {
//        String name = request.getParameter("name");
//        String age = request.getParameter("age");
//        int age = Integer.parseInt(age);
        log.info("/ex01 ====================");
        System.out.println("name: " + name2);
        System.out.println("age: " + (age + 1));
        return "ex01";
    }

    @GetMapping("/ex011")
    // 전달되는 데이터가 많은 경우 가방 역할의 변수에 넣음
    // 컨트롤러 함수 호출 시 입력 파마리터로 넣은 dto는 자동으로 view까지 전달되고, Model의 속성으로 추가됨
    // 이름은 클래스와 같되 lowerCamelCase로 설정해야 함
    public String ex011(SampleDTO sampleDTO, @ModelAttribute("day") String day) {
        log.info("/ex011 ===================");
        System.out.println("name: " + sampleDTO.getName());
        System.out.println("age: " + (sampleDTO.getAge() + 1));
        return "ex011";
    }

    @GetMapping("/ex04")
    public String ex04(SampleDTO sampleDTO, @ModelAttribute("page") int page) {
        log.info("dto: " + sampleDTO);
        log.info("page: " + page);
        return "sample/ex04";
    }

    @GetMapping("/ex05")
    public void ex05() {
        log.info("/ex05........");
    }

    @GetMapping("/ex06")
    public String ex06(RedirectAttributes ra) {
        log.info("/ex06........");
        ra.addAttribute("name", "AAA");
        ra.addAttribute("age", 10);
        return "redirect:/sample/ex06-2";
    }

    // json으로 응답, views 아래 jsp 파일을 사용하지 않는 경우
    @GetMapping("/ex07")
    public @ResponseBody SampleDTO ex07() {

        log.info("/ex07........");
        SampleDTO dto = new SampleDTO();
        dto.setAge(10);
        dto.setName("홍길동");
        return dto;
    }

    @GetMapping("/exUpload")
    public void exUpload() {
        log.info("/exUpload..........");
    }

    @PostMapping("/exUploadPost")
    public void exUploadPost(ArrayList<MultipartFile> files) {
        for(MultipartFile file : files) {

            log.info("----------------------------------");
            log.info("name:" + file.getOriginalFilename()); // 윈도우 OS: 한글 파일명인 경우 깨짐
            log.info("size:" + file.getSize());
        }
    }
}
