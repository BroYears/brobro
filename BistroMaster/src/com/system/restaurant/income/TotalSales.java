package com.system.restaurant.income;

public class TotalSales {
	
	private int no;
	private int sales;
	private String date;
	
	
	public TotalSales(int no, int sales, String date) {
		super();
		this.no = no;
		this.sales = sales;
		this.date = date;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public int getSales() {
		return sales;
	}


	public void setSales(int sales) {
		this.sales = sales;
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
		
		builder.append("TotalSales [no=");
		builder.append(no);
		builder.append(", sales=");
		builder.append(sales);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		
		return builder.toString();
	}

	
	
}
