package com.example.Resilience5.Services;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.decorators.Decorators;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
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

    public static void main(String[] args) throws InterruptedException {
        quoteServicew quoteServicew=new quoteServicew();

        List<String > products=List.of("one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen");

        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                //retry is also calculated as a call and will affect minNumberOfCalls
                .slidingWindow(10,5, CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                .automaticTransitionFromOpenToHalfOpenEnabled(true)
                .failureRateThreshold(50)
                .permittedNumberOfCallsInHalfOpenState(4)
                .waitDurationInOpenState(Duration.ofSeconds(1))
                .build();



        CircuitBreakerRegistry registry = CircuitBreakerRegistry.custom()
                .withCircuitBreakerConfig(config).build();

        CircuitBreaker circuitBreaker=registry.circuitBreaker("myCustom");


        RetryConfig config2 = RetryConfig.custom()
                .maxAttempts(2)
                .waitDuration(Duration.ofMillis(1000))
                .build();

// Create a RetryRegistry with a custom global configuration
        RetryRegistry registry2 = RetryRegistry.of(config2);

// Get or create a Retry from the registry -
// Retry will be backed by the default config
        Retry retryWithDefaultConfig = registry2.retry("name1");






       // Supplier<Integer> sp= CircuitBreaker.decorateSupplier(circuitBreaker,quoteServicew::getQuote);
        Supplier<Integer> decoratedSupplier = Decorators.ofSupplier(quoteServicew::getQuote)
                .withCircuitBreaker(circuitBreaker)

               .decorate();


        // String result = Try.ofSupplier(decoratedSupplier)
        //       .recover(throwable -> "Hello from Recovery").get();


//        quoteServicew.setProductName(product);
//        Try.ofSupplier(sp).recover(quoteServicew::getQuoteFallback);

        for(String product:products){
            System.out.println(product);
            if (product.equalsIgnoreCase("six")){
                Thread.sleep(4000);
            }
            Try.ofSupplier(decoratedSupplier)
                    .recover(quoteServicew::getQuoteFallback).get();
          gap();
        }


//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        quoteServicew.setProductName("soap");
//        gap();
//        Try.ofSupplier(decoratedSupplier)
//                .recover(quoteServicew::getQuoteFallback).get();
//
//    gap();
//        Try.ofSupplier(decoratedSupplier)
//                .recover(quoteServicew::getQuoteFallback).get();
//
//    gap();
//        Try.ofSupplier(decoratedSupplier)
//                .recover(quoteServicew::getQuoteFallback).get();
//

    }
}
