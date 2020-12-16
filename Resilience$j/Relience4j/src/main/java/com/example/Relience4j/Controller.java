package com.example.Relience4j;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    @Autowired
    RestTemplate restTemplate;

    @CircuitBreaker(name = "someRemoteSvc", fallbackMethod = "remoteCallFail")
    @RequestMapping("/someRemoteSvc")
    public String someRemoteService() {
        return restTemplate.getForObject("http://localhost:8081/someRemoteSvc",String.class);
    }

    public String remoteCallFail(Exception e) {

        return "remote call failed";
    }

}