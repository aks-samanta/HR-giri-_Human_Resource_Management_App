package com.hrgiri.main;


import java.util.Scanner;

import com.hrgiri.models.Employee;
import com.hrgiri.usecase.AddNewDeptUsecase;
import com.hrgiri.usecase.AdminLoginUsecase;
import com.hrgiri.usecase.ChangePasswordUsecase;
import com.hrgiri.usecase.EmployeeDeptTransferUsecase;
import com.hrgiri.usecase.EmployeeLoginUsecase;
import com.hrgiri.usecase.RegisterNewEmpUsecase;
import com.hrgiri.usecase.UpdateDeptUsecase;
import com.hrgiri.usecase.UpdateProfileUsecase;
import com.hrgiri.usecase.ViewAllDeptUsecase;
import com.hrgiri.usecase.ViewProfileUsecase;




public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	static void adminOrEmployee(Scanner sc) {
		System.out.println("+----------------------------+" + "\n"
						 						   + "| 1. Login As Admin          |" + "\n"
					 	 						   + "| 2. Login As Employee       |" + "\n"
						 						   + "| 3. Quit HRगिरी		     |" + "\n"
						 						   + "+----------------------------+" );
		choice(sc);
	}
	
	static void choice(Scanner sc) {
		
		int choice =0;
			try {
				 choice = Integer.parseInt(sc.next()) ;
			} catch (Exception e) {
				
				System.out.println("Your Choice must be a number");
			}

			
			if (choice == 1) {
				System.out.println( "Welcome Admin ! Please Login to your account");
				AdminLogin();
			}
			else if (choice == 2) {
				System.out.println("Welcome Customer !");
				employeeLogin();
			}
			else if (choice == 3) {
				System.out.println();
				System.out.println("-------------------------| HRगिरी |-------------------------");
				System.out.println();
				System.exit(0);
			}
			else if(choice <1 || choice > 3){
				System.out.println("Please choose a number from the options below");
				adminOrEmployee(sc);
			}
			else {
				System.out.println( "Input type should be number" );
			}
			
		} 
	
	
	static void AdminLogin() {
		
		Boolean result = AdminLoginUsecase.AdminLogin(sc);

		if (result) adminFeatures();
		else {
			adminOrEmployee(sc);
		}
	}
	
	static void adminFeatures() {
		System.out.println("+------------------------------------------+" + "\n"
						 + "| Welcome Admin                            |" + "\n"
						 + "| 1. Add New Department                    |" + "\n"
						 + "| 2. View All Departments                  |" + "\n"
						 + "| 3. Update Department                     |" + "\n"
						 + "| 4. Register New Employee                 |" + "\n"
						 + "| 5. Transfer Employee to other Department |" + "\n" 
						 + "| 6. Logout                                |" + "\n"
						 + "| 7. Quit HRगिरी                             |" + "\n"
						 + "+------------------------------------------+" );
		
	
		int choice =0;
		
		
		try {
			 choice = Integer.parseInt(sc.next()) ;
		} catch (Exception e) {
			
			System.out.println("Your Choice must be a number");
		}
		
		
				if (choice < 1 || choice > 8) {
					System.out.println("Please choose a number from below options");
					adminFeatures();
				}
				else {
					
					adminChoice(choice);
				}
			}
			
		
	
	
	static void adminChoice(int choice) {
		
			switch(choice) {
				case 1 : {
					AddNewDeptUsecase.addNewDept(sc);
					adminFeatures();
				}
				break;
				
				case 2 : {
					ViewAllDeptUsecase.viewAllDept();
					adminFeatures();
				}
				break;
				
				case 3 : {
					ViewAllDeptUsecase.viewAllDept();
					System.out.println("Enter the Department Id of the Department you choose to Update : ");
					int deptId = sc.nextInt();
					UpdateDeptUsecase.updateDepartment(deptId,sc);
					adminFeatures();
				}
				break;
				
				case 4 : {
					RegisterNewEmpUsecase.registerNewEmp(sc);
					adminFeatures();
				}
				break;
				
				case 5 : {
					EmployeeDeptTransferUsecase.transferDept(sc);
					adminFeatures();
				}
				break;
				
				case 6 : {
					adminOrEmployee(sc);
				}
				break;
				
				case 7 : {
					System.out.println( "Thank you ! Visit again");
					System.exit(0);
				}
				break;
					
				}
			}
	
	
	
	
	static void employeeLogin() {
		Employee emp = EmployeeLoginUsecase.empLogin(sc);
		
		if (emp == null) {
			adminOrEmployee(sc);
		}
		else {
			System.out.println( "Login Successfull" );
			employeeFeatures(emp);
		}
		
	}
	
	
	
	static void employeeFeatures(Employee emp) {
		System.out.println("+--------------------------------+" + "\n"
						 + "| Welcome "+emp.getEname()+"                    |" + "\n"
				 		 + "| 1. View Profile                |" + "\n"
				         + "| 2. Update Profile              |" + "\n"
				         + "| 3. Change Password             |" + "\n"
				         + "| 4. Request for Leave           |" + "\n"
				         + "| 5. View Leave Request Status   |" + "\n"
				         + "| 6. View Leave Request History  |" + "\n"
				         + "| 7. Logout                      |" + "\n"
				         + "| 8. Quit HRगिरी                   |" + "\n"
				         + "+--------------------------------+" );
	
		int choice = 0;
		try {
			 choice = Integer.parseInt(sc.next()) ;
		} catch (Exception e) {
			
			System.out.println("Your Choice must be a number");
		}
				if (choice < 1 || choice > 8) {
					System.out.println("Please choose a number from below options (Only enter the serial number, eg: 1)");
					employeeFeatures(emp);
				}
				else empChoice(choice, emp);
			}
	
//			
		
	
	
	static void empChoice(int choice, Employee emp) {
		switch(choice) {
		case 1 : {
			ViewProfileUsecase.showEmpProfile(emp);
			employeeFeatures(emp);
		}
		break;
		case 2 : {
			UpdateProfileUsecase.updateProfile(sc,emp);
			adminOrEmployee(sc);
		}
		break;
		case 3 : {
			ChangePasswordUsecase.changePassword(sc, emp);
			adminOrEmployee(sc);
		}
		break;
		
		case 4 : {
			ViewProfileUsecase.showEmpProfile(emp);
			employeeFeatures(emp);
		}
		break;
		
		case 5 : {
			ViewProfileUsecase.showEmpProfile(emp);
			employeeFeatures(emp);
		}
		break;
		
		case 6 : {
			ViewProfileUsecase.showEmpProfile(emp);
			employeeFeatures(emp);
		}
		break;
		
	
		
		case 7 : {
			adminOrEmployee(sc);
		}
		break;
		case 8 : {
			System.out.println("Thank you ! Visit again" );
			System.exit(0);
		}
	}
	}
	

	public static void main(String[] args) {
		System.out.println();
		System.out.println("-------------------------| HRगिरी |-------------------------");
		System.out.println();
		adminOrEmployee(sc);
		System.out.println();
		System.out.println("-------------------------| HRगिरी |-------------------------");
		System.out.println();
		sc.close();
		
	}	

}