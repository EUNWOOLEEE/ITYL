package org.scoula.config;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RootConfig.class)
class RootConfigTest {

    // 주입하는 3가지 방법 중 필드 위에 어노테이션 이용하는 방법
    @Autowired
    private DataSource dataSource;

    @Test
    @DisplayName("hikariDBCP 연결 정보 확인")
    void dataSource() throws SQLException {
        try (Connection con = dataSource.getConnection()) {
            log.info("dbcp로부터 연결 하나 가져옴");
            log.info(con);
        }
    }
}