//package com.example.Resilience5;
//
//import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
//import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
//import org.springframework.cloud.client.circuitbreaker.ConfigBuilder;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.function.Function;
//
//@Service
//public  class DemoControllerService {
//	private RestTemplate rest;
//	private CircuitBreakerFactory cbFactory;
//
//	public DemoControllerService(RestTemplate rest, CircuitBreakerFactory cbFactory) {
//		this.rest = rest;
//		this.cbFactory = cbFactory;
//	}
//
//	public String slow() {
//		return cbFactory.create("slow").run(() -> rest.getForObject("/slow", String.class), throwable -> "fallback");
//	}
//
//
//
//}