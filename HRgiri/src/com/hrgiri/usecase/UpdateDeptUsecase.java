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
				System.out.println();
				
				System.out.println("✔✔✔✔✔✔✔✔✔✔✔| " + dao.updateDeptHead(newEmpId, deptId) + " |✔✔✔✔✔✔✔✔✔✔✔");
				System.out.println();
				
			} catch (DepartmentException e) {
				
				System.out.println();
				System.out.println("✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘| " + e.getMessage() + " |✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘");
				System.out.println();

			}
		}
		else if(nameOrHead == 1) {
			System.out.println("Enter the New Department name :");
			sc.nextLine();
			String newDname = sc.nextLine();
			try {
				System.out.println();
				System.out.println("✔✔✔✔✔✔✔✔✔✔✔| " + dao.updateDeptName(newDname, deptId) + " |✔✔✔✔✔✔✔✔✔✔✔");
				System.out.println();
		
			} catch (DepartmentException e) {
				
				System.out.println();
				System.out.println("✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘| " + e.getMessage() + " |✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘");
				System.out.println();
			}
		}
		else {
			System.out.println();
			System.out.println("✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘| Select from the given Options. |✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘");
			System.out.println();
			updateDepartment(deptId, sc);
		}
		
		
	}
}
