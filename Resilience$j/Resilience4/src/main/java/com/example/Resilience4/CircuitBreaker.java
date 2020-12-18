package com.example.Resilience4;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.ConfigBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;

interface RemoteService {
    int process(int i);
}

public class CircuitBreaker {

    public static void main(String[] args) {

        DemoControllerService ddm=new DemoControllerService(new RestTemplate(), new CircuitBreakerFactory() {
            @Override
            protected ConfigBuilder configBuilder(String id) {
                return null;
            }

            @Override
            public void configureDefault(Function defaultConfiguration) {

            }

            @Override
            public org.springframework.cloud.client.circuitbreaker.CircuitBreaker create(String id) {
                return null;
            }
        });
        ddm.slow();


    }

}



@Service
  class DemoControllerService {
    private RestTemplate rest;
    private CircuitBreakerFactory cbFactory;

    public DemoControllerService(RestTemplate rest, CircuitBreakerFactory cbFactory) {
        this.rest = rest;
        this.cbFactory = cbFactory;
    }

    public String slow() {
        return cbFactory.create("slow").run(() -> rest.getForObject("/slow", String.class), throwable -> "fallback");
    }

}
