package com.hrgiri.usecase;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.hrgiri.dao.EmpDAO;
import com.hrgiri.dao.EmpDAOImpl;
import com.hrgiri.exceptions.EmployeeException;
import com.hrgiri.models.Employee;

public class EmployeeLoginUsecase {

	public static Employee empLogin(Scanner sc) {
		
		Employee emp = null;
		try {
			
			
			System.out.println("Enter email");
			String email = sc.next();
			
			System.out.println("Enter Password");
			String password = sc.next();
			
			EmpDAO dao = new EmpDAOImpl();
			
			try {
				emp = dao.getEmpfromDB(email, password);
				System.out.println();
				System.out.println("✔✔✔✔✔✔✔✔✔✔✔| "+emp.getEname()+" Logged In Successfully !! |✔✔✔✔✔✔✔✔✔✔✔");
				System.out.println();
			} catch (EmployeeException e) {
				
				System.out.println();
				System.out.println("✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘| Oops!! Wrong Password!! Try Again... |✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘");
				System.out.println();
			}
		}
		catch (InputMismatchException e) {
			System.out.println( e.getMessage() );
		}
		
		return emp;
	}
}
