package com.watent.cloud;

import com.watent.cloud.service.RemoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableCircuitBreaker
@RestController
@SpringBootApplication
public class CircuitClientApplication {

    @Resource
    private RemoteService bookService;

    @Bean
    public RestTemplate rest(RestTemplateBuilder builder) {
        return builder.build();
    }

    @RequestMapping("/to-visit")
    public String toRead() {
        return bookService.visit();
    }

    public static void main(String[] args) {
        SpringApplication.run(CircuitClientApplication.class, args);
    }
}