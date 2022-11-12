package com.hrgiri.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hrgiri.exceptions.LeaveException;
import com.hrgiri.models.Leave;
import com.hrgiri.utility.DButil;

public class LeaveDAOImpl implements LeaveDAO {

	@Override
	public String addLeavetoDB(Leave l, int noOfDays) throws LeaveException {
		String message = "Leave NOT Applied";

		try (Connection conn = DButil.provideConnection()) {
			PreparedStatement ps1 = conn.prepareStatement("select * from employee where  eid = ?");
			ps1.setInt(1, l.getEmpId());

			ResultSet rs = ps1.executeQuery();

			if (rs.next() && rs.getInt("Leaves_left") < noOfDays) {
				throw new LeaveException(
						"You Don't have Enough Leaves left, Please reduce number of Days then try again.");
			} else {
				PreparedStatement ps2 = conn.prepareStatement(
						"insert into Leave_table (empId, empName, deptId, startDate, endDate, reason) values (?,?,?,?,?,?)");
				ps2.setInt(1, l.getEmpId());
				ps2.setString(2, l.getEmpName());
				ps2.setInt(3, l.getDeptId());
				ps2.setString(4, l.getStartDate());
				ps2.setString(5, l.getEnDate());
				ps2.setString(6, l.getReason());

				int n = ps2.executeUpdate();

				if (n > 0) {
					message = "Leave Applied Successfully! ";
					PreparedStatement ps3 = conn
							.prepareStatement("update employee set Leaves_left = (Leaves_left-?) where eid = ?");

					ps3.setInt(1, noOfDays);
					ps3.setInt(2, l.getEmpId());

					int m = ps3.executeUpdate();
					if (m > 0) {
						message = "Leave Applied and remaining leaves updated Successfully!";
					} else {
						message = "Leave Applied Successfully! but could not update remaining leaves";
					}
				} else {
					throw new LeaveException("Reason Too long");
				}

			}
		} catch (SQLException e) {
			throw new LeaveException(e.getMessage());
		}

		return message;
	}

	@Override
	public List<Leave> getPendingLeaveRequests() throws LeaveException {
		List<Leave> leaveList = new ArrayList<>();

		try (Connection conn = DButil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from Leave_table where status = 'Pending'");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Leave leave = new Leave(rs.getInt("lid"), rs.getInt("empId"), rs.getString("empName"),
						rs.getInt("deptId"), rs.getString("startDate"), rs.getString("endDate"), rs.getString("reason"),
						rs.getString("status"));
				leaveList.add(leave);
			}

		} catch (SQLException e) {
			throw new LeaveException(e.getMessage());
		}

		return leaveList;
	}

	@Override
	public List<Leave> getLeaveHistory(int empId) throws LeaveException {
		List<Leave> leaveList = new ArrayList<>();

		try (Connection conn = DButil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from Leave_table where empId = ?");
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Leave leave = new Leave(rs.getInt("lid"), rs.getInt("empId"), rs.getString("empName"),
						rs.getInt("deptId"), rs.getString("startDate"), rs.getString("endDate"), rs.getString("reason"),
						rs.getString("status"));
				leaveList.add(leave);
			}

		} catch (SQLException e) {
			throw new LeaveException(e.getMessage());
		}

		return leaveList;
	}

	@Override
	public Leave getLeaveRequestStatus(int empId) throws LeaveException {
		Leave leave = null;

		try (Connection conn = DButil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from Leave_table where empId = ?");
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				leave = new Leave(rs.getInt("lid"), rs.getInt("empId"), rs.getString("empName"), rs.getInt("deptId"),
						rs.getString("startDate"), rs.getString("endDate"), rs.getString("reason"),
						rs.getString("status"));
			}

		} catch (SQLException e) {
			throw new LeaveException(e.getMessage());
		}

		return leave;
	}

	@Override
	public String approveRejectLeaves(int lid, int choice) throws LeaveException {
		String message = "Leave is Still Pending.";
		
		try (Connection conn = DButil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update Leave_table set status = ? where lid = ?");
			if(choice == 1) {
				ps.setString(1, "Approved" );
			}
			else if(choice == 2) {
				ps.setString(1, "Rejected" );
			}
			else {
				throw new LeaveException("Incorrect Choice.");
			}
			ps.setInt(2, lid);
			int n = ps.executeUpdate();
			if(n> 0) {
				if(choice == 1) {
					message = "Leave Request Approved";
				}
				else if(choice == 2) {
					message = "Leave Request Rejected";
				}
				
			}

		} catch (SQLException e) {
			throw new LeaveException(e.getMessage());
		}
		return message;
	}

}
