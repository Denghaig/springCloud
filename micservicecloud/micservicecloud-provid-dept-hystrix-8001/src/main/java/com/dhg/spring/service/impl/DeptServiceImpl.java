package com.dhg.spring.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.dhg.spring.dao.DeptDao;
import com.dhg.spring.entities.Dept;
import com.dhg.spring.service.DeptService;

@Service("DeptService")
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao deptDao;

	@Override
	public boolean addDept(Dept dept) {
		// TODO Auto-generated method stub
		return deptDao.addDept(dept);
	}

	@Override
	public List<Dept> findAll() {
		// TODO Auto-generated method stub
		return deptDao.findAll();
	}

	@Override
	public Dept findById(Integer deptno) {
		// TODO Auto-generated method stub
		return deptDao.findById(deptno);
	}

}
