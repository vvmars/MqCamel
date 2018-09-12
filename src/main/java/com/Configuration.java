package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@org.springframework.context.annotation.Configuration
//@Configuration
public class Configuration {
    private static final Logger LOGGER = LoggerFactory.getLogger(Configuration.class);

    @Value("${DRIVER_CLASS_NAME")
    private String driverClassName;
    @Value("${DB_URL}")
    private String dbUrl;
    @Value("DB_CLOSE_DELAY")
    private String DB_CLOSE_DELAY;
    @Value("DB_USER_NAME")
    private String dbUserName;
    @Value("DB_USER_PASS")
    private String dbUserPassword;
}
