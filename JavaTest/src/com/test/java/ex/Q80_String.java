package com.test.java.ex;

import java.util.Scanner;

public class Q80_String {
	
	public static void main(String[] args) {
		
		String in = "";
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("문장 입력: ");
		in = scan.nextLine();
		
		System.out.print("\"");
		
		for(int i=in.length()-1; i>=0; i--) {
			System.out.print(in.charAt(i));
		}
		
		System.out.print("\"");
	}

}
