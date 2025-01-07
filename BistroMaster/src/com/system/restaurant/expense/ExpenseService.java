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


	public static void selcetSales() {
		
		String inSelect = "";
		
		Scanner scan = new Scanner(System.in);
		inSelect = scan.nextLine();
		
		if (inSelect.equals("1")) {
			ExpenseView.dailySalesCalendar();
		} else if (inSelect.equals("2")) {
			ExpenseView.monthlySalesCalendar();
		} else if (inSelect.equals("3")) {
			ExpenseView.expeseList();
		} else if (inSelect.equals("0")) {
			//초기화면
			System.out.println("초기화면");
		} else {
			System.out.println("표기된 숫자만 입력해주세요.");
			selcetSales();
		}
	}
	
	
	public static void dailySales() {
		
		Calendar now = Calendar.getInstance();
		now.set(Calendar.DAY_OF_MONTH, 1);
		
		dailySalelsLoad();
			
		int lastDay = now.getActualMaximum(Calendar.DATE);
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
		int dayCounter = 0;
		
		for (int i=0; i<dayOfWeek - 1 ; i++) {
			System.out.print("\t"); 
			dayCounter++;
		}
	
		for (int i=1; i<=lastDay; i++) {
				
			System.out.printf("%3d\t", i);
			dayCounter++;
			
			if ((i + dayOfWeek - 1 ) % 7 == 0) {
				System.out.println();
				
				for (int j = i- ((dayCounter - 1) % 7); j<= i; j++) {
					if ( j<= 0 ) {
						System.out.println("");
					} else {
						now.set(Calendar.DAY_OF_MONTH, j);
						String currentDate = String.format("%tF", now);
						if (dailySalesList.get(j-1).getSalesDate().indexOf(currentDate) >= 0) {
							System.out.printf("%,d", dailySalesList.get(j-1).getDailySales());
						}
					}
				}
			}
		}
				
			
		}	

	
	
	
	
	
	public static void monthlySales() {//월 별 순수익
		
		Calendar now = Calendar.getInstance();
	    int nowMonth = now.get(Calendar.MONTH) + 1;
	    int month = 0;
	    
	    
	    
	    for ( int i=1; i<=6; i++ ) {//첫 줄 월 표시
	    	month = nowMonth + i;
            if ( month == 13 ) {
            	month = 1;
            }
            System.out.printf("\t%d월\t", month); 
        }
	    
	    System.out.println();
	    System.out.println();
	    
		
		totalExpenseLoad();
		totalSalesLoad();
		
		
		for (TotalSales s : tslist) {
			
			System.out.printf("\t%,d", s.getSales());
			if (s.getNo() == 6) {
				break;
			}
		}
		
		System.out.println();
		
		for (TotalExpense s : telist) {
			
			System.out.printf("\t-%,d", s.getExpense());
			if (s.getNo() == 6) {
				break;
			}
		}
	    
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------------------");
	    
		List<TotalExpense> sumList = new ArrayList<>();
		
		
		for (int i = 0; i < 6; i++) {
		    int no = tslist.get(i).getNo();
		    int sumExpense = tslist.get(i).getSales() - telist.get(i).getExpense();
		    sumList.add(new TotalExpense(no, sumExpense, null));
		}
		
		System.out.print("순수익");
		
		for (TotalExpense s : sumList) {
		    System.out.printf("\t%,d", s.getExpense());
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------------------");
		
		
		
        for ( int i=7; i<=11; i++ ) {//둘 째줄 월 표시
        	month = nowMonth + i;
        	if (month == 13) {
        		month = 1;
        	}
            System.out.printf("\t%d월\t", month);
            
        }
        System.out.printf("\t%d월", nowMonth);
        
        System.out.println();
        System.out.println();
        
        for (TotalSales s : tslist) {
        	
            if (s.getNo() <= 6) { 
            	continue;
            } else if (s.getNo() > 6) {
            	System.out.printf("\t%,d", s.getSales());
            }
        }
        
        System.out.println();
        
        for (TotalExpense s : telist) {
        	
            if (s.getNo() <= 6) { 
            	continue;
            } else if (s.getNo() > 6) {
            	System.out.printf("\t-%,d", s.getExpense());
            }
        }
        
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------------");
		
        List<TotalExpense> sumList2 = new ArrayList<>();
        
        for (int i = 6; i < 12; i++) {
		    int no = tslist.get(i).getNo();
		    int sumExpense = tslist.get(i).getSales() - telist.get(i).getExpense();
		    sumList2.add(new TotalExpense(no, sumExpense, null));
		}

		System.out.print("순수익");
		
		for (TotalExpense s : sumList2) {
		    System.out.printf("\t%,d", s.getExpense());
		}
		
        System.out.println();
        System.out.println();
	}
	
	
	
	
	
	
	
	public static void returnSales() {
		
		Scanner scan = new Scanner(System.in);
		String returnMenu = scan.nextLine();
		
		if ( returnMenu.equals("1")) {
			ExpenseView.expenseSelect();
		} else if (returnMenu.equals("0")) {
			//초기화면
			System.out.println("초기화면");
		} else {
			System.out.println("1 또는 0을 입력해주세요.");
			ExpenseService.returnSales();
		}
		
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//일매출 더미데이터 불러오기
	public static ArrayList<DailySales> dailySalesList;
	private final static String DAILYSALESPATH;
	
	static {
		DAILYSALESPATH = ".\\data\\일매출\\" + (Calendar.getInstance().get(Calendar.MONTH) + 1) + "월 일매출 더미 데이터.txt";
		dailySalesList = new ArrayList<>();	
	}
	
	
	public static void dailySalelsLoad() {
	
		String line = null;
		
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(DAILYSALESPATH));
			
			//1,9000000,2025-01-01
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
					
				DailySales dailySales = new DailySales(Integer.parseInt(temp[0])
													, Integer.parseInt(temp[1])
													, temp[2]);
				dailySalesList.add(dailySales);
				
			}
			
			
			reader.close();
				
		} catch (Exception e) {
			e.printStackTrace();
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
	
	public static ArrayList<TotalSales> tslist;
	private final static String TOTALSALESPATH;
	
	static {
		TOTALSALESPATH = ".\\data\\월매출\\2025월매출 더미 데이터.txt";
		tslist = new ArrayList<>();	
	}
	
	
	public static void totalSalesLoad() {
		
		String line = null;
		
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(TOTALSALESPATH));
			
			//1,33180000,2025-01-01
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				TotalSales totalSales = new TotalSales(Integer.parseInt(temp[0])
														, Integer.parseInt(temp[1])
														, temp[2]
														);
				tslist.add(totalSales);
			}
			
			reader.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	
	
	
}




