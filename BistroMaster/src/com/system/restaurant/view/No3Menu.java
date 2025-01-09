package com.system.restaurant.view;

import java.util.Scanner;

import com.system.restaurant.expense.ExpenseService;
import com.system.restaurant.income.IncomeService;
import com.system.restaurant.menu.MenuService;
import com.system.restaurant.menu.OrderService;

public class No3Menu {
	public static void loadNum3() {
		
		ExpenseService.recentDailyExpenseSumSave();
		IncomeService.recentMonthlySalesSave();
		ExpenseService.totalExpenseLoad();
		ExpenseService.nonVariableExpenseLoad();
		ExpenseService.variableExpenseLoad();
		
		
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		while (loop) {
		Sub_Menus_Temp.makeSubTitle("매출관리", 10);
		Sub_Menus_Temp.makeSubCategory("1. 일별 매출", 10);
		Sub_Menus_Temp.makeSubCategory("2. 월별 매출", 10);
		Sub_Menus_Temp.makeSubCategory("3. 지출 내역확인", 12);

		System.out.println("일별 매출: 1번 | 월별 매출: 2번 | 지출 내역확인: 3번 | 초기화: 0번");
		System.out.print("입력: ");
		int sel = scan.nextInt();

			switch (sel) {
				case 1: {
					ExpenseView.dailySalesCalendar();
					break;
				}
				case 2: {
					ExpenseView.monthlySalesCalendar();
					break;
				}
				case 3: {
					ExpenseView.expenseList();
					break;
				}
				case 0: {
					loop = false;
					break;
				}
				default: {
					System.out.println("잘못된 번호입니다.");
				}
			}
		}
	

	}
}
