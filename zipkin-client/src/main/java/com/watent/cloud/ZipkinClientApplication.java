package com.watent.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Zipkin Client Application
 * <p>
 * Created by Atom on 2017/7/6.
 */
@SpringBootApplication
@RestController
public class ZipkinClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinClientApplication.class, args);
    }

    private static final Logger logger = LoggerFactory.getLogger(ZipkinClientApplication.class);

    @RequestMapping("/up")
    public String home() {
        logger.info("up is being called");
        return "zipkin-client is up!";
    }

    @RequestMapping("/hello")
    public String info() {
        logger.info("hello calling trace zipkin-server ");
        return restTemplate.getForObject("http://localhost:9060/ok", String.class);
    }

    @Resource
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }

}
