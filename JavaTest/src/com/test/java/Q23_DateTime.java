package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q23_DateTime {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("아빠 생일(년): ");
		String fatherYearIn = reader.readLine();

		System.out.print("아빠 생일(월): ");
		String fatherMonthIn = reader.readLine();

		System.out.print("아빠 생일(일): ");
		String fatherDateIn = reader.readLine();

		System.out.print("딸 생일(년): ");
		String dauYearIn = reader.readLine();

		System.out.print("딸 생일(월): ");
		String dauMonthIn = reader.readLine();

		System.out.print("딸 생일(일): ");
		String dauDateIn = reader.readLine();
		
		int fatherYear = Integer.parseInt(fatherYearIn);
		int fatherMonth = Integer.parseInt(fatherMonthIn);
		int fatherDate = Integer.parseInt(fatherDateIn);
		int dauYear = Integer.parseInt(dauYearIn);
		int dauMonth = Integer.parseInt(dauMonthIn);
		int dauDate = Integer.parseInt(dauDateIn);
		
		Calendar fatherbirth = Calendar.getInstance();
		Calendar daubirth = Calendar.getInstance();
		
		fatherbirth.set(fatherYear, fatherMonth, fatherDate);
		daubirth.set(dauYear, dauMonth, dauDate);
		
		long gap = daubirth.getTimeInMillis() - fatherbirth.getTimeInMillis();
		
		System.out.printf("아빠는 딸보다 총 %,d일을 더 살았습니다.", gap / 1000 / 60 / 60 / 24);
		
	}//main

}