package com.hrgiri.usecase;

import java.util.Scanner;

import com.hrgiri.dao.DeptDAO;
import com.hrgiri.dao.DeptDAOImpl;
import com.hrgiri.exceptions.DepartmentException;

public class UpdateDeptUsecase {

	
	
	public static void updateDepartment(int deptId, Scanner sc) {
		
		System.out.println("+----------------------------+" + "\n"
				   + "| 1. Update Department Name  |" + "\n"
				   + "| 2. Update Department Head  |" + "\n"
				   + "+----------------------------+" );
		
		
		int nameOrHead = sc.nextInt();
		DeptDAO dao = new DeptDAOImpl();
		
		if(nameOrHead == 2) {
			System.out.println("Enter the Employee ID of the new Employee head : ");
			int newEmpId = sc.nextInt();
			try {
				dao.updateDeptHead(newEmpId, deptId);
			} catch (DepartmentException e) {
				
//				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		else if(nameOrHead == 1) {
			System.out.println("Enter the New Department name :");
			String newDname = sc.next();
			try {
			System.out.println(dao.updateDeptName(newDname, deptId));
		
			} catch (DepartmentException e) {
				
				System.out.println(e.getMessage());
			}
		}
		else {
			System.out.println("Select from the given Options.");
			updateDepartment(deptId, sc);
		}
		
		
	}
}
