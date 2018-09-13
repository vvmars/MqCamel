package com;

import org.springframework.stereotype.Component;
import org.apache.camel.builder.RouteBuilder;

@Component
public class DataRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("QUEUE" + "?concurrentConsumers=" + "CONSUMER_THREADS")
            .log("Start: correlation_id=${header.MCP_CORRELATION_ID}, action=validate1000")
            .setHeader("INCOMING_QUEUE", constant("1000_0409")).to("direct:process-validation");

}
