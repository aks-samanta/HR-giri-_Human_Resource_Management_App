package com.hrgiri.usecase;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.hrgiri.dao.LeaveDAO;
import com.hrgiri.dao.LeaveDAOImpl;
import com.hrgiri.exceptions.LeaveException;
import com.hrgiri.models.Leave;

public class RespondToLeaveRequestUsecase {

	public static void respondToLeaveRequest(Scanner sc) {
		LeaveDAO dao = new LeaveDAOImpl();
		try {
			List<Leave> leaveList = dao.getPendingLeaveRequests();
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

				
				System.out.println();
				System.out.println("Choose Leave ID to Respond");
			
				try {
					int lid = sc.nextInt();
					System.out.println("Press 1 to Approve.");
					System.out.println("Press 2 to Reject.");
					int choice = sc.nextInt();
					
					LeaveDAO dao2 = new LeaveDAOImpl();
					
					System.out.println();
					System.out.println("✔✔✔✔✔✔✔✔✔✔✔| " + dao2.approveRejectLeaves(lid, choice) + " |✔✔✔✔✔✔✔✔✔✔✔");
					System.out.println();
					
				} catch (InputMismatchException e) {
					System.out.println();
					System.out.println("✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘| " + e.getMessage() + " |✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘");
					System.out.println();
					
				}
				
				
				
			} else {
				System.out.println("No Pending Leave Request As of Now.");
			}

		} catch (LeaveException e) {
			System.out.println(e.getMessage());
		}

	}
}
