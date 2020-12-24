package com.example.Resilience5.CircuitBreaker;


import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class Breaker1 {

    public int test=11;


    private CircuitBreaker circuitBreaker;


    public static io.github.resilience4j.circuitbreaker.CircuitBreaker give(){
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .slidingWindow(10,5, CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                .automaticTransitionFromOpenToHalfOpenEnabled(true)
                .failureRateThreshold(50)
                .permittedNumberOfCallsInHalfOpenState(4)
                .waitDurationInOpenState(Duration.ofSeconds(30))
                .build();



        CircuitBreakerRegistry circuitBreakerRegistry =
                CircuitBreakerRegistry.of(circuitBreakerConfig);
io.github.resilience4j.circuitbreaker.CircuitBreaker circuitBreaker = (io.github.resilience4j.circuitbreaker.CircuitBreaker) circuitBreakerRegistry
                .circuitBreaker("name",circuitBreakerConfig);

        return  circuitBreaker;
    }


}
