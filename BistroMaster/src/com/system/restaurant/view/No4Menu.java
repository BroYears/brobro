package com.system.restaurant.view;

import java.util.Scanner;

import com.system.restaurant.reservation.ReservationService;

public class No4Menu {
	
	public static void loadNum4() {

		ReservationService.load();
		
		Scanner scan = new Scanner(System.in);
		boolean loop = true;

		while (loop) {
			ReservationView.mainMenu();
			System.out.println("예약 목록 1번/예약 입력 2번/예약 수정 3번/예약 취소 4번/초기 화면 0번");
			System.out.println();
			
			System.out.print("선택: ");
			String sel = scan.nextLine();
		
			if (sel.equals("1")) {
				//예약 목록 몇일에 있는지
				ReservationService.reservationList();
				ReservationView.pause();
			} else if (sel.equals("2")) {
				//예약 추가
				ReservationService.reservationAdd();
				ReservationView.pause();
			} else if (sel.equals("3")) {
				//예약 수정
				ReservationService.reservationEdit();
				ReservationView.pause();
			} else if (sel.equals("4")) {
				//예약 수정
				ReservationService.reservationCancel();
				ReservationView.pause();
			} else if (sel.equals("0")) {
				loop = false; //종료
			} else {
				System.out.println("잘못된 숫자입니다.");
			}//if
		
		}//while
		
		System.out.println();
		System.out.println("초기 화면으로 돌아갑니다.");
		
	}

}
