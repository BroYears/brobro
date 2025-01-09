package com.system.restaurant.reservation;

import java.util.Calendar;
import java.util.Objects;

public class Reservation {

	private int no; //고유번호(pk)
	private String name; //이름
	private String phoneNumber; //연락처
	private String dateTime; //주문 날짜
	private int number; //인원수
	
	
	//기본 생성자
	public Reservation(int no, String name, String phoneNumber, String dateTime, int number) {
		this.no = no;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.dateTime = dateTime;
		this.number = number;
	}

	//Getter, Setter
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reservation [no=");
		builder.append(no);
		builder.append(", name=");
		builder.append(name);
		builder.append(", phoneNumber=");
		builder.append(phoneNumber);
		builder.append(", dateTime=");
		builder.append(dateTime);
		builder.append(", number=");
		builder.append(number);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateTime, name, no, number, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(dateTime, other.dateTime) && Objects.equals(name, other.name) && no == other.no
				&& number == other.number && Objects.equals(phoneNumber, other.phoneNumber);
	}
	
	
	
	
}
