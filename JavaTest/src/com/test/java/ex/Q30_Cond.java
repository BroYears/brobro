package com.test.java.ex;

import java.util.Scanner;

public class Q30_Cond {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("문자: ");
		int txt = scan.nextInt();
		
		//A(65) ~ Z(90)***
		//a(97) ~ z(122)***
		if (txt >= 65 && txt <= 90) {
			System.out.printf("'%s'의 소문자는 '%s'입니다.", (txt), (txt + 32));
			
		}
		
		
		
		
	}

}
