package com.hrgiri.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hrgiri.exceptions.DepartmentException;
import com.hrgiri.models.Department;
import com.hrgiri.utility.DButil;


public class DeptDAOImpl implements DeptDAO {

	@Override
	public String addDeptToDB(Department d) throws DepartmentException {
		String message = "Adding";
		
		try (Connection conn = DButil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into department values (?,?,?)");
			
			
			ps.setInt(1, d.getDid());
			ps.setString(2, d.getdName());
			ps.setInt(3, d.getdHeadId());
			
			
			int rowsEffected = ps.executeUpdate();
			
			if(rowsEffected > 0) {
				message = "Department Added Successfully"; 
			}
			
			
		} catch (SQLException e) {
//			e.printStackTrace();
			throw new DepartmentException(e.getMessage());
		}
		
		
		
		return message;
	}

	
	
	@Override
	public Department getDeptFromDB(int deptId) throws DepartmentException {
		
		Department dept = null;
		
		try (Connection conn = DButil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from department where did = ?");
			ps.setInt(1, deptId);
			
				ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				dept = new Department(deptId, rs.getString("dname"), rs.getInt("d_Head_Id"));
			}
			else {
				throw new DepartmentException("No Department found with ID = " + deptId);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		return dept;
	}



	
	
	
	
	@Override
	public List<Department> getAllDept() throws DepartmentException {
		List<Department> deptList = new ArrayList<Department>();
		
		try(Connection conn= DButil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from department");

			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				deptList.add(new Department(rs.getInt("did"), rs.getString("dname"), rs.getInt("d_Head_Id")));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DepartmentException(e.getMessage());
		}
		
		return deptList;
	}

	
	
	
	
}
