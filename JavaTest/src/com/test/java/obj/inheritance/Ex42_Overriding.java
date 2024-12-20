package com.test.java.obj.inheritance;

public class Ex42_Overriding {
	
	public static void main(String[] args) {
		
		
		/*
		  
		  	메서드 오버로딩, Method Overloading
		  	- 메서드 이름 동일 x N개 선언
		  
		 	메서드 오버라이딩, Method Overriding
		  	- 클래스 상속 할 때 발생
		  	- 메서드 재정의 -> 상속받은 메서드를 수정하는 기술
		  	- 
		  	
		 */
		
		
		
		OverridingParent hong = new OverridingParent();
		hong.name = "홍길동";
		hong.hello();
		
		OverridingChild jhong = new OverridingChild();
		jhong.name = "홍철수";
		jhong.hello();
		//jhong.hi();
				
		jhong.test();
		
	}//main

}//class

//동네 사람
class OverridingParent {
	
	public String name;

	public void hello() {
		// TODO Auto-generated method stub
		
	}
	
//	public void hello() {
//		System.out.printf("안녕하세요. 좋은 아침입니다. 저는 %s입니다.\n"
//							, this.name);
//	}
	
}
//자식을 만들어라 시키면 -> 부모를 먼저 찾음
//부모 instance를 만들어버림(부모 객체를 하나 더 만들어서 자식 안에 들어옴) -> 자식이 만든 것과 상속 받은 것을 따로 보관함 -> 우선권은 자식이 만든 것이 가져감
class OverridingChild extends OverridingParent {
	
	//상속받은 것을 안씀 재정의(x)
	public void hi() {
		System.out.printf("하이~ 반가워요. 전 %s입니다\n", this.name);
	}
	
	//hello가 만들어지면 안되는데 만들어짐
	//덮어쓰기해서 수정됨 -> 부모에게 상속받은 것을 이김 -> 재정의
	//Overriding
	public void hello() {
		System.out.printf("하이~ 반가워요. 전 %s입니다\n", this.name);
	}
	
	//super.xxx -> 상속받았는데 숨겨져 있는 거 꺼내줌
	public void test() {
		this.hello();
		super.hello();
	}
	
}

class AAAA {
	public int a = 10;
	private int b = 20;
	
	public void test() {
		System.out.println(this.a);
		System.out.println(this.b);
	}
	
}

class BBBB extends AAAA {
	
	public int c = 30;
	public int d = 40;
	
	public void test2() {
		System.out.println(this.c);
		System.out.println(this.d);

		System.out.println(this.a);
		//System.out.println(this.b); 상속받았는데 금고(private)로 받아버림 그래서 안열림
		//private은 상속해도 못봄 -> 근데 받기는 했음
				
	}
	
	
}



