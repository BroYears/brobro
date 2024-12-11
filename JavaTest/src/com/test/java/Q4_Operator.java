package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4_Operator {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("섭씨(℃): ");
		String input = reader.readLine();
		
		double temp = Double.parseDouble(input);
		
		double result = temp * 1.8 +32;
		
		System.out.printf("섭씨 %.1f℃는 화씨 %.1f℉입니다.", temp, result);
		
		
	}

}
