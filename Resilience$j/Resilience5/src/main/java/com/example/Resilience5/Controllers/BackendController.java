package com.example.Resilience5.Controllers;

import com.example.Resilience5.CircuitBreaker5;
import com.example.Resilience5.Services.Backend;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.decorators.Decorators;
import io.github.resilience4j.retry.Retry;
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


   private final ScheduledExecutorService scheduledExecutorService;

   @Autowired
   private final Retry retry;
    public BackendController(CircuitBreaker circuitBreaker, Retry retry) {
        this.circuitBreaker = circuitBreaker;
        this.retry = retry;
        this.scheduledExecutorService =  Executors.newScheduledThreadPool(3);
    }

    @GetMapping("/failure")
    public String failure(){
        return execute(CircuitBreaker5::print);
    }

    private <T> T execute(Supplier<T> supplier){
        return Decorators.ofSupplier(supplier)
                .withCircuitBreaker(circuitBreaker)
                .withRetry(retry)
                .get();
    }

    @GetMapping("/loop")
    public void loop(){
        for (int i = 0; i < 100; i++) {
            failure();
        }
    }





}
