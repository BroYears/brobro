package com.test.java.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q7_Operator {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문자 입력: ");
		int input = reader.read();
		
		char result1 = input <= 90 ? (char)(input + 32) : (char)input;
		char result2 = input >= 91 ? (char)(input - 32) : (char)input;
		
		System.out.printf("소문자 '%s'의 대문자는 '%s'입니다.", result1, result2);
		
		
	}

}
