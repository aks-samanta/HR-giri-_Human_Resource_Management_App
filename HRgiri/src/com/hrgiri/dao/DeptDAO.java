package com.hrgiri.dao;

import java.util.List;

import com.hrgiri.exceptions.DepartmentException;
import com.hrgiri.models.Department;

public interface DeptDAO {
	
	public String addDeptToDB(Department d)throws DepartmentException;
	
	public Department getDeptFromDB(int deptId) throws DepartmentException;
	
	public List<Department> getAllDept() throws DepartmentException;
	
	public String updateDeptName(String newDeptName, int deptId) throws DepartmentException;
	
	public String updateDeptHead(int newDeptHeadEmpId, int deptId) throws DepartmentException;
}
