package org.scoula.persistence;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Log4j2
public class JDBCTest {
    // 설정 테스트 예정
    // 테스트 단위마다 함수 하나 생성
    // 함수 단위마다 테스트 -> 단위 테스트(Unit Test)
    // JUnit 라이브러리 사용

    // 모든 단위 테스트에서 사용할 드라이버를 설정해야 함

    // 아래 모든 함수 호출 전에 무조건 한 번 이거 실행해줘 라는 어노테이션
    @BeforeAll
    public static void setup() {
        // 클래스 파일을 연결(try-catch 예외처리)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // 상세 에러정보 프린트
        }
    }

    @Test
    @DisplayName("JDBC 드라이버 연결이 된다.")
    public void testConnection() {
        String url = "jdbc:mysql://localhost:3306/scoula_db";
        try(Connection con = DriverManager.getConnection(url, "scoula", "1234")) {
            log.info(con);
        } catch(Exception e) {
//            System.out.println(e.getMessage());
            fail(e.getMessage()); // JUnit에게 테스트하려고 했던 것을 실패했다고 명시적으로 알려주는 역할의 함수
        }
    }
}
