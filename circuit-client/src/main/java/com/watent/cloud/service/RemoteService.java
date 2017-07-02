package com.watent.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class RemoteService {

  private final RestTemplate restTemplate;

  public RemoteService(RestTemplate rest) {
    this.restTemplate = rest;
  }

  @HystrixCommand(fallbackMethod = "reliable")
  public String visit() {
    URI uri = URI.create("http://localhost:8090/provide");

    return this.restTemplate.getForObject(uri, String.class);
  }

  public String reliable() {
    return "circuit-client native";
  }

}