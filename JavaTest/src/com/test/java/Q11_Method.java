package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11_Method {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자: ");
		String input1 = reader.readLine() ;
		
		System.out.print("두번째 숫자: ");
		String input2 = reader.readLine();
		
		int n1 = Integer.parseInt(input1);
		int n2 = Integer.parseInt(input2);
		
		String result = "";
		
		result = add(n1, n2); 
		System.out.println(result);

		result = subtract(n1, n2);
		System.out.println(result);

		result = multiply(n1, n2);
		System.out.println(result);

		result = divide(n1, n2);
		System.out.println(result);

		result = mod(n1, n2);
		System.out.println(result);
		
		
	}//main

	public static String add(int n1, int n2) {
		
		int result = n1 + n2;
		String end = "n1 + n2 = " + result;
		
		return end;
		
	}
	
	public static String subtract(int n1, int n2) {
		
		int result = n1 - n2;
		String end = "n1 - n2 = " + result;
		
		return end;
	}
	
	public static String multiply(int n1, int n2) {
		
		int result = n1 * n2;
		String end = "n1 * n2 = " + result;
		
		return end;
	}
	
	public static String divide(int n1, int n2) {
		
		double result = (double)n1 / (double)n2;
		String end = "n1 / n2 = " + result;
		
		return end;
		
	}
	
	public static String mod(int n1, int n2) {
		
		int result = n1 % n2;
		String end = "n1 %% n2 = " + result;
		
		return end;
		
	}
	
}
