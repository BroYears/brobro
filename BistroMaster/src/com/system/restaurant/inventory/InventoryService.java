package com.system.restaurant.inventory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class InventoryService { //발주확인
		
		public int num;
		public String name;
		public int percent;
		public int count;
		
		
		public InventoryService(int num, String name, int percent, int count) {
			super();
			this.num = num;
			this.name = name;
			this.percent = percent;
			this.count = count;
		}
		
		public void setNum(int num) {
			this.num = num;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setPercent(int percent) {
			this.percent = percent;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public int getNum() {

			return num;
		}
		
		public String getName() {

			return name;
		}
		
		public int getPercent() {

			return percent;
		}
		
		public int getCount() {
			return count ;
		}
		
		public void reduceInventory(int amount) {
			count-=amount;
		}
		
		public void restoreInventory(int amount) {
			count += amount;
		}
		
	    @Override  
	    public String toString() {  
	        return String.format("%d, %s, %d, %d", num, name, percent, count);
	    }

		public void updateInventory(String newName, int newPercent, int newCount) {
			
		}  
		
		public static void modify(Scanner scan, List<InventoryService> inventoryList) throws Exception { // 품목 수정
			
			System.out.print("수정할 품목 번호 입력: ");  
			int numToModify = Integer.parseInt(scan.nextLine());  
			boolean found = false;  

			for (InventoryService inventory : inventoryList) {  
			    if (inventory.getNum() == numToModify) {  
			        found = true;  
			        System.out.print("새로운 이름 입력 (현재: " + inventory.getName() + "): ");  
			        String newName = scan.nextLine();  
			        
			        System.out.print("새로운 재고 수량 입력 (현재: " + inventory.getCount() + "): ");  
			        int newCount = Integer.parseInt(scan.nextLine());  

			        // 수량이 올라가면 자동으로 재고율을 조정
			        inventory.setCount(newCount);
			        int currentCount = inventory.getCount(); 
			        
			    
			        // 새로운 재고 비율 계산  
			        int newPercent = currentCount* 100 /100 ; 
			        inventory.setPercent(newPercent);
			        newPercent = inventory.getPercent();

			        // 업데이트 및 재고율 조정  
			        inventory.updateInventory(newName, newPercent, newCount);  
			        
			       System.out.println(currentCount); 
			        System.out.println(newName);
			        System.out.println(newPercent);
			        System.out.println(newCount);
			        
			        // Save the updated list back to the file.  
			        saveInventoryToFile(inventoryList);  
			        System.out.println("품목이 수정되었습니다.");  
			        break;  
			    }  
			}  
			if (!found) { 
			    System.out.println("해당 품목이 없습니다.");  
			} 
			}

		public static void saveInventoryToFile(List<InventoryService> inventoryList) throws Exception {
			try {
				FileWriter writer = new FileWriter(
						".\\data\\메뉴_재고\\발주확인 더미데이터.txt");

				for (InventoryService inventory : inventoryList) {
					writer.write(inventory.getNum() + "," + inventory.getName() + "," + inventory.getPercent() + ","
							+ inventory.getCount() + "\n");
				}
				writer.close();
			} catch (IOException e) {
				System.out.println("파일에 저장 중 오류 발생: " + e.getMessage());
			}
		}

		public static void add(Scanner scan) throws Exception { // 품목 추기

			
			System.out.print("품목 번호 입력: ");
			int num = Integer.parseInt(scan.nextLine());
			System.out.print("품목 이름 입력: ");
			String name = scan.nextLine();
			System.out.print("재고 비율(%) 입력: ");
			int percent = Integer.parseInt(scan.nextLine());
			System.out.print("재고 수량 입력: ");
			int count = Integer.parseInt(scan.nextLine());

			try {
				FileWriter writer = new FileWriter(
						".\\data\\메뉴_재고\\발주확인 더미데이터.txt",
						true);
				writer.write(num + "," + name + "," + percent + "," + count + "\n");
				writer.close();
				System.out.println("품목이 추가되었습니다.");
			} catch (IOException e) {
				System.out.println("파일에 품목 추가 중 오류 발생: " + e.getMessage());
			}
		}
		
		
		
	}//class