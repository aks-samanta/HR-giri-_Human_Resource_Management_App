package com.hrgiri.dao;

import java.util.List;

import com.hrgiri.exceptions.LeaveException;
import com.hrgiri.models.Leave;

public interface LeaveDAO {

	public String addLeavetoDB(Leave l, int noOfDays) throws LeaveException;
	
	public List<Leave> getPendingLeaveRequests() throws LeaveException;
	
	public List<Leave> getLeaveHistory(int empId) throws LeaveException;
	
	public Leave getLeaveRequestStatus(int empId) throws LeaveException;
	
	public String approveRejectLeaves(int lid, int choice) throws LeaveException;
}
