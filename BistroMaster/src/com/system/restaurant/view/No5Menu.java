package com.system.restaurant.view;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import com.system.restaurant.menu.MenuService;
import com.system.restaurant.menu.OrderService;

public class No5Menu {
	public static void loadNum5() {
		
		
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		
		while (loop) {
			printSubMenu();
			int sel = scan.nextInt();
			scan.skip("\r\n");
			
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

	public static void printSubMenu() {
		Sub_Menus_Temp.makeSubTitle("주문관리", 10);
		Sub_Menus_Temp.makeSubCategory("1. 메뉴 관리", 10);
		Sub_Menus_Temp.makeSubCategory("2. 주문 관리", 10);

		System.out.println("메뉴 관리: 1번 | 주문 관리: 2번 | 초기화면: 0번");
	}
}
