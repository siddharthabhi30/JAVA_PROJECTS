package com.example.Resilience5.Controllers;

import com.example.Resilience5.CircuitBreaker.Breaker1;
import com.example.Resilience5.CircuitBreaker.Breaker2;
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
    @Autowired
    private final CircuitBreaker circuitBreaker2;

    private quoteServicew quoteservicew=new quoteServicew();

    @Autowired
    private Breaker1 breaker1;

    @Autowired
    private Breaker2 breaker2;




    //we had to define a static circuit breaker ....as importing from other service's function was resetting it
    private CircuitBreaker circuitBreaker3=Breaker1.give();

    private final ScheduledExecutorService scheduledExecutorService;

    Supplier<Integer> supplier;
    Supplier<java.lang.Integer> decoratedSupplier;


    @Autowired
   private final Retry retry;

    @Autowired
    private RateLimiter rateLimiter;

    public BackendController(CircuitBreaker circuitBreaker, CircuitBreaker circuitBreaker2, Retry retry, RateLimiter rateLimiter) {

        this.circuitBreaker = circuitBreaker;
        this.circuitBreaker2 = circuitBreaker2;
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

    @GetMapping("/failure2")
    public void failure2(){
      Supplier<Integer>  supplier2=quoteservicew::getQuote;

     Supplier<Integer>   decoratedSupplier2=Decorators.ofSupplier(supplier)
                .withCircuitBreaker(this.circuitBreaker)
                .withRateLimiter(rateLimiter)
                .decorate();
        Try.ofSupplier(decoratedSupplier2).recover(quoteservicew::getQuoteFallback);

    }


    @GetMapping("/failure3")
    public void failure3(){
        Supplier<Integer>  supplier2=quoteservicew::getQuote;

        Supplier<Integer>   decoratedSupplier2=Decorators.ofSupplier(supplier)
                .withCircuitBreaker(circuitBreaker3)

                .decorate();
        Try.ofSupplier(decoratedSupplier2).recover(quoteservicew::getQuoteFallback);

    }


//another way of making different circuit breakers
    @GetMapping("/failure4")
    public void failure4(){
        Supplier<Integer>  supplier2=quoteservicew::getQuote;

        Supplier<Integer>   decoratedSupplier2=Decorators.ofSupplier(supplier)
                .withCircuitBreaker(breaker2.getCircuitBreaker())

                .decorate();
        Try.ofSupplier(decoratedSupplier2).recover(quoteservicew::getQuoteFallback);

    }


    @GetMapping("/single")
    public int failure5(){
       return breaker1.test;

    }



}
