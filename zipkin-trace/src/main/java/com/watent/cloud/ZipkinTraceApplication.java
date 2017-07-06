package com.watent.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * Zipkin Server Application
 * <p>
 * Created by Atom on 2017/7/6.
 */
@SpringBootApplication
@EnableZipkinServer
public class ZipkinTraceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinTraceApplication.class, args);
    }

}
