package com.example.Resilience5;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class Resilience5Application {

	public static void main(String[] args) {
		SpringApplication.run(Resilience5Application.class, args);
	}


	@Bean
	public RestTemplate getRestTemplate() {

		return new RestTemplate();
	}

	@Bean
	public  CircuitBreaker getCirtcuitBreaker(){
		CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
				.failureRateThreshold(4)
				.waitDurationInOpenState(Duration.ofMillis(500))

				.minimumNumberOfCalls(5)
				.permittedNumberOfCallsInHalfOpenState(10)
				.slidingWindowSize(2)
				.automaticTransitionFromOpenToHalfOpenEnabled(true)
				.recordExceptions(IOException.class, TimeoutException.class)
				.build();

		CircuitBreakerRegistry circuitBreakerRegistry =
				CircuitBreakerRegistry.of(circuitBreakerConfig);

		CircuitBreaker circuitBreaker = circuitBreakerRegistry
				.circuitBreaker("name",circuitBreakerConfig);

		return circuitBreaker;
	}

	@Bean
	public static Retry retry(){
		RetryConfig config = RetryConfig.custom()
				.maxAttempts(3)
				.waitDuration(Duration.ofMillis(1000))
				.build();

// Create a RetryRegistry with a custom global configuration
		RetryRegistry registry = RetryRegistry.of(config);

// Get or create a Retry from the registry -
// Retry will be backed by the default config
		Retry retryWithDefaultConfig = registry.retry("name1");
		return retryWithDefaultConfig;

	}



}
