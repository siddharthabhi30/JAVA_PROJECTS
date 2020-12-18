//package com.example.Resilience5;
//
//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
//import org.apache.catalina.User;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Mono;
//
//import java.util.concurrent.TimeoutException;
//@RestController
//@RequestMapping("/test1")
//public class CircuitBreak2 {
//
//
//    // With Fallback
//    @GetMapping("/fallback/users")
//    @CircuitBreaker(name = "user", fallbackMethod = "getUserFallback")
//    public Mono<ResponseEntity> getUserWithFallback() {
//// This will cause the exception and control will be transferred to fallback method.
//        return Mono.error(new TimeoutException("Timeout exception occurred."));
//    }
//
//    private Mono<ResponseEntity> getUserFallback() {
//// You can fetch the value from cache here when the service is down, if the
//// fallback method also cause any exception the circuit breaker will go in
//// open state accordingly after multiple failed requests(Please check
//// configurations for that).
//        return Mono.just(ResponseEntity.ok(User.builder().id("1").name("Deepak").build()));
//    }
//
//
//}
