package com.hrgiri.usecase;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.hrgiri.dao.LeaveDAO;
import com.hrgiri.dao.LeaveDAOImpl;
import com.hrgiri.exceptions.LeaveException;
import com.hrgiri.models.Employee;
import com.hrgiri.models.Leave;

public class CreateLeaveRequestUsecase {

	public static void applyForLeave(Scanner sc, Employee emp) {
		
		
		System.out.println("Enter Leave start Date in dd-MM-yyyy pattern");
		String from= sc.next();
		System.out.println("Enter Leave End Date in dd-MM-yyyy pattern");
		String till= sc.next();
		sc.nextLine();
		System.out.println("Enter the Reason of Leave (in <=120 characters)");
		String reason= sc.nextLine();
		
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate startdate = null;
		LocalDate enddate = null;
		try {
			 startdate = LocalDate.parse(from, dtf);
			from = startdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}catch (Exception e){
			System.out.println("Please pass the leave Start date in proper format.");
		}
		try {
			 enddate = LocalDate.parse(till, dtf);
			 if(startdate.compareTo(enddate)<0) { //checking if start date comes before end date or not...
				 till = enddate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				 int noOfDays = Period.between(startdate, enddate).getDays();
				 
				 Leave leave = new Leave(emp.getEid(),emp.getEname(), emp.getDeptId(), from, till,reason);
					
					LeaveDAO dao = new LeaveDAOImpl();
					try {
						String ans = dao.addLeavetoDB(leave, noOfDays);
						System.out.println(ans);
						if(ans.equals("Leave Applied and remaining leaves updated Successfully!")) {
							emp.setLeavesLeft(emp.getLeavesLeft() - noOfDays);
						}
						
					} catch (LeaveException e) {
						System.out.println(e.getMessage());
					}
			 }
			 else {
				 System.out.println("Start Date cannot come after end Date!");
			 }
			
		}catch (Exception e){
			System.out.println("Please pass the Leave End date in proper format.");
			}
		
		
		
		
		}
	}

