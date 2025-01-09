package com.system.restaurant.view;

import java.util.Scanner;

import com.system.restaurant.Main;
import com.system.restaurant.menu.MenuService;
import com.system.restaurant.menu.OrderService;

public class No2Menu {
	public static void loadNum2() { //루프2차
		Sub_Menus_Temp.makeSubTitle("재고관리", 10);
		Sub_Menus_Temp.makeSubCategory("1. 유통기한 관리", 12);
		Sub_Menus_Temp.makeSubCategory("2. 발주 관리", 10);

		System.out.println("유통기한 관리: 1번 | 발주 관리: 2번 | 초기화면: 0번");

		Scanner scan = new Scanner(System.in);
		int sel = scan.nextInt();

		boolean loop = true;

		while (loop) {
			switch (sel) {
				case 1: {
					InventoryView.InvexpiryDate();
					break;
				}
				case 2: {
					InventoryView.InvorderList();
					break;
				}
				case 0: {
					//Main.main(null);
					loop = false;
					break;
				}
				default: {
					System.out.println("잘못된 번호입니다.");
					break;
				}
			}
		}
	}
}
