package com.example.Resilience5.Services;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.decorators.Decorators;
import io.vavr.control.Try;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.function.Supplier;

public class YtExample {

    static void gap(){
        System.out.println("                ");
        System.out.println("                ");
        System.out.println("                ");System.out.println("                ");
        System.out.println("                ");
    }

    public static void main(String[] args) {
        quoteServicew quoteServicew=new quoteServicew();

        List<String > products=List.of("soap","ffs","dd","gfd","as","as","soap");

        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .slidingWindow(10,5, CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                .automaticTransitionFromOpenToHalfOpenEnabled(true)
                .failureRateThreshold(50)
                .permittedNumberOfCallsInHalfOpenState(3)
                .waitDurationInOpenState(Duration.ofSeconds(30))
                .build();

        CircuitBreakerRegistry registry = CircuitBreakerRegistry.custom()
                .withCircuitBreakerConfig(config).build();

        CircuitBreaker circuitBreaker=registry.circuitBreaker("myCustom");

       // Supplier<Integer> sp= CircuitBreaker.decorateSupplier(circuitBreaker,quoteServicew::getQuote);
        Supplier<Integer> decoratedSupplier = Decorators.ofSupplier(quoteServicew::getQuote)
                .withCircuitBreaker(circuitBreaker)
               .decorate();


        // String result = Try.ofSupplier(decoratedSupplier)
        //       .recover(throwable -> "Hello from Recovery").get();


//        quoteServicew.setProductName(product);
//        Try.ofSupplier(sp).recover(quoteServicew::getQuoteFallback);

        for(String product:products){
            Try.ofSupplier(decoratedSupplier)
                    .recover(quoteServicew::getQuoteFallback).get();
          gap();
        }


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        quoteServicew.setProductName("soap");
        Try.ofSupplier(decoratedSupplier)
                .recover(quoteServicew::getQuoteFallback).get();

    gap();
        Try.ofSupplier(decoratedSupplier)
                .recover(quoteServicew::getQuoteFallback).get();

    gap();
        Try.ofSupplier(decoratedSupplier)
                .recover(quoteServicew::getQuoteFallback).get();


    }
}
