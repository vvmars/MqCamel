package com;

import com.Utils.Db;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.camel.builder.RouteBuilder;

@Component
public class DataRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
//        from("QUEUE" + "?concurrentConsumers=" + "CONSUMER_THREADS")
//                .log("Start: correlation_id=${header.MCP_CORRELATION_ID}, action=validate1000")
//                .setHeader("INCOMING_QUEUE", constant("1000_0409")).to("direct:process-validation");
        from("file:data/in?noop=true&autoCreate=false")
                .routeId("moveFiles")
                .log("@@@test@@@")
                .convertBodyTo(String.class)
                .to("file:data/out?autoCreate=false")
                .to("direct: DB");
        from("direct: DB")
                .routeId("initDB")
                .log("*** DB init ***")
                .bean(Db.class, "init")
                .to("direct: checkDbInit");
        from("direct: checkDbInit")
                .routeId("checkDbInit")
                .log("--- db ---")
                .bean(Db.class, "getCountRows")
                .to("log: reply");
    }
}
