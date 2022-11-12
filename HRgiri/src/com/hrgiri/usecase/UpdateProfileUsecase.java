package com.hrgiri.usecase;

import java.util.Scanner;

import com.hrgiri.dao.EmpDAO;
import com.hrgiri.dao.EmpDAOImpl;
import com.hrgiri.exceptions.EmployeeException;
import com.hrgiri.models.Employee;

public class UpdateProfileUsecase {

	public static void updateProfile(Scanner sc, Employee e) {
		
		System.out.println("Enter New Email : (If you don't want to update Email, Please Enter the current Email)");
		String email = sc.next();
		System.out.println("Enter New Address : (If you don't want to update Address, Please Enter the current Address)");
		String address = sc.next();
	
	 	
		EmpDAO dao = new EmpDAOImpl();
		
		try {
			String ans = dao.updateEmpProfile(email, address, e);
			System.out.println(ans);
			
			if(ans.equals("Profile Updated Successfully !")) {
				e.setAddress(address);
				e.setEmail(email);
			}
			
			
		} catch (EmployeeException e1) {
//			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}
		
		
	}
}
