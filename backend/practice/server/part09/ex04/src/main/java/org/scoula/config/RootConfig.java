package org.scoula.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@PropertySource({"classpath:/application.properties"})
// 인터페이스에 해당하는 객체를 자동 생성하여 싱글톤으로 객체 생성함
// xml 파일이 있는 위치를 찾음
@MapperScan(basePackages = {"org.scoula.mapper"})
public class RootConfig {
    @Value("${jdbc.driver}") String driver;
    @Value("${jdbc.url}") String url;
    @Value("${jdbc.username}") String username;
    @Value("${jdbc.password}") String password;

    // HikariDBCP 싱글톤 만드는 함수 정의
    @Bean
    public DataSource dataSource() {
        // db연결 설정 -> DBCP
        // 10개의 연결을 기본으로 생성, 수는 설정 가능
        // 연결 설정 담당 클래스
        HikariConfig config = new HikariConfig();

        config.setDriverClassName(driver);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);

        // 설정한 연결 정보를 가지고 연결하여 dbcp를 생성한 클래스
        HikariDataSource dataSource = new HikariDataSource(config);
        // db 연결 10개를 만들어서 대기줄에 넣어둠
        return dataSource;
    }

    //db사용 --> google mybatis사용 설정
    //트랜잭션 설정

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setConfigLocation(applicationContext.getResource("classpath:/mybatis-config.xml"));
        sqlSessionFactory.setDataSource(dataSource());
        return (SqlSessionFactory) sqlSessionFactory.getObject();
    }
    @Bean
    public DataSourceTransactionManager transactionManager(){
        DataSourceTransactionManager manager = new DataSourceTransactionManager(dataSource());
        return manager;
    }
}
