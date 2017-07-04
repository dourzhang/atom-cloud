package com.watent.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Zuul Client Application
 * <p>
 * Created by Atom on 2017/7/4.
 */
@RestController
@SpringBootApplication
public class ZuulClientApplication {

    @RequestMapping(value = "/available")
    public String available() {
        return "Spring in Action";
    }

    @RequestMapping(value = "/checked-out")
    public String checkedOut() {
        return "Spring Boot in Action";
    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulClientApplication.class, args);
    }
}
