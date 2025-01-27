package com.system.restaurant.expense;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.system.restaurant.income.IncomeService;
import com.system.restaurant.income.TotalSales;
import com.system.restaurant.view.ExpenseView;
public class ExpenseService {

	
	public static void nonVariableExpense() {
		
		
		System.out.printf("- 인터넷\t\t%,d\t\t%s\r\n", nvlist.get(0).getInternetFee(), nvlist.get(0).getDate());
		System.out.printf("- 월세\t\t%,d\t%s\r\n", nvlist.get(0).getMonthlyRent(), nvlist.get(0).getDate());
		System.out.printf("- 인건비\t\t%,d\t%s\r\n", nvlist.get(0).getCostOfLabor(), nvlist.get(0).getDate());
		System.out.println("---------------------------------------------------");
		System.out.printf("- 총합\t\t%,d\r\n", nvlist.get(0).getInternetFee() + nvlist.get(0).getMonthlyRent() + nvlist.get(0).getCostOfLabor());
		

	}
	
	public static void variableExpense() {
	
		
		System.out.printf("- 수도\t\t%,d\t\t%s\r\n", vlist.get(0).getWaterTax(), vlist.get(0).getDate());
		System.out.printf("- 전기\t\t%,d\t\t%s\r\n", vlist.get(0).getElectricityBill(), vlist.get(0).getDate());
		System.out.printf("- 가스\t\t%,d\t\t%s\r\n", vlist.get(0).getGasBill(), vlist.get(0).getDate());
		System.out.printf("- 재료\t\t%,d\t%s\r\n", vlist.get(0).getIngredient(), vlist.get(0).getDate());
		System.out.printf("- 기타\t\t%,d\t\t%s\r\n", vlist.get(0).getDescripton(), vlist.get(0).getDate());
		System.out.println("---------------------------------------------------");
		System.out.printf("- 총합\t\t%,d\r\n", vlist.get(0).getWaterTax() + vlist.get(0).getElectricityBill() + vlist.get(0).getGasBill() + vlist.get(0).getIngredient() + vlist.get(0).getDescripton());
		
	}
	
	
	public static void inExpense() {
		
		String defaultInternetFee = "5000";
		String defaultMonthlyRent = "5000";
		String defaultCostOfLabor = "5000";//기본값 가져올거

		
		Scanner scan = new Scanner(System.in);
		String inExSelect = scan.nextLine();
		
		
		if (inExSelect.equals("1")) {
			ExpenseView.editSelct();
			String select = scan.nextLine();
			
			if (select.equals("1")) {
				
				String internetFee = "";
				String monthlyRent = "";
				String costOfLabor = "";
				String date = "";
				
				while(true) {
					System.out.print("인터넷: ");
					internetFee = scan.nextLine();
		
					if (internetFee.isEmpty()) {
						internetFee = defaultInternetFee;//기본값
						break;
					} 
					
					if (isNumeric(internetFee)){
						break;
					} else {
						System.out.println("숫자를 입력하세요.");
						continue;
					}
				}
				
				while(true) {
					System.out.print("월세: ");
					monthlyRent = scan.nextLine();
		
					if (monthlyRent.isEmpty()) {
						monthlyRent = defaultMonthlyRent;//기본값
						break;
					} 
					
					if (isNumeric(monthlyRent)){
						break;
					} else {
						System.out.println("숫자를 입력하세요.");
						continue;
					}
				}
				
				while(true) {
					System.out.print("인건비: ");
					costOfLabor = scan.nextLine();
		
					if (costOfLabor.isEmpty()) {
						costOfLabor = defaultCostOfLabor;//기본값
						break;
					} 
					
					if (isNumeric(costOfLabor)){
						break;
					} else {
						System.out.println("숫자를 입력하세요.");
						continue;
					}
				}
				
				while(true) {
					System.out.print("날짜: ");
					date = scan.nextLine();
		
					
					boolean sameCheck = false;
					
					if (isValidFormat(date)) {
						for (NonVariableExpense m : nvlist) {
							
							String[] preParts = m.getDate().split("-");
							String preYear = preParts[0];
							String preMonth = preParts[1];
							
							String[] inParts = date.split("-");
							String year = inParts[0];
							String month = inParts[1];

							
							if(preMonth.equals(month) && preYear.equals(year)) {
								System.out.println("같은 달이 있습니다.\r\n수정해주세요.");
								sameCheck = true;
								break;
							} 
						} 
						if(sameCheck) {
							continue;
						}
					} else {
						System.out.println("0000-00-00의 형식으로 입력해 주세요.");
						continue;
					}
					break;
					
				}
				
				int no = getNonVariableExpenseMaxNo() + 1;
				
				
				nvlist.add(new NonVariableExpense(no
												, Integer.parseInt(internetFee)
												, Integer.parseInt(monthlyRent) 
												, Integer.parseInt(costOfLabor) 
												, date));
				
				System.out.println();
				System.out.println("고정지출 입력이 완료되었습니다.");
				
				nonVariableExpenseSave();
				totalMonthlyExpense();
				
			} else if (select.equals("2")) {//고정 지출 수정
				
				String internetFee = "";
				String monthlyRent = "";
				String costOfLabor = "";
				String date = "";
				String enterDate = "";
				
				while(true) {
					
					System.out.print("수정 날짜:");
					date = scan.nextLine();
					
					if (isValidFormat(date)) {
						
						int count = 0;
						
						for (NonVariableExpense m : nvlist) {
							
							if(m.getDate().equals(date)) {
								break;
							}else {
								if ((nvlist.size() - 1 ) == count) {
									System.out.println("해당 날짜는 존재하지 않습니다.");
									System.out.print("수정 날짜: ");
									date = scan.nextLine();
								}
							}
							count++;
						}
						
						while(true) {
							
							System.out.print("인터넷: ");
							internetFee = scan.nextLine();
				
							if (internetFee.isEmpty()) {
								break;
							} 
							
							if (isNumeric(internetFee)){
								break;
							} else {
								System.out.println("숫자를 입력하세요.");
								continue;
							}
						}
						
						while(true) {
							System.out.print("월세: ");
							monthlyRent = scan.nextLine();
				
							if (monthlyRent.isEmpty()) {
								break;
							} 
							
							if (isNumeric(monthlyRent)){
								break;
							} else {
								System.out.println("숫자를 입력하세요.");
								continue;
							}
						}
						
						while(true) {
							System.out.print("인건비: ");
							costOfLabor = scan.nextLine();
				
							if (monthlyRent.isEmpty()) {
								break;
							} 
							
							if (isNumeric(monthlyRent)){
								break;
							} else {
								System.out.println("숫자를 입력하세요.");
								continue;
							}
						}
						
								
						while(true) {//날짜
							
							System.out.print("날짜: ");
							enterDate = scan.nextLine();
				
							if (enterDate.equals("")) {
								break;
							}
							
							if (isValidFormat(enterDate)) {
								break;
							} else {
								System.out.println("0000-00-00의 형식으로 입력해 주세요.");
								continue;
							}
						}
						
						
						for (NonVariableExpense m : nvlist) {
							
							if (m.getDate().equals(date)) {
								
								if (!internetFee.isEmpty()) {
									m.setInternetFee(Integer.parseInt(internetFee));
								}
								
								if (!monthlyRent.isEmpty()) {
									m.setMonthlyRent(Integer.parseInt(monthlyRent));
								}
								
								if (!costOfLabor.isEmpty()) {
									m.setCostOfLabor(Integer.parseInt(costOfLabor));
								}
								
								if (!date.isEmpty()) {
									m.setDate(date);
								}
							}
						}

						break;
						
					} else {
						System.out.println("0000-00-00의 형식으로 입력해 주세요.");
						continue;
					}
				}
				
				System.out.println();
				System.out.println("고정지출 수정이 완료되었습니다.");
				
				nonVariableExpenseSave();
				totalMonthlyExpense();
			} 				
		} else if (inExSelect.equals("2")) {//변동 지출 입력, 수정
			ExpenseView.editSelct();
			String select = scan.nextLine();
			
				if (select.equals("1")) {//변동 지출 입력
				
				String waterTax = "";
				String elecelectricityBill = "";
				String gasBill = "";
				String ingredient = "";
				String descripton = "";
				String date = "";
				
				while(true) {
					System.out.print("수도: ");
					waterTax = scan.nextLine();
		
					if (isNumeric(waterTax)){
						
						break;
					} else {
						System.out.println("숫자를 입력하세요.");
						continue;
					}
				}
				
				while(true) {
					System.out.print("전기: ");
					elecelectricityBill = scan.nextLine();
		
					if (isNumeric(elecelectricityBill)){
						break;
					} else {
						System.out.println("숫자를 입력하세요.");
						continue;
					}
				}
				
				while(true) {
					System.out.print("가스: ");
					gasBill = scan.nextLine();
		
					if (isNumeric(gasBill)){
						break;
					} else {
						System.out.println("숫자를 입력하세요.");
						continue;
					}
				}
				
				while(true) {//재료비
					System.out.print("재료비: ");
					ingredient = scan.nextLine();
					
					if (isNumeric(ingredient)){
						break;
					} else {
						System.out.println("숫자를 입력하세요.");
						continue;
					}
				}
				
				while(true) {//기타
					System.out.print("기타: ");
					descripton = scan.nextLine();
										
					if (isNumeric(descripton)){
						break;
					} else {
						System.out.println("숫자를 입력하세요.");
						continue;
					}
				}
				
				while(true) {//날짜
					System.out.print("날짜: ");
					date = scan.nextLine();
		
					if (isValidFormat(date)) {
						
						boolean sameCheck = false;
						
						for (VariableExpense m : vlist) {
							
							String[] preParts = m.getDate().split("-");
							String preYear = preParts[0];
							String preMonth = preParts[1];
								
							String[] inParts = date.split("-");
							String year = inParts[0];
							String month = inParts[1];

								
							if(preMonth.equals(month) && preYear.equals(year)) {
								System.out.println("같은 달이 있습니다.\r\n수정해주세요.");
								sameCheck = true;
								break;
							} 
						} 
						
						if(sameCheck) {
							continue;
						}
						
						break;
					} else {
						System.out.println("0000-00-00의 형식으로 입력해 주세요.");
						continue;
					}
				}
				
				int no = getVariableExpenseMaxNo() + 1;
				
				
				vlist.add(new VariableExpense(no
												, Integer.parseInt(waterTax)
												, Integer.parseInt(elecelectricityBill) 
												, Integer.parseInt(gasBill) 
												, Integer.parseInt(ingredient) 
												, Integer.parseInt(descripton) 
												, date));
				
				System.out.println();
				System.out.println("변동지출 입력이 완료되었습니다.");
				
				variableExpenseSave();
				totalMonthlyExpense();
				
			} else if (select.equals("2")) {//변동 지출 수정
				
				String waterTax = "";
				String elecelectricityBill = "";
				String gasBill = "";
				String ingredient = "";
				String descripton = "";
				String date = "";
				String enterDate = "";
				
				while(true) {
					
					System.out.print("수정 날짜: ");
					date = scan.nextLine();
					
					
					if (isValidFormat(date)) {
						
						int count = 0;
						
						for (VariableExpense m : vlist) {//유효성 검사
							
							if(m.getDate().equals(date)) {
								break;
							}else {
								if ((vlist.size() - 1 ) == count) {
									System.out.println("해당 날짜는 존재하지 않습니다.");
									System.out.print("수정 날짜: ");
									date = scan.nextLine();
								}
							}
							count++;
						}
						
						while(true) {
							System.out.print("수도: ");
							waterTax = scan.nextLine(); //변경값
				
							if (waterTax.isEmpty()) {
								break;
							}
							
							if (isNumeric(waterTax)){
								break;
							} else {
								System.out.println("숫자를 입력하세요.");
								continue;
							}
						}
						
						while(true) {
							System.out.print("전기: ");
							elecelectricityBill = scan.nextLine();
							
							if (elecelectricityBill.isEmpty()) {
								break;
							}
				
							if (isNumeric(elecelectricityBill)){
								break;
							} else {
								System.out.println("숫자를 입력하세요.");
								continue;
							}
						}
						
						while(true) {
							System.out.print("가스: ");
							gasBill = scan.nextLine();
							
							if (gasBill.isEmpty()) {
								break;
							}
				
							if (isNumeric(gasBill)){
								break;
							} else {
								System.out.println("숫자를 입력하세요.");
								continue;
							}
						}
						
						while(true) {//재료비
							System.out.print("재료비: ");
							ingredient = scan.nextLine();
							
							if (ingredient.isEmpty()) {
								break;
							}
							
							if (isNumeric(ingredient)){
								break;
							} else {
								System.out.println("숫자를 입력하세요.");
								continue;
							}
						}
						
						while(true) {//기타
							System.out.print("기타: ");
							descripton = scan.nextLine();
								
							if (descripton.isEmpty()) {
								break;
							}
							
							if (isNumeric(descripton)){
								break;
							} else {
								System.out.println("숫자를 입력하세요.");
								continue;
							}
						}
						
						
						
						while(true) {//날짜
							
							System.out.print("날짜: ");
							enterDate = scan.nextLine();
				
							if (enterDate.equals("")) {
								break;
							}
							
							if (isValidFormat(enterDate)) {
								break;
							} else {
								System.out.println("0000-00-00의 형식으로 입력해 주세요.");
								continue;
							}
						}
						
						for (VariableExpense m : vlist) {
							
							if (m.getDate().equals(date)) {
								
								if (!waterTax.isEmpty()) {
									m.setWaterTax(Integer.parseInt(waterTax));
								}
								
								if (!elecelectricityBill.isEmpty()) {
									m.setElectricityBill(Integer.parseInt(elecelectricityBill));
								}
								
								if (!gasBill.isEmpty()) {
									m.setGasBill(Integer.parseInt(gasBill));
								}
								
								if (!ingredient.isEmpty()) {
									m.setIngredient(Integer.parseInt(ingredient));
								}
								
								if (!descripton.isEmpty()) {
									m.setDescripton(Integer.parseInt(descripton));
								}
								
								if (!enterDate.isEmpty()) {
									m.setDate(enterDate);
								}
							}
						}
						
						break;
						
					} else {
						System.out.println("0000-00-00의 형식으로 입력해 주세요.");
						continue;
					}
				}
				
				System.out.println();
				System.out.println("변동지출 수정이 완료되었습니다.");
				
				variableExpenseSave();
				totalMonthlyExpense();
			} 		
		} else {
			
		}
	}
	
	
	
	
	
	private static int getNonVariableExpenseMaxNo() {//변동지출 입력 시 pk최신화를 위한 max
		
		int maxNo =0;
		for (NonVariableExpense nonVariableExpense : nvlist) {
			if (nonVariableExpense.getNo() > maxNo) {
				maxNo = nonVariableExpense.getNo();
			}
		}
		return maxNo;
	}
	
	private static int getVariableExpenseMaxNo() {//고정지출 입력 시 pk최신화를 위한 max
		
		int maxNo =0;
		for (VariableExpense variableExpense : vlist) {
			if (variableExpense.getNo() > maxNo) {
				maxNo = variableExpense.getNo();
			}
		}
		return maxNo;
	}

	

	public static boolean isNumeric(String input) {//숫자확인 유효성 검사
		
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

    public static boolean isValidFormat(String date) {//날짜기입 형태 유효성검사
	    String regex = "^\\d{4}-\\d{2}-\\d{2}$";
	        
	    return Pattern.matches(regex, date);
	    
    }

    public static int dailyExpenseSum() {
    	
    	dailyExpenseLoad();
    	
    	int sumDailyExpense = 0;
		
		for (int i=0; i < delist.size(); i++) {
		
			int dailyExpnese = delist.get(i).getDailyExpense();
			sumDailyExpense = sumDailyExpense +  dailyExpnese;
		}
		
		return sumDailyExpense;
    	
    }
    
    public static void recentDailyExpenseSumSave() {
    	
		variableExpenseLoad();
		
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String formattedDate = today.format(formatter);
		
		for (VariableExpense variableExpense : vlist)  {
			
			String[] preParts = variableExpense.getDate().split("-");
			String preYear = preParts[0];
			String preMonth = preParts[1];
			
			String[] currentParts = formattedDate.split("-");
			String currentYear = currentParts[0];
			String currentMonth = currentParts[1];

			
			if(preMonth.equals(currentMonth) && preYear.equals(currentYear)) {
				variableExpense.setIngredient(dailyExpenseSum());
				variableExpense.setDate(formattedDate);
			} 
		}
		
		variableExpenseSave();
		
	}
    
    
    public static void totalMonthlyExpense() {
    

    	BufferedWriter writer = null;
    	
    	try {
    		writer = new BufferedWriter(new FileWriter(TOTALEXPENSEPATH));
    	} catch (IOException e) {
    		throw new RuntimeException(e);
    	}

    	int total = 0;
    	for (int i = 0; i < vlist.size(); i++) {
    		total = vlist.get(i).getTotalPrice() + nvlist.get(i).getTotalPrice();
//    		System.out.println(vlist.get(i).getTotalPrice());
//    		System.out.println(nvlist.get(i).getTotalPrice());
//    		System.out.println(total);
            telist.sort((n1, n2) -> n1.getDate().compareTo(n2.getDate()));
    		String txt = String.format("%d,%d,%s\n", i, total, vlist.get(i).getDate());
    		try {
    			writer.write(txt);
    		} catch (IOException e) {
    			throw new RuntimeException(e);
    		}
    	}

    	try {
    		writer.close();
    	} catch (IOException e) {
    		throw new RuntimeException(e);
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
		
		if(nvlist.isEmpty()){
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
				nvlist.sort((n1, n2) -> n2.getDate().compareTo(n1.getDate()));
				nvlist.add(nvExpense);
				}
			
			
				reader.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void nonVariableExpenseSave() {

		nvlist.sort((n1, n2) -> n2.getDate().compareTo(n1.getDate()));
		int count = 0;
		
		if (nvlist.size() < 12) {
			try {
				
				BufferedWriter writer = new BufferedWriter(new FileWriter(NONVEXPENSEPATH));
			
				for (NonVariableExpense nvExpense : nvlist) {
					//1,3000000,50000,15500000,2025-01-01
					writer.write(String.format("%d,%d,%d,%d,%s\r\n"
											, nvExpense.getNo()
											, nvExpense.getInternetFee()
											, nvExpense.getMonthlyRent()
											, nvExpense.getCostOfLabor()
											, nvExpense.getDate()
											));
				}
		
			
				writer.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			for (NonVariableExpense vExpense: nvlist) {
				count++;
				if(nvlist.size() == count ) {
						nvlist.remove(vExpense);
						break;
				}
			}
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

		if(vlist.isEmpty()){
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
					vlist.sort((n1, n2) -> n2.getDate().compareTo(n1.getDate()));
					vlist.add(vExpense);
				}


				reader.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

	public static void variableExpenseSave() {

		vlist.sort((n1, n2) -> n2.getDate().compareTo(n1.getDate()));
		int count = 0;
		
		if (vlist.size() < 12) {
			
			try {
			
				BufferedWriter writer = new BufferedWriter(new FileWriter(VEXPENSEPATH));
			
					for (VariableExpense vExpense : vlist) {
			
				//1,300000,250000,150000,13800000,130000,2025-01-01
				writer.write(String.format("%d,%d,%d,%d,%d,%d,%s\r\n"
											, vExpense.getNo()
											, vExpense.getWaterTax()
											, vExpense.getElectricityBill()
											, vExpense.getGasBill()
											, vExpense.getIngredient()
											, vExpense.getDescripton()
											, vExpense.getDate()
											));
					}
		
					writer.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		else {
			for (VariableExpense vExpense: vlist) {
				count++;
				if(vlist.size() == count ) {
						vlist.remove(vExpense);
						break;
				}
			}
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
		
		if(telist.isEmpty()){
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
					telist.sort((n1, n2) -> n2.getDate().compareTo(n1.getDate()));
					telist.add(totalExpense);
				}
			
			
				reader.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void totalExpenseSave() {

		telist.sort((n1, n2) -> n2.getDate().compareTo(n1.getDate()));
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(TOTALEXPENSEPATH));
			
			for (TotalExpense totalExpense : telist) {
			
				//1,33180000,2025-01-01
				writer.write(String.format("%d,%d,%s\r\n"
											, totalExpense.getNo()
											, totalExpense.getExpense()
											, totalExpense.getDate()
											));
			}
		
			
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static ArrayList<DailyExpense> delist;//일일 지출비(재료비)
	private final static String DAILYEXPENSEPATH;
	
	static {
		DAILYEXPENSEPATH = ".\\data\\일지출\\일지출.txt";
		delist = new ArrayList<>();	
	}
	
	
	public static void dailyExpenseLoad() {
		
		if(delist.isEmpty()){
			String line = null;
		
			try {
			
			
				BufferedReader reader = new BufferedReader(new FileReader(DAILYEXPENSEPATH));
			
				//1,33180000,2025-01-01
				while ((line = reader.readLine()) != null) {
				
					String[] temp = line.split(",");
				
					DailyExpense dailyExpense = new DailyExpense(Integer.parseInt(temp[0])
																, Integer.parseInt(temp[1])
																, temp[2]
																);
					delist.sort((n1, n2) -> n1.getDate().compareTo(n2.getDate()));
				delist.add(dailyExpense);
				}
			
			
				reader.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void dailyExpenseSave() {

		delist.sort((n1, n2) -> n1.getDate().compareTo(n2.getDate()));
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(DAILYEXPENSEPATH));
			
			for (DailyExpense dailyExpense : delist) {
				
				//1,33180000,2025-01-01
				writer.write(String.format("%d,%d,%s\r\n"
											, dailyExpense.getNo()
											, dailyExpense.getDailyExpense()
											, dailyExpense.getDate()
											));
			}
		
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
}




