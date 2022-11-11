package com.hrgiri.dao;

import com.hrgiri.exceptions.DepartmentException;
import com.hrgiri.exceptions.EmployeeException;
import com.hrgiri.models.EmpDeptDTO;

public interface EmpDeptDAO {

	public EmpDeptDTO getDeptHeadDetails(int deptId) throws DepartmentException,EmployeeException ;
	
	
}
