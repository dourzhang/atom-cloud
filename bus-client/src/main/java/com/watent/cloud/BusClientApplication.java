package com.watent.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Bus Client Application
 * <p>
 * Created by Atom on 2017/7/5.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class BusClientApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(BusClientApplication.class).web(true).run(args);
    }
}
