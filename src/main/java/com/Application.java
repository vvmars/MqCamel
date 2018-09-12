package com;

//import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        //SpringApplicationBuilder springBuilder = new SpringApplicationBuilder(Application.class);
        //springBuilder.run(args);
        ApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);
        Connection con = context.getBean(Connection.class);

    }
}