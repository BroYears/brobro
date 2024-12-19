package com.test.java.obj.inheritance;

public class Ex40_Inheritance {

	
	public static void main(String[] args) {
		
		/*
		  
		  
		  	상속, Inheritance
		  	- 부모가 가지는 재산을 자식에게 물려주는 행동
		  	- 부모(클래스)가 가지는 재산(멤버 변수, 멤버 메서드)을 자식(클래스)에게 물려주는 행동
		  	- 코드 재사용성을 높이는 것들 중 최고
		  
		  	상속 관계에 있는 클래스 호칭
		  	- 부모 클래스 <- 자식 클래스
		  	- 슈퍼 클래스 <- 서브 클래스
		  	- 기본 클래스 <- 확장 클래스
		  	- 기본 클래스 <- 파생 클래스
		 
		 */
		
		Parent p1 = new Parent();
		
		p1.a = 10;
		p1.b = 10;
		p1.ccc();
		
		Child c1 = new Child();
		
		c1.a = 10;
		c1.b = 20;
		c1.ccc();
		
		c1.d = 30;
		c1.e = 40;
		c1.fff();
		
		CCC c = new CCC();
		c.a = 10;
		c.b = 20;
		c.c = 30;
		
		
	}
	
}

//class

//부모 클래스
class Parent {
	
	public int a;
	public int b;
	
	public void ccc() {
		
		System.out.println("ccc");
		
	}
	
}


//자식 클래스
//호출해서 엮는 거랑 다름
//말 그대로 계승하는 느낌
class Child extends Parent {
	public int d;
	public int e;
	
	public void fff() {
		System.out.println("fff");
	}
	
	
}

//사이트 > 일반유저, 관리자
class Member {
	
	public String id;
	public String password;
	
}

class User extends Member {

	public String name;
	public String email;
	public int point;
	
}

//상속을 나중에 받는 경우도 있음
//리팩토링
//자바는 다중 상속 지원 X
//- 요즘은 다중 상속 지원 X
//상속은 되물림 가능
class Administrator extends Member {
	
	public int level;
	
	
	
}

class AAA {
	public int a;
}//얘 부모는 Object -> 항상 상속 최상위(시조 느낌)
//a

class BBB extends AAA{
	public int b;
}//a, b

class CCC extends BBB{
	public int c;
}//a, b, c
