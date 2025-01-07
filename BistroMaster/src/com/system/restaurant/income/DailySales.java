package com.system.restaurant.income;

public class DailySales {

	private int no;
	private int dailySales;
	private String salesDate;
	
	public DailySales(int no, int dailySales, String salesDate) {
		super();
		this.no = no;
		this.dailySales = dailySales;
		this.salesDate = salesDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getDailySales() {
		return dailySales;
	}

	public void setDailySales(int dailySales) {
		this.dailySales = dailySales;
	}

	public String getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(String salesDate) {
		this.salesDate = salesDate;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("DailySales [no=");
		builder.append(no);
		builder.append(", dailySales=");
		builder.append(dailySales);
		builder.append(", salesDate=");
		builder.append(salesDate);
		builder.append("]");
		
		return builder.toString();

	}
	
	
	
}
