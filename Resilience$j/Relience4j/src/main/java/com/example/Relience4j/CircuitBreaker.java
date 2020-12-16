package com.example.Relience4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
class CircuitBreaker2 {

    private static final String MAIN_SERVICE = "mainService";

    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/getSleuthTest")
    @ResponseStatus(HttpStatus.OK)
    @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker( name = MAIN_SERVICE, fallbackMethod="testFallBack")
    public ResponseEntity<String> getSleuthTest(){

        String response = restTemplate.getForObject("http://localhost:8081/serviceOne", String.class);
        return new ResponseEntity<String>(response, HttpStatus.OK);

    }

    @GetMapping("/welcome")
    public String ss(){
        return  "helo";
    }


    private  ResponseEntity<String> testFallBack(Exception e){
        return new ResponseEntity<String>("In fallback method", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/test")
    @CircuitBreaker(name = "testing1", fallbackMethod = "returnDefault")
    public  String test1(){
        return restTemplate.getForObject("gdsg",String.class);
    }

    public String retunrDefault(){
        return "reverted";
    }





}
