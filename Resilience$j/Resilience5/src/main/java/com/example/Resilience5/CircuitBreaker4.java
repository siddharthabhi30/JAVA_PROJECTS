package com.example.Resilience5;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;
@RestController
@RequestMapping("/fourth")
public class CircuitBreaker4 {



    private void randomlyRunLong() throws TimeoutException {
        Random rand = new Random();
        int randomNum = rand.nextInt((3 - 1) + 1) + 1;
        sleep();
    }
    private void sleep() throws TimeoutException {
        try {
            Thread.sleep(5000);
            throw new java.util.concurrent.TimeoutException();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @GetMapping(path = "/test")
    @CircuitBreaker(name = "licenseService")
    public List<String> getLicensesByOrganization(String organizationId) throws TimeoutException {
        randomlyRunLong();
        return Arrays.asList("a","b");
    }

}
