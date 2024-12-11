package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1_Operator {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("태어난 년도 : ");
		String birth = reader.readLine(); 
		
		int year = Integer.parseInt(birth);
		
		int age = 2024 - year;
		
		System.out.printf("나이 : %d세", age);
		
	}
	

}
