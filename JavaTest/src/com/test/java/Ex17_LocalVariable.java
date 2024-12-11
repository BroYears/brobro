package com.test.java;

public class Ex17_LocalVariable {
	
	//int b;//메서드말고 클래스에 변수 선언 가능
		  //멤버 변수
	
	public static void main(String[] args) {
		
		
		/*
			
			1. 멤버 변수, Member Variable
				- 클래스 관련
			
			2. 지역 변수, Local Variable
		 		- 여태까지 사용한 변수
		 		- 메서드내에서 선언한 변수
		 		- 변수 스코프(Scope) or 변수 생명 주기(Life Cycle) > 어떤 변수를 어디부터 어디까지에서 사용이 가능한지의 범위
		 		-
		 		
		 	지역 변수 생명 주기(Life Cycle)
		 	- 생성 > 변수 선언문이 실행되는 순간
		 	- 소멸 > 변수 선언문이 소속된 블럭을 제어가 벗어날 때 
		 			
		 */
		
		//int a;//초기값 설정 안해주면 에러, The local variable a may not have been initialized
		System.out.println("지역 변수의 생명 주기");
		
		int a;//main 메서드를 영역으로 하는 지역변수
		
		a = 10;
		
		System.out.println(a);
		
		
		m1();
		
		//System.out.println(b);
		
		int age = 20;
		
		// TODO 오후 2시 김대리에게 확인
		checkAge(age);
		
	}//main

	public static void checkAge(int age) {
		
		
	}
		
//	private static void checkAge(int age) {
//		// TODO Auto-generated method stub
//		// task에서 확인 할 수 있는 주석 만들 수 있음
//
//		
//		
//	}
	
	
	
	
	
	public static void m1() {
		
		int b;//m1 메서드를 영역으로 하는 지역변수
		b = 20;
		System.out.println(b);
		
		int a;
		
		//자원을 주고 받으려면 매개변수 사용
		
	}
	
//	public static void m2(int c);{
//	
//		int d;
//		
//		//int c - 매개변수
//		//int d - 지역변수
//	}
//	
}









