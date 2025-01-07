package com.system.restaurant.expense;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.system.restaurant.view.ExpenseView;
public class ExpenseService {

	public static void main(String[] args) {
		
	
		ExpenseView.expenseSelect();
		
	}



	
	public static void nonVariableExpense() {
		
		nonVariableExpenseLoad();
		
		for (NonVariableExpense s : nvlist) {
			System.out.printf("1. 월세\t\t%,d\t\t%s\r\n", s.getMonthlyRent(), s.getDate());
			System.out.printf("2. 인터넷\t%,d\t%s\r\n", s.getInternetFee(), s.getDate());
			System.out.printf("3. 인건비\t%,d\t%s\r\n", s.getCostOfLabor(), s.getDate());
		}
	}
	
	public static void variableExpense() {
	
		variableExpenseLoad();
		
		for (VariableExpense s : vlist) {
			System.out.printf("1. 수도\t\t%,d\t\t%s\r\n", s.getWaterTax(), s.getDate());
			System.out.printf("2. 전기\t\t%,d\t\t%s\r\n", s.getElectricityBill(), s.getDate());
			System.out.printf("3. 가스\t\t%,d\t\t%s\r\n", s.getGasBill(), s.getDate());
			System.out.printf("4. 재료\t\t%,d\t%s\r\n", s.getIngredient(), s.getDate());
			System.out.printf("5. 기타\t\t%,d\t\t%s\r\n", s.getDescripton(), s.getDate());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	//고정지출 더미 불러오기
	public static ArrayList<NonVariableExpense> nvlist;
	private final static String NONVEXPENSEPATH;
	
	static {
		NONVEXPENSEPATH = ".\\data\\월지출\\월 고정지출 더미 데이터.txt";
		nvlist = new ArrayList<>();	
	}
	

	public static void nonVariableExpenseLoad() {
		
		String line = null;
		
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(NONVEXPENSEPATH));
			
		//1,3000000,50000,15500000,2025-01-01
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
					
				NonVariableExpense nvExpense = new NonVariableExpense(Integer.parseInt(temp[0])
																	, Integer.parseInt(temp[1])
																	, Integer.parseInt(temp[2])
																	, Integer.parseInt(temp[3])
																	, temp[4]
																	);
				nvlist.add(nvExpense);
			}
			
			reader.close();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	//변동 지출 더미데이터 불러오기
	public static ArrayList<VariableExpense> vlist;
	private final static String VEXPENSEPATH;
	
	static {
		VEXPENSEPATH = ".\\data\\월지출\\월 변동지출 더미 데이터.txt";
		vlist = new ArrayList<>();	
	}
	
	
	public static void variableExpenseLoad() {
		
		String line = null;
		
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(VEXPENSEPATH));
			
			//1,300000,250000,150000,13800000,130000,2025-01-01
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				VariableExpense vExpense = new VariableExpense(Integer.parseInt(temp[0])
															, Integer.parseInt(temp[1])
															, Integer.parseInt(temp[2])
															, Integer.parseInt(temp[3])
															, Integer.parseInt(temp[4])
															, Integer.parseInt(temp[5])
															, temp[6]
																);
				vlist.add(vExpense);
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	//총 지출 데이터 불러오기
	public static ArrayList<TotalExpense> telist;
	private final static String TOTALEXPENSEPATH;
	
	static {
		TOTALEXPENSEPATH = ".\\data\\월지출\\월 별 총 지출 더미 데이터.txt";
		telist = new ArrayList<>();	
	}
	
	
	public static void totalExpenseLoad() {
		
		String line = null;
		
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(TOTALEXPENSEPATH));
			
			//1,33180000,2025-01-01
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				TotalExpense totalExpense = new TotalExpense(Integer.parseInt(temp[0])
															, Integer.parseInt(temp[1])
															, temp[2]
																);
				telist.add(totalExpense);
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
}




