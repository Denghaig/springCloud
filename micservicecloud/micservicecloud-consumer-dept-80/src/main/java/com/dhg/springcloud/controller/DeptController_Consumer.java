package com.dhg.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dhg.spring.entities.Dept;

@RestController
public class DeptController_Consumer {
	 //private static final String REST_URL_PREFIX = "http://localhost:8001";
	private static final String REST_URL_PREFIX = "http://MICSERVICECLOUD-DEPT";
	@Autowired
	private RestTemplate restTemplate;

	// 使用restTemplate访问restful接口实简单粗暴的
	// restTemplate.postForObject(url, request, responseType)
	// 分别代表请求URL,请求参数，http响应转换被转换成的对象类型
	@RequestMapping(value = "/consumer/dept/add")
	public boolean add(Dept dept) {
		return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
	}

	@RequestMapping(value = "/consumer/get/{deptno}", method=RequestMethod.GET)
	@ResponseBody
	public Dept getdept(@PathVariable("deptno") Integer deptno) {
		System.out.println(REST_URL_PREFIX.toString());
		return restTemplate.getForObject(REST_URL_PREFIX +"/dept/get/" + deptno,Dept.class);

	}

	@RequestMapping(value = "/consumer/discoery")
	public Object discovery() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/detp/discovery", Object.class);
	}
}
