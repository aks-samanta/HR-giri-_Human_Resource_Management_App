package com.hrgiri.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hrgiri.exceptions.DepartmentException;
import com.hrgiri.exceptions.EmployeeException;
import com.hrgiri.models.EmpDeptDTO;

import com.hrgiri.utility.DButil;

public class EmpDeptDAOImpl implements EmpDeptDAO {


@Override
public EmpDeptDTO getDeptHeadDetails(int deptId) throws DepartmentException, EmployeeException {
	
	EmpDeptDTO ed = null;
	
	try (Connection conn = DButil.provideConnection()){
		
		PreparedStatement ps = conn.prepareStatement("select * from department where did = ?");
		
		ps.setInt(1, deptId);
		
		ResultSet rs =  ps.executeQuery();
		
		if (rs.next()) {
			
			int dHeadId = rs.getInt("d_Head_Id");
			String dname = rs.getString("dname");
 			PreparedStatement ps2 = conn.prepareStatement("select * from employee where eid = ?");
			
			ps2.setInt(1, dHeadId);
			
			ResultSet rs2 =  ps2.executeQuery();
			
			if(rs2.next()) {
				int eid = rs2.getInt("eid");
				 String ename = rs2.getString("ename");
				 int dId = rs2.getInt("deptId");
				 String email = rs2.getString("email");
				 int salary = rs2.getInt("deptId");
				 String address = rs2.getString("address");
				 
			
				 
				ed = new EmpDeptDTO(eid, ename, dId, email, salary, address,dname,ename);
				return ed;
			}

		}
			else {
				
				throw new EmployeeException("Invalid username or password");
			
			}
	

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	return ed;
	}
}
