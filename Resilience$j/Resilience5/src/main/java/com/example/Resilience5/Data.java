package com.example.Resilience5;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.net.ConnectException;
import java.util.concurrent.TimeoutException;

@Service
public class Data {

    static void Slow() throws InterruptedException {
        Thread.sleep(4000);
    }

    @Retry(name = "ApplicationB")
    public  String give()   {
        try {
            Thread.sleep(5000);
            throw new java.util.concurrent.TimeoutException();
        } catch (InterruptedException | TimeoutException e) {
            e.printStackTrace();
        }
        RestTemplate rr=new RestTemplate();
        String ss= rr.getForObject("http://localhost:8083/ratingsdata/hello",String.class);
        return ss;
    }
    private String fallback(HttpServerErrorException ex) {
        return "Recovered HttpServerErrorException: " + ex.getMessage();
    }


    public static void main(String[] args) {
        Data data=new Data();
        System.out.println(data.give());

//        Thread t1=new Thread(()->data.give());
//        Thread t2=new Thread(()->data.give());
//        for (int i = 0; i < 100000; i++) {
//            t1.run();
//            t2.run();
//        }
    }


}
