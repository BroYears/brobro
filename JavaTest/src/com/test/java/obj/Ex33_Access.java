package com.test.java.obj;

public class Ex33_Access {

	public static void main(String[] args) {
		
		
		
		Book b1 = new Book();
		
		//b1.title = "제목";
		//this.title = "제목";
		
		
		b1.title = "이것이 자바다";
		//b1.price = 38000;
		b1.aaa(38000);
		
		System.out.println(b1.title);
		//System.out.println(b1.price);
		System.out.println(b1.bbb());
		
		Book b2 = new Book();
		
		b2.title = "자바의 정석";
		//b2.price = -2000000000;

		System.out.println(b2.title);
		//System.out.println(b2.price);
		
		
		//멤버 변수 > 속성 (Property), 상태(State)
		
		//멤버 변수 조작
		//setter, getter > 속성(Property)
		
		Book b3 = new Book();
		
		
		b3.title= "자바책";
		b3.setPrice(20000);
		
		System.out.println(b3.getPrice());

	}//main
	
}
