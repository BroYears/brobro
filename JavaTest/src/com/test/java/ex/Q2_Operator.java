package com.test.java.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2_Operator {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자 : ");
		String input1 = reader.readLine();
		
		System.out.print("두번째 숫자 : ");
		String input2 = reader.readLine();
		
		int num1 = Integer.parseInt(input1);
		int num2 = Integer.parseInt(input2);
		
		int sum = num1 + num2;
		int sub = num1 - num2;
		int mul = num1 * num2;
		double div = (double)(num1 / num2);
		int mod = num1 % num2;
		
		
		System.out.printf("%d + %d = %,d\n", num1, num2, sum);
		System.out.printf("%d - %d = %,d\n", num1, num2, sub);
		System.out.printf("%d * %d = %,d\n", num1, num2, mul);
		System.out.printf("%d / %d = %,.1f\n", num1, num2, div);
		System.out.printf("%d %% %d = %,d\n", num1, num2, mod);

		
	}

}
