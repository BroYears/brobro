package com.test.java.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Q12_Method {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String result = "";
		int n = 0;
		
		System.out.print("숫자: ");
		String input = reader.readLine();
		
		n = Integer.parseInt(input);
		
		
		result = getNumber(n); 
		System.out.printf("입력하신 숫자 '%d'는(은) '%s'입니다.\n", n, result);
		
	}

	public static String getNumber(int n) {
		
		String result = n % 2 == 0 ? "짝수" : "홀수";
		
		return result;

	}
	
}
