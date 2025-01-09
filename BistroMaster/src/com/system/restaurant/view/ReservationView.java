package com.system.restaurant.view;

import java.util.Calendar;
import java.util.Scanner;

import com.system.restaurant.reservation.Reservation;
import com.system.restaurant.reservation.ReservationService;

public class ReservationView {
	
	
	public static void mainMenu() {
		
		Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.DAY_OF_MONTH, 1);
		
		int lastDay = c1.getActualMaximum(Calendar.DATE);
		int dayOfWeek = c1.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("===============================================================");
		System.out.println("                        예약 관리 목록");
		System.out.printf("                          %d년 %02d월\n", c1.get(Calendar.YEAR), c1.get(Calendar.DAY_OF_MONTH));
		System.out.println("===============================================================");
		System.out.println("  [일]\t  [월]\t  [화]\t  [수]\t  [목]\t  [금]\t  [토]");
		
		int dayCounter = 0; // 날짜 출력 개수 카운터

        // 빈 공간 출력 (1일의 요일 전까지)
        for (int i = 0; i < dayOfWeek - 1; i++) {
            System.out.print("        "); // 날짜 공간
            dayCounter++;
        }

        // 날짜 출력
        for (int i = 1; i <= lastDay; i++) {
            System.out.printf("   %2d   ", i); // 날짜 출력
            dayCounter++;

            // 줄 바꿈 (토요일마다)
            if (dayCounter % 7 == 0 || i == lastDay) {
                System.out.println(); // 날짜 줄 바꿈

                // 예약 여부 출력 (날짜 아래)
                for (int j = i - ((dayCounter - 1) % 7); j <= i; j++) {
                    if (j <= 0) {
                        System.out.print("        "); // 빈 공간
                    } else {
                        // 현재 날짜 계산
                        c1.set(Calendar.DAY_OF_MONTH, j);
                        String currentDate = String.format("%tF", c1); // yyyy-MM-dd
                        if (checkReservationForDate(currentDate)) {
                            System.out.print("    ●   "); // 예약이 있으면 별 출력
                        } else {
                            System.out.print("        "); // 예약이 없으면 빈 공간
                        }
                    }
                }

                System.out.println(); // 별 출력 줄 바꿈
            }
        }
		System.out.println("===============================================================");
		
	}
	
	private static boolean checkReservationForDate(String date) {
        for (Reservation rv : ReservationService.rlist) {
            // 예약의 날짜 부분만 추출 (yyyy-MM-dd)
            String reservationDate = rv.getDateTime().split(" ")[0];

            if (reservationDate.equals(date)) {
                return true; // 예약이 있으면 true 반환
            }
        }
        return false; // 예약이 없으면 false 반환
    }
	
	public static void pause() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println();
		
		System.out.println("계속하려면 엔터를 입력하세요.");
		scan.nextLine();
		
	}
	
}
