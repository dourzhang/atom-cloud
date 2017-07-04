package com.watent.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Ribbon Client Application
 * <p>
 * Created by Atom on 2017/7/4.
 */
@RestController
@SpringBootApplication
@RibbonClient(name = "ribbon-server", configuration = ClientConfiguration.class)
public class RibbonClientApplication {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String hi(@RequestParam(value = "name", defaultValue = "Artaban") String name) {
        String greeting = this.restTemplate.getForObject("http://ribbon-server/greeting", String.class);
        return String.format("%s, %s!", greeting, name);
    }

    public static void main(String[] args) {
        SpringApplication.run(RibbonClientApplication.class, args);
    }


}
