package com.test.java.obj;

public class Monitor {

	private String model;
	private int size = 24;
	private int price;
	
	public static void main(String[] args) {
		
		Monitor m1 = new Monitor(); //쓰기
		
		m1.setModel("LG100"); //쓰기 프로퍼티
		System.out.println(m1.getModel());//읽기 프로퍼티
		
		//m1.size = 10;
		//System.out.println(m1.size);
		
		//m1.size
		//m1.setSize
		System.out.println(m1.getSize()); //읽기 전용 프로퍼티
		
		m1.setPrice(300000); //쓰기 전용 프로퍼티
		//System.out.println(m1.getprice());
		
		//Monitor
		System.out.println(m1.getGrade());
		
		System.out.println(m1.info());
	}
	
	
	public void setModel(String model) {
		//유효성 검사 or 가공/조작
		this.model = model;
	}
	public String getModel() {
		return this.model;
	}


	public int getSize() {
		return size;
	}


	public void setPrice(int pirce) {
		this.price = pirce;
	}
	
	public int getGrade() {
		
		if (this.price >= 500000) {
			return 1;
		} else if (this.price >= 300000) {
		 return 2;
		} else {
			return 3;
		}
	
	}
	
	
	//클래스의 상태를 확인하는 메서드 > 개발자용 > 덤프 메서드
	public String info() {
		
		//return this.model + ":" + this.size + ":" + this.price;
		
		return String.format("%s[%,d원,%d인치]",
								this.model,
								this.price,
								this.size);
	}
	
	
	
}
