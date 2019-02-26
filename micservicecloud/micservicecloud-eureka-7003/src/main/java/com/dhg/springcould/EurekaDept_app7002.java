package com.dhg.springcould;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDept_app7002 {

	public static void main(String[] args) {
		SpringApplication.run(EurekaDept_app7002.class, args);

	}

}
