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
 * Zipkin Server Application
 * <p>
 * Created by Atom on 2017/7/6.
 */
@RestController
@SpringBootApplication
public class ZipkinServerApplication {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApplication.class, args);
    }

    @Resource
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/test")
    public String callHome() {
        logger.info("hi calling zipkin-client  ");
        return restTemplate.getForObject("http://localhost:8080/up", String.class);
    }

    @RequestMapping("/ok")
    public String info() {
        logger.info("info is being called");
        return "Zipkin-server is ok ";

    }

    @Bean
    public AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }

}
