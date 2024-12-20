package com.test.java.obj.inheritance;

import java.util.Calendar;

public class Ex44_final {
	
	
	/*
	  	final 키워드
	  	- 한 번 결정된 건 바꿀 수 없다.
	  	- 안정성 향상
	  	- 대문자로만 해야 됨
	  	
	  	1. 변수 적용(지역 변수, 멤버 변수)
	 		- 상수(Constant)
	  		- 초기화 이후에 값을 변경 할 수 없다.
	  		
	  		
	  	2. 메서드 적용
	  		- 상속 시 오버라이딩 방지
	  	
	  	3. 클래스 적용
	  
	  
	 */
	public static void main(String[] args) {
		
		int a = 10;
		int b = 20;
		final int C = 30;
		
		a = 100;
		//C = 300; -> final때문에 불가능
		
		Phone p1 = new Phone();
		p1.a = 10;
		//p1.B = 20;
	
		Student s1 = new Student();
		s1.name = "홍길동";
		s1.age = 20;
		//s1.gender = s1.male; //?
		//s1.gender = Student.MALE;
		s1.gender  =Gender.MALE;
		
		
//		System.out.println(Calendar.YEAR); 아이콘에 S, F다 표시 있음
		
		Teacher t1 = new Teacher();
		
		
		
	}//main
	
	
}

class Phone {
	
	public int a; //변수
	public final int B; //상수 -> 나중에 값을 못넣어서 무조건 초기화
						//	   -> 생성자에 한해서 초기화 분리가능
	
	public Phone() {
		this.a = 10;
		this.B = 20; //아주아주 특별히 예외사항 -> 초기화라고 인식
		//this.B = 30; 
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return B;
	}
	
//	public void setB(int b) {
//		this.B = b;
//	}
	
	
	
}

class Gender {
	public static final int MALE = 1;
	public static final int FEMALE = 2;
}

class Student {
	
	
	public String name;
	public int age;
	public int gender;//열거형 -> 성별 -> 남자(1), 여자(2)

	private String tel;
	
	public void test() {
		 System.out.println(this.name); // 마우스 갖다대면 초록색 public
		 System.out.println(this.tel);	// 빨간색 
	}
	
}

class Teacher {
	
	public String name;
	public String address;
	
	public int gendar;//남자!
	
}

class FinalParent {
	public int a = 10;
	public void hello() {
		System.out.println("안녕하세요");
		this.a++;
	}
	
}

class FinalChild extends FinalParent {
//	@Overridig
//	public void hello() {
//		System.out.println("Heeo~");
//	}
}






