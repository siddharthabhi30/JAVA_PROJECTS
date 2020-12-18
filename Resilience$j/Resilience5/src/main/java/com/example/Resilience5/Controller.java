package com.example.Resilience5;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;


@RestController
public class Controller {

    @Autowired
    Data data;

    @GetMapping(path = "test")
    public String test() throws TimeoutException {
        System.out.println("taking from it");
       return  data.give();

    }
}
