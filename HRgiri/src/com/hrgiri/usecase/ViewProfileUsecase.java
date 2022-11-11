package com.hrgiri.usecase;


import com.hrgiri.dao.DeptDAO;
import com.hrgiri.dao.DeptDAOImpl;
import com.hrgiri.dao.EmpDAO;
import com.hrgiri.dao.EmpDAOImpl;
import com.hrgiri.dao.EmpDeptDAO;
import com.hrgiri.dao.EmpDeptDAOImpl;
import com.hrgiri.exceptions.DepartmentException;
import com.hrgiri.exceptions.EmployeeException;
import com.hrgiri.models.Employee;

public class ViewProfileUsecase {
	
	public static void showEmpProfile(Employee emp) {
		
		System.out.println( " Employee ID      		: "+ emp.getEid());
		System.out.println( " Department ID    		: "+ emp.getDeptId());
		System.out.println( " Name             		: "+ emp.getEname());
		DeptDAO dao = new DeptDAOImpl();
		
		try {
		System.out.println( " Your Department  		: "+ dao.getDeptFromDB(emp.getDeptId()).getdName());
		} catch (DepartmentException e) {
			e.printStackTrace();
			
		}
		EmpDeptDAO dao2 = new EmpDeptDAOImpl();
		try {
		System.out.println( " Your Department Head		: "+ dao2.getDeptHeadDetails(emp.getDeptId()).getEname()); 
		// getting department head nname from emp deptId -> dept table -> dept head Id -> emp table eid -> ename
		} catch (DepartmentException e) {
			e.printStackTrace();
			
		} catch (EmployeeException e) {
			e.printStackTrace();
		}
		System.out.println( " email 				: "+ emp.getEmail());
		System.out.println( " address 			: "+ emp.getAddress());
		System.out.println( " Salary 			: "+ emp.getSalary());
		System.out.println( " Leave Left 			: "+ emp.getLeavesLeft());
		
	}
}
