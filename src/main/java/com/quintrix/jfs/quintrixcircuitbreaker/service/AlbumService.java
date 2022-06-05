package com.quintrix.jfs.quintrixcircuitbreaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlbumService {

  @Autowired
  private CircuitBreakerFactory circuitBreakerFactory;

  @Autowired
  RestTemplate restTemplate;


  public String getAlbumList() {
    CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
    String url = "http://localhost:1234/not-real";

    return circuitBreaker.run(() -> restTemplate.getForObject(url, String.class),
        throwable -> getAlbumList());
  }

}

