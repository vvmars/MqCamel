package com;

import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@org.springframework.context.annotation.Configuration
@PropertySource("classpath:application.properties")
public class Configuration {
    private static final Logger LOGGER = LoggerFactory.getLogger(Configuration.class);

    @Value("${DRIVER_CLASS_NAME}")
    private String driverClassName;
    @Value("${DB_URL}")
    private String dbUrl;
    @Value("${DB_CLOSE_DELAY}")
    private String DB_CLOSE_DELAY;
    @Value("${DB_USER_NAME}")
    private String dbUserName;
    @Value("${DB_USER_PASS}")
    private String dbUserPassword;

    @Bean
    public Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(dbUrl);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }
}
