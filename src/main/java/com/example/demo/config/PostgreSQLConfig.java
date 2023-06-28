package com.example.demo.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;


@Component
public class PostgreSQLConfig implements ApplicationRunner {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public PostgreSQLConfig(DataSource dataSource,
                            JdbcTemplate jdbcTemplate){
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        try (Connection connection = dataSource.getConnection()){
            pln("successfully connected!");
            pln("dataSource Class: " + dataSource.getClass());
            pln("URL: " + connection.getMetaData().getURL());
            pln("userName: " + connection.getMetaData().getUserName());
        }

    }

    void pln(String str){
        System.out.println(str);
    }
    void p(String str){
        System.out.print(str);
    }
}
