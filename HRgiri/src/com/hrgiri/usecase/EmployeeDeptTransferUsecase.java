package com.hrgiri.usecase;

import java.util.Scanner;

import com.hrgiri.dao.EmpDAO;
import com.hrgiri.dao.EmpDAOImpl;
import com.hrgiri.exceptions.EmployeeException;

public class EmployeeDeptTransferUsecase {

	public static void transferDept(Scanner sc) {
		System.out.println("Enter Employee ID of Employee who needs to be Transfered : ");
		int empId = sc.nextInt();
		System.out.println("Enter Employee's new Department ID : ");
		int deptId = sc.nextInt();
		
		EmpDAO dao = new EmpDAOImpl();
		
		try {
			System.out.println(dao.transferEmpToOtherDept(empId, deptId));
			
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		}
	}
}
