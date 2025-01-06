package com.system.restaurant.expense;

public class VariableExpense {

	private int amount;
	private String date;
	private String descripton;
	
	public VariableExpense(int amount, String date, String descripton) {
		super();
		this.amount = amount;
		this.date = date;
		this.descripton = descripton;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescripton() {
		return descripton;
	}

	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("VariableExpense [amount=");
		builder.append(amount);
		builder.append(", date=");
		builder.append(date);
		builder.append(", descripton=");
		builder.append(descripton);
		builder.append("]");
		
		return builder.toString();
	} 
	
	
	
}
