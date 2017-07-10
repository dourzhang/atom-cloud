package com.watent.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.sleuth.NoOpSpanAdjuster;
import org.springframework.cloud.sleuth.SpanAdjuster;
import org.springframework.cloud.sleuth.SpanReporter;
import org.springframework.cloud.sleuth.stream.SleuthSink;
import org.springframework.cloud.sleuth.stream.Spans;
import org.springframework.cloud.sleuth.zipkin.EndpointLocator;
import org.springframework.cloud.sleuth.zipkin.ZipkinSpanListener;
import org.springframework.cloud.sleuth.zipkin.ZipkinSpanReporter;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import zipkin.server.EnableZipkinServer;

import java.util.List;

/**
 * Zipkin Stream Application
 * <p>
 * Created by Atom on 2017/7/7.
 */
@EnableZipkinStreamServer
@MessageEndpoint
@SpringBootApplication
public class ZipkinStreamApplication {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(ZipkinStreamApplication.class, args);
    }

    @ServiceActivator(inputChannel = SleuthSink.INPUT)
    public void sink(Spans input) throws Exception {
        // ... process spans

        logger.info("*** serviceActivator:{} ***", input);
    }

    @Bean
    @ConditionalOnMissingBean
    public SpanAdjuster defaultSpanAdjuster() {

        return new NoOpSpanAdjuster();
    }

}
