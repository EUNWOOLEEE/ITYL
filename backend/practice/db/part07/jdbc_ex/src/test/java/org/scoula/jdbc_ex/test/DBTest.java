package org.scoula.jdbc_ex.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DBTest {
    // 메서드 단위 테스트

    @Test
    @DisplayName("DB 연결 테스트 결과")
    public void test1() throws ClassNotFoundException, SQLException {
        Connection con = null;

        // 1. 드라이버설정
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("1. 드라이버설정성공..");

        // 2. 데이터베이스연결
        String url = "jdbc:mysql://localhost:3306/jdbc_ex";
        String user = "scoula";
        String password = "1234";
        con = DriverManager.getConnection(url, user, password);
        System.out.println("2. db연결성공.");

        Assertions.assertNull(con);
    }
}
