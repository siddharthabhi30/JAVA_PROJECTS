package com.example.Resilience5.Services;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.function.Supplier;

@Component
public class Backend {

    public static void main(String[] args) {
        Backend bck=new Backend();
      int we=434;
        Supplier<String> sp=()->{
            return bck.test(we);
        };

    }
    private  String test(int n){
        return  "aa";
    }

    @Autowired
    private RestTemplate restTemplate;


    public static String testFunc() {

        throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "This is a remote exception");
    }

    public static  int recovery(Throwable t){

        System.out.println("from fallback");
        return 99;
    }
}
