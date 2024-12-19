package com.test.java.obj;

public class Ex36_Contstructor {
	
	public static void main(String[] args) {
		
		/*
		 	
		 	
		 	생성자, Constructor
		 	- (특수한 목적을 가지는) 메서드
		 	- 객체의 멤버(변수)를 초기화하는 역할(***)
		 	
		 	
		 	자료형 참조변수 = new 생성자();
		 	point p1 = new Point();
		 	
 			
		 
		 */

//		int n1 = null;
//		String s1 = null;
		
		//new Box();
		//1. new 실행 > 객체생성연산자
		//2. Box() 실행 > 생성자
		Box b1 = new Box();//이름을 같게 안해도 될 것 같은데 클래스명이랑 같이해야 함 안그럼 안만들어짐
		
//		b1.setSize("대형");
//		b1.setPrice(3000);
		
		System.out.println(b1.getSize());
		System.out.println(b1.getPrice());
		
		Box b2 = new Box();
		
//		b2.setSize("대형");
//		b2.setPrice(3000);
		
		Box b3 = new Box();
		
//		b3.setSize("대형");
//		b3.setPrice(3000); -> 초기값 설정을 바꿔서 반복적인 의미없는 행동 해결
		
		Box b101 = new Box();
		
		b101.setSize("소형");
		b101.setPrice(1000);
		
		System.out.println();
		System.out.println(b101.getSize());
		System.out.println(b101.getPrice());
		
		//생성자 > 멤버 변수 쓰기 + 초기화 + 수정(X) -> 세팅은 오버로딩
		//Setter > 멤버 변수 값 쓰기 + 초기화 비슷 + 수정 (O)	-> 변화 줘야 할 때는 Set	
		Box b201 = new Box();
		Box b202 = new Box("대형", 3000);
		
		Box b302 = new Box("소형", 1000);
		b302.setSize("소형");
		b302.setPrice(1000);
		
		Box b205 = new Box("중형");
		b205.setPrice(2500);
		
		Box b206 = new Box(4000);
		
	}//main
	
	
	
}

class Box {
	
	private String size;
	private int price;
	
	
	
	//컴파일러 > 컴파일 > 자동으로 생성하는 코드
	
	//생성자
	//- 접근 지정장: public 
	//- 반환값: 존재하지 않음 > void 생략
	//- 생성자명 == 클래스명
	
	//기본 생성자
	public Box() { //메서드
//		this.size = "대형";
//		this.price = 3000;
		this("대형", 3000);
		
	}
	
	//생성자 오버로딩
	public Box(String size, int price) { 
		this.size = size;
		this.price = price;
	}
	
	public Box(String size) { //메서드
//		this.size = size;
//		this.price = 0;
		this(size, 0);
	}
	public Box(int price) { //메서드
//		this.size = "";
//		this.price = price;
		this("", price);
	}
	
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
