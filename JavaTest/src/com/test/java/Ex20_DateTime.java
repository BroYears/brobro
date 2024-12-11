package com.test.java;

import java.util.Calendar;
import java.util.Date;

public class Ex20_DateTime {

	
	public static void main(String[] args) {
		
		
		//주변 데이터 > 문자(열), 숫자, 날짜(시간)
		
		/*
		 	
		 	시각 vs 시간
		 	
		 	시각 - 점, 포인트, 위치
		 	시간 - 양, 범위
		 	
		 	시간 + 시간 = 시각 C.add()
		 	시각 - 시간 = 시각 C.add()
		 	시각 - 시각 = 시간 tick - tick
		 	
		 	시간 + 시간 = 시간
		 	시간 - 시간 = 시간
		
		 */
		
		//m1();//F3 -> 정의된 곳을 찾음, Outline으로도 찾을 수 있음
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		m8();
		
		
		
	}//main
	
	private static void m8() {
		
		
		//내가 짠 코드의 실행 소요 시간?
		//long start = System.currentTimeMillis();
		long start = System.nanoTime();
		
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");
		System.out.println("내가 짠 코드 실행");

		
		//long stop = System.currentTimeMillis();
		long stop = System.nanoTime();
		
		System.out.printf("소요시간: %dns", stop - start);
		
	}

	private static void m7() {
		
		
		//현재 시각의 tick
		Calendar now = Calendar.getInstance();
		System.out.println(now.getTimeInMillis());
		
		//전용 메서드(현재 시각 tick)
		System.out.println(System.currentTimeMillis());//Calendar now = Calendar.getInstance();
													   //System.out.println(now.getTimeInMillis());랑 똑같음
		
		
		
	}

	private static void m6() {
		//시간 + 시간 = 시간
		//시간 - 시간 = 시간
		
		//2시간 30분 + 1시간 10분 = 3시간 40분
		
//		Calendar c1 = Calendar.getInstance();
//		c1.set(Calendar.HOUR, 2);
//		c1.set(Calendar.MINUTE, 30); - 이러면 시각이라 안됨
		
		int h1 = 2;
		int h2 = 1;
		
		System.out.println(h1 + h2);
		
		//2시간 30분 + 10분 = 2시간 40분
		int hour = 2;
		int min = 30;
		
		//min = min + 10;
		min += 10;
		
		System.out.printf("%d시간 %d분\n", hour, min);
		
		//2시간 30분 + 40분 = 3시간 10분
		hour = 2;
		min = 30;
		
		min += 40;
		
		hour = hour + (min / 60); //2시간 + 1시간
		min = min % 60; //70분 -> 10분
		
		System.out.printf("%d시간 %d분\n", hour, min);	
		
		
	}

	//변수명, 메서드명, 클래스명, 파일명 등 > 식별자를 수정하는 방법(이클립스)
	private static void m5() {
		
		//연산
		//- 시각 - 시간 = 시간
		
		//내가 태어나서 살아온 시간?
		Calendar now = Calendar.getInstance();
		Calendar birthday = Calendar.getInstance();
		birthday.set(1994, 6, 17, 14, 30, 0);
		
		//System.out.println(now.add());
		
		// 2024년 12월 11일 14시 30분 00초
		//-1999년  6월  1일 14시 30분 00초
		//--------------------------------
		//					   0시 0분 0초
		
		//tick
		//Epoch Time, Unix Time
		//System.out.println(now.getTimeInMillis()); //1,733,897,479,538ms
		
		long gap = now.getTimeInMillis() - birthday.getTimeInMillis();
		
		System.out.printf("살아온 시간: %,dms\n", gap);
		System.out.printf("살아온 시간: %,d시간\n", gap / 1000 / 60 / 60);
		System.out.printf("살아온 시간: %,d일\n", gap / 1000 / 60 / 60 / 24);
		
		
		//수료일까지 며칠?
		Calendar end = Calendar.getInstance();
		end.set(2025, 4, 26);
		
		gap = end.getTimeInMillis() - now.getTimeInMillis();
		
		System.out.printf("수료일까지 남은 일: %d\n",
							gap / 1000 / 60 / 60 / 24);
		
		//오늘 집에 가려면 몇 시간?
		Calendar out = Calendar.getInstance();
		out.set(Calendar.HOUR_OF_DAY, 17);
		out.set(Calendar.MINUTE, 50);
		
		System.out.printf("집에가는 남은 시간 ~ : %f시간\n",
							(out.getTimeInMillis() - now.getTimeInMillis()) / 1000.0 / 60 / 60);
		
		
		
		
	}

	private static void m4() {
		
		//연산
		//- 시각 + 시간
		//- 시각 - 시간
		
		//오늘 만난 커플 > 100일?
		//오늘(시각) + 100일(시간) = 기념일(시각)
		//Calendar	 + int		    = Calendar
		
		Calendar now = Calendar.getInstance();
		
		//산술 연산자는 피연산자로 기본형만 가질 수 있다. -> 참조형 불가
		//Calendar -> 참조형
		//System.out.println(now + 100);
		
		//시각 + 시간
		//- void add(상수, 더할 값)
		
		now.add(Calendar.DATE, 99);
		System.out.printf("100일차 : %tF\n", now);
		
		now = Calendar.getInstance();
		
		now.add(Calendar.DATE, 200);//위에 값에 누적
		System.out.printf("200일차 : %tF\n", now);
		
		
		now = Calendar.getInstance();
		
		
		//일주일 전?
		now.add(Calendar.DATE, -7); // 모든 걸 더하고 뺄 수 있다.
		System.out.printf("일주일 전 : %tF\n", now);
		
		now = Calendar.getInstance();
		
		
		//3년 뒤?
		now.add(Calendar.YEAR, 3);
		System.out.printf("3년 뒤: %tF\n", now);
		
		//컵라면 > 3분뒤
		now = Calendar.getInstance();
		now.add(Calendar.MINUTE, 3);
		System.out.printf("라면드세요 : %tT\n", now);
		
		
		
	}

	private static void m3() {
		
		//-현재 시각 얻어오기
		//-특정 시각 얻어오기
		
		//올해 크리스마스
		//1. 현재 시각 얻어오기
		//2. 특정 시각 수정하기
		
//		Calendar christmas = Calendar.getInstance(); //지금
//		
//		System.out.printf("%tF %tT\n", christmas, christmas);

		//메서드명 패턴(접두어)
		//1. getXXX() > 가져온다. 읽기 메서드
		//	- 반환자료형 getXXX();
		
		//2. setXXX() > 넣는다. 쓰기 메서드
		//	- void setXXX(매개변수);
		
		//3. isXXX() > 확인용. 반환값(Boolean)
		//	- boolean isMale(주민번호);
		
		//Calendar 메서드
		//1. int get(int): 요소 읽기
		//2. void set(오버로딩): 요소 쓰기(=수정하기)
		
		Calendar christmas = Calendar.getInstance(); //지금
		
		System.out.printf("%tF %tT\n", christmas, christmas);

		//11일 > 25일
//		christmas.set(Calendar.YEAR, 2025);
//		christmas.set(Calendar.DATE, 25);
//		christmas.set(Calendar.HOUR_OF_DAY, 0);
//		christmas.set(Calendar.MINUTE, 0);
//		christmas.set(Calendar.SECOND, 0);
		
		//christmas.set(2025, 4, 10); //한 번에 바꿀 때는 이거
		//christmas.set(2024, 11, 25, 0, 0);
		christmas.set(2024, 11, 25, 0, 0, 0);
		
		System.out.printf("%tF %tT\n", christmas, christmas);
		
		
		
	}

	private static void m2() {
		
		//java.util.Date
		//java.util.Calendar
		
		//Calendar 클래스
		Calendar now = Calendar.getInstance();	//메서드의 반환값으로 캘린더 출력
											  	//현재 시각
		//java.util.GregorianCalendar[time=1733886638406,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="GMT+09:00",offset=32400000,dstSavings=0,useDaylight=false,transitions=0,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2024,MONTH=11,WEEK_OF_YEAR=50,WEEK_OF_MONTH=2,DAY_OF_MONTH=11,DAY_OF_YEAR=346,DAY_OF_WEEK=4,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=0,HOUR_OF_DAY=12,MINUTE=10,SECOND=38,MILLISECOND=406,ZONE_OFFSET=32400000,DST_OFFSET=0]
		System.out.println(now);
		System.out.println();
		
		//집합 데이터 > 원하는 부분 추출
		//- int get(int)
		//- 
		
		int year = 1;
		
		System.out.println(now.get(year));
		System.out.println(now.get(2));
		System.out.println(now.get(3));
		System.out.println(now.get(4));
		System.out.println(now.get(5));
						
		System.out.println(Calendar.YEAR);//식별자가 다 대문자면 상수
		
		System.out.println(now.get(Calendar.YEAR));//캘린더 상수
		System.out.println();
		
		
		System.out.println(now.get(Calendar.YEAR)); 		//년도
		System.out.println(now.get(Calendar.MONTH)); 		//월(0~11)
		System.out.println(now.get(Calendar.DATE));			//일
		System.out.println(now.get(Calendar.HOUR));			//시간
		System.out.println(now.get(Calendar.MINUTE));		//분
		System.out.println(now.get(Calendar.SECOND));		//초
		System.out.println(now.get(Calendar.MILLISECOND));	//밀리초
		System.out.println(now.get(Calendar.AM_PM));		//오전(0), 오후(1)
		System.out.println(now.get(Calendar.DAY_OF_YEAR));	//연을 기준으로
		System.out.println(now.get(Calendar.DAY_OF_MONTH));//일 = DATE
		System.out.println(now.get(Calendar.DAY_OF_WEEK));	//요일 = 1 ~ 7, 일요일부터
		System.out.println(now.get(Calendar.WEEK_OF_YEAR));//50 > 몇 주차
		System.out.println(now.get(Calendar.WEEK_OF_MONTH));//이번 달 몇 주 차
		System.out.println();
		System.out.println();

		//요구사항] "오늘은 2024 12월 11일 입니다.
		
		//%02d -> 2자리인데 모자란 곳은 0을 채운다는 의미. ex) 1 -> 01
		System.out.printf("오늘은 %d년 %02d월 %02d일입니다.\n"
							, now.get(Calendar.YEAR)
							, now.get(Calendar.MONTH) + 1
							, now.get(Calendar.DATE)
							);
		
		//요구사항] "지금은 오후 2시 36분 49초입니다" > 12H
		//요구사항] "지금은 14시 36분 49초입니다" > 24H

		
		System.out.printf("지금은 %02d시 %02d분 %02d입니다.\n"
							, now.get(Calendar.HOUR_OF_DAY)
							, now.get(Calendar.MINUTE)
							, now.get(Calendar.SECOND)
						);
		
		System.out.printf("지금은 %s %02d시 %02d분 %02d입니다."
							, now.get(Calendar.AM_PM) == 1 ? "오후" : "오전"
							, now.get(Calendar.HOUR)
							, now.get(Calendar.MINUTE)
							, now.get(Calendar.SECOND)
						);
		
		System.out.println();
		//printf() > 형식 문자(날짜/시간)
		System.out.printf("%tF\n", now); //2024-12-11
		System.out.printf("%tT\n", now); //12:48:03
		System.out.printf("%tA\n", now); //수요일
		
		
	}

	private static void m1() {
		
		
		//날짜, 시간 클래스
		//1. Date
		//2. Calendar
		//-----------------
		//3. java.time 패키지 > LocalDate...등
		
		//Date 클래스
		Date now = new Date(); //now 변수 > 컴퓨터의 현재 시각
		
		

		//Wed Dec 11 12:04:22 GMT+09:00 2024
		//Wed Dec 11 12:05:02 GMT+09:00 2024
		System.out.println(now);
		
	}
	
	
	
}
