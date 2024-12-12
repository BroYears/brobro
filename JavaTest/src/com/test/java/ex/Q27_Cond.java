package com.test.java.ex;

import java.util.Scanner;

public class Q27_Cond {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("문자: ");
		String fam = scan.nextLine();
		
		switch (fam) {
			case "f":
			case "F":
				System.out.print("Father");
				break;
			case "m":
			case "M":
				System.out.print("Mother");
				break;
			case "s":
			case "S":
				System.out.print("Sister");
				break;
			case "b":
			case "B":
				System.out.print("Brother");
				break;
			default:
				System.out.print("입력한 문자가 올바르지 않습니다.");
				break;
		}
		
		
		
		
	}

}
