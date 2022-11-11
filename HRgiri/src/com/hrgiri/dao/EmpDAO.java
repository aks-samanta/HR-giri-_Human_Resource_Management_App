package com.hrgiri.dao;

import com.hrgiri.exceptions.EmployeeException;
import com.hrgiri.models.Employee;

public interface EmpDAO {
	
	public Employee getEmpfromDB(String email, String password) throws EmployeeException;
	
	
}
