package com.hrgiri.usecase;

import java.util.List;

import com.hrgiri.dao.DeptDAO;
import com.hrgiri.dao.DeptDAOImpl;
import com.hrgiri.exceptions.DepartmentException;
import com.hrgiri.models.Department;

public class ViewAllDeptUsecase {

	public static void viewAllDept() {
		DeptDAO dao = new DeptDAOImpl();
		try {
			List<Department> deptList = dao.getAllDept();
			String leftAlignFormat = "| %-8d | %-13s | %-18d |%n";

			System.out.format("+----------+---------------+--------------------+%n");
			System.out.format("| Dept ID  | Dept Name     | Dept Head Emp ID   |%n");
			System.out.format("+----------+---------------+--------------------+%n");

			for(Department d : deptList) {
				System.out.format(leftAlignFormat, d.getDid(), d.getdName(), d.getdHeadId());
			
			}
			System.out.format("+----------+---------------+--------------------+%n");

			
		} catch (DepartmentException e) {
		
			System.out.println();
			System.out.println("✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘| " + e.getMessage() + " |✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘");
			System.out.println();
		}
	}
}
