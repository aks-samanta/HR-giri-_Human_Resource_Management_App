package com.hrgiri.models;

public class EmpDeptDTO {

	private int eid;
	private String ename;
	private int deptId;
	private String email;
	private int salary;
	private String address;
	private String deptHeadName;
	private String didName;
	
	public EmpDeptDTO() {
		// TODO Auto-generated constructor stub
	}

	public EmpDeptDTO(int eid, String ename, int deptId, String email, int salary, String address, String didName, String dHeadName) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.deptId = deptId;
		this.email = email;
		this.salary = salary;
		this.address = address;
		this.didName = didName;
		this.setDeptHeadName(dHeadName);
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDidName() {
		return didName;
	}

	public void setDidName(String didName) {
		this.didName = didName;
	}

	@Override
	public String toString() {
		return "EmpDeptDTO [eid=" + eid + ", ename=" + ename + ", deptId=" + deptId + ", email=" + email + ", salary="
				+ salary + ", address=" + address + ", didName=" + didName + "]";
	}

	public String getDeptHeadName() {
		return deptHeadName;
	}

	public void setDeptHeadName(String deptHeadName) {
		this.deptHeadName = deptHeadName;
	}


	
	
}
