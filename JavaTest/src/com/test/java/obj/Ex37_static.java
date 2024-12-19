package com.test.java.obj;

import java.lang.ProcessHandle.Info;

public class Ex37_static {

	//1. 클래스 로딩
	//- 프로젝트 전체를 뒤지면서 클래스를 인식시킴
	//- static에 다 저장 돼 버림(메모리에 얹는 작업) -> 설계도 인식 작업
	//- *** 클래스 로딩 과정 중(클라스 정의를 읽어 나가는 중) > static 키워드를 만나면 메모리에 구현한다.
	
	//2. 메인 실행
	public static void main(String[] args) {
		
		
		/*
		  	
		  	static(정적) 키워드
		  	- 지시자(제어자) 중 하나
		  	- 클래스 or 클래스 멤버에 붙인다.
		  	- 가장 먼저 태어남
		  	1. 멤버 변수
		  	2. 멤버 메서드
		  	
		  	객체 멤버(변수, 메서드)
		  	- 개인마다 각자 저장할 데이터 > 객체 멤버 변수
		  	- 개인마다 각자 하는 행동 > 객체 멤버 메서드
		  	- 안정성은 높은데 노가다해야함.(비용 상승)
		  	
		  	정적 멤버(변수, 메서드)
		  	- 집합 모두가 공통으로저장할 데이터 > 정적 멤버 변수
		  	- 개인이 아닌 집합으로서의 행동> 정적 멤버 메서드
		  	- 앞으로의 변수를 꼭 고려해야 함.
		  
		 */
		
		//상황] 학생 3명
		//- "역삼 중학교"
		
		Student.setSchool("역삼중학교");
		
		Student s1 = new Student();
		s1.setName("홍길동");
		s1.setAge(15);
		
		//s1.setSchool("역삼중학교");
	
		
		Student s2 = new Student();
		s2.setName("아무개");
		s2.setAge(14);
		
		//s2.setSchool("역삼중학교");
		
		Student s3 = new Student();
		s3.setName("하하하");
		s3.setAge(16);
		
		//s3.setSchool("역삼중학교");//매번 10byte 씩 잡아먹음
		
		System.out.println(s1.info());
		System.out.println(s2.info());
		System.out.println(s3.info());
		
	}//main
}


class Student {
	
	//멤버 변수 
	//- OOP > 속성(Property), 상태(State)
	//- 자바 > 속성(Property), 멤버 변수, 필드(field)
	
	
	private String name; //객체 멤버 변수 
	private int age;
	
	//private String school;
	private static String school; //정적 멤버 변수, 클래스 멤버 변수
								  //        		우리가 아는 클래스 아님
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
//	public String getSchool() {
//		return school;
//	}
//	public void setSchool(String school) {
//		this.school = school; 
//	} private static String school; static으로 선언한 school인데 그냥 이렇게 해버리면 원래 오류가 나야함. -> 저장 위치가 다름.
	
	public static String getSchool() {
		return school;
	}
	public static void setSchool(String school) {
		Student.school = school;
	}
	

	
	public String info() {
		
		return String.format("%s(%d세,%s)"
							, this.name
							, this.age
							, Student.getSchool());
	}
}