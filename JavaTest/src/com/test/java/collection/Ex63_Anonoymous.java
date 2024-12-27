package com.test.java.collection;

public class Ex63_Anonoymous {

	
	public static void main(String[] args) {
		
		/*
		
		
			익명 클래스, Anonymous class
			- 익명 개체, Anonymous Object
			- 이름없는 클래스
		
			프로젝트
			- 수많은 클래스~
			
			실명 클래스
			- 객체를 여러개 만들 수 있다.(장점)
			- 클래스 계속 관리를 해야한다.
				
			익명 클래스
			- 객체를 딱 1개만 만들 수 있다.
			- 클래스 관리가 필요 없다. 
			
			
		 */
		
		//요구사항] 인터페이스를 구현한 클래스를 선언하기 > 객체를 생성
		
		
		//1. 본인 타입의 참조 변수
		BBB b1 = new BBB();
		b1.test();
		
		
		//2. 부모 타입의 참조 변수
		AAA b2 = new BBB();
		b2.test();
		
		//3. 익명 개체(+ 익명 클래스)
		//- Cannot instantiate the type AAA
		//- The type new AAA(){} must implement the inherited abstract method AAA.test()
		AAA b3 = new AAA() {
			@Override
			public void test() {
				System.out.println("익명 개체 메서드");				
			}
		};
		b3.test();
		
		AAA b4 = new AAA() {
			
			@Override
			public void test() {
				System.out.println("익명 메서드를 구현했습니다.");
			}
			
			public void print() {//호출 안됨
				System.out.println();
			}
			
		};
		b4.test();
		
		
		
	}//main
}//class


interface AAA {
	void test();
}


//The type BBB must implement the inherited abstract method AAA.test()
class BBB implements AAA {
	public void test() {
		
		System.out.println("추상 메서드를 구현");
		
	}
}




