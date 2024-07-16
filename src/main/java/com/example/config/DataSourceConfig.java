package com.example.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class DataSourceConfig {
    @Bean
    public Connection hikariPostgresConnection() throws SQLException {
        HikariConfig config = new HikariConfig("src/main/resources/hikari.properties");
        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource.getConnection();
    }
}
