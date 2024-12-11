package com.test.java;

import java.util.Calendar;

public class Q19_DateTime {
	
	
	public static void main(String[] args) {
		
		nowTime();
		
	}

	private static void nowTime() {
		
		
		Calendar now = Calendar.getInstance();
		
		System.out.printf("현재 시간: %d시 %d분 %d초\n",
							now.get(Calendar.HOUR_OF_DAY),
							now.get(Calendar.MINUTE),
							now.get(Calendar.SECOND));
		System.out.printf("현재 시간: %s %d시 %d분 %d초",
				now.get(Calendar.AM_PM) == 1 ? "오후" : "오전",
				now.get(Calendar.HOUR_OF_DAY),
				now.get(Calendar.MINUTE),
				now.get(Calendar.SECOND));
		
	}

}
