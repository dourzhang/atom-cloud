package com.watent.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Config Client Application
 * <p>
 * Created by Atom on 2017/7/1.
 */
@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class CircuitServerApplication {

    @RequestMapping(value = "/provide")
    public String provide(){
        return "CircuitServerApplication";
    }

    public static void main(String[] args) {
        SpringApplication.run(CircuitServerApplication.class, args);
    }
}
