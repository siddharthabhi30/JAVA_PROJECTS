package com.example.Resilience5.Controllers;

import com.example.Resilience5.CircuitBreaker5;
import com.example.Resilience5.Services.Backend;
import com.example.Resilience5.Services.quoteServicew;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.decorators.Decorators;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.retry.Retry;
import io.vavr.control.Try;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Supplier;


@RestController
@RequestMapping(value = "/backendB")
public class BackendController {


    @Autowired
    private final CircuitBreaker circuitBreaker;

    private quoteServicew quoteservicew=new quoteServicew();


    private final ScheduledExecutorService scheduledExecutorService;

    Supplier<Integer> supplier;
    Supplier<java.lang.Integer> decoratedSupplier;


    @Autowired
   private final Retry retry;

    @Autowired
    private RateLimiter rateLimiter;

    public BackendController(CircuitBreaker circuitBreaker, Retry retry,RateLimiter rateLimiter) {

        this.circuitBreaker = circuitBreaker;
        this.retry = retry;
        this.scheduledExecutorService =  Executors.newScheduledThreadPool(3);
        this.supplier=quoteservicew::getQuote;
        this.rateLimiter=rateLimiter;
        this.decoratedSupplier=Decorators.ofSupplier(supplier)
                .withCircuitBreaker(this.circuitBreaker)
                .withRateLimiter(rateLimiter)
                .decorate();

    }

    @GetMapping("/failure")
    public void failure(){
         execute2();
    }
    private <Integer> void execute2(){
      Try.ofSupplier(decoratedSupplier).recover(quoteservicew::getQuoteFallback);
    }


}
