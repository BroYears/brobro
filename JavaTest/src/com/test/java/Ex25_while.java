package com.test.java;

import java.util.Scanner;

public class Ex25_while {

	public static void main(String[] args) {
		
		
		/*
		
			반복문
			1. for
			2. while 	- for문이랑 비슷함
			3. do while	- 거의 안씀
			-----------
			4. for
			
			while
			
			if (조건식) {
				문장;
			}
			
			while (조건식) {
				문장;
			} - if문을 반복
			
			
			do
			{
				문장;
			} while (조건식);
			
			
		
		 */
		//m1();
		//m2();
		//m3();
		//m4();
		m5();
	
	
	}

	private static void m5() {

		int sum = 0;
		
		for (int i=1; i<=10; i++) {
			
			System.out.print(i + " + ");
			
//			if ( i!= 10) {
//				System.out.print(i + " + ");
//			} else {
//				System.out.print(i + " = ");
//			}
			
			sum += i;
			
		}
		
		System.out.println("\b\b= " + sum);
		
	}

	private static void m4() {
		int n = 1;
		
		while(n<=10) {
			System.out.println(n);
			n++;
		}
		
		System.out.println();
		
		int m = 1;
		
		do {
			System.out.println(m);
			m++;
		} while(m <= 10);
		
	}

	private static void m3() {
		
		//자판기
		//- (메뉴 출력 > 선택 > 결과) x 반복
		//- + 돈 투입 > 가격 처리 > 잔돈 환금
		
		Scanner scan = new Scanner(System.in);
		
		boolean loop = true;
		
		while (loop) {
		
			showMenu();
			 
			System.out.print("투입 금액: ");
			int money = scan.nextInt(); //1000(엔터) -> 버퍼에 엔터가 남아버림 -> 안버려줌 -> 빈 문자열를 입력해 버림
			
			//scan.skip("\r\n");
			scan.nextLine();//빈 문자열 버려버리기
			
			System.out.print("메뉴 선택: ");			
			String sel = scan.nextLine();//홍길동(엔터) -> 버퍼에 엔터가 남아버림 -> 버려줌

			// 가격 알려주기
			if (sel.equals("1")) {
				
				if(checkMoney(scan, money, 700)) {
					System.out.println("700원입니다.");
					System.out.printf("잔돈 %,d원을 반환합니다.\n",
										money - 700);
					pause(scan);
				} else {
					continue;
				}
				
//				System.out.println("700원입니다.");
//				pause(scan);
			} else if (sel.equals("2")) {
//				System.out.println("600원입니다.");
//				pause(scan);
				
				if(checkMoney(scan, money, 600)) {
					System.out.println("600원입니다.");
					System.out.printf("잔돈 %,d원을 반환합니다.\n",
										money - 700);
					pause(scan);
				} else {
					continue;
				}
				
			} else if (sel.equals("3")) {
//				System.out.println("500원입니다.");
//				pause(scan);
				
				if(checkMoney(scan, money, 700)) {
					System.out.println("500원입니다.");
					System.out.printf("잔돈 %,d원을 반환합니다.\n",
										money - 500);
					pause(scan);
				} else {
					continue;
				}
				
			} else {
				//break;
				loop = false;
			}
			
		}//while
		
		System.out.println("자판기를 종료합니다.");
		
	}
	
	
	public static boolean checkMoney(Scanner scan, int money, int price) {
		if (money < price ) { 
			System.out.println("잔액이 부족합니다.");
			System.out.println("투입 금액을 반환헀습니다.");
			pause(scan);
			//continue;
			return false;
		} else {
			return true;
		}
	}

	public static void showMenu() {
		System.out.println("==========");
		System.out.println("  자판기  ");
		System.out.println("==========");
		System.out.println("1. 콜라");
		System.out.println("2. 사이다");
		System.out.println("3. 박카스");
		System.out.println("4. 종료");
		System.out.println("---------");
		//System.out.print("선택: ");
	}

	public static void pause(Scanner scan) {
		System.out.println();
		System.out.println("계속하려면 엔터를 입력해주세요.");
		scan.nextLine();//잠시 멈추는 용도로 사용
	}

	private static void m2() {
		
		//1~100까지 합
		int sum = 0;
		
		for (int i=1; i<=100; i++) {
			sum += i;
		}
		
		System.out.println(sum);
		
		sum = 0;
		int num = 1; //루프 변수
		
		while (num <= 100) {
			sum += num;
			num++;
		}
		
		System.out.println(sum);
		
	}

	private static void m1() {
		
		//요구사항] 1~10까지 출력하시오.
		for (int i=1; i<=10; i++) {//초기식;조건식;증감식
			System.out.println(i);
		}
		System.out.println();
		
		int num = 1;//for의 초기식
		
		while (num <= 10) { //for의 조건식
			System.out.println(num);
			num++;//for의 증감식
		}
		
		System.out.println();
		
		//무한 루프
		
//		while (true) {
//			System.out.println();
//		}
//		
//		while (;;) {
//			System.out.println();
//		}
		
		
		
		
		
		
		
	}
	
	
	
	
}













