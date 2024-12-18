package com.test.java.obj;

public class Ex32_Class {
	
	public static void main(String[] args) {
		
		/*
			
			Ex32_Class.java
			
			
			
		*/
		
		Person2 p1 = new Person2();
		p1.name = "홍길동";
		p1.age = 20;
		p1.hello();
		
		Person2 p2 = new Person2();
		p2.name = "아무개";
		p2.age = 22;
		p2.hello();
		
	}//main

}//class


//
class Person2 {
	
	//멤버 변수
	public String name;
	public int age;
	
	//멤버 메서드
//	public void hello() {
//		System.out.println("안녕하세요.");
//	}
	
	public void hello() {
		System.out.printf("안녕하세요. 저는 %s입니다. 그리고 %d살입니다.\n", name, age);
	}
	
}
