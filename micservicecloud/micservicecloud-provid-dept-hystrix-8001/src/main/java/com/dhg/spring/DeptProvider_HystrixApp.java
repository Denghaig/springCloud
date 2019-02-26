package com.dhg.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//本服务注册到Eureka中
@EnableDiscoveryClient//服务发现的
@MapperScan(value="com.dhg.spring.dao.*.dao")
@EnableCircuitBreaker
//熔断机制的服务
public class DeptProvider_HystrixApp {

	public static void main(String[] args) {
		SpringApplication.run(DeptProvider_HystrixApp.class, args);

	}

}
