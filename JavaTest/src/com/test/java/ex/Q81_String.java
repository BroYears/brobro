package com.test.java.ex;

import java.util.Scanner;

public class Q81_String {
	
	public static void main(String[] args) {
		
		String email = "";
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이메일: ");
		email = scan.nextLine();
		
		System.out.print("아이디: "); 
		for ( int i=0; i<=email.indexOf("@")-1; i++) {
			System.out.print(email.charAt(i));
		}
		
		System.out.println();
		
		System.out.print("도메인: ");
		for (int i=email.indexOf("@") + 1; i<=email.length() - 1; i++) {
			System.out.print(email.charAt(i));
		}
		
	}

}
