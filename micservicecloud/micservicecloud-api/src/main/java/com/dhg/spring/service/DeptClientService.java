package com.dhg.spring.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dhg.spring.entities.Dept;

@FeignClient(value = "MICSERVICECLOUD-DEPT", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
	@RequestMapping(value = "/dept/get/{deptno}", method = RequestMethod.GET)
	public Dept findById(@PathVariable("deptno") Integer deptno);

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> findAll();

	@RequestMapping(value = "/add/dept", method = RequestMethod.POST)
	public boolean addDept(Dept dept);
}
