package com.test.java.collection;

public class Student {

	//멤버 순서 -> 찾을 때 이렇게 많이 보기때문에 걍 이렇게 만드는게 나음
	//멤버 변수 
	private String name;
	private String gender;
	
	
	//생성자
	public Student(String name, String gender) {
		this.name = name;
		this.gender = gender;
	}
	
	
	//Getter/Setter
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	//toString
	@Override
	public String toString() {
		return String.format("Student [name=%s, gender=%s]", name, gender);
	}
	
	
}
