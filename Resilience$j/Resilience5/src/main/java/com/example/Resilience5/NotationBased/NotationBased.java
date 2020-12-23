//package com.example.Resilience5.NotationBased;
//
//
//import io.github.resilience4j.retry.annotation.Retry;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Flux;
//
//@Component(value = "backendAService")
//public class NotationBased {
//    private static final String BACKEND_A = "bacxkendA";
//
////    @Autowired
////    WebClient webClient= WebClient.create("http://localhost:8081/test");
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//
//    @Retry(name = BACKEND_A)
//    public String fluxFailure() {
////        return webClient.get()
////                .uri("/greet")
////                .retrieve()
////                .bodyToFlux(String.class);
//        return restTemplate.getForObject("http://localhost:8081/test/greet", String.class);
//    }
//
//}
