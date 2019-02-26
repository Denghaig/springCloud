package com.dhg.spring.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dhg.spring.entities.Dept;

public interface DeptService {
	public boolean addDept(Dept dept);

	public Dept findById(Integer deptno);

	public List<Dept> findAll();
}
