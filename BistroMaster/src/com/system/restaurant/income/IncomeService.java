package com.system.restaurant.income;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import com.system.restaurant.expense.ExpenseService;
import com.system.restaurant.expense.TotalExpense;
import com.system.restaurant.view.ExpenseView;

public class IncomeService {

	public static void selcetSales() {
		
		String inSelect = "";
		
		Scanner scan = new Scanner(System.in);
		inSelect = scan.nextLine();
		
		if (inSelect.equals("1")) {
			ExpenseView.dailySalesCalendar();
		} else if (inSelect.equals("2")) {
			ExpenseView.monthlySalesCalendar();
		} else if (inSelect.equals("3")) {
			ExpenseView.expenseList();
		} else if (inSelect.equals("4")) {
			ExpenseView.expenseEdit();
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
			
			if (dayCounter % 7 == 0 || i == lastDay) {

				System.out.println();
				
				for (int j = i- ((dayCounter - 1) % 7); j<= i; j++) {
					if ( j<= 0 ) {
						System.out.print("\t");
					} else {
						now.set(Calendar.DAY_OF_MONTH, j);
						String currentDate = String.format("%tF", now);
						if (dailySalesList.get(j-1).getSalesDate().indexOf(currentDate) >= 0) {
							System.out.printf("%,d\t", dailySalesList.get(j-1).getDailySales());
						} else {
							System.out.print("\t");
						}
					}
				}
				
				System.out.println();
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
	    
		
		ExpenseService.totalExpenseLoad();
		totalSalesLoad();
		
		
		for (TotalSales s : tslist) {
			
			System.out.printf("\t%,d", s.getSales());
			if (s.getNo() == 6) {
				break;
			}
		}
		
		System.out.println();
		
		for (TotalExpense s : ExpenseService.telist) {
			
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
		    int sumExpense = tslist.get(i).getSales() - ExpenseService.telist.get(i).getExpense();
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
        
        for (TotalExpense s : ExpenseService.telist) {
        	
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
		    int sumExpense = tslist.get(i).getSales() - ExpenseService.telist.get(i).getExpense();
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
			returnSales();
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
