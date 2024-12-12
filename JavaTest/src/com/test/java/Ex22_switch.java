package com.test.java;

import java.util.Scanner;

public class Ex22_switch {

	public static void main(String[] args) {

		/*
		 * switch문, switch case문 - if문: 조건문 > boolean을 가진다. - switch문: 조건값 > 변수/상수 > 정수,
		 * 문자열, 열거형
		 * 
		 * switch (조건값) { case 값: 문장; break; [case 값: 문장; break;] x N [default: 문장;
		 * break;] }
		 * 
		 */

		//m1();
		//m2();
		m3();
		//m4();
		//m5();
		
		
	}

	private static void m5() {
		
		//*** 메서드 or 제어문 영역 인식 변수 > 블록 영역 변수, Block Scoped Variable
		
		int n1 = 10;
		
		if (n1 > 0) {
			int n2 = n1;
			System.out.println(n2);
			//int n1 = 30; 중복 변수 선언
		}
		
		if (n1 > 0) {
			int n2 = 30;
			System.out.println(n2);
		}
		
		
		
	}

	private static void m4() {
		
		
//		if(true) {
//			System.out.println("참");
//		} else {
//			System.out.println("거짓"); //Dead Code
//		}
//		
//		boolean flag = true;
		
		
		//Cannot switch on a value of type boolean. Only convertible int values, strings or enum variables are permitted
//		switch (flag) {//조건이 제한적
//			case true:
//				System.out.println("참");
//				break;
//			case false:
//				System.out.println("참");
//				break;
//		}
		
		
		int num = 10;
		
		//** 모든 제어문의 실행 블랙내의 문장 1개면 {}을 생략 가능
		if (num >0) System.out.println("양수");
		else System.out.println("양수 아님");
		System.out.println();
		
		
		if (num > 0) {
			System.out.println("양수");
			System.out.println("종료");
		}
		
		
		
			
		
	}

	private static void m3() {
		//요구사항] 자판기
		//- 메뉴 출력 > 음료 선택 > 가격 출력
		//- 사이다 > 700원 > 콜라/사이다 항상 동일한 가격에 판매!
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("============");
		System.out.println("   자판기");
		System.out.println("============");
		System.out.println("1. 콜라");
		System.out.println("2. 사이다");
		System.out.println("3. 박카스");
		System.out.println("------------");
		System.out.print("번호 선택: ");
			
		String sel = scan.nextLine();
		
		int price = 0;
		
		if (sel.equals("1" )) {
			//System.out.println("선택한 음료의 가격은 700원 입니다.\n");
			price = 700;
		} else if(sel.equals("2")) {
			//System.out.println("선택한 음료의 가격은 600원 입니다.\n");
			price = 700;
		} else if(sel.equals("3")) {
			//System.out.println("선택한 음료의 가격은 500원 입니다.\n");
			price = 500;
		}
		
		if (sel.equals("1") || sel.equals("2")) {
			price = 800;
		} else if(sel.equals("3")) {
			price = 500;
		}
		
		System.out.printf("선택하신 음료의 가격은 %d원입니다.\n", price);
		
		switch (sel) {//switch문이 좀 더 가독성 높음 - 직관적
			case "1"://같은 구역인 애들은 머리통만 있기도 함
			case "2":
				price = 800;//brak안걸려서 여기까지 인식
				break;
			case "3":
				price = 500;
				break;
		}
		
		System.out.printf("선택한 음료의 가격은%d원입니다.\n", price); 
		
		
	}

	private static void m2() {
		
		
		//몸무게 처리
		//1. 50kg 미만 > 저체중
		//2. 100kg 이상 > 과체중
		//3. 50kg~100kg > 정상체중
		
		int weight = 70;
		
		if (weight < 50) {
			System.out.println("저체중");			
		} else if (weight < 100) {
			System.out.println("정상체중");
		} else {
			System.out.println("과체중");
		}//가독성이 별로임
		
		if (weight >= 50 && weight < 100) {//정상일 경우
			System.out.println("정상체중");			
		} else {//비정상일 경우로 그룹 나눠서 가독성 높임
			
			if (weight < 50) {
				System.out.println("저체중");
			} else if (weight >= 100) {
				System.out.println("과체중");
			}
			
		}
		//몸무게 처리(1~120)
		//1. 50kg 미만 > 저체중
		//2. 100kg 이상 > 과체중
		//3. 50kg~100kg > 정상체중
		
		switch (weight) {//케이스는 정확한 값에 대응하기 때문에 범위 비교 어려움. 
			case 70:
				System.out.println("정상체중");
				break;
			case 71:
				
		}
		
		switch (weight / 10) {//이렇게 범위를 좁혀서 하는 방법이 있긴함. 그래도 어려움.
			case 7:
				System.out.println("정상체중");
				break;
			case 8:
			
		}
		
		
		
	}

	private static void m1() {
		// 요구사항] 숫자를 1개를 입력받아 한글로 출력하시오.
		// 1 > "하나"
		// 2 > "둘"

		// 보일러플레이트 코드
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자: ");
		int num = scan.nextInt();

		if (num == 1) {
			System.out.println("하나");
		} else if (num == 2) {
			System.out.println("둘");
		} else if (num == 3) {
			System.out.println("셋");
		} else {
			System.out.println("범위를 벗어난 숫자입니다.");
		}

		switch (num) {
			case 1: // 1: 라벨(Label)
				System.out.println("하나");
				break; // 밖으로 나가라
			case 2:
				System.out.println("둘");
				break;
			case 3:
				System.out.println("셋");
				break;
			default:
				System.out.println("범위를 벗어난 숫자입니다.");
				break;
		}

	}

}
