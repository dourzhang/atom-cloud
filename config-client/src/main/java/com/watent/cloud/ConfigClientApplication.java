package com.watent.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Config Client Application
 * <p>
 * Created by Atom on 2017/7/1.
 */
@SpringBootApplication
@RestController
public class ConfigClientApplication {

    @Value("${atom.name}")
    private String name;

    @Value("${atom.config}")
    private String config;

    @ResponseBody
    @RequestMapping("/")
    public Map<String, String> home() {

        Map<String, String> map = new HashMap<>();
        map.put("result", "success");
        map.put("code", "200");
        map.put("data", name + " , " + config);

        return map;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}
