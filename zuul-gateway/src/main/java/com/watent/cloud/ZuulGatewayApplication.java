package com.watent.cloud;

import com.watent.cloud.filter.SimpleFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Zuul Gateway Controller
 * Annotation EnableZuulProxy
 * This will turn the Gateway application into a reverse proxy that forwards relevant calls to other services
 * <p>
 * Created by Atom on 2017/7/4.
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class, args);
    }

    @Bean
    public SimpleFilter simpleFilter() {
        return new SimpleFilter();
    }
}
