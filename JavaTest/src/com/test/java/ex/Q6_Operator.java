package com.test.java.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q6_Operator {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("한 달 수입 금액(원): ");
		String input = reader.readLine();
		
		int money1 = Integer.parseInt(input);
		
		
		int money2 = money1 * 33/1000;
		int result = money1 - money2;
		
		System.out.printf("세후 금액(원): %,d원\n", result);
		System.out.printf("세금(원): %,d원\n", money2);
		
		
	}

}
