package com.system.restaurant.employee;

public class Employee extends User{

	private int attendance;

	public Employee(int no, String name, String type1, String phoneNumber, String hireDate, int payment, String type2) {
		super(no, name, type1, phoneNumber, hireDate, payment, type2);
		
		
		
		super.setNo(no);
		super.setName(name);
		super.setType1(type1);
		super.setPhoneNumber(phoneNumber);
		super.setHireDate(hireDate);
		super.setPayment(payment);
		super.setType2(type2);
		
	}

	
	
	@Override
	public void showAttendance() {
		System.out.println(attendance+"입니다.");
		
	}
	
}
