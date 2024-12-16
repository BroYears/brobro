package com.test.java;

import java.util.Calendar;

public class Ex28_Calendar {
	
	public static void main(String[] args) {
		
		int year = 2024;
		int month = 12;
		
		pintCalendar(year, month);
	
		//59. 수열 > 게으른 급사의 수열
		//60. 수열 > 피보나치 수열
		
	}

	private static void pintCalendar(int year, int month) {
		
		Calendar c1 = Calendar.getInstance();
		c1.set(year, month -1, 1);
		
		
		int lastDay = c1.getActualMaximum(Calendar.DATE);
		int dayOfWeek = c1.get(Calendar.DAY_OF_WEEK);
		System.out.println(dayOfWeek);
		
		System.out.println("===================================================================");
		System.out.printf(                             "%d년 %02d월\n", year, month);
		System.out.println("===================================================================");
		System.out.println("[일]\t[월]\t[화]\t[수]\t[목]\t[금]\t[토]");
		
		//System.out.print("\t\t\t\t\t");
		for (int i=0; i<dayOfWeek; i++) {
			System.out.print("\t"); 
			
		}
		
		for (int i=1; i<=lastDay; i++) {
			
			System.out.printf("%3d\t", i);
			
			if ((i + dayOfWeek) % 7 == 0) {
			//if ((i+ dayOfWeek) % 7 == 0 ) {	
				System.out.println();
			}
			
		}
		
	}

}
