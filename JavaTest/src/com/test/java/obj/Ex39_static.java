package com.test.java.obj;

public class Ex39_static {

	public static void main(String[] args) {
		
		
		//생성자를 아예 안만들면 기본생성자 자동 생성 시켜줌
		//생성자 하나라도 만들어버리면 기본생성자 없음
		Note n1 = new Note(1000, "A4");
		n1.m1();
		
		Note n2 = new Note(2000, "A3");
		n2.m1();
				
	}
}


class Note {
	//멤버 변수 직접 초기화 x
	//생성자
	
	private int price;		//1000, 2000
	private String size;	//A4, A5
	
	private static String color; //White
	
//	public Note(int price, String size, String color) {
//		this.price = price;
//		this.size = size;
//		Note.color = color;
//	} 공용이어도 정적변수 넣을 때 있긴함.
	
	public Note(int price, String size) {
		this.price = price;
		this.size = size;
	}
	
	//정적 생성자
	static {
		Note.color = "white";
	}
	
	//1. 객체 변수 vs 정적 변수
	//- 개인마다 다뤄야 하는 데이터면 객체 변수
	//- 공용으로 사용 할 데이터면 정적 변수
	
	//2. 객체 메서드 vs 정적 메서드
	//- 개인 행동 > 객체 메서드 > this, Note(클래스) 사용 가능
	//- 공용 행동 > 정적 메서드 > this 사용 불가능 , Note(클래스) 사용 가능
	
	//객체 메서드
	public void m1() {
		
		System.out.println(this.price);
		System.out.println(this.size);
		System.out.println(Note.color); // 이거는 어느정도 괜찮은 대답, 박쥐련...
				
	}
	
	//정적 메서드
	//개인 질문이 아니라 this(1인칭) 오류
	public static void m2() {
		
		System.out.println(Note.color); // 이거는 어느정도 괜찮은 대답
				
	}
	
}