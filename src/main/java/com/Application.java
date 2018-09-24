package com;

//import org.springframework.boot.builder.SpringApplicationBuilder;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws Exception {
        //SpringApplicationBuilder springBuilder = new SpringApplicationBuilder(Application.class);
        //springBuilder.run(args);
        ApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);
        Connection con = context.getBean(Connection.class);
        CamelContext context1 = new DefaultCamelContext();
        context1.addRoutes(new DataRouter());
        context1.start();
        Thread.sleep(30000);
        context1.stop();

    }
}