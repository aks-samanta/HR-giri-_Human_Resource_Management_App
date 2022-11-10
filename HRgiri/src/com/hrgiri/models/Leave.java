package com.hrgiri.models;

import java.sql.Date;

public class Leave {

	private int lid;
	private int empId;
	private String empName;
	private int deptId;
	private Date startDate;
	private Date enDate;
	private String reason;
	private String status;
	private int leavesLeft;
	
	public Leave() {
		// TODO Auto-generated constructor stub
	}
	
	public Leave(int empId, String empName, int deptId, Date startDate, Date enDate, String reason) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.deptId = deptId;
		this.startDate = startDate;
		this.enDate = enDate;
		this.reason = reason;
	}

	public Leave(int lid, int empId, String empName, int deptId, Date startDate, Date enDate, String reason,
			String status) {
		super();
		this.lid = lid;
		this.empId = empId;
		this.empName = empName;
		this.deptId = deptId;
		this.startDate = startDate;
		this.enDate = enDate;
		this.reason = reason;
		this.status = status;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEnDate() {
		return enDate;
	}

	public void setEnDate(Date enDate) {
		this.enDate = enDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Leave [lid=" + lid + ", empId=" + empId + ", empName=" + empName + ", deptId=" + deptId + ", startDate="
				+ startDate + ", enDate=" + enDate + ", reason=" + reason + ", status=" + status + "]";
	}

	public int getLeavesLeft() {
		return leavesLeft;
	}

	public void setLeavesLeft(int leavesLeft) {
		this.leavesLeft = leavesLeft;
	}
	
	
}
