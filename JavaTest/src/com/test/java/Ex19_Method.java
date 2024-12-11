package com.test.java;

public class Ex19_Method {

	
	public static void main(String[] args) {
		
		//재귀 메서드, Recursive Method
		//- 재귀 구조를 가지는 메서드
		//- 메서드 구현부 ({}: body)에서 자기 자신을 호출하는 메서드
		//- 파일 디렉토리 구조 탐색 or 트리 구조 탐색
		
		
		//m1();
		
		
		//팩토리얼
		//4! = 4 x 3 x 2 x 1 = 24
		
		//요구사항] 팩토리얼 메서드를 구현하시오.
		int n = 4;
		int result = factorial(n);
		
		System.out.printf("%d! = %d\n", n, result);
		
		
	}
	
	
	public static int factorial(int n) {
		
		return (n == 1) ? 1 : n * factorial(n -1);

	}
	
	
	public static void m1() { //재귀 메서드
		
		System.out.println("m1");
		
		m1();//StackOverflowError
			 //실제로는 또 다른 m1(쌍둥이)를 호출
		
	}
	
	public static void m2() {
		
		System.out.println("m2");
		
	}
	
}
