package com.test.java.ex;

import java.util.Scanner;

public class Q29_Cond {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("첫번째 숫자: ");
		int num1 = scan.nextInt(); 		
		System.out.print("두번째 숫자: ");
		int num2 = scan.nextInt();
		
		
		
		//정수 -> 문자 :
		//scan.nextLine();


		
		System.out.print("연산자: ");
		String Oper = scan.nextLine();
		
		
		switch (Oper) {
			case "+":
				System.out.printf("%d + %d = %d", num1, num2, num1 + num2);
				break;
			case "-":
				System.out.printf("%d - %d = %d", num1, num2, num1 - num2);
				break;
			case "*":
				System.out.printf("%d * %d = %d", num1, num2, num1 * num2);
				break;
			case "/":
				System.out.printf("%d / %d = %f", num1, num2, num1 / (double)num2);
				break;
			case "%":
				System.out.printf("%d %% %d = %d", num1, num2, num1 % num2);
			break;
			default:
				System.out.printf("연산이 불가능합니다.");
			break;
		}
		
		
	}

}
