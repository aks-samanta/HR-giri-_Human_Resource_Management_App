package com.hrgiri.usecase;

import java.util.Scanner;

import com.hrgiri.dao.EmpDAO;
import com.hrgiri.dao.EmpDAOImpl;
import com.hrgiri.exceptions.EmployeeException;
import com.hrgiri.models.Employee;

public class RegisterNewEmpUsecase {

	public static void registerNewEmp(Scanner sc) {
		Employee emp = null;
		try {
			System.out.println("Enter Employee Name : ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.println("Enter Department ID of Employee :");
			int deptId = sc.nextInt();
			System.out.println("Enter Employee's Email : ");
			String email = sc.next();
			System.out.println("Set Employee's Temporary Initial Password : ");
			String pass = sc.next();
			System.out.println("Enter Employee's Salary : ");
			int sal = sc.nextInt();
			emp = new Employee( name,  deptId,  email,  pass, sal);
		} catch (Exception e) {
			System.out.println();
			System.out.println("Invalid Input Type.");
			System.out.println();
			registerNewEmp( sc);
		}
		
		
	
		
		EmpDAO dao = new EmpDAOImpl();
		
		try {
			String ans =  dao.registerEmployee(emp);
			System.out.println();
			System.out.println("✔✔✔✔✔✔✔✔✔✔✔| " + ans + " |✔✔✔✔✔✔✔✔✔✔✔");
			System.out.println();
		} catch (EmployeeException e) {
			System.out.println();
			System.out.println("✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘| " + e.getMessage() + " |✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘");
			System.out.println();
			System.out.println("Try Again (y/n)");
			String a = sc.next();
			if(a.equals("y")) {
				registerNewEmp(sc);
			}
		}
	}
}
