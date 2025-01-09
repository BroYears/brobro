package com.system.restaurant.domain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.system.restaurant.reservation.Reservation;

public class TodaysInfo {
	
	public static final String PATH_R = ".\\data\\예약\\예약 더미데이터.txt";
	public static ArrayList<Reservation> mainreadDate = new ArrayList<>();
	
	public static void todaysInfo(String today) {
		System.out.println();
		System.out.println("                   오늘의 알림");
		System.out.println("─".repeat(50));
		
		System.out.println("1. 예약자 목록" + " \uD83D\uDCC5");
		infoReservation(today);
		System.out.println();
		
		
		System.out.println("2. 유통기한 임박 알림 (D-3)" + " \u26A0");
		System.out.println("   - 냉면 유통기한이 D-3 남았습니다. ");
		System.out.println();
		System.out.println("3. 오늘 폐기해야 할 재고 목록(D-0)" + " \uD83D\uDED1");
		System.out.println("   - 냉면 유통기한이 오늘까지입니다. ");
		System.out.println();
		
		if(today.endsWith("25")) {
			System.out.println("4. 월말 정산을 위한 지출내역 입력 요청" + " \uD83D\uDCB0");
			System.out.println("   - 가스비를 입력하세요.");
		}
		
		System.out.println("─".repeat(50));
	}
	
	public static void infoReservation(String today) {
		TodaysInfo i = new TodaysInfo();
		i.reservationListLoad();
		
		mainreadDate.sort((r1, r2) -> r1.getDateTime().compareTo(r2.getDateTime()));

		List<Reservation> todayList = mainreadDate.stream().filter(r -> r.getDateTime().contains(today))
				.distinct().toList();
		
		int count = todayList.size();
		
		System.out.println("오늘 예약은 총 " + count + "건 있습니다.");
	}
	
	
	void reservationListLoad() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(PATH_R));
			String line = "";
			try {
				while ((line = reader.readLine()) != null) {
					String[] temp = line.split(",");


					int no = Integer.parseInt(temp[0]);
					String name = temp[1];
					String phnoeNumber = temp[2];
					int Hnumber = Integer.parseInt(temp[3]);//인원수
					String dateTime = temp[4];
					
					mainreadDate.add(new Reservation(no, name, phnoeNumber, dateTime, Hnumber));
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
