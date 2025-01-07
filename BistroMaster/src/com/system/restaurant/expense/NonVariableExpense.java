package com.system.restaurant.expense;

public class NonVariableExpense {

	private int no;
	private int internetFee;
	private int monthlyRent;
	private int costOfLabor;
	private String date;
	
	
	public NonVariableExpense(int no, int internetFee, int monthlyRent, int costOfLabor, String date) {
		super();
		this.no = no;
		this.internetFee = internetFee;
		this.monthlyRent = monthlyRent;
		this.costOfLabor = costOfLabor;
		this.date = date;
	}

	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	
	public int getInternetFee() {
		return internetFee;
	}


	public void setInternetFee(int internetFee) {
		this.internetFee = internetFee;
	}


	public int getMonthlyRent() {
		return monthlyRent;
	}


	public void setMonthlyRent(int monthlyRent) {
		this.monthlyRent = monthlyRent;
	}


	public int getCostOfLabor() {
		return costOfLabor;
	}


	public void setCostOfLabor(int costOfLabor) {
		this.costOfLabor = costOfLabor;
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
		
		builder.append("NonVariableExpense [internetFee=");
		builder.append(internetFee);
		builder.append(", monthlyRent=");
		builder.append(monthlyRent);
		builder.append(", costOfLabor=");
		builder.append(costOfLabor);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		
		return builder.toString();
	}
	
	
	
}




