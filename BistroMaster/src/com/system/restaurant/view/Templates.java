package com.system.restaurant.view;

import java.util.Scanner;

import com.system.restaurant.menu.MenuService;
import com.system.restaurant.menu.OrderService;

public class Templates {
	public static void printMenu() {
//		Scanner scan = new Scanner(System.in);
		printThickTextBox("매장 관리", 10, 0);
		printThickTextBox("1. 직원 관리", 10, 3);
		printThickTextBox("2. 재고 관리", 10, 3);
		printThickTextBox("3. 매출 관리", 10, 3);
		printThickTextBox("4. 예약 관리", 10, 3);
		printThickTextBox("5. 주문 관리", 10, 3);

		System.out.println();
		System.out.println("인력관리 1번 | 재고관리 2번 | 매출관리 3번 | 예약관리 4번 | 주문관리 5번\r\n");
	}

	public static void printThickTextBox(String text, int num, int count) {
		int width = text.length() + num;
		printSpace(count);
		System.out.println("┌" + "─".repeat(width - 2) + "┐");
		;
		printSpace(count);
		System.out.println("│  " + text + "  │");
		printSpace(count);
		System.out.println("└" + "─".repeat(width - 2) + "┘");
	}

	private static void printSpace(int count) {
		for (int i = 0; i < count; i++) {
			System.out.print(" ");
		}
	}

}
