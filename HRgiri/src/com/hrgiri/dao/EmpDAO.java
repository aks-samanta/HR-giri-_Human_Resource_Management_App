package com.hrgiri.dao;

import com.hrgiri.exceptions.EmployeeException;
import com.hrgiri.models.Employee;

public interface EmpDAO {
	
	public Employee getEmpfromDB(String email, String password) throws EmployeeException;
	
	public String registerEmployee(Employee emp) throws EmployeeException;
	
	public String transferEmpToOtherDept(int empId, int newDeptId) throws EmployeeException;
	
	public String updateEmpProfile(String email, String address, Employee e) throws EmployeeException;
	
	public String updateEmpPassword(  String newPass, String oldPass, Employee e) throws EmployeeException;
}
