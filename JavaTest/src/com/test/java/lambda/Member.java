package com.test.java.lambda;

public class Member {

	private String name;
	private int age;
	
	
	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}


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


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [name=").append(name).append(", age=").append(age).append("]");
		return builder.toString();
	}
	
	//객체의 상태가 동일하면 같은 객체로 취급하기
	//1. hashCode() 재정의
	//2. equals() 재정의
	@Override
	public int hashCode() {
		//1.1 모든 멤버 변수의 값을 하나의 문자열로 만들어라
		//1.2 합쳐진 문자열의 해시코드를 반환해라
		
		String temp = this.name + this.age;
				
		return temp.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		//2.1 hashCode의 비교 결과를 반환해라
		
		return this.hashCode() == obj.hashCode();
	}
	
}
