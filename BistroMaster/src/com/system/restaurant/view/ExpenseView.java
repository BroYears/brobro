package com.system.restaurant.view;

import java.util.Calendar;
import java.util.Scanner;

import com.system.restaurant.expense.ExpenseService;
import com.system.restaurant.expense.VariableExpense;
import com.system.restaurant.income.DailySales;
import com.system.restaurant.income.IncomeService;

public class ExpenseView {
	public static void dailySalesCalendar() {
		
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		while (loop) {
		
			System.out.println("\t\t\t\t\t\t일별 매출 ");				
			System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t단위: 원");
			System.out.println("---------------------------------------------------------------------------------------------------------");
			System.out.println("일\t\t월\t\t화\t\t수\t\t목\t\t금\t\t토");
			System.out.println("---------------------------------------------------------------------------------------------------------");
		
			IncomeService.dailySales();
			
			System.out.println();
			System.out.println("---------------------------------------------------------------------------------------------------------");
			System.out.println("---------------------------------------------------------------------------------------------------------");
			
			System.out.println("이전 화면: 0번");
			System.out.print("입력: ");
			
			String returnMenu = scan.nextLine();
			
			if (returnMenu.equals("0")) {
				//초기화면
				loop = false;
			} else {
				System.out.println("0을 입력해주세요.");
			}
		
		}
			
	}
	
	public static void monthlySalesCalendar() {
		
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		
		while (loop) {
		
			System.out.println("\t\t\t\t\t월별 매출");
			System.out.println();
			System.out.println("\t\t\t\t\t\t\t\t\t\t\t단위: 원");
			System.out.println("-----------------------------------------------------------------------------------------------------");
			
			IncomeService.monthlySales();
			
			System.out.println("-----------------------------------------------------------------------------------------------------");
			System.out.println("-----------------------------------------------------------------------------------------------------");
		
			System.out.println("이전 화면: 0번");
			System.out.print("입력: ");
			String returnMenu = scan.nextLine();
		
			if (returnMenu.equals("0")) {
				//초기화면
				loop = false;
			} else {
				System.out.println("0을 입력해주세요.");
			}
	
		}
	
	}




	public static void expenseList() {
		
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		while (loop) {
			
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
		
			System.out.println("이전 화면: 0번");
			System.out.print("입력: ");
			String returnMenu = scan.nextLine();
		
			if (returnMenu.equals("0")) {
				//초기화면
				loop = false;
			} else {
				System.out.println("0을 입력해주세요.");
			}

		}
		
		
	}
		
	public static void editSelct() {
		System.out.println("입력: 1\r\n수정: 2");
		System.out.println("입력 또는 수정하시려면 번호를 입력해주세요.");
		
	}
		
	
	public static void pause() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		
		System.out.println("계속하려면 엔터를 입력하세요.");
		scan.nextLine();
	}
	
	
	
	
}




	



