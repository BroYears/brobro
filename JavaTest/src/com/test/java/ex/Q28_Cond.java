package com.test.java.ex;

import java.util.Scanner;

public class Q28_Cond {
		
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("근무 년수: ");
		int years = scan.nextInt();
		
		
		if (years >= 1) {
			if (years <= 4) {
				System.out.printf("%d년차 초급 개발자입니다.\n앞으로 %d년 더 근무를 하면 중급 개발자가 됩니다.", years, 5 - years);
			} else if (years <= 9) {
				System.out.printf("%d년차 중급 개발자입니다.\n앞으로 %d년 더 근무를 하면 고급 개발자가 됩니다.", years, 9 - years);
			} else if (years >= 10) {
				System.out.printf("%d년차 고급 개발자입니다.\n당신은 %d년전까지 중급 개발자였습니다.", years, years - 9);
			}
		} else {
			System.out.print("입력한 값이 올바르지 않습니다. 1이상의 값을 입력하세요.");
		}
		
	}//main

}
