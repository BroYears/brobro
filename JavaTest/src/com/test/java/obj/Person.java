package com.test.java.obj;

public class Person {
	
	private String name;
	private int age;

	//별명 > 여러개	
	private String[] nick;

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

//	public String[] getNick() {
//		return nick;
//	}
//
//	public void setNick(String[] nick) {
//		this.nick = nick;
//	}

	private int index = 0;
	
	public void addNick(String nick) {
		
		if (this.nick == null) {
			this.nick = new String[3];	
		}
		
		this.nick[index] = nick;
		index++;
		
	}

	public String getNick(int index) {
		
		return this.nick[index];
	}
	
	
}












