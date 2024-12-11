package com.test.java;

public class Ex18_Method {

	
	public static void main(String[] args) {
		
		/*
			
			
			면접 질문 패턴
			1. 정의
			2. 목적 -> 이해했니?
			3. 뭐(***) 할 때 써봤니?
			
			
			
		 	메서드 오버로딩, Method Overloading		 	
		 	- 메서드의 인자 리스트를 다양한 형태로 구성해서, 같은 이름의 메서드를 여러개 만드는 기술
		 
		 	메서드 오버로딩을 하는 이유?
		 	- 성능 향상 > x
		 	- 우리가 편해짐
		 
		 	메서드 오버로딩 구현 가능 조건
			1. 매개변수의 개수
			2. 매개변수의 자료형
			
					 	
		 	메서드 오버로딩 구현 불가능 조건
		 	1. 매개변수의 이름 -> 인자들어가는게 같으면 안됨
		 	2. 반환값의 자료형

		 	메서드 만드는 중...
		 	1. public static void test() {}				//O
		 	2. public static void test() {}				//X, 1번 존재해서
		 	3. public static void test(int n) {}		//O
		 	4. public static void test(int m) {}		//X, 3번
		 	5. public static void test(int n, int m) {}	//O 
		 	6. public static void test(String s) {}		//O 
		 	7. public static int test() {}				//X, 1번
			


		 	메서드 호출하기
		 	test();				//1번
		 	test(3);			//3번
		 	test(5, 10);		//5번
		 	test("홍길동");		//6번
		 	int result = test();//7번
		 	
		 */
			
		//요구사항] 선을 그리는 메서드를 선언하시오.
		//1. ----------
		//2. ==========
		//3. **********
		
		drawLine();//drawLine() 호출
		drawLine();
		drawLine();
		
		drawLine("*");
		
		System.out.println(100);
		System.out.println("문자열");//이미 오버로딩 활용해서 표현 중이었음
		
		//*** 지역 변수 사용 시 주의!!
		//- 지역 변수는 초기화를 하지 않으면 사용 할 수 없다.
		//- The local variable a may not have been initialized
		int a;//null(無) - null은 연산의 대상이 될 수 없다.
		//a = 10;
		
//		int b = a + 10;
//		System.out.println(a);
		
		int b;
		b = 20;
		System.out.println(b);
		
		//정수형(0)
		byte c = 0;
		
		//실수형(0.0)
		double d = 0.0;
		
		//논리형
		boolean e = false;
		
		//문자
		char f = '\0'; //null
		
		//문자열
		String s = "";
		
		
	}//main
	
	
//	public static void test() {
//		//1.
//		
//	}
//	
//	public static void test() {
//		//2.
//		
//	}	
	
	
	
	public static void println(int args) {
		
		
		
		
		
		
	}
	
	public static void drawLine(String c) {
		System.out.print(c);
		System.out.print(c);
		System.out.print(c);
		System.out.print(c);
		System.out.print(c);
		System.out.print(c);
		System.out.print(c);
		System.out.print(c);
		System.out.print(c);
		System.out.print(c);
		System.out.println();
		
		
	}
	
	public static void drawLine() {
		System.out.println("==========");
		
		
	}
	
	public static void drawLine2() {
		System.out.println("**********");
		
		
	}
	
	
	
	
//	public static void m1() {
//		
//		System.out.println("m1");
//		
//	}
//	
//	public static void m1() {
//		
//		System.out.println("m1");
//		
//	}
	
	
	


}
