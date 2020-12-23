package com.example.Resilience5.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class Backend {
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
