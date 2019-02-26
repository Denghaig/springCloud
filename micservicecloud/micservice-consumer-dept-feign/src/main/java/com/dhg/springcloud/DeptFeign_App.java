package com.dhg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.dhg.spring","com.dhg.springcloud"})
@ComponentScan(value= {"com.dhg.spring","com.dhg.springcloud"})
public class DeptFeign_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptFeign_App.class, args);

	}

}
