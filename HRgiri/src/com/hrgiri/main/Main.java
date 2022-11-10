package com.hrgiri.main;

import java.util.Scanner;

import com.hrgiri.usecase.AddNewDept;

public class Main {
 static void userLogin() {
	 while(true) {
			System.out.println("------------------------------| LOGIN |------------------------------");
			System.out.println();
			System.out.println("Employees Press 1 || Admins Press 2");
			System.out.println("                                                To Quit HRगिरी, Press 3");
			
			
			Scanner scanner = new Scanner(System.in);
			int mainChoice = scanner.nextInt();
			
			if(mainChoice == 1) {
				
			}
			else if (mainChoice == 2) {
				String adminLoginStatus = AddNewDept.addNewDept();
			}
			else if (mainChoice == 3) {
				scanner.close();
				
			}
			else {
				System.out.println("❌❌❌❌❌| WRONG INPUT |❌❌❌❌❌");
				System.out.println("----------| CHOOSE AGAIN |---------");
				System.out.println();
			}
		}
		
	}

	public static void main(String[] args) {
		System.out.println();
		System.out.println("------------------------------| HRगिरी |------------------------------");
		System.out.println();
		System.out.println("Let's begin HRगिरी, Choose any of the following options to proceed...");
		System.out.println();
		userLogin();
		
}
}