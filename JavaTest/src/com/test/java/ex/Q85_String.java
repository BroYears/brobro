package com.test.java.ex;

import java.util.Scanner;

public class Q85_String {
	
	public static void main(String[] args) {
		
		int sum = 0;
		int num = 2;
		int mod = 0;
		
		int modSum1 = 0;
		int modSum2 = 0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("주민등록번호: ");
		String citizenNum = scan.nextLine();
		citizenNum = citizenNum.replace("-", "");
		
		
		for (int i=0; i<citizenNum.length()- 1; i++) {
						
			sum += num * Integer.parseInt(citizenNum.substring(i, i + 1));
			num ++;
			
			if (num >= 10) {
				num = 2;
			}
		}
		
		mod = sum % 11;
		modSum1 = 11 - mod;
		modSum2 = 11 - 10 - mod;
		
		if (modSum1 < 10) {
			if ("modSum1" == citizenNum.substring(citizenNum.length())) {
				System.out.println("올바른 주민등록번호입니다.");
			}
		} else if ("modSum2" == citizenNum.substring(citizenNum.length())) {
			System.out.println("올바른 주민등록번호입니다.");
		} else {
			System.out.println("올바르지 않은 주민등록번호입니다.");
		}
		
	
		
		
	}

}
