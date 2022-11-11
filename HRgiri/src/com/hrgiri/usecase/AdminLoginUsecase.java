package com.hrgiri.usecase;

import java.util.Scanner;



public class AdminLoginUsecase {

	public static boolean AdminLogin(Scanner sc) {
		
		
		
		System.out.println("Enter Admin Password" );
		
		String password = sc.next();
		
		
		if (password.equals("a")){
			System.out.println();
			System.out.println("✔✔✔✔✔✔✔✔✔✔✔| Admin Logged In Successfully !! |✔✔✔✔✔✔✔✔✔✔✔");
			System.out.println();
			return true;
		}
		else {
			System.out.println();
			System.out.println("✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘| Oops!! Wrong Password!! Try Again... |✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘ ✘");
			System.out.println();
			return false;
		}

	}

}