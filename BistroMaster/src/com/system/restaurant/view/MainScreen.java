package com.system.restaurant.view;

import java.util.Scanner;

import com.system.restaurant.employee.EmployeeService;

public class MainScreen {
	public static void mainScreenload() {

		Scanner scan = new Scanner(System.in);
		boolean loop = true;

		while (loop) { // 루프 1차
			Templates.printMenu();

			System.out.print("입력: ");
			int sel = scan.nextInt();

			switch (sel) {
				case 1: {
					// 인력관리>우돌
					No1Menu.loadNum1();
					//EmployeeService.staffLoad();
					break;
				}
				case 2: {
					// 재고관리>승진
					No2Menu.loadNum2();
					break;
				}
				case 3: {
					// 매출관리>형년
					No3Menu.loadNum3();
					break;
				}
				case 4: {
					// 예약관리
					No4Menu.loadNum4();
					break;
				}
				case 5: {
					// 주문관리
					No5Menu.loadNum5();
					break;
				}
				default: {
					return;
				}
			}

		}
	}
}
