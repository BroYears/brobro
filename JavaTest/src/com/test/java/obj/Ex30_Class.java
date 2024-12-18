package com.test.java.obj;

public class Ex30_Class {
	
	public static void main(String[] args) {
		
		//Ex30_Class.java
		/*
			
			자바, Java
			- 객체 지향 프로그래밍 언어
			- Object Oriented Programming Language > OOP
			- 객체를 중심으로 프로그램을 만드는 방식의 언어
			- 클래스라는 설계도를 사용해서,
			  객체라는 것을 만들고,
			  만들어진 객체를 사용해서,
			  내가 원하는 행동을 구현하는 것
			  
			1. 클래스, Class
			
			2. 객체, Object
			
			3. 인스턴스, Instance
			
			4. 행동, Behavior
			
			5. 속성, Property
			
			6. 추상화, 정보은닉, 캡슐화, 인터페이스, 상속 등등..
			
		*/
		
		//요구사항] 지도 > 우리집 > 좌표 저장(***)
		
		//Case 1. 
		//- 가장 간단한 방법
		//- 식별자 문제 > 같은 성질의 데이터를 서로 다른 이름으로 저장
		//- 구조적 문제 > 구조화(X), 규칙(X) > 관리 실패 확률 높음.
		
		//우리집 좌표
		int x = 100;
		int y = 200;
		
		System.out.printf("우리집은 [%d,%d]에 위치합니다.\n", x, y);
		
		//마트 좌표
		int x2 = 300; //역할이 같은 데이터의 이름 > 다르게 정의
		int y2 = 400;
		
		System.out.printf("마트는 [%d,%d]에 위치합니다.\n", x2, y2);
		System.out.println();
		
		//Case 2.
		//- 배열 사용
		//- 비용 저렴
		//- 식별자 문제 > 해결 > 배열이라는 구조 생성 > 집합 역할 > 관리 용이 + 가독성
		//- 배열 단점 > 요소의 성질을 첨자로 구분할 수 없다. > 방번호는 의미를 가지지를 못한다.
		
		//과목 성적 
		
		int[] score = { 100, 90, 80 }; //X score[0]
		int[] kor = { 100, 90, 80 }; //O
		
		
		
		//우리집 좌표
		//- 정수 2개
		int[] a1 = { 100, 200 };
		
		//우리집 좌표
		System.out.printf("우리집은 [%d,%d]에 위치합니다.\n", a1[0], a1[1]);
		
		System.out.println("x: " + a1[1]);
		
		//마트 좌표
		int[] a2 = { 300, 400 };
		System.out.printf("마트는 [%d,%d]에 위치합니다.\n", a2[0], a2[1]);
		System.out.println();
		
		
		//기본형, 원시형 > 자바가 처음부터 제공
		//클래스(사용자 정의형) > 기존의 자료형을 조합 > 
		
		
		//Case 3.
		//- 클래스 사용
		//- 고비용
		//- 데이터 저장 구조 > 관리 용이
		//- 각 멤버의 이름을 명시적 지정 > 데이터의 성질 구분 용이
		
		
		
		//설계한 클래스로부터 객체를 만드는 방법
		//- 자료형 변수명 = new 생성자();
		//- 클래스명 객체명(객체변수) = 객체생성연산자 생성자();
		
		//Point라는 설계도를 사용해서 p1이라는 객체를 생성했다.
		//붕어빵틀(Point)을 사용해서 붕어빵 1개(p1)를 만들었다.
		
		//우리집 좌표
		Point p1 = new Point();
		
		p1.x = 100;
		p1.y = 200;
		
		System.out.printf("우리집은 [%d,%d]에 위치합니다.\n", p1.x, p1.y);
		
		//마트 좌표
		
		Point p2 = new Point();
		
		p2.x = 300;
		p2.y = 400;
		
		System.out.printf("마트는 [%d,%d]에 위치합니다.\n", p2.x, p2.y);
		System.out.println();
		
		//객체 == 인스턴스
		//- 클래스의 구현체(실체화된 무언가)
		
		//p2 > 객체(=객체참조변수)
		//s1 > 객체(=객체참조변수)
		
		//p2 > Point의 인스턴스이다.
		//s1 > Size의 인스턴스이다.
		
		Size s1 = new Size();
		
		s1.name = "모니터";
		s1.width = 1000;
		s1.height = 500;
		
		System.out.println(s1.name + "," + s1.width + "," + s1.height);
		
		com.test.java.Size s2 = new com.test.java.Size();
//		s2.a = 10;
		
	}//main

}//class

//클래스 선언하기(= 설계도 만들기, 붕어빵틀 만들기)
//- 클래스명: 파스칼 표기법
class Point {
	
	//클래스 설계하기
	//1. 변수 선언하기 > 객체의 속성
	//2. 메서드 선언하기 > 객체의 행동
	
	//클래스 멤버 변수
	// 접근지정자,제어자,제한자
		public int x;
		public int y;
	
}

//패키지역할 

class Size {
	
	public String name;
	public int width;
	public int height;
	
}
