package com.test.java.obj.inheritance;

public class Ex47_Abastract {

	public static void main(String[] args) {
		
		/*
		  
		  	추상 클래스, Abstract Class
		  	- 추상 메서드를 가진 클래스
		  	
		  	추상 메서드, Abstract Method
		  	- 헤더만 있고 본문이 없는 메서드
		  	
		  	
		  
		 */
		
		G305 m1 = new G305();
		m1.color = "white";
		m1.price = 25000;
		
		m1.click();
		m1.click();
		m1.click();
		
		//10년 사용
		
		M410 m2 = new M410();
		m2.color = "black";
		m2.price = 50000;
		
		
		//m2.clic
		m2.click();
		
		//추상 클래스 > 객체생성 불가능
		
		
//		Mouse m3 = new Mouse();//불러도 할 수 있는게 없어서 허용도안해줌
//		
//		m3.color = "white";
//		m3.price = 3000;
//		m3.click();
		
		
		
		
		
	}
}

//일반 클래스는 추상멤버를 가질 수 없다. > Why?
//객체화를 할 수 없어서
//class Keyboard {
//	
//	public String a;
//	public void test() {
//		
//	}
//	
//	public abstract void info();
//	
//}





//일반 클래스
//- 추상메서드 소유 불가능
//class Mouse {

//추상 클래스
abstract class Mouse {
	
	//구현된 멤버
	//1. 변수
	//2. 구현부를 가진 메서드
	public String color;
	public int price;
	
	//일반 메서드, 구현된 메서드
//	public void click() {
//		System.out.println("저렴한 스위치를 사용해서 클릭합니다.");//특정 모델의 행동을 부모에 넣는 것은 안좋은 행동
//	}
	
	
	public void info() {
		System.out.println();
	}
	
	
	//추상 메서드
	//- 구체적으로 정해진 일을 설정하지않고 추상적으로 남아있음.
	public abstract void click();
	
	
	
}

	


class G305 extends Mouse {
	
	//추상 클래스(부모)가 물려준 추상 메서드를 구현({})했습니다. - 구현이라고 말하는게 맞음
	//오버라이딩한 것
	public void click() {
		System.out.println("싼 스위치를 사용해서 클릭합니다.");
		
	}
	
}

class M410 extends Mouse {

	@Override
	public void click() {
		System.out.println("비싼 스위치를 사용해서 클릭합니다.");
	}
	
//	public void push() {
//		System.out.println("비싼 스위치를 사용해서 클릭합니다.");
//	}
	
//	@Override
//	public void click() {
//		System.out.println("비싼 스위치를 사용해서 클릭합니다.");
//		super.click();
//	}
	
}
 