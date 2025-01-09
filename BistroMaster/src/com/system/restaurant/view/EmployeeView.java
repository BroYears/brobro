package com.system.restaurant.view;

import java.util.ArrayList;

import com.system.restaurant.employee.EmployeeService;
import com.system.restaurant.employee.User;

public class EmployeeView {
	
	public static void subMenu(){
		
		System.out.println("1.인력관리");
		// 인력관리 View를 보여주고 Service 할 메소드 번호 선택 1 ~ 9 
		EmployeeService.employeeMaxCount = EmployeeService.Users.size();
		
		Sub_Menus_Temp.makeSubTitle("직원관리", 10);
		for (User user1 : EmployeeService.Users) {
			String h = String.format("%d.%s(%s)",user1.getNo(),user1.getName(),user1.getType1());
			Sub_Menus_Temp.makeSubCategory(h, 12);
			
//			System.out.printf("  %d. %s(%s)  \n",user1.getNo(),user1.getName(),user1.getType1());
			
		}
		
		String ah = String.format("%s.직원추가",EmployeeService.employeeMaxCount+1);
		Sub_Menus_Temp.makeSubCategory(ah, 10);
//		System.out.printf("  %s. 인력추가 \n",EmployeeService.employeeMaxCount+1);
		
		String dh = String.format("9.직원삭제");
		Sub_Menus_Temp.makeSubCategory(dh, 10);
//		System.out.println("  9. 인력삭제 ");
//		System.out.println();
		
		System.out.print("(");
		for (User user2 : EmployeeService.Users) {
			System.out.printf("%s %d번 / ",user2.getName(),user2.getNo());
			
		}
		
		
		System.out.printf("인력추가 %s번",EmployeeService.employeeMaxCount+1);
		System.out.print("/");
		System.out.println("인력삭제 9번 / 초기화면 0번)");
		
	}//subMenu
	
}
