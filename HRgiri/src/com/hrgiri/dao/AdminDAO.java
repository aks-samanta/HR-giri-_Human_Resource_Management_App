package com.hrgiri.dao;


import com.hrgiri.exceptions.DepartmentException;
import com.hrgiri.exceptions.EmployeeException;
import com.hrgiri.models.Department;


public interface AdminDAO {
	
	public String addNewDepartment(Department dept) throws DepartmentException;
	
	public String transferEmpToOtherDept(int empId, int deptId) throws DepartmentException, EmployeeException;
	
	public String registerNewEmployee(Department dept) throws DepartmentException;
	
	
}
