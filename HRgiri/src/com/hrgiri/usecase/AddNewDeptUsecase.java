package com.hrgiri.usecase;

import java.util.Scanner;

import com.hrgiri.dao.DeptDAO;
import com.hrgiri.dao.DeptDAOImpl;
import com.hrgiri.models.Department;

public class AddNewDeptUsecase {

	public static void addNewDept(Scanner sc) {
		
		
		
		System.out.println("Add New Department");
		System.out.println("Enter Department ID :- ");
  		int did = sc.nextInt();
  		System.out.println("Enter Department Name :- ");
  		sc.nextLine();
  		String  dName = sc.nextLine();
  		System.out.println("Enter Employee ID of Department Head :- ");
  		System.out.println("Note : if Department Head is not assigned yet, enter 0, You can Update Department later.");
  		int dHeadId = sc.nextInt();
  		
  		
  		Department d = new Department(did, dName, dHeadId);
  		
  		DeptDAO dao =  new DeptDAOImpl();
  		
  		try {
			String result = dao.addDeptToDB(d);
			System.out.println(result);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println();
			System.out.println("✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘| Department not Added ! |✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘");
			System.out.println();
			System.out.println();
			System.out.println("✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘| "+e.getMessage() +" |✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘");
		
		}
  		
  		
	}

}
