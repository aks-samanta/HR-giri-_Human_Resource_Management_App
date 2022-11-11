package com.hrgiri.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hrgiri.exceptions.EmployeeException;
import com.hrgiri.models.Employee;
import com.hrgiri.utility.DButil;

public class EmpDAOImpl implements EmpDAO{

	@Override
	public Employee getEmpfromDB(String email, String password) throws EmployeeException {
		Employee emp = null;
		
		try (Connection conn = DButil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from employee where email = ? and password = ?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs =  ps.executeQuery();
			
			if (rs.next()) {
				int eid = rs.getInt("eid");
				String ename =  rs.getString("ename");
				int deptId = rs.getInt("deptId");	
				int salary = rs.getInt("salary");			
				String address = rs.getString("address");			
				int leaveLeft = rs.getInt("Leaves_left");	
				
				emp = new Employee(eid, ename, deptId, email, salary, address,leaveLeft);
				
			}
			else {
				throw new EmployeeException("Invalid username or password");
				
			}
			
		}
		catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return emp;
	}

	
}
