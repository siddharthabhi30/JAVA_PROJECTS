package com.example.Resilience5;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import reactor.core.publisher.Mono;

public class CircuitBReaker3 {
    @CircuitBreaker(name = "backend", fallbackMethod = "fallback")
    @RateLimiter(name = "backend")
    @Bulkhead(name = "backend")
    @Retry(name = "backend", fallbackMethod = "fallback")
    @TimeLimiter(name = "backend")
    public Mono<String> method(String param1) {
        System.out.println("not fall back");
        int a=10/0;
        return Mono.error(new NumberFormatException());
    }

    private Mono<String> fallback(String param1, IllegalArgumentException e) {
        System.out.println("fallback  ");
        return Mono.just("test");
    }

    private Mono<String> fallback(String param1, RuntimeException e) {
        return Mono.just("test");
    }
    private Mono<String> fallback(String param1, ArithmeticException e) {
        System.out.println("fallback 3");
        return Mono.just("test");
    }

    public static void main(String[] args) {
        CircuitBReaker3 circuitBReaker3=new CircuitBReaker3();
        circuitBReaker3.method("one");
    }
}
