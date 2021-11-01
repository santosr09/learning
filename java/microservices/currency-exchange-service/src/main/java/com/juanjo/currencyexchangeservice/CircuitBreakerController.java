package com.juanjo.currencyexchangeservice;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {
	
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/failing-sample-api")
	//@Retry(name = "default")
	@Retry(name = "sample-api", fallbackMethod = "harcodedResponse")
	public String failingSampleApi() {
		logger.info("Sample API call received"); //The "retry" will be attemped 3 times by default, before the error
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8001/fake-api", String.class);
		
		return forEntity.getBody();
	}
	
	private String harcodedResponse(Exception ex) {
		return "fallback Hardcoded Response";
	
	}
	
	@GetMapping("/sample-api")
	public String sampleApi() {
		return "sample API";
	}
	
}
