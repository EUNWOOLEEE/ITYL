package org.scoula.security.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // 문자셋 필터
    public CharacterEncodingFilter encodingFilter() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return encodingFilter;
    }


     @Override
    public void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(encodingFilter(), CsrfFilter.class);

        // 경로별 접근 권한 설정
        // form-login 기본 설정은 비활성화돼서 사라짐
        // 권한이 없으면 403에러 화면 표시 -> 에러 화면보다는 로그인 페이지로 연결하는 것이 더 좋음
        http.authorizeRequests()
               .antMatchers("/security/all").permitAll()
               .antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')")
               .antMatchers("/security/member").access("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')");
        // 위 작업을 하면 처음에 떴던 login redirect가 사라짐
        // 경로별 접근 권한 설정

        http.formLogin()
                 .loginPage("/security/login")
                 .loginProcessingUrl("/security/login")
                 .defaultSuccessUrl("/");
        // form-login화면 다시 활성화
        // 403 에러가 발생했을 때 form-login 화면으로 다시 redirect

        http.logout() // 로그아웃 설정 시작
                 .logoutUrl("/security/logout") // POST: 로그아웃 호출 url
                 .invalidateHttpSession(true) // 세션 invalidate
                 .deleteCookies("remember-me", "JSESSION-ID") // 삭제할 쿠키 목록
                 .logoutSuccessUrl("/security/logout"); // GET: 로그아웃 이후 이동할 페이지
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        log.info("configure .........................................");
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}1234")
                .password("$2a$10$EsIMfxbJ6NuvwX7MDj4WqOYFzLU9U/lddCyn0nic5dFo3VfJYrXYC")
                .roles("ADMIN","MEMBER"); // ROLE_ADMIN

        auth.inMemoryAuthentication()
                .withUser("member")
                .password("{noop}1234")
                .password("$2a$10$EsIMfxbJ6NuvwX7MDj4WqOYFzLU9U/lddCyn0nic5dFo3VfJYrXYC")
                .roles("MEMBER"); // ROLE_MEMBER
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}