package com.dhg.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dhg.spring.entities.Dept;

@Mapper
public interface DeptDao {
	public boolean addDept(Dept dept);
	
	public Dept findById(Integer deptno);

	public List<Dept> findAll();
}
