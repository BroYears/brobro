package com.system.restaurant.expense;

public class TotalExpense {
	
	private int no;
	private int expense;
	private String date;
	
	public TotalExpense(int no, int expense, String date) {
		super();
		this.no = no;
		this.expense = expense;
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getExpense() {
		return expense;
	}

	public void setExpense(int expense) {
		this.expense = expense;
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
		
		builder.append("TotalExpense [no=");
		builder.append(no);
		builder.append(", expense=");
		builder.append(expense);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		
		return builder.toString();
	}
	
	

}
