package com.test.java.ex;

import java.util.Scanner;

public class Q62_Array {

	
	public static void main(String[] args) {
		
		
		String studentName = ""; 
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("학생 수: ");
		int inNum = scan.nextInt();
		
		String[] student = new String[inNum];
		
		for (int i=0; i<inNum; i++) {
			
			System.out.print("학생명: ");
			studentName = scan.nextLine();
		}

		
	}
	
	
}
