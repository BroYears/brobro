package com.system.restaurant.expense;

public class DailyExpense {

	private int no;
	private int dailyExpense;
	private String date;
	
	public DailyExpense(int no, int dailyExpense, String date) {
		super();
		this.no = no;
		this.dailyExpense = dailyExpense;
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getDailyExpense() {
		return dailyExpense;
	}

	public void setDailyExpense(int dailyExpense) {
		this.dailyExpense = dailyExpense;
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
		
		builder.append("DailyExpense [no=");
		builder.append(no);
		builder.append(", dailyExpense=");
		builder.append(dailyExpense);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		
		return builder.toString();
	}
	
	
	
}
