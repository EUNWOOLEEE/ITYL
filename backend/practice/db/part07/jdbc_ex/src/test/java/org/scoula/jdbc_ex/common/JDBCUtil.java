package org.scoula.jdbc_ex.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCUtil {
    static Connection con = null;

    public static Connection getConnection() {
        if (con != null)
            return con;

        try {
            Properties props = new Properties();
            props.load(JDBCUtil.class.getResourceAsStream("/application.properties"));
            String driver = props.getProperty("driver");
            String url = props.getProperty("url");
            String id = props.getProperty("id");
            String password = props.getProperty("password");
            Class.forName(driver);
            con = DriverManager.getConnection(url, id, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    public static void close() {
        try {
            if (con != null) con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
