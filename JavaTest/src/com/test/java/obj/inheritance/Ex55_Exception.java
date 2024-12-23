package com.test.java.obj.inheritance;

import java.util.Random;
import java.util.Scanner;

public class Ex55_Exception {
	
	public static void main(String[] args) { //throws Exception(예외 미루기) 메인에는 쓰면 안됨
		
		
		
		
		/*
		 
		  	예외, Exception
		  	- 런타임 오류
		  	- 컴파일 발견(X) > 실행 중 발견(O)
		  	- 개발자 예측 > 사전 조치
		  	
		  	예외 처리, Exception Handling
		  	1. 제어문 사용
		  		- 선조건 후처리
		  	
		  	2. 전용 구문 사용 > try catch문
		  		- 선실행 후처리
		  			 
		 */
		
		//m1();
		//m2();
		//m3();
		m4();
		
		//try {
		//m5();
//		} catch (Exception e) {
//			System.out.println("예외처리");
//		}
		
//		Scanner scan = new Scanner(System.in);//java.util.NoSuchElementException -> 스캐너 꺼져서 안됨
//		System.out.println("입력: ");
//		System.out.println(scan.nextLine());
		//m6();
		//m7();
		
	}//main

	private static void m7() {

		Scanner scan = new Scanner(System.in);
		
		int num;
		
		while(true) {
			try {
				System.out.print("숫자: ");
				num = scan.nextInt();	
				break;
			} catch (Exception e){
				System.out.println("숫자만 입력하세요.");
				scan = new Scanner(System.in);//틀리면 아예 망가져버려서 무한루프 돌아버림 새로 만들자
			}
		}
		
		if (num % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		
	}
	
	private static void m6() {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("숫자: ");
		
		try {//다 묶는거랑 안묶인거랑 속도가 다름 -> 최소한으로 묶는게 좋음.
			int num = scan.nextInt();
			
			if (num % 2 == 0) {
				System.out.println("짝수");
			} else {
				System.out.println("홀수");
			}
			
		} catch (Exception e) {
			System.out.println("숫자만 입력하세요.");
		}
		
		
	}

	private static void m5() throws Exception {
		
		//예외 미루기
		int n =0;
		System.out.println(100 / n);
		
		
		
	}

	private static void m4() {

		Scanner scan = new Scanner(System.in);//open
		
		System.out.print("숫자: ");
		int num = scan.nextInt();
		
		try {
			//비즈니스 코드 영역
			System.out.println(100 / num);
			
			return;
			//scan.close();
		} catch (Exception e) {
			//예외 처리 영역
			System.out.println("0 입력");
			//scan.close();//중복코드 finally로 ㄱㄱ
		} finally {
			//자원 해제 영역
			//- 성공 or 실패 > 무조건 실행
			System.out.println("마무리");
			scan.close();//보증받은 마무리 -> 왜 실패했을 때 종료가 뜨지?
		}
		
		System.out.println("종료");
		
		scan.close();//close 이거 하고 나면 입력 아예 안됨
					 //java.util.NoSuchElementException -> 스캐너 꺼져서 안됨

	}

	private static void m3() {

		try {
			
			int num = 5; //입력
			System.out.println(100 / num);//throw new ArithmeticException()
		
		
			int[] nums = { 10, 20, 30 };
			System.out.println(nums [0]);//throw new ArrayIndexOutOfBoundsException()
			
				
			Random rnd = new Random();
			System.out.println(rnd.nextInt(10));//throw new NullPointerException()
			
			Scanner scan = new Scanner(System.in);
			scan.nextInt();//java.util.InputMismatchException
			
			//Exception 들은 서로 형제라 형변환 x
			// -> 그래서 통과
		} catch (ArithmeticException e) {
			System.out.println("0으로 나누기 - 김대리 연락");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 첨자 오류 - 박과장 연락");
		} catch (NullPointerException e) {
			System.out.println("널 참조 오류- 최대리 연락");
		} catch (Exception e) {//else절 느낌 -> 다 잡음 -> 맨 마지막에 배치
			System.out.println("예외 처리 - 사용에 불편을 드려 죄송합니다. 빠른 시일에 기능을 복구하겠습니다. 담당자 연락처: ");
		}
		
	}

	private static void m2() {

		
		//에러상황 3가지
		int num = 0; //입력
		
		try {
			System.out.println(100 / num);
		} catch (Exception e) {
			System.out.println("0으로 나누기 > 김대리 연락");
		}
		
		int[] nums = { 10, 20, 30 };
		
		try {
			System.out.println(nums [5]);
		} catch (Exception e) {
			System.out.println("배열 첨자 오류 > 박과장 연락");
		}
		
		Random rnd = null;
		
		try {
			System.out.println(rnd.nextInt(10));
		} catch (Exception e) {
			System.out.println("널 참조 > 최대리 연락"); 
		}
		
	}

	private static void m1() {
		
		//SF 둘 다 들어간 필드 System.in;
		//InputStream in = System.in;
		
		
		//요구사항] 숫자를 입력받아 계산을 하시오.
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자: ");
		//정수/0 = 에러
		//실수/0 = Infinity
		
		
		int num = scan.nextInt();
//		double num = scan.nextInt();
		
		//제어문을 사용한 예외 처리
		//예외 조건
		if(num != 0 ) {
			//비즈니스 코드(업무 코드)
			System.out.println("빨강");
			System.out.printf("100 / %d = %d\n", num, 100 / num);
			System.out.println("노랑");
		} else {
			//예외 처리 코드
			System.out.println("0을 입력하지 마세요.");
		}
		System.out.println();
		
		
		//예외 조건이 명시되어 있지 않다!
		//try는 예외를 미리 알지 못한다 > 에러가 발생
		//try가 에러를 확인해주고 catch가 에러 캐치해서 보내버림
		try { 
			//비즈니스 코드(업무 코드)
			System.out.println("빨강");
			System.out.printf("100 / %d = %d\n", num, 100 / num);
			System.out.println("노랑");
		} catch(Exception e) {
			//예외 처리 코드
			System.out.println("0을 입력하지 마세요.");
			
			//e: 예외 객체
			//- 발생한 예외에 대한 여러가지 정보를 제공한다.
			//System.out.println(e.getMessage());
			//e.printStackTrace();
			
		}
		
		System.out.println("프로그램 종료.");
		
	} 

}












