package com.test.java;

import java.util.Scanner;

public class Ex21_if {//클래스 이름 대문자로 시작, _도 잘 안씀

	
	public static void main(String[] args) {
		
//		m1();	
		//m2();
		
		
		/*
		 	
		 	자바(객체지향 프로그래밍 언어, OOP) > 3대장(어렵)
		 	
		 	1. 제어문 > 코드 실행의 흐름을 제어(통제)
		 	2. 자료구조 > 
		 	3. 클래스 > 
		 	
		 	
		 	제어문
		 	- 수 많은 문장 > 문장들이 실행되는 순서 > 위 -> 아래
		 	- 제어의 흐름을 통제하는 도구
		 	- 조건 제어, 반복 제어, 분기 제어
		 	
		 	1. 조건문
		 		- 개발자가 조건을 제시한 후 결과에 따라 흐름을 제어
		 		a. if
		 		b. switch
		 	
		 	2. 반복문
		 		- 특정 코드를 원하는 횟수만큼 반복 제어
		 		a. for
		 		b. while
		 		c. do while
		 		d. for(foreach, enhanced for statement), 향상된 for
		 				 		
		 	
		 	3. 분기문
		 		- 코드의 흐름을 원하는 곳으로 이동
		 		a. break
		 		b. continue
		 		c. goto(JDK 1.5 폐기) -> 다른 곳에서도 잘 안씀
		 		
		 		
		 	
		 */
		
		//m3();
//		M4();
		//m5();
		//m6();
		//m7();
		m8();
		
		
	}//main

	private static void m8() {
	
		/*
			
			자바 > C 계열 언어
			
			조건문
			1. 자바: boolean
			2. 타언어: boolean, 다른 자료형 사용 가능
			if (조건문) {
				
				실행문;
			
			}
			
			조건 문에서 다른 언어는 0이 아니면 1(ture, ex] 20 ...)로 받는 경우가 많음
			
			자료형
			1. 정수형 : 0(false), 0이외(ture)
			2. 실수형 : 0.0(false), 0이외(true)
			3. 문자형 : \0(false), 이외의 문자(ture)
			4. 문자열 : ""(false), "A"(true)
			
		*/
		
		//Ctrl + shift + F -> 정렬
		//Debug: F11
		//Ctrl + shift + B -> 디버그 모드에서 브레이크 포인트 -> 원하는 곳에서 멈출 수 있음
		//F6 누르면 다음 행동 시작
		//F8 누르면 남은 코드 모두 실행
		//Run: Ctrl + F11
		
		Scanner scan = new Scanner(System.in);

		System.out.print("기상 시각(시): ");

		int hour = scan.nextInt();

		if (hour < 6) {
			System.out.println("지하철을 타고 출근한다.");
		} else if (hour < 7) {
			System.out.println("버스를 타고 출근하다.");
		} else if (hour < 8) {
			System.out.println("택시를 타고 출근한다.");
		} else {
			System.out.println("병가를 낸다.");
		}
	}

	private static void m7() {
		
		
		//성적(0~100) 입력 > 합격/불합격
		//+ 유효성 검사
		Scanner scan = new Scanner(System.in);
		
		System.out.print("성적(0~100사이의 값): ");
		
		int score = scan.nextInt();
		
		//중첩 if문, nested if statement
		if(score >= 0 && score <= 100) {//유효성 검사
			
			if(score >= 60) {
				System.out.println("합격");
			} else {
				System.out.println("불합격");
			}
			
		} else {
			System.out.println("점수는 0~100 사이로 입력하세요");
		}
		
		
		if(score >= 60 && score <= 100) {
			System.out.println("합격");
		} else if(score >= 0 && score > 60) {
			System.out.println("불합격");
		} else {
			System.out.println("점수는 0~100 사이로 입력하세요.");	
		}
		
	}

	
	
	private static void m6() {
	
	
		//심리 테스트
		
		//질문 > 항목 선택 > 항목에 따라 점수 누적
		
		
		//int i = 0;
		//int e = 0;
		
		int sum = 0;//누적 변수(보통 0으로 초기화)
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1. 어떤 개발툴을 선호합니까?");
		System.out.println("a. 메모장");	 //+1
		System.out.println("b. 이클립스");	 //+3
		System.out.println("c. 인텔리제이");//+5
		
		System.out.print("선택: ");
		
		String sel = scan.nextLine();
		
		if (sel.equals("a")) {
			sum += 1;
		} else if (sel.equals("b")) {
			sum += 3;
		} else if (sel.equals("c")) {
			sum += 5;
		}
		
		System.out.println("2. 어떤 프로그래밍 언어를 선호합니까?");
		System.out.println("a. Java");	//+7
		System.out.println("b. C#");	//+3
		System.out.println("c. Kotlin");//+2
		
		System.out.print("선택: ");
		
		sel = scan.nextLine();
		
		if (sel.equals("a")) {
			sum += 7;
		} else if (sel.equals("b")) {
			sum += 3;
		} else if (sel.equals("c")) {
			sum += 2;
		}
		
		System.out.println("3. 하루에 몇 시간을 코딩합니까?");
		System.out.println("a. 4시간");	 //+10
		System.out.println("b. 2시간");	 //+5
		System.out.println("c. 1시간 미만");//+1
		
		System.out.print("선택: ");
		
		sel = scan.nextLine();
		
		if (sel.equals("a")) {
			sum += 10;
		} else if (sel.equals("b")) {
			sum += 5;
		} else if (sel.equals("c")) {
			sum += 1;
		}
		
		System.out.println("설문이 완료되었습니다.");
		
		System.out.println();
		System.out.println("[결과]");
		
		if (sum >= 15) {
			System.out.println("당신은 개발자의 자질이 높습니다.");
		} else if (sum > 7) {
			System.err.println("개발자가 되려면 조금 더 노력하세요.");
		} else {
			System.out.println("치킨집을 하세요.");
		}
		
		
		
	}

	private static void m5() {

		//출근 > 기상?
		Scanner scan = new Scanner(System.in);
		
		System.out.print("기상 시각(시): ");
		
		int hour = scan.nextInt();
		
		if (hour < 6) {
			System.out.println("지하철을 타고 출근한다.");
		} else if (hour >= 6 && hour <7) {
			System.out.println("버스를 타고 출근하다.");
		} else if (hour >= 7 && hour <8) {
			System.out.println("택시를 타고 출근한다.");
		} else {
			System.out.println("병가를 낸다.");
		}
		
		if (hour < 6) {
			System.out.println("지하철을 타고 출근한다.");
		} else if (hour <7) {
			System.out.println("버스를 타고 출근하다.");
		} else if (hour <8) {
			System.out.println("택시를 타고 출근한다.");
		} else {
			System.out.println("병가를 낸다.");
		}// 이 쪽 코드가 더 좋음
	
	
		
		
}

	private static void M4() {
		
		//나이입력
		Scanner scan = new Scanner(System.in);
	
		System.out.print("나이: ");
		int age = scan.nextInt();
		
		String result = age >= 18 ? "성인" : "미성년자";
		System.out.println(result);
		
		if (age >= 18) {
			System.out.println("성인");
		} else {
			System.out.println("미성년자");
		}
		
	}

	private static void m3() {
	
		/*
		  	***** 제어문 > 실행 순서
		  	
		  	if문 구문
		  	
		  	
		  	if문 구문
		  	- 조건문: boolean을 가지는 표현식
		  	
		  	
		  		
		  		구현부
		  	if (조건문) { 
		  		문장;
		  	}
		  	
		  	
		  	1
		  	
		  		  2
		  	if (ture) { 3
		  		문장;4
		  		문장;
		  		문장;
		  	}5
		  	
		  	6
		  	
		  	1
		  	
		  		  2
		  	if (false) { 
		  		문장;
		  		문장;
		  		문장;
		  	} 3
		  	
		  	
		  	4
		  	
		  	***** 어떤 제어문이 블럭 1개를 실행했다면 나머지 블럭은 실행 절대 안함.
		  	
		  	if (조건문) { //참 블럭
		  		문장;
		  	} else { //거짓 블럭
		  		문장;
		  	}
		  	
		  	if (조건문) {
		  		문장;
		  	} [else if { 
		  		문장;
		  	}] x N - [] x N 구문을 설명하기 위한 구문
		  	
		  	if (조건문) {
		  		문장;
		  	} [else if { 
		  		문장;
		  	}] x N
		  	[else {
		  	
		  	
		  	}] - N 없으면 한 번만 쓰란 뜻
		  	
		  	
		 */
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자: ");
		
		int num = scan.nextInt();
		
		if (num > 0) { //참 블럭
			System.out.printf("입력한 %d는 양수입니다.\n", num);
			}
		
		
		if (num > 0) { //참 블럭
			System.out.printf("입력한 %d는 양수입니다.\n", num);
		} else {
			System.out.printf("입력한 %d는 양수가 아닙니다.\n", num);
		}
		
		
		if (num > 0) {
			System.out.printf("입력한 %d는 양수입니다.\n", num);
		} else if(num < 0) {
			System.out.printf("입력한 %d는 음수입니다.\n", num);
		} else {
			System.out.printf("입력한 %d는 0입니다\n", num);
		}
		
		System.out.println("프로그램이 종료.");
		
		
	
	}//m3

	private static void m2() {
		
		//System.out.printf("형식문자", 값);
	
		//String String.format("형식문자", 값)
		
		int num = 1000000;
		
		System.out.printf("%,d\n", num);
		
		
	}
	
	private static String getNum(int num) {
		
		//천단위 표시 > 문자열 반환
		//1000000 > " 1,000,000"
		
		
		
		return String.format("%,d", num);//출력 값이 아니라 \n 안넣었음
		
//		String result = getNum(num);
//		
//		System.out.println(result);
	}
	
	
	

	private static void m1() {
		
		//콘솔 입력
		//1. System.in.read()
		//2. BufferedReader	read	>
		//3. Scanner	scan		> 둘 다 잘쓰임, 서로 쓰이는게 조금씩 다름
		
		System.out.print("나이: ");
		
		Scanner scan = new Scanner(System.in);//throw 문 삽입
		
		//reader.readLine() 동일
		String input = scan.nextLine();
		
		//		  Wrapper Class
		int age = Integer.parseInt(input); //"20 > 20
		
		System.out.println(age >= 18 ? "성인" : "미성년자");
		
		System.out.print("나이 : ");
		
		age = scan.nextInt();//자료형 별로 입력받는 전용메서드 존재 -> 편리
		
		System.out.print(age >= 18 ? "성인" : "미성년자");
		
		
	}
}












