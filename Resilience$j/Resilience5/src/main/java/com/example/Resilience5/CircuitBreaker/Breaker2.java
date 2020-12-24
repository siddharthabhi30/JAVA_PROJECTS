package com.example.Resilience5.CircuitBreaker;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.stereotype.Service;

import java.time.Duration;
@Service
public class Breaker2 {

    private io.github.resilience4j.circuitbreaker.CircuitBreaker circuitBreaker;
    public Breaker2(){
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .slidingWindow(10,5, CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                .automaticTransitionFromOpenToHalfOpenEnabled(true)
                .failureRateThreshold(50)
                .permittedNumberOfCallsInHalfOpenState(4)
                .waitDurationInOpenState(Duration.ofSeconds(4))
                .build();




        CircuitBreakerRegistry circuitBreakerRegistry =
                CircuitBreakerRegistry.of(circuitBreakerConfig);
        circuitBreaker = (io.github.resilience4j.circuitbreaker.CircuitBreaker) circuitBreakerRegistry
                .circuitBreaker("name3",circuitBreakerConfig);



    }

    public CircuitBreaker getCircuitBreaker() {
        return (io.github.resilience4j.circuitbreaker.CircuitBreaker) circuitBreaker;
    }
}
