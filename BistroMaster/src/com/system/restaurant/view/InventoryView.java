package com.system.restaurant.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.system.restaurant.inventory.Inventory;
import com.system.restaurant.inventory.InventoryService;

public class InventoryView {

	public static void main(String[] args){

		Invload();
		
		
	}//main
	
	private static boolean Invload() {  // 재고관리
		
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		while (loop) {
			System.out.println();
			System.out.println("=================================================================");
			System.out.println("                             재고관리");
			System.out.println("=================================================================");
			System.out.println("1. 유통기한 확인하기");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("2. 발주 확인/수정하기");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("0. 초기화면가기");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			
			System.out.print("선택: ");
			String sel = scan.nextLine();
			
			switch (sel) {
			case "1":
				// 유통기한 확인
				InvexpiryDate();
				break;
				
			case "2":
				// 발주 / 발주 수정
				InvorderList();
				break;
				
			case "0":
				System.out.println("초기화면으로 이동합니다.");
				System.out.println();
				No2Menu.loadNum2();
				//RestaurantView.loadNum2();
				//loop = false;
				break;
				
			default:
				System.out.println("번호를 잘못 입력하였습니다.");
				System.out.println();
				break;
			}
		}
		
		scan.close();
		return false;
	}

	public static boolean InvexpiryDate() {  // 유통기한 확인
		
		  Scanner scan = new Scanner(System.in);  
		    int mainInput = 1;  

		    List<Inventory> currentInventoryList = new ArrayList<>();  

		    loadInventoryFromFile(currentInventoryList);  

		    while (mainInput > 0) {  
		    	System.out.println();
		        System.out.println("=================================================================");  
		        System.out.println("                           유통기한 확인");  
		        System.out.println("=================================================================");  
		        System.out.println();  

		        try {  
		            Map<String, Inventory> inventoryMap = new HashMap<>();  

		            for (Inventory inventory : currentInventoryList) {  
		                Inventory existingInventory = inventoryMap.get(inventory.getName());  
		                if (existingInventory == null  
		                        || inventory.getExpiryDate().equals(existingInventory.getExpiryDate())) {  
		                    inventoryMap.put(inventory.getName(), inventory);  
		                }  
		            }  

		            List<Inventory> uniqueInventoryList = new ArrayList<>(inventoryMap.values());  

		            Collections.sort(uniqueInventoryList, new Comparator<Inventory>() {  
		                public int compare(Inventory inv1, Inventory inv2) {  
		                    return inv1.getExpiryDate().compareTo(inv2.getExpiryDate());  
		                }  
		            });  
		            
		            int count = 1;
		            for (Inventory inventory : uniqueInventoryList) {
		            	System.out.print(count++ + ". ");
		                System.out.println(inventory);  
		            }  

		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }  

		        System.out.println();  
		        System.out.println("유통기한 수정은 1번 / 발주(재고 보유) 확인은 2번 / 초기화면은");
		        System.out.println("0번을 입력하고 엔터");
		        System.out.println("=================================================================");
				//System.out.println(" *유통기한 D-7일 알림* ");
				//System.out.println("=================================================================");
		        System.out.print("입력 : ");  
		        mainInput = Integer.parseInt(scan.nextLine());  

		        if (mainInput == 2) {  
		            InvorderList(); // 발주 리스트 메서드 호출  
		            break;  
		        } else if (mainInput == 1) {  
		            System.out.print("유효기간을 수정할 품목의 이름을 입력하세요: ");  
		            String itemName = scan.nextLine();  

		            System.out.print("새 유효기간 입력 (YYYY-MM-DD 형식): ");  
		            String newExpiryDate = scan.nextLine();  

		            updateInventory2(itemName, newExpiryDate, currentInventoryList);
		        } else if (mainInput == 0) {  
		        	No2Menu.loadNum2(); // 초기화면 메서드 호출  
		        	//No2Menu.loadNum2();
		            break;  
		        } else {  
		            System.out.println("잘못된 입력입니다. 다시 시도하세요."); // 잘못된 입력 처리  
		        }  
		    }  
		    scan.close();
		    return false;
	}

	public static boolean InvorderList() {  // 발주확인

		Scanner scan = new Scanner(System.in);
		int mainInput2 = 1;

		while (mainInput2 > 0) {
			System.out.println();
			System.out.println("=================================================================");
			System.out.println("                          발주(재고 보유) 확인");
			System.out.println("=================================================================");
			System.out.println();

			List<InventoryService> inventoryList2 = new ArrayList<>();

			try {
				File file = new File(".\\data\\메뉴&재고\\발주확인 더미데이터.txt");
				Scanner scan2 = new Scanner(file);

				while (scan2.hasNextLine()) {
					String line = scan2.nextLine();
					String[] temp = line.split(",");

					if (temp.length < 4)
						continue;

					try {
						int num = Integer.parseInt(temp[0].trim());
						String name = temp[1].trim();
						int percent = Integer.parseInt(temp[2].trim());
						int count = Integer.parseInt(temp[3].trim());

						inventoryList2.add(new InventoryService(num, name, percent, count));
					} catch (NumberFormatException e) {
						System.out.println("입력 형식 오류: " + e.getMessage());
					}
				}
				scan2.close();

				for (InventoryService inventory : inventoryList2) {
					int no = inventory.getNum();
					String name = inventory.getName();
					int percent = inventory.getPercent();
					int count = inventory.getCount();
					System.out.printf("%d, 품목:%s, 재고량:%d%%, 재고:%d개 \r\n", no, name, percent, count);
				}

			} catch (Exception e) {
				System.out.println("파일 처리 중 오류 발생: " + e.getMessage());
				e.printStackTrace();
			}

			System.out.println();
			System.out.println("품목 추가 1번 / 품목 수정 2번 / 유통기한 확인 9번 / 초기화면은 0번");
			System.out.println("번호를 입력하고 엔터");
			System.out.println("=================================================================");
			System.out.println(" *발주는 각 재료 별로 재고 30%이하면 발주 알림* ");
			System.out.println("=================================================================");
			for (InventoryService inventory : inventoryList2) {
				String name = inventory.getName();
				int percent = inventory.getPercent();
				
				if (percent <= 30) {
					System.out.printf("%s의 재고가 %d%%이하입니다. 발주 부탁드립니다.\r\n", name, percent);
				}
			}
			System.out.println();
			System.out.print("입력: ");

			try {
				mainInput2 = Integer.parseInt(scan.nextLine());

				if (mainInput2 == 1) {
					add(scan);
				} else if (mainInput2 == 2) {
					modify(scan, inventoryList2);
				} else if (mainInput2 == 9) {
					InvexpiryDate();
					break;
				} else if (mainInput2 == 0) {
					No2Menu.loadNum2();
					break;
				} else {
					System.out.println("잘못된 입력입니다. 다시 시도하세요.");
				}
			} catch (NumberFormatException e) {
				System.out.println("잘못된 입력입니다. 다시 시도하세요.");
			}
		}
		return true;
	}
	
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ발주 메서드
	
	private static void modify(Scanner scan, List<InventoryService> inventoryList) {  // 품목 수정
		
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

		        // 수량이 올라가면 재고율 수정
		        inventory.setCount(newCount);
		        int currentCount = inventory.getCount(); 
		        
		        int newPercent = currentCount* 100 /100 ; 
		        inventory.setPercent(newPercent);
		        newPercent = inventory.getPercent();
 
		        inventory.updateInventory(newName, newPercent, newCount);  
		        
		       System.out.println(currentCount); 
		        System.out.println(newName);
		        System.out.println(newPercent);
		        System.out.println(newCount);
		        
		        saveInventoryToFile(inventoryList);  
		        System.out.println("품목이 수정되었습니다.");  
		        break;  
		    }  
		}  
		if (!found) { 
		    System.out.println("해당 품목이 없습니다.");  
		} 
		}

	public static void saveInventoryToFile(List<InventoryService> inventoryList) {  // 품목 저장
		try {
			FileWriter writer = new FileWriter(
					".\\data\\메뉴&재고\\발주확인 더미데이터.txt");

			for (InventoryService inventory : inventoryList) {
				writer.write(inventory.getNum() + "," + inventory.getName() + "," + inventory.getPercent() + ","
						+ inventory.getCount() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("파일에 저장 중 오류 발생: " + e.getMessage());
		}
	}

	private static void add(Scanner scan) {  // 품목 추가
		
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
					".\\data\\메뉴&재고\\발주확인 더미데이터.txt",
					true);
			writer.write(num + "," + name + "," + percent + "," + count + "\n");
			writer.close();
			System.out.println("품목이 추가되었습니다.");
		} catch (IOException e) {
			System.out.println("파일에 품목 추가 중 오류 발생: " + e.getMessage());
		}
	}
	
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ유통기한 메서드	
	
	private static void loadInventoryFromFile(List<Inventory> inventoryList) {  //유통기한 읽기
		
	    try {  
	        File file = new File(".\\data\\메뉴&재고\\재고 더미데이터.txt");  
	        Scanner scan1 = new Scanner(file);  

	        while (scan1.hasNextLine()) {  
	            String line = scan1.nextLine();  
	            String[] temp = line.split(",");  
	            if (temp.length < 4) continue;

	            String name = temp[0].trim();  
	            int quantity = 0;  
	            int price = 0;  
	            String expirationDate = temp[3].trim();  

	            
	            try {  
	                quantity = Integer.parseInt(temp[1].trim());  
	                price = Integer.parseInt(temp[2].trim());  
	            } catch (NumberFormatException e) {  
	                System.out.println("수량 또는 가격이 유효하지 않습니다: " + line);  
	                continue;  
	            }  

	            // 품목 이름과 유통기한 유효성 체크  
	            if (name.isEmpty() || !isValidDate(expirationDate)) {  
	                System.out.println("품목 이름이나 유통기한이 유효하지 않습니다: " + line);  
	                continue;
	            }  

	            // 모든 유효성 검사를 통과한 항목 추가  
	            inventoryList.add(new Inventory(name, quantity, price, expirationDate));  
	        }  
	        scan1.close();  
	    } catch (FileNotFoundException e) {  
	        System.out.println("재고 파일을 찾을 수 없습니다: " + e.getMessage());  
	    }  
	}  

	private static boolean isValidDate(String date) {  // 유통기한 유효값  
	    String regex = "\\d{4}-\\d{2}-\\d{2}";  //유효기간 맞는지 ex)2025-01-08 O / 20111- 11-10 X
	    return date.matches(regex);  
	}  

	private static void updateInventory2(String itemName, String newExpiryDate, List<Inventory> inventoryList) {  // 유통기한 수정  
	    boolean found = false;  

	    // 유통기한 유효성 검사  
	    if (!isValidDate(newExpiryDate)) {  
	        System.out.println("유효하지 않은 유통기한입니다: " + newExpiryDate);  
	        return; // 유효하지 않은 경우 메서드 종료  
	    }  

	    for (Inventory inventory : inventoryList) {  
	        if (inventory.getName().equals(itemName)) {  
	            inventory.setExpiryDate(newExpiryDate);  
	            found = true;  
	            System.out.println("수정 완료: " + itemName + "의 유통기한이 " + newExpiryDate + "로 변경되었습니다.");  
	            break;  
	        }  
	    }  

	    if (!found) {  
	        System.out.println("해당 품목을 찾을 수 없습니다: " + itemName);  
	    } else {  
	        saveCurrentInventoryToFile(inventoryList); // Save updated inventory back to file  
	    }  
	}  

	private static void saveCurrentInventoryToFile(List<Inventory> inventoryList) {  // 유통기한 저장
	    try (PrintWriter writer = new PrintWriter(new FileWriter(".\\data\\메뉴&재고\\재고 더미데이터.txt"))) {  
	        for (Inventory inventory : inventoryList) {  
	            writer.println(inventory.toString());  
	        }  
	        writer.flush();  
	    } catch (IOException e) {  
	        System.out.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());  
	    }  
	}  
	

}//class