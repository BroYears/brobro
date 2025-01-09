package com.system.restaurant.income;

public class DailySales {

	private int dailySales;
	private String date;
	
	public DailySales(int dailySales, String date) {
		super();
		this.dailySales = dailySales;
		this.date = date;
	}


	public int getDailySales() {
		return dailySales;
	}

	public void setDailySales(int dailySales) {
		this.dailySales = dailySales;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(", dailySales=");
		builder.append(dailySales);
		builder.append(", salesDate=");
		builder.append(date);
		builder.append("]");
		
		return builder.toString();

	}
	
	
	
}
