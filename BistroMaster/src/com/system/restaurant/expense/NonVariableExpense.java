package com.system.restaurant.expense;

public class NonVariableExpense {

	private int waterTax;
	private int electricityBill;
	private int gasBill;
	private int internetFee;
	private int monthlyRent;
	private int costOfLabor;
	
	
	public NonVariableExpense(int waterTax, int electricityBill, int gasBill, int internetFee, int monthlyRent,
			int costOfLabor) {
		
		super();
		this.waterTax = waterTax;
		this.electricityBill = electricityBill;
		this.gasBill = gasBill;
		this.internetFee = internetFee;
		this.monthlyRent = monthlyRent;
		this.costOfLabor = costOfLabor;
		
	}


	public int getWaterTax() {
		return waterTax;
	}


	public void setWaterTax(int waterTax) {
		this.waterTax = waterTax;
	}


	public int getElectricityBill() {
		return electricityBill;
	}


	public void setElectricityBill(int electricityBill) {
		this.electricityBill = electricityBill;
	}


	public int getGasBill() {
		return gasBill;
	}


	public void setGasBill(int gasBill) {
		this.gasBill = gasBill;
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


	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("NonVariableExpense [waterTax=");
		builder.append(waterTax);
		builder.append(", electricityBill=");
		builder.append(electricityBill);
		builder.append(", gasBill=");
		builder.append(gasBill);
		builder.append(", internetFee=");
		builder.append(internetFee);
		builder.append(", monthlyRent=");
		builder.append(monthlyRent);
		builder.append(", costOfLabor=");
		builder.append(costOfLabor);
		builder.append("]");
		
		return builder.toString();
	}
	
	
	
	
	
}




