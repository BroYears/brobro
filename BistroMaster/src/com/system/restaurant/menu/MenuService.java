package com.system.restaurant.menu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.system.restaurant.inventory.Inventory;
import com.system.restaurant.inventory.InventoryService;
import com.system.restaurant.view.No5Menu;

public class MenuService {
	
	public static String PATH = ".\\data\\메뉴&재고\\메뉴.txt";
	public static String PATH_IVN = ".\\data\\메뉴&재고\\발주확인 더미데이터.txt";
	public static ArrayList<Menu> menus = new ArrayList<>();

	//재고 list
	public static ArrayList<InventoryService> inventory = new ArrayList<>();

	public static void menuManage() { 
		Scanner scan = new Scanner(System.in);
		// 메뉴 읽기
		MenuService m = new MenuService();

		//재고 읽기
		m.inventoryload();

		boolean flag = true;
		while (flag) {
			m.printMenu(menus);
			
			System.out.println("메뉴 수정: 1번 | 메뉴 추가: 2번 | 품절 설정: 3번 | 초기화면: 0번");
			System.out.println();
			String sel = scan.nextLine();
			
			if (sel.equals("1")) { // 메뉴 수정
				int num = printSelctText(scan, "수정");

				if (num < 1 || num > menus.size()) {
					System.out.println("잘못된 값입니다.");
					return;
				}

				m.editMenu(menus, num - 1);
				m.pause();
				scan.skip("\r\n");
			} else if (sel.equals("2")) { // 메뉴 추가
				m.addMenu(menus);
				m.printMenu(menus);
				m.pause();
				scan.skip("\r\n");
			} else if (sel.equals("3")) {// 메뉴 삭제
				int num = printSelctText(scan, "품절 설정");

				if (num < 1 || num > menus.size()) {
					System.out.println("잘못된 값입니다.");
					return;
				}
				m.removeMenu(menus, num - 1);
				m.printMenu(menus);
				m.pause();
				scan.skip("\r\n");
				
			} else if (sel.equals("0")) {
				//중단 초기화면 돌아감.
				flag = false;
			} else {
				System.out.println("잘못된 숫자입니다.");
			}
		}
		System.out.println("종료됨.");
	}

	ArrayList<InventoryService> getRequiredInventory(String menuName, ArrayList<InventoryService> inventory) {
		ArrayList<InventoryService> requiredInventory = new ArrayList<>();
		switch (menuName) {
			case "삼겹살(300g)":
				requiredInventory.add(inventory.get(0));  // 삼겹
				requiredInventory.add(inventory.get(6));  // 야채
				requiredInventory.add(inventory.get(12)); // 버섯
				break;
			case "목살(200g)":
				requiredInventory.add(inventory.get(1));  // 목살
				requiredInventory.add(inventory.get(6));  // 야채
				requiredInventory.add(inventory.get(12)); // 버섯
				break;
			case "항정살(200g)":
				requiredInventory.add(inventory.get(2));  // 항정
				requiredInventory.add(inventory.get(6));  // 야채
				requiredInventory.add(inventory.get(12)); // 버섯
				break;
			case "찌개(김치|된장)":
				requiredInventory.add(inventory.get(11)); // 김치
				requiredInventory.add(inventory.get(13)); // 양파
				requiredInventory.add(inventory.get(14)); // 파
				requiredInventory.add(inventory.get(15)); // 된장
				break;
			case "냉면(물냉면|비빔냉면)":
				requiredInventory.add(inventory.get(4));  // 냉면
				requiredInventory.add(inventory.get(5));  // 육수
				break;
			case "계란찜":
				requiredInventory.add(inventory.get(3)); // 계란
				break;
			case "음료(사이다|콜라)":
				requiredInventory.add(inventory.get(9));  // 음료
				break;
			case "소주":
				requiredInventory.add(inventory.get(7));  // 소주
				break;
			case "맥주":
				requiredInventory.add(inventory.get(8));  // 맥주
				break;
			case "공깃밥":
				requiredInventory.add(inventory.get(10)); // 쌀
				break;
			default:
				//System.out.println("알 수 없는 메뉴 번호: " + menuName);
				break;
		}
		return requiredInventory;
	}

	
	void menuload() {
		if (menus.isEmpty()) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(PATH));

				String line = "";

				try {
					while ((line = reader.readLine()) != null) {
						String[] temp = line.split(",");

						int no = Integer.parseInt(temp[0]);
						String name = temp[1];
						int price = Integer.parseInt(temp[2]);

						// 재료 매핑 호출
						ArrayList<InventoryService> requiredInventory = getRequiredInventory(name, inventory);

						// 메뉴 추가
						menus.add(new Menu(no, requiredInventory, name, price));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

	void inventoryload() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(PATH_IVN));
			String line = "";
			try {
				while ((line = reader.readLine()) != null) {
					String[] temp = line.split(",");


					int no = Integer.parseInt(temp[0]);
					String name = temp[1];
					int count = Integer.parseInt(temp[2]);
					int percent = Integer.parseInt(temp[3]);

					inventory.add(new InventoryService(no, name, percent, count));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	void menuSave() {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(PATH));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		//int no, ArrayList<Inventory> inventory, String name, int price
		for (Menu m : menus) {
			try {
				writer.write(String.format("%d,%s,%d\r\n", m.getNo(), m.getName(), m.getPrice()));
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

	void pause() {
		System.out.println();
		System.out.println("계속하려면 엔터를 누르세요.");
	}

	void printMenu(ArrayList<Menu> menu) { 
		menuload();
		System.out.println();
		System.out.println("                    메뉴 관리");
		System.out.println("─".repeat(50));

		for (int i = 0; i < menu.size(); i++) {
			String name = menu.get(i).getName();
			int price = menu.get(i).getPrice();
			System.out.printf("- %2d\t %-20s \t%,6d(원)\n", (i + 1), name, price);
		}

		System.out.println("─".repeat(50));
		System.out.println();
		
	}

	public static int printSelctText(Scanner scan, String txt) {
		System.out.print(txt + "할 메뉴의 번호를 입력하세요: ");
		int num = scan.nextInt();		return num;
	}

	void editMenu(ArrayList<Menu> menu, int index) {
		Menu oldMenu = menu.get(index);
		String oldMeName = oldMenu.getName();
		int oldMePrice = oldMenu.getPrice();

		System.out.println(oldMenu.getName() + "을 수정하시겠습니까?( Yes: 1| No: 2)");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		scan.nextLine();

		if (num == 1) {
			// 수정
			System.out.println("수정을 원하지 않는 데이터는 엔터를 눌러주세요.");
			System.out.print("메뉴명: ");
			String newName = scan.nextLine();

			System.out.print("가격: ");
			String newPrice = scan.nextLine();

			if (!newName.isEmpty()) {
				oldMenu.setName(newName);
			}

			if (!newPrice.isEmpty()) {
				oldMenu.setPrice(Integer.parseInt(newPrice));
			}
			
			if(newName.isEmpty()&&newPrice.isEmpty()) {
				System.out.println("변경된 데이터가 없습니다.");
			}else {
				System.out.println("수정이 완료되었습니다.");
			}

			
			System.out.printf("메뉴명: %-10s >> %-10s\n", oldMeName, oldMenu.getName());
			System.out.printf("가격: %,-5d(원) >> %,-5d(원)\n", oldMePrice, oldMenu.getPrice());
		}

		menuSave();
		menuload(); // 주문 저장

	}

	void addMenu(ArrayList<Menu> menu) {
		Scanner scan = new Scanner(System.in);
		System.out.print("추가할 메뉴명을 입력하세요. : ");
		String addMenuName = scan.nextLine();

		System.out.print("가격을 입력하세요. : ");
		String addMenuPrice = scan.nextLine();

		System.out.print("추가할 위치의 번호를 입력하세요. : ");
		String addMenuLocation = scan.nextLine();

		// 사용할 재료 입력
		System.out.println("사용할 재료의 번호를 ','로 구분하여 입력하세요 (예: 4,5,11): ");
		String addMenuInv = scan.nextLine();
		String[] inventoryInput = addMenuInv.split(",");
		ArrayList<InventoryService> requiredInventory = new ArrayList<>();

		for (String indexStr : inventoryInput) {
			try {
				int index = Integer.parseInt(indexStr.trim());
				if (index >= 0 && index < inventory.size()) {
					requiredInventory.add(inventory.get(index));
				} else {
					System.out.println("해당하는 재고가 없습니다.");
				}
			} catch (NumberFormatException e) {
				System.out.println("잘못 입력하셨습니다.");
			}
		}

		// 새로운 메뉴 생성 및 추가
		int LastIndexNum = menu.size();
		Menu newMenu = new Menu(LastIndexNum, requiredInventory, addMenuName, Integer.parseInt(addMenuPrice));
		menu.add(Integer.parseInt(addMenuLocation) - 1, newMenu);

		System.out.println("메뉴 추가가 완료되었습니다.");

		System.out.print("추가된 메뉴: " + newMenu.getName() + ", 재료: ");
		for (InventoryService inv : requiredInventory) {
			System.out.print(inv.getName() + " "); // 재료 이름만 출력
		}
		System.out.println(); // 줄바꿈

		menuSave(); // 메뉴 저장
		menuload(); // 변경된 메뉴
	}

	void removeMenu(ArrayList<Menu> menu, int index) {
		Menu oldMenu = menu.get(index);
		String oldNameMenu = oldMenu.getName();
		
		
		if(!oldNameMenu.contains("(품절)")) {
			System.out.println(oldMenu.getName() + "을 품절 등록 하시겠습니까?( Yes: 1| No: 2)");

			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();
			scan.nextLine();

			if (num == 1) {
				// 품절처리
				menus.get(index).setName(oldNameMenu + "(품절)");
				System.out.println("품절 등록이 완료되었습니다.");
			} else {
				return;
			}
		}else {
			System.out.println(oldMenu.getName() + "을 품절 취소 하시겠습니까?( Yes: 1| No: 2)");
			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();
			scan.nextLine();

			if (num == 1) {
				// 품절처리 취소
				String SoldOutCancel = menus.get(index).getName();
				
				menus.get(index).setName(SoldOutCancel.replace("(품절)", ""));
				System.out.println("품절 등록이 완료되었습니다.");
			} else {
				return;
			}
			
		}
		

		menuSave(); // 메뉴 저장
		menuload(); // 변경된 메뉴
	}

}
