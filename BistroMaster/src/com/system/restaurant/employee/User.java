package com.system.restaurant.employee;

public abstract class User {
	
	
	private int no;
	private String name;
	private String type1 ;
	private String phoneNumber;
	private String hireDate;
	private int payment;
	private String type2 ;
	
	
	
	public User(int no, String name,String type1, String phoneNumber, String hireDate, int payment, String type2) {
		super();
		this.no = no;
		this.name = name;
		this.type1 = type1;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.payment = payment;
		this.type2 = type2;
	}

	

	public int getNo() {
		return no;
	}



	public void setNo(int no) {
		this.no = no;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getType1() {
		return type1;
	}



	public void setType1(String type1) {
		this.type1 = type1;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getHireDate() {
		return hireDate;
	}



	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}



	public int getPayment() {
		return payment;
	}



	public void setPayment(int payment) {
		this.payment = payment;
	}



	public String getType2() {
		return type2;
	}



	public void setType2(String type2) {
		this.type2 = type2;
	}



	public abstract void showAttendance();
	
}
