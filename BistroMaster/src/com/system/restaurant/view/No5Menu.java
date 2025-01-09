package com.system.restaurant.view;

import java.util.Scanner;

import com.system.restaurant.menu.MenuService;
import com.system.restaurant.menu.OrderService;

public class No5Menu {
	public static void loadNum5() { //루프2차
		Sub_Menus_Temp.makeSubTitle("주문관리", 10);
		Sub_Menus_Temp.makeSubCategory("1. 메뉴 관리", 10);
		Sub_Menus_Temp.makeSubCategory("2. 주문 관리", 10);

		System.out.println("메뉴 관리: 1번 | 주문 관리: 2번 | 초기화면: 0번");

		Scanner scan = new Scanner(System.in);
		int sel = scan.nextInt();
		scan.skip("\r\n");

		boolean loop = true;

		while (loop) {
			switch (sel) {
				case 1: {
					MenuService.menuManage();
					break;
				}
				case 2: {
					OrderService.orderManage();
					break;
				}
				case 0: {
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
