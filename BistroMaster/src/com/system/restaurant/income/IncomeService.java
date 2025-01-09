package com.system.restaurant.income;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
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
		}  else if (inSelect.equals("0")) {
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
			
		int lastDay = now.getActualMaximum(Calendar.DATE);
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
		int dayCounter = 0;
		
		for (int i=0; i<dayOfWeek - 1 ; i++) {
			System.out.print("\t\t"); 
			dayCounter++;
		}
	
		for (int i=1; i<=lastDay; i++) {
				
			System.out.printf("%3d\t\t", i);
			dayCounter++;
			
			if (dayCounter % 7 == 0 || i == lastDay) {

				System.out.println();
				
				for (int j = i- ((dayCounter - 1) % 7); j<= i; j++) {
					if ( j<= 0 ) {
						System.out.print("\t\t");
					} else {
						now.set(Calendar.DAY_OF_MONTH, j);
						String currentDate = String.format("%tF", now);
						if (( j - 1) < dailySalesList.size()) {
							if (dailySalesList.get(j-1).getDate().indexOf(currentDate) >= 0 ) {
								System.out.printf("%,d\t", dailySalesList.get(j-1).getDailySales());
							} else {
								System.out.print("\t");
							}
						} else {
							System.out.print("\t");
						}
					}
				}
				System.out.println();
				System.out.println("---------------------------------------------------------------------------------------------------------");
			} 
		}		
	}	

	

	
	public static void monthlySales() {//월 별 매출  - 지출 = 순수익
		
		Calendar now = Calendar.getInstance();
	    int nowMonth = now.get(Calendar.MONTH) + 1;
	    int month = 0;
	    int count = 0;
	    
	    for ( int i=1; i<=6; i++ ) {//첫 줄 월 표시
	    	month = nowMonth + i;
            if ( month == 13 ) {
            	month = 1;
            }
            
            System.out.printf("\t%d월\t", month); 
        }
	    
	    System.out.println();
	    System.out.println();
	    
		
		
		for (TotalSales s : tslist) {
			
			System.out.printf("\t%,d", s.getSales());
			count ++;
			if (count == 6) {
				break;
			}
			
		}
		
		System.out.println();
		
		count = 0;
		
		for (TotalExpense s : ExpenseService.telist) {
			
			System.out.printf("\t-%,d", s.getExpense());
			count ++;
			if (count == 6) {
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
        
        count = 0;
        
        for (TotalSales s : tslist) {
        	
        	count++;
            if (count <= 6) { 
            	continue;
            } else if (count > 6) {
            	System.out.printf("\t%,d", s.getSales());
            }
        }
        
               
        System.out.println();
        
        count = 0;
        
        for (TotalExpense s : ExpenseService.telist) {
        	
        	count++;
            if (count <= 6) { 
            	continue;
            } else if (count > 6) {
            	System.out.printf("\t-%,d", s.getExpense());
            }
        }
               
        
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------------");
		
        List<TotalExpense> sumList2 = new ArrayList<>();//임시로 넣기
        
        for (int i = 6; i < 12; i++) {
		  
		    int sumExpense = tslist.get(i).getSales() - ExpenseService.telist.get(i).getExpense();
		    sumList2.add(new TotalExpense(0, sumExpense, null));
		}

		System.out.print("순수익");
		
		for (TotalExpense s : sumList2) {
		    System.out.printf("\t%,d", s.getExpense());
		}
		
        System.out.println();
        System.out.println();
	}
	
	
	public static int dailySalesSum() {//당월 일 매출 더하기
		
		dailySalesLoad();
		
		int sumDailySales = 0;
		
		for (int i=0; i < dailySalesList.size(); i++) {
		
			int dailySales = dailySalesList.get(i).getDailySales();
			sumDailySales = sumDailySales +  dailySales;
		}
		
		return sumDailySales;
	}
		
	
	public static void recentMonthlySalesSave() {
	
		totalSalesLoad();
		
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String formattedDate = today.format(formatter);
		
		for (TotalSales totalSales : tslist)  {
			
			String[] preParts = totalSales.getDate().split("-");
			String preYear = preParts[0];
			String preMonth = preParts[1];
			
			String[] currentParts = formattedDate.split("-");
			String currentYear = currentParts[0];
			String currentMonth = currentParts[1];

			
			if(preMonth.equals(currentMonth) && preYear.equals(currentYear)) {
				totalSales.setSales(dailySalesSum());
				totalSales.setDate(formattedDate);
			} 
		}
		
		totalSalesLSave();
		
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//일매출 더미데이터 불러오기, load, save
	public static ArrayList<DailySales> dailySalesList;
	private final static String DAILYSALESPATH;
		
	static {
		DAILYSALESPATH = ".\\data\\메뉴&재고\\메뉴 총합 데이터.txt";
		dailySalesList = new ArrayList<>();	
	}
		
		
	public static void dailySalesLoad() {
	
		String line = null;
			
			
		try {
				
			BufferedReader reader = new BufferedReader(new FileReader(DAILYSALESPATH));
				
			//1,9000000,2025-01-01
			while ((line = reader.readLine()) != null) {
					
				String[] temp = line.split(",");
					
				DailySales dailySales = new DailySales(Integer.parseInt(temp[0])
														, temp[1]);
				
				dailySalesList.sort((n1, n2) -> n1.getDate().compareTo(n2.getDate()));
				dailySalesList.add(dailySales);
					
				}
			
				
				reader.close();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	
	public static void dailySalesSave() {

		dailySalesList.sort((n1, n2) -> n1.getDate().compareTo(n2.getDate()));	
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(DAILYSALESPATH));
			
			for (DailySales dailysales : dailySalesList) {
			
				//1,9000000,2025-01-01
				writer.write(String.format("%d,%s\r\n"
							, dailysales.getDailySales()
							, dailysales.getDate()
							));
			}
		
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	//월별 총매출 더미 데이터 불러오기, load, save
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
				tslist.sort((n1, n2) -> n1.getDate().compareTo(n2.getDate()));
				tslist.add(totalSales);
			}
				
			
			reader.close();
				
		} catch (Exception e) {
				
			e.printStackTrace();
				
		}
			
	}
	
	public static void totalSalesLSave() {

		tslist.sort((n1, n2) -> n1.getDate().compareTo(n2.getDate()));
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(TOTALSALESPATH));
			
			for (TotalSales totalSales : tslist) {
			
				//1,33180000,2025-01-01
				writer.write(String.format("%d,%d,%s\r\n"
							, totalSales.getNo()
							, totalSales.getSales()
							, totalSales.getDate()
							));
			}
		
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
