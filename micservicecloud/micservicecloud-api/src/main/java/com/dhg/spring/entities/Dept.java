package com.dhg.spring.entities;

import java.io.Serializable;

public class Dept implements Serializable {
	    /**
		 * 实现序列化 这个最重要
		 */
	private static final long serialVersionUID = 1L;
	private Integer deptno;
	private String dname;
	private String db_source;// 来自哪个数据库，应为微服务架构一个服务对应一个数据库，同有个信息储存到不同的数据库
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDb_source() {
		return db_source;
	}
	public void setDb_source(String db_source) {
		this.db_source = db_source;
	}
	public Dept(Integer deptno, String dname, String db_source) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.db_source = db_source;
	}
	public Dept() {
		super();
	}
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", db_source=" + db_source + "]";
	}

	

}
