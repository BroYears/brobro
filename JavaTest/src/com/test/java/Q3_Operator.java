package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3_Operator {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("너비(cm) : ");
		String input1 = reader.readLine();
		
		System.out.print("높이(cm) : ");
		String input2 = reader.readLine();
		
		int num1 = Integer.parseInt(input1);
		int num2 = Integer.parseInt(input2);
		
		int result1 = num1 * num2;
		int result2 = num1 * 2 + num2 * 2;
		
		System.out.printf("사각형의 넓이는 %d㎠입니다.\n", result1);
		System.out.printf("사각형의 높이는 %dcm입니다.", result2);	
	}

}
