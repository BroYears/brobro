package com.test.java.obj.inheritance;

public class Ex48_Interface {
	
	
	public static void main(String[] args) {
		
		/*
		  	
		  	인터페이스, Interface
		  	- 자료형
		  	- 두 요소간의 밀접한 경계
		  	- 외부와 내부의 경계 ex) 리모콘의 버튼 구멍
		  	
		  
		 */
		
		
// 		불가능
//		Bag b1 = new Bag();
//		
//		b1.open();
//		b1.close();
		
		BackPack b1 = new BackPack();
		b1.open();
		b1.close();
		
		BackPack b2 = new BackPack();
		b2.open();
		b2.close();
		
		//추상 클래스 vs 인터페이스
		//- 추상 클래스: 구현부를 가질 수 있다. + 추상 멤버를 가질 수 있다.
		//- 인터페이스: 구현부를 가질 수 없다. + 추상멤버를 가질 수 있다 -> 거의 인터페이스를 씀
		//- 추상 클래스보다 인터페이스가 쉬움
		
		
		
	}//main

}


//인터페이서 == 추상 메서드의 집합 == 규칙의 집합

//인터페이스 선언
interface Bag {
	
	//인터페이스는 구현멤버를 가질 수 없다
	//1. 일반 멤버 변수
	//2. 구현된 일반 메서드
	//public int a;
	//public void test () {
	//}
	
	//인터페이스 멤버 선언
	//- 추상 멤버를 가진다.
	//- abstract 생략 가능
	//- public 생략 가능
	//public abstract void open();
	//public void open();
	void open();
	
	//Abstract methods do not specify a body
	void close();
	
}

class BackPack implements Bag {

	@Override
	public void open() {
		System.out.println("백팩을 엽니다.");
	}

	@Override
	public void close() {
		System.out.println("백팩을 닫습니다");
	}

}

class BriefCase implements Bag {
	
	@Override
	public void open() {
		System.out.println("서류가방을 엽니다.");
	}

	@Override
	public void close() {
		System.out.println("서류가방을 닫습니다");
	}
}

