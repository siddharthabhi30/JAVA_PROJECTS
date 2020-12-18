package com.example.Resilience5;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ciurcuitBreaker2 {

    @Retry(name = "retryService", fallbackMethod = "retryfallback")
    public String registerUser() throws InterruptedException {
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject("http://localhost:8083/ratingsdata/hello", String.class);

    }

    public String retryfallback( Throwable t) {
        System.out.println("inside fallback");
        return "Inside retryfallback method. Some error occurred while calling service for user registration";
    }

    public static void main(String[] args) throws InterruptedException {
        ciurcuitBreaker2 ciurcuitBreaker2=new ciurcuitBreaker2();
        System.out.println(ciurcuitBreaker2.registerUser());
    }

    @RequestMapping("test19")
    public  void test() throws InterruptedException {
        ciurcuitBreaker2 ciurcuitBreaker2=new ciurcuitBreaker2();
        System.out.println(ciurcuitBreaker2.registerUser());

    }

}
