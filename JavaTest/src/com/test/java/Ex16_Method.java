package com.test.java;

public class Ex16_Method {
	
	public static void main(String[] args) {
		
		//public static void hello() {}
		
		//메서드의 반환 타입(자료형)
		
		int a = 10;
		int b = 20;
		
		int c = sum(a, b);
		System.out.println(c);
		
		checkAge(20);
		String result = checkAge(20);
		
		System.out.println(result);
				
		
	}//main

	//This method must return a result of type String
	public static String checkAge(int age) {
		
		//메서드 종료 상황
		//- 호출한 곳으로 돌아가는 경우
		//1. 메서드 실행 종료( }을 만나는 경우)
		//2. 위치와 관계없이 return문을 실행하는 경우
		
		
		
		String result = age >= 18 ? "통과" : "거절";
		
		return result; //반환값은 유일하다.
		
		//Unreachable code
		//System.out.println("메서드 종료");
		
		

		 
	}
	
	public static void aaa() {
		
		aaa();
		bbb();
		ccc();
		
	}
	
	public static void bbb() {
		//reader > 성적 입력
	}
	
	public static void ccc() {
		//계산 > 성적 평가
	}
	
	public static void ddd() {
		//화면 출력
		
	}
	
	public static void eee() {
		
		//5000줄
		
	}
	
	public static int sum(int a, int b) {
		
		int result = a + b;
		
		return result;
		
		
	}
	
}
