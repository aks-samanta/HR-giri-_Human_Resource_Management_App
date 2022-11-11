package com.hrgiri.usecase;

import java.util.Scanner;

import com.hrgiri.dao.DeptDAO;
import com.hrgiri.dao.DeptDAOImpl;
import com.hrgiri.models.Department;

public class AddNewDeptUsecase {

	public static String addNewDept(Scanner sc) {
		String message = "Adding new Dept....";
		
		
		System.out.println("Adding New Department");
		System.out.println("Enter Department ID :- ");
  		int did = sc.nextInt();
  		System.out.println("Enter Department Name :- ");
  		String  dName = sc.next();
  		System.out.println("Enter Employee ID of Department Head :- ");
  		int dHeadId = sc.nextInt();
  		
  		
  		Department d = new Department(did, dName, dHeadId);
  		
  		DeptDAO dao =  new DeptDAOImpl();
  		
  		try {
			String result = dao.addDeptToDB(d);
			System.out.println(result);
		} catch (Exception e) {
			// TODO: handle exception
		}
  		
  		return message;
	}

}
