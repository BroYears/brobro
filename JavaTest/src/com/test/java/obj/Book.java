package com.test.java.obj;

public class Book {

	
	//누구를 대상으로?
	//-멤버가 소속된 클래스 영역을 기준으로 > 경계선/담벼락
//	public 	int a;//100% 공개 - 
//	private int b;//100% 비공개 - case
//	
//	public void test() {
//		
//		System.out.println("a: " + a); //public > 동작안함
//		System.out.println("b: " + b); //private > 동작안함
//	
//	}
	
	//접근 지정자 가이드
	//1. 멤버 변수는 무조건 private으로 선언한다.
	//2. 멤버 메서드를 선언한다.
	
	
	public String title;
	
	private int price;//색이 다름
	
	
	//외부 > 전달 > 내부
	//- setter
	//- setXXX()
	public void aaa(int a) {
		
		if(a >= 0 && a <= 1000000) {
			price = a;
		}
		
	}
	
	public void setPrice(int price) {//무조건 얘가 이김
		
		//price
		
		System.out.println(price);
		
		//충돌 발생
		//- price(멤버변수)
		//- price(지역변수/매개변수)
		//- 멤버변수랑 세터변수랑 이름 같게하는 경우가 많음
		
		//this 연산자
		//- 객체 접근(지정) 연산자
		//- 현재 코드가 소속되어 있는 객체 자신을 가르키는 역할
		//- "나"야 들기름
		//- 내부에서는 1인칭
		this.price = price;
		
		this.title = "제목";
		
		
		
	}
	
	//내부 > 전달 > 외부
	//- Getter
	//- get멤버변수명()
	public int bbb() {
		return price;
	}
	
	
	public int getPrice() {
		return this.price;//가독성
	}
	
	
}







