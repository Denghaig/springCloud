package com.dhg.springclound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulGateway_9257App {
	public static void main(String[] args) {
		SpringApplication.run(ZuulGateway_9257App.class, args);

	}

}
