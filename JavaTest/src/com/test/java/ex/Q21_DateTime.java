package com.test.java.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q21_DateTime {
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		Calendar now = Calendar.getInstance();
		
		System.out.print("태어난 년도: ");
		String birth = reader.readLine();
		
		int year = Integer.parseInt(birth);
		
		System.out.printf("나이: %d세", now.get(Calendar.YEAR) - year + 1 );
	
	
	}//main
		

}
