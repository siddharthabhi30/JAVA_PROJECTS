package com.example.Resilience5;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.bulkhead.BulkheadRegistry;
import io.vavr.control.Try;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.function.Supplier;

public  class BulkHead1 {
    static void test1(){

        BulkheadConfig config = BulkheadConfig.custom()
                .maxConcurrentCalls(10)
                .maxWaitDuration(Duration.ofMillis(1))
                .build();

        // Create a BulkheadRegistry with a custom global configuration
        BulkheadRegistry bulkheadRegistry =
                BulkheadRegistry.of(config);

        Bulkhead bulkhead = bulkheadRegistry
                .bulkhead("name");

        Supplier<String> decoratedSupplier = Bulkhead
                .decorateSupplier(bulkhead, CircuitBreaker5::print);

        String result = Try.ofSupplier(decoratedSupplier)
                .recover(throwable -> "Hello from Recovery").get();

    }


    public static void main(String[] args) {

        RestTemplate restTemplate=new RestTemplate();

        for (int i = 0; i < 10000; i++) {

           String ans2=CircuitBreaker5.print();
            if(i>=8000){
                String ans=CircuitBreaker5.print2();
            }
        }
    }

}
