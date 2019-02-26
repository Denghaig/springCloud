package com.dhg.spring.controller;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dhg.spring.entities.Dept;
import com.dhg.spring.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController {
	@Autowired
	private DeptService deptService;
	@Autowired
	// 对外暴露服务接口的信息
	private DiscoveryClient client;

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean addDept(@RequestBody Dept dept) {
		return deptService.addDept(dept);
	}

	// 熔断机制
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	@RequestMapping(value = "/dept/get/{deptno}", method = RequestMethod.GET)
	public Dept findDept(@PathVariable("deptno") Integer deptno) {
		Dept dept = deptService.findById(deptno);
		if (dept == null) {
			throw new RuntimeException("该ID" + deptno + "不存在");
		}
		return deptService.findById(deptno);
	}

	public Dept processHystrix_Get(@PathVariable("deptno") Integer deptno ) {
		Dept dept=new Dept();
		dept.setDeptno(deptno);
		dept.setDname("该Id不存在");
		dept.setDb_source("no Datasource IN Mysql");
		return dept;

	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> findAll() {
		return deptService.findAll();

	}

	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery() {
		List<String> list = client.getServices();
		System.out.println("****" + list);
		List<ServiceInstance> serlist = client.getInstances("MICSERVICECLOUD-DEPT");
		for (ServiceInstance element : serlist) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getUri());

		}
		return this.client;
	}
}
