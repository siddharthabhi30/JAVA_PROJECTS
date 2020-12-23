package com.example.Resilience5.LambdaBased;


import com.example.Resilience5.CircuitBreaker5;
import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.bulkhead.BulkheadRegistry;
import io.github.resilience4j.decorators.Decorators;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import io.vavr.CheckedFunction0;
import io.vavr.CheckedRunnable;
import io.vavr.control.Try;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeoutException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;
import java.util.function.Supplier;


@Service
public class Resilience {

    public static CircuitBreaker lendCircuit(){
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofMillis(500))

                .permittedNumberOfCallsInHalfOpenState(2)
                .slidingWindowSize(2)
                .recordExceptions(IOException.class, TimeoutException.class)
                .build();

        CircuitBreakerRegistry circuitBreakerRegistry =
                CircuitBreakerRegistry.of(circuitBreakerConfig);

        CircuitBreaker circuitBreaker = circuitBreakerRegistry
                .circuitBreaker("name",circuitBreakerConfig);

        return circuitBreaker;
    }

    public static Retry lendRetry(){
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(2)
                .waitDuration(Duration.ofMillis(1000))
                .build();

// Create a RetryRegistry with a custom global configuration
        RetryRegistry registry = RetryRegistry.of(config);

// Get or create a Retry from the registry -
// Retry will be backed by the default config
        Retry retryWithDefaultConfig = registry.retry("name1");
        return retryWithDefaultConfig;

    }

    public static Bulkhead lendBulk(){
        BulkheadConfig config = BulkheadConfig.custom()
                .maxConcurrentCalls(10)
                .maxWaitDuration(Duration.ofMillis(1))
                .build();

        // Create a BulkheadRegistry with a custom global configuration
        BulkheadRegistry bulkheadRegistry =
                BulkheadRegistry.of(config);

        Bulkhead bulkhead = bulkheadRegistry
                .bulkhead("name");

        return  bulkhead;
    }


    public  static RateLimiter lendrate(){
        RateLimiterConfig config = RateLimiterConfig.custom()
                .limitRefreshPeriod(Duration.ofSeconds(1))
                .limitForPeriod(10)
                .timeoutDuration(Duration.ofMillis(25))
                .build();

// Create registry
        RateLimiterRegistry rateLimiterRegistry = RateLimiterRegistry.of(config);

// Use registry
        io.github.resilience4j.ratelimiter.RateLimiter rateLimiterWithCustomConfig = (io.github.resilience4j.ratelimiter.RateLimiter) rateLimiterRegistry
                .rateLimiter("name2", config);
        return  rateLimiterWithCustomConfig;
    }

    static TimeLimiter lendTime(){
        TimeLimiter timeLimiter = TimeLimiter.of(Duration.ofSeconds(1));
        return timeLimiter;
    }



    public static String test1(){
        Supplier<String> supplier = CircuitBreaker5::print;
        //final int time=1000;
        //Supplier<String> suu=()->CircuitBreaker5.printNew(time);
        Supplier<String> decoratedSupplier = Decorators.ofSupplier(supplier)
                .withCircuitBreaker(lendCircuit())
                .withBulkhead(lendBulk())

                .withRetry(lendRetry())

                .decorate();

       // String result = Try.ofSupplier(decoratedSupplier)
         //       .recover(throwable -> "Hello from Recovery").get();

            String result2 = Try.ofSupplier(decoratedSupplier)
                    .recover(throwable -> "Hello from Recovery").get();

        System.out.println(result2);
        return  result2;




    }

    static void test5(){
//        Supplier<String> supplier = CircuitBreaker5::print;
//        CompletableFuture<String> future = Decorators.ofSupplier(supplier)
//                .wi

    }



    static void test3(){
        Supplier<String> supplier = CircuitBreaker5::print;
        //final int time=1000;
        //Supplier<String> suu=()->CircuitBreaker5.printNew(time);
        Supplier<String> decoratedSupplier = Decorators.ofSupplier(supplier)
               .withRateLimiter(lendrate())
                .decorate();

        // String result = Try.ofSupplier(decoratedSupplier)
        //       .recover(throwable -> "Hello from Recovery").get();

            String result2 = Try.ofSupplier(decoratedSupplier)
                    .recover(throwable -> "Hello from Recovery").get();
        System.out.println(result2);
    }





    //    static  void test4(){
//        // Decorate your call to BackendService.doSomething()
//        CheckedRunnable restrictedCall = RateLimiter
//                .decorateCheckedRunnable(lendrate(), CircuitBreaker5::print);
//
//        Try.run(restrictedCall)
//                .andThenTry(restrictedCall)
//                .onFailure((RequestNotPermitted throwable) -> System.out.println("Wait before call it again :)"));
//
//    }











    public static  void test2(){
        String ans=lendCircuit().executeSupplier(CircuitBreaker5::print);
        System.out.println(ans);
    }




    public static void main(String[] args) {
        //test2();
       test1();
        //test3();
    }

}
