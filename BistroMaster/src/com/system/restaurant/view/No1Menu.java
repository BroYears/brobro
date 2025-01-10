package com.system.restaurant.view;

import java.util.Scanner;

import com.system.restaurant.employee.EmployeeService;
import com.system.restaurant.employee.User;

public class No1Menu {

	public static void loadNum1() {

		Scanner scan = new Scanner(System.in);

		boolean loop = true;
		while (loop) {
			subMenuTemp();
			
			int mainInput = scan.nextInt();
			scan.skip("\r\n");

			if (mainInput == 0) {
				loop = false;
			} else if (mainInput <= EmployeeService.employeeMaxCount && mainInput > 0) {
				EmployeeService.showEmployeeInfos(mainInput);
				//여긴 break는 안됨.
			} else if (mainInput == EmployeeService.employeeMaxCount + 1) {
				EmployeeService.employeeAdd();
			} else if (mainInput == 9) {
				mainInput = EmployeeService.remove();
			} else {
				System.out.printf("0번~%d번,9번만 입력하시오. \n", EmployeeService.employeeMaxCount + 1);
				continue;
			}
			
			EmployeeService.save();
			
		}
	}

	public static void subMenuTemp() {
		EmployeeService.employeeLoad();

		EmployeeService.employeeMaxCount = EmployeeService.Users.size(); // 갯수만큼 for문
		Sub_Menus_Temp.makeSubTitle("직원관리", 10); // 제목
		for (User user1 : EmployeeService.Users) {
			String h = String.format("%d.%s(%s)", user1.getNo(), user1.getName(), user1.getType1());
			Sub_Menus_Temp.makeSubCategory(h, 12);
		}

		String ah = String.format("%s.직원추가", EmployeeService.employeeMaxCount + 1);
		Sub_Menus_Temp.makeSubCategory(ah, 10);

		String dh = String.format("9.직원삭제");
		Sub_Menus_Temp.makeSubCategory(dh, 10);

		System.out.print("(");
		for (User user2 : EmployeeService.Users) {
			System.out.printf("%s %d번 / ", user2.getName(), user2.getNo());

		}

		System.out.printf("인력추가 %s번", EmployeeService.employeeMaxCount + 1);
		System.out.print("/");
		System.out.println("인력삭제 9번 / 초기화면 0번)");
	}

}
