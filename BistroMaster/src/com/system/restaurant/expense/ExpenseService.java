package com.system.restaurant.expense;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.system.restaurant.view.ExpenseView;

public class ExpenseService {

	public static void main(String[] args) {
		
		
		ExpenseView.expenseSelect();
		
	}


	public static void selcetSalese() {
		
		String inSelect = "";
		
		Scanner scan = new Scanner(System.in);
		inSelect = scan.nextLine();
		
		if (inSelect.equals("1")) {
			ExpenseView.dailySelesCalendar();
		} else if (inSelect.equals("2")) {
			
		} else if (inSelect.equals("3")) {
			
		} else if (inSelect.equals("0")) {
			
		} else {
			
		}
		

	}
	

	
	
	
	
	
	
	//일매출 더미데이터 불러오기
	public static ArrayList<VariableExpense> dailySalesList;
	private final static String DAILYSALESPATH;
	
	
	static {
		DAILYSALESPATH = ".\\data\\" + Calendar.MONTH + "월 일매출 더미데이터.txt";
		dailySalesList = new ArrayList<>();
	}
	
	
	
}
