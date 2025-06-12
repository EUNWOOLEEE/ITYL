package org.scoula.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

// mvc 관련 설정이나 객체생성 + 주입
@EnableWebMvc // mvc 관련된 설정을 할 수 있는 파일로 등록
@ComponentScan(basePackages = {
                                "org.scoula.controller",
                                "org.scoula.ex03.controller"
                                }) // Spring MVC용 컴포넌트 등록을 위한 스캔 패키지
public class ServletConfig implements WebMvcConfigurer {
    // 어떤 함수를 써서 설정해야할지 WebMvcConfigurer에 정의되어있음
    // override해서 사용

    // 프론트파일(css, js, img)의 위치를 지정해주는 함수
    // /resources/img/a.png라고 요청이 들어오면
    // /resources/ 및에서 찾도록 설정
    // <img src="resources/img/a.png">
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**") // url이 /resources/로 시작하는 모든 경로
                .addResourceLocations("/resources/"); // webapp/resources/경로로 매핑
    }

    // jsp view resolver 설정
    // 컨트롤러에서 받은 결과를 어떤 jsp 파일을 불러서 넣을지 위치 설정, 뒤에 jsp 붙여서 만들어주는 기능의 함수
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // view resolver 객체 생성
        // 앞에는 위치 지정, 뒤에는 jsp 지정해서 객체 등록

        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        registry.viewResolver(bean);
    }

    // Servlet 3.0 파일 업로드 사용시 - MultipartResolver 빈 등록
    @Bean
    public MultipartResolver multipartResolver() {
        StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();

        return resolver;
    }
}