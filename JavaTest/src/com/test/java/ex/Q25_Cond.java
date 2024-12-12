package com.test.java.ex;

import java.util.Scanner;

public class Q25_Cond {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("첫번째 숫자: ");
		int num1 = scan.nextInt();
		
		System.out.print("두번째 숫자: ");
		int num2 = scan.nextInt();
		
		if (num1 > num2) {
			System.out.printf("큰 수는 %d이고, 작은 수는 %d입니다. 두 숫자는 2(가)이 차이납니다", num1, num2, num1 - num2);
		} else if (num1 < num2)	{ 
			System.out.printf("큰 수는 %d이고, 작은 수는 %d입니다. 두 숫자는 2(가)이 차이납니다", num2, num1, num2 - num1);
		} else {
			System.out.print("두 숫자는 동일합니다");
		}
		
	}

}
