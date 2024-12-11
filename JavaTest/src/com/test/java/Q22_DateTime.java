package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q22_DateTime {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("남자 이름: ");
		String maleName = reader.readLine();
		
		System.out.print("여자 이름: ");
		String femaleName = reader.readLine();
		
		System.out.print("만난날(년): ");
		String firstYear = reader.readLine();
		
		System.out.print("만난날(월): ");
		String firstMonth = reader.readLine();
		
		System.out.print("만난날(일): ");
		String firstDay = reader.readLine();
		
		int year = Integer.parseInt(firstYear);
		int month = Integer.parseInt(firstMonth);
		int day = Integer.parseInt(firstDay);
		
		Calendar first = Calendar.getInstance();
		first.set(year, month - 1, day);
		
		System.out.printf("'%s'과(와) '%s'의 기념일\n", maleName, femaleName);
		
		
		first.add(first.get(Calendar.DATE), 99);
		System.out.printf("100일: %tF\n", first);
		
		first = Calendar.getInstance();
		
		first.add(first.get(Calendar.DATE), 199);
		System.out.printf("200일: %tF\n", first);
		
		first = Calendar.getInstance();
		
		first.add(first.get(Calendar.DATE), 299);
		System.out.printf("300일: %tF\n", first);
		
		first = Calendar.getInstance();
		
		first.add(first.get(Calendar.DATE), 499);
		System.out.printf("500일: %tF\n", first);
		
		first = Calendar.getInstance();
		
		first.add(first.get(Calendar.DATE), 999);
		System.out.printf("1000일: %tF", first);
		
	}

}
