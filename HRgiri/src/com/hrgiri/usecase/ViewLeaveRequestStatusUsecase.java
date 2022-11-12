package com.hrgiri.usecase;

import java.util.List;

import com.hrgiri.dao.LeaveDAO;
import com.hrgiri.dao.LeaveDAOImpl;
import com.hrgiri.exceptions.LeaveException;
import com.hrgiri.models.Employee;
import com.hrgiri.models.Leave;

public class ViewLeaveRequestStatusUsecase {

	public static void viewLeaveRequestStatus(Employee emp) {
		LeaveDAO dao = new LeaveDAOImpl();

		try {
			Leave l = dao.getLeaveRequestStatus(emp.getEid());
			if(l != null) {
				String leftAlignFormat = "| %-3d | %-5d | %-15s | %-6d | %-13s | %-15s | %-35s | %-10s |%n";

				System.out.format(
						"+-----+-------+-----------------+--------+---------------+-----------------+-------------------------------------+------------+%n");
				System.out.format(
						"| lid | empId |     empName     | deptId |   startDate   |    endDate      |               Reason                |   Status   |%n");
				System.out.format(
						"+-----+-------+-----------------+--------+---------------+-----------------+-------------------------------------+------------+%n");
			
					System.out.format(leftAlignFormat, l.getLid(), l.getEmpId(), l.getEmpName(), l.getDeptId(),
							l.getStartDate(), l.getEnDate(), l.getReason(), l.getStatus());

				
				System.out.format(
						"+-----+-------+-----------------+--------+---------------+-----------------+-------------------------------------+------------+%n");

			}
			else {
				System.out.println("You have NOT Applied for any Leave Yet.");
			}
			
		} catch (LeaveException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static void viewLeaveRequestHistory(Employee emp) {
		LeaveDAO dao = new LeaveDAOImpl();

		try {

			List<Leave> leaveList = dao.getLeaveHistory(emp.getEid());
			if (leaveList.size() != 0) {

				String leftAlignFormat = "| %-3d | %-5d | %-15s | %-6d | %-13s | %-15s | %-35s | %-10s |%n";

				System.out.format(
						"+-----+-------+-----------------+--------+---------------+-----------------+-------------------------------------+------------+%n");
				System.out.format(
						"| lid | empId |     empName     | deptId |   startDate   |    endDate      |               Reason                |   Status   |%n");
				System.out.format(
						"+-----+-------+-----------------+--------+---------------+-----------------+-------------------------------------+------------+%n");
				for (Leave l : leaveList) {
					System.out.format(leftAlignFormat, l.getLid(), l.getEmpId(), l.getEmpName(), l.getDeptId(),
							l.getStartDate(), l.getEnDate(), l.getReason(), l.getStatus());

				}
				System.out.format(
						"+-----+-------+-----------------+--------+---------------+-----------------+-------------------------------------+------------+%n");

			} else {
				System.out.println("You have NOT Applied for any Leave Yet.");
			}

		} catch (LeaveException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
