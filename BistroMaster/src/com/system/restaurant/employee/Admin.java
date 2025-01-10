package com.system.restaurant.employee;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedList;
import com.system.restaurant.inventory.Inventory;


public class Admin { 
	
	// 재고더미 데이터 경로
	public final static String InventoryDataPath =".data\\메뉴&재고\\재고 더미데이터.txt";
	// 발주더미 데이터 경로
	public final static String OrederDataPath =".data\\메뉴&재고\\발주확인 더미데이터.txt";
	// 일지출더미 데이터 경로
	public final static String OrderCostDataPath =".data\\일지출\\일지출.txt";
	// 유통기한표 데이터 경로
	public final static String ExpireDataPath =".data\\메뉴&재고\\제품 유통기한표.txt";
	
	
	String internetFee = "";
    String monthlyRent = "";
    String costOfLabor = "";
    
    //발주확인 더미데이터 리스트 객체타입
	private class TodoOrder{
		
		private int no=0;
		private String name ="";
		private int quantitySum=0;
		
		//발주확인 더미데이터 리스트 객체타입
		public TodoOrder(int no, String name, int quantitySum) {
			
			super();
			this.no = no;
			this.name = name;
			this.quantitySum = quantitySum;
			
		}

		public int getNo() {
			return no;
		}
		public String getName() {
			return name;
		}
		public int getQuantitySum() {
			return quantitySum;
		}
		public void setNo(int no) {
			this.no = no;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setQuantitySum(int quantitySum) {
			this.quantitySum = quantitySum;
		}
		

	}
	
	private class TodoCost{
		private int num;
		private int totalprice;
		private String ymd;
		
		public TodoCost(int num, int totalprice, String ymd) {
			super();
			this.num = num;
			this.totalprice = totalprice;
			this.ymd = ymd;
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public int getTotalprice() {
			return totalprice;
		}
		public void setTotalprice(int totalprice) {
			this.totalprice = totalprice;
		}
		public String getYmd() {
			return ymd;
		}
		public void setYmd(String ymd) {
			this.ymd = ymd;
		}
		
		
		
		
	}
	
	private class TodoExpire{
		private String name ="";
		int expireDates=0;
		
		public TodoExpire(String name, int expireDates) {
			super();
			this.name = name;
			this.expireDates = expireDates;
		}

		private String getName() {
			return name;
		}

		private int getExpireDates() {
			return expireDates;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setExpireDates(int expireDates) {
			this.expireDates = expireDates;
		}
		
		
		
		
	}
	
	
	// Admin 생성자
	public Admin() {
		
		
	}

	//재고 더미데이터 리스트
	//ex) 41,맥주,100,1000,2025-02-04
	//Inventory(String name, int quantity, int price, String expiryDate)
	
	//발주확인 더미데이터 리스트
	//ex) 3,항정살,30%,(30EA)
	//String no,name,quantitySum,quantitySum
	//TodoInven(int no, String name, int quantitySum)
	//TodoCost(int num, int totalprice, String ymd)
	
	LinkedList<Inventory>inventoryList = new LinkedList<Inventory>();
	LinkedList<TodoOrder>orderList = new LinkedList<TodoOrder>();
	LinkedList<TodoCost>costList = new LinkedList<TodoCost>();
	HashSet<String> uniqueNamesSet = new HashSet<String>(); 
	LinkedList<TodoExpire>expireList = new LinkedList<TodoExpire>();
	
	
	private void expireDateRead() {
		try {
			
			BufferedReader expireDateReader = new BufferedReader(new FileReader(ExpireDataPath));
			
			String line =null;
			
			while((line = expireDateReader.readLine()) != null ) {
				
				String[] temp = line.split(",");
				
				//int num, int totalprice, String ymd
				String name = temp[0];
				int expireDate = Integer.parseInt(temp[1]);
				
				
				
				expireList.add(new TodoExpire(name,expireDate)); 
				
				
			}
			
			expireDateReader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setNamesWrite() {
		
		try {
			BufferedWriter expireDateWriter = new BufferedWriter(new FileWriter(ExpireDataPath));
			
			for(String s : uniqueNamesSet) {	
					expireDateWriter.write( String.format("%s \r\n", s));
			}	
			expireDateWriter.close();
			
			//System.out.println("유통기한 더미데이터 쓰기완료");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//유효기간
	private void settingNames() {
		
	    for (Inventory inven : inventoryList) {  
	        uniqueNamesSet.add(inven.getName());  
	    }  
		
	}
	
	//직원 생성??
	private void settingEmployee() {
		
		
	
	}
	
	public void todo() {
		
		
		loadOrder();				//1
		loadInven();				//2
		invenListAddOrderData();	//3
		invenListWriter();			//4
		loadCostData();				//5
		orderListTotalCostCal();	//6
		costListAdd();				//7
		costDataWrite();			//8
		todoOrderDataRemove();		//9
		todoOrderListReset();		//10
		todoInvenListReset();		//11
		todoCostListReset();		//12
		
	}
	//날짜 받아오기
	private String getTodayDate(int addMonth) {
		Calendar calendar = Calendar.getInstance();  
	    calendar.add(Calendar.MONTH, addMonth); 
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
        String todayDate = sdf.format(calendar.getTime());
        
        return todayDate;
	}
	
	
	//12.일지출리스트 리셋
	private void todoCostListReset() {
		costList.clear();
		//System.out.println("12번완료");
	}
	
	//11.재고리스트 리셋
	private void todoInvenListReset() {
		inventoryList.clear();
		//System.out.println("11번완료");
	}
	
	//10.발주 리스트 리셋
	private void todoOrderListReset() {
		orderList.clear();
		//System.out.println("10번완료");
	}
	
	//9 발주더미 내용 삭제
	private void todoOrderDataRemove() {
			
			try {			
				BufferedWriter Orederwriter = new BufferedWriter(new FileWriter(OrederDataPath));
				Orederwriter.write(""); // 내용을 빈 문자열로 덮어씀
				Orederwriter.close();
				//System.out.println("발주더미 내용 삭제 성공: ");
			} catch (Exception e) {
				e.printStackTrace();
			}
			//System.out.println("9번완료");
	}
	
	
	//8.일지출리스트	-->	일지출더미		데이터 쓰기
	private void costDataWrite() {
		try {
		
			BufferedWriter costWriter = new BufferedWriter(new FileWriter(OrderCostDataPath));
			
			for( TodoCost costObj: costList) {
				costWriter.write(String.format("%d,%d,%s\r\n",costObj.num,costObj.totalprice,costObj.ymd));
			}
			
			costWriter.close();
			
		
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("8번완료");
	}
	
	
	//7. 일지출리스트 + 당일 일지출비용
	private void costListAdd() {
		try {
			
			
			
	        
			int lastNum = costList.getLast().num;
				
			costList.add(new TodoCost(lastNum+1,orderListTotalCostCal(),getTodayDate(0)));
			
		
		}catch(Exception e){
			
		}
		//System.out.println("7번완료");
	}

	//6.일지출더미 읽기
	private void loadCostData() {
		try {
			BufferedReader costDateReader = new BufferedReader(new FileReader(OrderCostDataPath));
			
			String line =null;
			
			while((line = costDateReader.readLine()) != null ) {
				
				String[] temp = line.split(",");
				
				//int num, int totalprice, String ymd
				int num = Integer.parseInt(temp[0]);
				int totalprice = Integer.parseInt(temp[1]);
				String ymd = temp[2];
				
				
				costList.add(new TodoCost(num, totalprice, ymd)); 
				
				
			}//while
			
			costDateReader.close();
			}catch(IOException e) {
				e.printStackTrace();
		}
		//System.out.println("6번완료");
	}
	
	// 5.발주 리스트에서 일지출 비용 계산하기
	private int orderListTotalCostCal() {
		int totalCostSum =0;
		
		for(TodoOrder orderObj : orderList) {
			totalCostSum += sameNameGetPrice(orderObj);	
		}
		
		//System.out.println("5번완료");
		return totalCostSum;
	}
	
	// 4.재고더미에 재고리스트 데이터 쓰기
	private void invenListWriter() {
		try {
			BufferedWriter invenWriter = new BufferedWriter(new FileWriter(InventoryDataPath));
			
			for( Inventory invenObj: inventoryList) {
				invenWriter.write(String.format("%s,%d,%d,%s\r\n",invenObj.getName(),invenObj.getQuantity(),invenObj.getPrice(),invenObj.getExpiryDate()));
			}
			
			invenWriter.close();
			
		} catch (Exception e) {
			
		}
		
		//System.out.println("4번완료");
	}
	
	//3. 재고리스트에 새로운 데이터 추가
	private void invenListAddOrderData() {
		try {
			//새로운 데이터를 담기 위해 재고 객체 리스트 정리 
			inventoryList.clear();
			
			
			BufferedReader invenreader = new BufferedReader(new FileReader(InventoryDataPath));
			BufferedReader expireReader = new BufferedReader(new FileReader(ExpireDataPath));
			
			String InvenLine=null;
					
	
			//inventoryList에 발주리스트에있는 데이터 담기
			while((InvenLine = invenreader.readLine()) != null ) {
				
				String[] temp = InvenLine.split(",");
				
				//ex) 41,맥주,100,1000,2025-02-04
				String name = temp[0];
				int quantity = Integer.parseInt(temp[1]);
				int price = Integer.parseInt(temp[2]);
				String expiryDate = temp[3];
				
				inventoryList.add(new Inventory(name, quantity, price, expiryDate)); 
				
				
			}
			invenreader.close();
			
			//ExpireDataPath;
			
			
			expireDateRead();
			
			for(TodoExpire expObj : expireList) {
				for(TodoOrder orderObj : orderList) {
					
					if(orderObj.getName().equals(expObj.getName())) {
						inventoryList.add(new Inventory(expObj.name,100-orderObj.quantitySum,sameNameGetPrice(orderObj),getTodayDate(expObj.expireDates)));
						//System.out.println("유통기한 굳");
					}
				}
			}
		
			expireReader.close();
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//System.out.println("3번 완료");
	}
	
	//3.1 인벤리스트에서 이름같은 항목 가격 추출하기
	private int sameNameGetPrice(TodoOrder orderObj) {
		for(Inventory invenObj:inventoryList) {
			if(invenObj.getName().equals( orderObj.getName() )) {
				
				return invenObj.getPrice();
			}
			
		}
		
		return 0;
	}
	
	
	//2. 재고 더미데이터를 inventoryList 객체리스트에 내용을 저장
	private void loadInven() {
		try {
		BufferedReader loadreader = new BufferedReader(new FileReader(InventoryDataPath));
		
		String line =null;
		
		while((line = loadreader.readLine()) != null ) {
			
			String[] temp = line.split(",");
			
			//ex) 41,맥주,100,1000,2025-02-04
			String name = temp[0];
			int quantity = Integer.parseInt(temp[1]);
			int price = Integer.parseInt(temp[2]);
			String expiryDate = temp[3];
			
			inventoryList.add(new Inventory(name, quantity, price, expiryDate)); 
			
			
		}//while
		
		loadreader.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		//System.out.println("2번완료");
	}//loadInven
	
	
	//1. 발주 더미에서 orderList 객체리스트 로 내용을 저장
	private void loadOrder()  {
			try {
			
			//발주 리스트에서 orderList 객체리스트 로 내용을 저장
			BufferedReader Orderreader = new BufferedReader(new FileReader(OrederDataPath));
			
			String line =null;
			
			while((line = Orderreader.readLine()) != null ) {
				//1,삼겹살,100%,(100EA)
				String[] temp = line.split(",");
				
				//Inventory(String name, int quantity, int price, String expiryDate)
				
				int no = Integer.parseInt(temp[0]);
				String name = temp[1];
				int quantity = Integer.parseInt(temp[2]);;
				
				
				
				//(int no, String name, int quantitySum)
				orderList.add(new TodoOrder(no, name, quantity)); 
				
				
			}//while
			
			Orderreader.close();
			
			}catch(IOException e) {
				e.printStackTrace();
			}
			//System.out.println("1번 완료");
		}//load
}//Admin class

