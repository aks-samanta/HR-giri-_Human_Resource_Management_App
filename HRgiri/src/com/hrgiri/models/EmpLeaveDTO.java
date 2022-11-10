package com.hrgiri.models;

import java.sql.Date;

public class EmpLeaveDTO {

	private int empId;
	private int leaveId;
	private String empName;
	private int deptId;
	private String deptName;
	private int leavesLeft;
	private Date startDate;
	private Date enDate;
	private String reason;
	private String status;
	
	public EmpLeaveDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public EmpLeaveDTO(int empId, int leaveId) {
		super();
		this.empId = empId;
		this.leaveId = leaveId;
	}

	public EmpLeaveDTO(int empId, int leaveId, String empName, int deptId, String deptName, int leavesLeft,
			Date startDate, Date enDate, String reason, String status) {
		super();
		this.empId = empId;
		this.leaveId = leaveId;
		this.empName = empName;
		this.deptId = deptId;
		this.deptName = deptName;
		this.leavesLeft = leavesLeft;
		this.startDate = startDate;
		this.enDate = enDate;
		this.reason = reason;
		this.status = status;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
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

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getLeavesLeft() {
		return leavesLeft;
	}

	public void setLeavesLeft(int leavesLeft) {
		this.leavesLeft = leavesLeft;
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
		return "EmpLeaveDTO [empId=" + empId + ", leaveId=" + leaveId + ", empName=" + empName + ", deptId=" + deptId
				+ ", deptName=" + deptName + ", leavesLeft=" + leavesLeft + ", startDate=" + startDate + ", enDate="
				+ enDate + ", reason=" + reason + ", status=" + status + "]";
	}
	
	

}
