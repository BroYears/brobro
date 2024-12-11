package com.test.java;

import java.util.Calendar;

public class Q20_DateTime {
	
	public static void main(String[] args) {
	
		Calendar now = Calendar.getInstance();
		
		now.add(Calendar.DATE, 99);
		System.out.printf("백일: %tF\n", now);
		
		now = Calendar.getInstance();
		
		now.add(Calendar.YEAR, 1);
		System.out.printf("첫돌: %tF\n", now);
		
	}
	
	
	

}
