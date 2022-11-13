package com.hrgiri.usecase;

import java.util.Scanner;

import com.hrgiri.dao.EmpDAO;
import com.hrgiri.dao.EmpDAOImpl;
import com.hrgiri.exceptions.EmployeeException;

public class EmployeeDeptTransferUsecase {

	public static void transferDept(Scanner sc) {
		sc.nextLine();
		try {
			System.out.println("Enter Employee ID of Employee who needs to be Transfered : ");
			int empId = sc.nextInt();
			System.out.println("Enter Employee's new Department ID : ");
			int deptId = sc.nextInt();

			EmpDAO dao = new EmpDAOImpl();

			try {
				System.out.println();
				System.out.println("✔✔✔✔✔✔✔✔✔✔✔| " + dao.transferEmpToOtherDept(empId, deptId) + " |✔✔✔✔✔✔✔✔✔✔✔");
				System.out.println();
			} catch (EmployeeException e) {
				System.out.println();
				System.out.println("✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘| " + e.getMessage() + " |✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘");
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println();
			System.out.println("✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘| Invalid Input type. |✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘");
			System.out.println();
			transferDept(sc);
		}
		
	}
}
