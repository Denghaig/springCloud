package com.dhg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import dd.dhg.rule.MyRule;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name="MICSERVICECLOUD-DEPT",configuration=MyRule.class)//自定义的轮训策略
public class DeptConsumer80_APP {
	public static void main(String[] args) {
	SpringApplication.run(DeptConsumer80_APP.class, args);

	}

}
