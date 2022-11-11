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

	
	
	
	@Override
	public String registerEmployee(Employee emp) throws EmployeeException {
		String message = "Employee Not Registered";
		
		
		try (Connection conn = DButil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into employee (ename, deptId, email, password, salary) values (?, ?, ?, ?, ?)");
			
			ps.setString(1, emp.getEname());
			ps.setInt(2, emp.getDeptId());
			ps.setString(3, emp.getEmail());
			ps.setString(4, emp.getPassword());
			ps.setInt(5, emp.getSalary());
			
			int res = ps.executeUpdate();
			
			if(res > 0) {
				message = "Employee Registered Successfully !!";
			}
			else {
				throw new EmployeeException();
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new EmployeeException(e.getMessage());
		}
		
		
		return message;
	}




	
	
	
	
	
	@Override
	public String transferEmpToOtherDept(int empId, int newDeptId) throws EmployeeException {
		String message = "Employee Not Transfered";
		
		
		try (Connection conn = DButil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("update employee set deptId = ? where eid = ?");
			
			ps.setInt(1, newDeptId);
			ps.setInt(2, empId);
			
			int res = ps.executeUpdate();
			
			if(res > 0) {
				message = "Employee Transfered Successfully !!";
			}
			else {
				
				throw new EmployeeException("Incorrect Department Id or Employee ID, Please check then try Again");
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new EmployeeException(e.getMessage());
		}
		
		
		return message;
	}




	
	
	
	
	@Override
	public String updateEmpProfile(String email, String pass, String address, Employee e) throws EmployeeException {
		
		String message = "Profile Not Updated !";
		
		
		try (Connection conn = DButil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("update employee set email = ?, password = ? , address = ? where eid = ?");
			ps.setString(1, email);
			ps.setString(2, pass);
			ps.setString(3,address);
			ps.setInt(4, e.getEid());
			
			int res = ps.executeUpdate();
			
			if(res > 0) {
				message = ("Profile Updated Successfully !");
			}
			else {
				throw new EmployeeException("Profile NOT Updated! Please try Again...");
			}
		} catch (Exception e1) {
			throw new EmployeeException(e1.getMessage());
		}
		
		
		return message;
	}

	
	
	
	
}
