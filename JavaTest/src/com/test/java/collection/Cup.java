package com.test.java.collection;

public class Cup {
	
	private String color;
	private int price;
	
	public Cup(String color, int price) {
		this.color = color;
		this.price = price;
		
	}

	@Override
	public String toString() {
		return this.color + ":" + this.price;
	}
	
	
	
}//class

