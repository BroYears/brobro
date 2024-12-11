package com.test.java;

public class Ex14_Method {
	
	
	//main 메서드
	//- 특수 메서드
	//- 이름이 예약된 메서드(=main)
	//- 프로그램이 사직되면 자동으로 호출되는 메서드 > JVM이 main() 호출
	//- 프로그램의 시작점(Entry Point)
	//- 프로그램의 종착점(End Point)
	
	public static void main(String[] args) {
		
		
		/*
		 
			메서드, Method
			- 함수(Function), 프로시저(Procedure), 서브 루틴(Sub Routine)..
			- 코드의 집합
			- 같은 목적을 가진 코든의 집합
			- 코드 분류 > 왜? > 관리 or 재사용
			- 코드 재사용의 단위(***)
			 
			
			메서드 사용 목적
			1. 코드 재사용
			2. 코드 관리(+가독성)
			
			메서드 사용 단계
			1. 메서드 선언
			2. 메서드 호출(사용)
						
				
			
		 */
		
		//요구사항] "반갑습니다." x 5 출력
		//수정사항] "반갑습니다." x 수정
		
		//단순한 방법
		//-Ctrl + C, Ctrl + V > 유지 보수가 힘들어진다.(***)
		//- 생산 비용 = 수정 비용 이 된다고 한다.
		
		System.out.println("반갑습니다.");
		System.out.println("반갑습니다.");
		System.out.println("반갑습니다.");
		System.out.println("반갑습니다.");
		System.out.println("반갑습니다.");//같은 코드 반복 지양
		System.out.println();
		
		
		//메서드 호출하기
		hello();
		hello();
		hello();
		hello();
		hello();
		
		//요구사항] "하나" ~ "열" 출력하기
		
		printNumber();
		
		
		
		
	}//main
	
	//메서드명
	//1. 카멜 표기법(영문자 + 숫자 + _)
	//2. 의미있게 만들기
	//3. 동사 + 명사
	
	//접근지정자 정적키워드 반환타입 메서드명(인자리스트)
	//public static void printNumber()
	
	
	
	public static void printNumber() {
		
		System.out.println("하나");
		System.out.println("둘");
		System.out.println("셋");
		System.out.println("넷");
		System.out.println("다섯");
		System.out.println("여섯");
		System.out.println("일곱");
		System.out.println("여덟");
		System.out.println("아홉");
		System.out.println("열");
		
	}
	
	
	//메서드 선언 위치
	//- 클래스 내부
	//- 메서드 간의 순서는 무관
	
	//메서드 선언하기
	//1.public static void hello()
	//	- 메서드 헤더(header)
	// 	- 메서도 서명(Signature)
	//2. {}
	//	- 메서드 본문(body)
	//	- 메서드 구현부 > 하는 일
	public static void hello()	{ //행동(Behavior)
		System.out.println("반갑습니다."); //단위 행동 > 1회
											//유지보수 용이
		
		
		
		
		
		
		
	}
	
	
	
}
