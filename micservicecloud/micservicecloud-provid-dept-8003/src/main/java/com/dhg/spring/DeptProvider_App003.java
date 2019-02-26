package com.dhg.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//本服务注册到Eureka中
@EnableDiscoveryClient//服务发现的
@MapperScan(value="com.dhg.spring.dao.*.dao")
public class DeptProvider_App003 {

	public static void main(String[] args) {
		SpringApplication.run(DeptProvider_App003.class, args);

	}

}
