package com.dhg.spring.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dhg.spring.entities.Dept;

import feign.hystrix.FallbackFactory;
@Component//一定要加@Component注解
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

	@Override
	//服务降级熔断
	public DeptClientService create(Throwable throwable) {
		// TODO Auto-generated method stub
		return new DeptClientService() {
			
			@Override
			public Dept findById(Integer deptno) {
				Dept dept=new Dept();
				dept.setDeptno(deptno);
				dept.setDname("没有对应的信息");
				dept.setDb_source("no dataTable in Mysql");				
				return dept;
			}
			
			@Override
			public List<Dept> findAll() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean addDept(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

}
