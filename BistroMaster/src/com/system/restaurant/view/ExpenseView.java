package com.system.restaurant.view;

import java.util.Calendar;
import java.util.Scanner;

import com.system.restaurant.expense.ExpenseService;

public class ExpenseView {

	public static void expenseSelect() {
		
		System.out.println("매출관리\r\n");
		System.out.println("\t1. 일별 매출");
		System.out.println("\t2. 월별 매출");
		System.out.println("\t3. 지출 내역확인");
		
		ExpenseService.selcetSalese();
		
	}
	
	public static void dailySelesCalendar() {
			
			Calendar c = Calendar.getInstance();
			c.set(Calendar.MONTH -1, 1);
			
			
			int lastDay = c.getActualMaximum(Calendar.DATE);
			int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

			System.out.println("\t\t\t일별 매출 ");				
			System.out.println("\t\t\t\t\t   단위: 원");
			System.out.println("---------------------------------------------------");
			System.out.println("일\t월\t화\t수\t목\t금\t토");
			System.out.println("---------------------------------------------------");
			
			for (int i=0; i<dayOfWeek - 1 ; i++) {
				System.out.print("\t"); 
			}
			
			for (int i=1; i<=lastDay; i++) {
				
				System.out.printf("%3d\t", i);
				
				if ((i + dayOfWeek - 1 ) % 7 == 0) {
					
					System.out.println();
	
			
				}

			}
			
			System.out.println();
			System.out.println("---------------------------------------------------");
			System.out.println("---------------------------------------------------");
			
	}
	
//	public static void monthlySelesCalendar() {
//		
//		Calendar c = Calendar.getInstance();
//		
//		int
//		
//
//	}
}
