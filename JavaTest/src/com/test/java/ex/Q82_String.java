package com.test.java.ex;

import java.util.Scanner;

public class Q82_String {

	public static void main(String[] args) {
		
		String in = "";
		int num = 0;
		int sum = 0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자: ");
		in = scan.nextLine();
						
		System.out.print("결과: ");
		for (int i=0; i<in.length(); i++) {
			
			System.out.print(in.charAt(i));
			num = in.charAt(i);
			sum += Integer.parseInt(in.substring(i, i + 1));
			if (i<in.length()-1) {
				System.out.print(" + ");
			}
			
		}
		System.out.println(" = " + sum);
	}
	
}
