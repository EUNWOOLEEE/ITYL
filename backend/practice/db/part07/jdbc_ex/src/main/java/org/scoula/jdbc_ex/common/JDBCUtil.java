package org.scoula.jdbc_ex.common;

import java.sql.Connection;
import java.util.Properties;

// 실무에서는 코드 직접 작성하지 않고 자동화함
public class JDBCUtil {
    // 드라이버 설정, DB 연결
    // Connection con 리턴
    static Connection conn = null;

    public static Connection getConnection() {
        if (conn != null) return conn;

        try {
            Properties props = new Properties();

        } catch(Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
