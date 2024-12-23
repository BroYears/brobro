package com.test.java.obj.inheritance;

public class Ex53_Generic {

	
	public static void main(String[] args) {
		
		
		//Item is a raw type. References to generic type Item<T> should be parameterized
		//Item o1 = new Item();
		Item<String> o1 = new Item<String>(); //-> <> 자료형을 받음
		o1.a = "문자열";
		System.out.println(o1.a.length());		
		
		Item<Integer> o2 = new Item<Integer>(); 
		o2.a =10;
		System.out.println(o2.a * 2);
				
		Pen<Double> p1 = new Pen<Double>();
		Pen<Double> p2 = new Pen<>();
		
		p1.a = 3.3;
		p1.b = 2.2;
		p1.c = 5.5;
		
		Laptop<String> l1 = new Laptop<>();
		l1.setType("맥북");
		System.out.println(l1.getType());
		
		Laptop<Integer> l2 = new Laptop<>();
		l2.setType(100);
		System.out.println(l2.getType());
		
		
		Monitor<String, Integer> m1 = new Monitor<String, Integer>("모니터", 100);
		System.out.println(m1.getA());
		System.out.println(m1.getB());
		
//		Object o3 = 10;
//		o3 = "문자열";//절대 이렇게 하면 안됨

		
		
	}
	
	
}//class

//제네릭 클래스
//- T :  타입 변수(매개 변수 역할) > 참조형만 전달 가능(기본형은 전달 불가능)
//- <> : 인자리스트 메소드의 소괄호 같은 것
class Item<T> { //  <>안에 보편적으로 한 글자만
	
	public T a;//클래스를 선언 할 당시에는 a의 자료형이 정해지지 않음.
	public int b;
	public String c;
	
	public void test() {
		
	}
	
}

interface Desk<T> {
	
}

class Pen<T> {
	public T a;
	public T b;
	public T c;
}

class Laptop<T> {
	private T type;
	
	public T getType() {
		return this.type;
	}
	
	public void setType(T type) {
	    this.type = type;
	} 
	
	
}

class Monitor<T,U> {
	
	private T a;
	private U b;
	
	public Monitor(T a, U b) {
		this.a =a;
		this.b =b;
	}

	public T getA() {
		return a;
	}

	public U getB() {
		return b;
	}
	
}




