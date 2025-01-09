package com.system.restaurant.menu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
//주문 할 일
//C : 주문생성 : 완
//U : 주문수정
//D : 주문삭제
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.sql.rowset.serial.SQLOutputImpl;

import com.system.restaurant.inventory.InventoryService;
import com.system.restaurant.view.No5Menu;

public class OrderService {
	String today = "2025-01-01";

	public static String PATH = ".\\data\\메뉴&재고\\주문데이터.txt";
	private static ArrayList<Order> orders = new ArrayList<>();
	private static ArrayList<Menu> menus = MenuService.menus;
	private static ArrayList<InventoryService> inventory = MenuService.inventory;

	public static void orderManage() {
		Scanner scan = new Scanner(System.in);
		OrderService o = new OrderService();

		MenuService m = new MenuService();
		//재고 로드
		m.inventoryload();
		// 메뉴 로드
		m.menuload();
		// 주문로드
		o.orderload();

		boolean flag = true;
		while (flag) {
			m.printMenu(menus);
			System.out.println("주문 생성: 1번 | 주문 수정: 2번 | 주문 삭제: 3번 | 주문 내역: 4번 | 초기화면: 0번");
			System.out.println();

			String sel = scan.nextLine();
			if (sel.equals("1")) { // 주문 생성
				System.out.print("주문할 메뉴의 번호를 입력하세요: ");
				int num = scan.nextInt();

				if (num < 1 || num > menus.size()) {
					System.out.println("잘못된 값입니다.");
					return;
				}

				System.out.print("주문할 메뉴의 수량를 입력하세요: ");
				int quantity = scan.nextInt();

				o.addOder(orders, num, quantity);
				o.pause();
				scan.skip("\r\n");

			} else if (sel.equals("2")) {
				// 주문 수정(주문 넣은 값을 찾아서 --)
				System.out.print("수정할 주문의 번호를 입력하세요: ");
				int num = scan.nextInt();

				if (num < 1 || num > orders.size()) {
					System.out.println("잘못된 값입니다.");
					return;
				}
				System.out.print("수정할 주문의 수량를 입력하세요: ");
				int quantity = scan.nextInt();

				o.editOrder(orders, num, quantity);
				o.pause();
				scan.skip("\r\n");
				
			} else if (sel.equals("3")) {
				// 주문 삭제(주문 넣은 값을 찾아서 --)
				System.out.print("삭제할 주문의 번호를 입력하세요: ");
				int num = scan.nextInt();

				if (num < 1 || num > orders.size()) {
					System.out.println("잘못된 값입니다.");
					return;
				}

				o.removeOrder(orders, num);
				o.pause();
				scan.skip("\r\n");
				
			} else if (sel.equals("4")) {
				o.printOrder(orders, o.today);
				o.pause();
				scan.skip("\r\n");
				
			} else if (sel.equals("0")) {
				flag = false;
			} else {
				System.out.println("잘못된 숫자입니다.");
			}
		}
	}

	// 주문 데이터 save()
	void ordersave() {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(OrderService.PATH));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		for (Order o : orders) {
			try {
				String menuName = o.getMenu().getName();
				int menuPrice = o.getMenu().getPrice();

				writer.write(String.format("%d,%s,%d,%d,%s\r\n", o.getNo(), menuName, o.getQuantity(), menuPrice,
						o.getOrderDate()));

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
		Scanner scan = new Scanner(System.in);
		System.out.println("계속하려면 엔터를 누르세요.");
		scan.nextLine();
	}

	// 주문 더미 load()
	void orderload() {
		if (orders.isEmpty()) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(OrderService.PATH));
				String line = "";

				try {
					while ((line = reader.readLine()) != null) {
						String[] temp = line.split(",");
						int no = Integer.parseInt(temp[0]);
						String menuName = temp[1]; // "메뉴명" > (품절)포함
						int quantity = Integer.parseInt(temp[2]);
						int Menuprice = Integer.parseInt(temp[3]);
						Menu menu = null;

						for (Menu m : menus) {
							if (m.getName().contains(menuName) && Menuprice == m.getPrice()) {
								menu = m;
							}
						}

						String orderDate = temp[4];
						orders.add(new Order(no, menu, quantity, orderDate));
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

	// 주문 읽기(월별)
	void printOrder(ArrayList<Order> orders, String today) {
		String totalPath = ".\\data\\메뉴&재고\\메뉴 총합 데이터.txt";
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(totalPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		orderload();
		System.out.println();
		System.out.println("                       주문 관리");
		System.out.println("─".repeat(60));
		System.out.println(today + " 주문 내역");
		System.out.println();

		LinkedHashMap<Menu, Integer> eachMenuCount = orders.stream().filter(order -> order.getOrderDate().equals(today))
				.sorted((o1, o2) -> o1.getMenu().getNo() - o1.getMenu().getNo())
				.collect(Collectors.groupingBy(Order::getMenu, LinkedHashMap::new, // 순서 유지
						Collectors.summingInt(Order::getQuantity)));

		int i = 1;
		int totalPrice = 0;
		for (Map.Entry<Menu, Integer> m : eachMenuCount.entrySet()) {
			int no = m.getKey().getNo(); // 메뉴 로드 시 같은 값으로 sort할 것.
			String name = m.getKey().getName();
			int price = m.getKey().getPrice();
			int quantity = m.getValue();
			totalPrice += price * quantity;

			// 이거 나중에 정렬해보기
			System.out.printf("-%2d\t %-20s \t %-5d – %3dEA\n", i++, name, price, quantity);
		}
		String menuTotalPrice = String.format("%d,%s\n", totalPrice, today);
		try {
			writer.write(menuTotalPrice);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("─".repeat(60));
		System.out.println();
		
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// CRUD코드
	// 주문 추가
	void addOder(ArrayList<Order> orders, int num, int quantity) {
		int no = (orders.isEmpty()) ? 1 : orders.get(orders.size() - 1).getNo() + 1; // 리스트가 비어 있으면 1로 설정
		Menu orderMenu = menus.get(num - 1);
		String name = menus.get(num - 1).getName();
		int quan = quantity;
		int price = menus.get(num - 1).getPrice();
		String orderDate = "2025-01-03";// 임시데이터

		System.out.printf("주문 내역 확인 : %s, %d개, %d원(개당) - 총 %d원 (Yes: 1, No:2)", name, quan, price, price * quan);

		Scanner scan = new Scanner(System.in);
		String sel = scan.nextLine();

		if (sel.equals("1")) {
			// 주문 가능 수량 확인용
			if (orderMenu.isAvailalbeMenu(quan)) {
				// 주문 가능 > 재고 빼기
				orderMenu.reduceInventory(quan);
				orders.add(new Order(no, orderMenu, quan, orderDate));
				System.out.println("주문이 완료되었습니다.");
			} else {
				System.out.println("품절된 메뉴입니다.");
				return;
			}
		} else if (sel.equals("2")) {
			return;
		} else {
			System.out.println("올바르지 않은 값입니다.");
			return;
		}

		ordersave(); // 주문 저장
		orderload(); // 변경된 주문
	}

	void editOrder(ArrayList<Order> orders, int num, int quantity) {
		Order oldOrder = orders.get(num - 1);
		Menu oldMenu = oldOrder.getMenu();
		int oldOrderQuantity = oldOrder.getQuantity();
		if (oldOrderQuantity < quantity) {
			int gap = quantity - oldOrderQuantity;
			if (oldMenu.isAvailalbeMenu(gap)) {
				oldMenu.reduceInventory(gap);
				System.out.printf("%s: %d개 >> %d개로 ", oldMenu.getName(), oldOrderQuantity, quantity);
				System.out.println("주문 수정이 완료되었습니다.");
				oldOrder.setQuantity(quantity);
			} else {
				System.out.println("Sold Out 되어 추가 주문이 불가능합니다.");
			}
		} else {
			//
//			int gap = oldOrderQuantity - quantity;
//			oldMenu.restoreInventory(gap);
			System.out.printf("%s: %d개 >> %d개로 ", oldMenu.getName(), oldOrderQuantity, quantity);
			System.out.println("주문 수정이 완료되었습니다.");
		}

		ordersave(); // 주문 저장
		orderload(); // 변경된 주문
	}

	void removeOrder(ArrayList<Order> orders, int num) {
		Order oldOrder = orders.get(num-1);
		System.out.printf("[%d] %s : %d원 %d개", oldOrder.getNo(), oldOrder.getMenu().getName(),
				oldOrder.getMenu().getPrice(), oldOrder.getQuantity());
		orders.remove(num);

		ordersave(); // 주문 저장
		orderload(); // 변경된 주문
	}
}
