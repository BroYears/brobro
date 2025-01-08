package com.system.restaurant.view;

import java.util.Calendar;
import java.util.Scanner;

import com.system.restaurant.expense.ExpenseService;
import com.system.restaurant.expense.VariableExpense;
import com.system.restaurant.income.DailySales;
import com.system.restaurant.income.IncomeService;

public class ExpenseView {

	public static void expenseSelect() {
		
		System.out.println("매출관리\r\n");
		System.out.println("\t1. 일별 매출");
		System.out.println("\t2. 월별 매출");
		System.out.println("\t3. 지출 내역확인");
		
		IncomeService.selcetSales();
		
	}
	
	
	
	
	public static void dailySalesCalendar() {
			

		System.out.println("\t\t\t\t\t\t일별 매출 ");				
		System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t단위: 원");
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println("일\t\t월\t\t화\t\t수\t\t목\t\t금\t\t토");
		System.out.println("---------------------------------------------------------------------------------------------------------");
		
		IncomeService.dailySales();
			
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------------------------------");
			
		IncomeService.returnSales();		
			
	}
	
	public static void monthlySalesCalendar() {
		
		System.out.println("\t\t\t\t\t월별 매출");
		System.out.println();
		System.out.println("\t\t\t\t\t\t\t\t\t\t\t단위: 원");
		System.out.println("-----------------------------------------------------------------------------------------------------");
		IncomeService.monthlySales();
			
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------");
		
		IncomeService.returnSales();
	}




	public static void expenseList() {
		
		
		System.out.println("\t\t지출 내역 확인");
		System.out.println("\t\t\t\t\t   단위: 원");
		System.out.println("---------------------------------------------------");
		System.out.printf("%d월 지출\r\n", (Calendar.getInstance().get(Calendar.MONTH) + 1));
		System.out.println("---------------------------------------------------");
		System.out.println("1. 고정 지출");
		ExpenseService.nonVariableExpense();
		System.out.println("---------------------------------------------------");
		System.out.println("2. 변동 지출");
		ExpenseService.variableExpense();
		System.out.println("---------------------------------------------------");
		System.out.println("입력 또는 수정하시려면 번호를 입력해주세요.");
		System.out.println("게속하시려면 다른 키를 입력해주세요.");
		System.out.println("---------------------------------------------------");
		ExpenseService.inExpense();
		
		
	}
		
	public static void editSelct() {
		System.out.println("입력: 1\r\n수정: 2");
		System.out.println("입력 또는 수정하시려면 번호를 입력해주세요.");
		
	}
		
	
	
	
	
	
	
}


	



