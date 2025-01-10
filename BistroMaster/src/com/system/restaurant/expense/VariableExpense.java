package com.system.restaurant.expense;

public class VariableExpense {

	private int no;
	private int waterTax;
	private int electricityBill;
	private int gasBill;
	private int ingredient;
	private int descripton;
	private String date;
	
	public VariableExpense(int no, int waterTax, int electricityBill, int gasBill, int ingredient, int descripton, String date) {
		super();
		this.no = no;
		this.waterTax = waterTax;
		this.electricityBill = electricityBill;
		this.gasBill = gasBill;
		this.ingredient = ingredient;
		this.descripton = descripton;
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public int getIngredient() {
		return ingredient;
	}
	
	public void setIngredient(int ingredient) {
		this.ingredient = ingredient;
	}
	
	public int getDescripton() {
		return descripton;
	}

	public void setDescripton(int descripton) {
		this.descripton = descripton;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTotalPrice(){
		return waterTax + electricityBill + gasBill + ingredient + descripton;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("VariableExpense [no=");
		builder.append(no);
		builder.append(", waterTax=");
		builder.append(waterTax);
		builder.append(", electricityBill=");
		builder.append(electricityBill);
		builder.append(", gasBill=");
		builder.append(gasBill);
		builder.append(", ingredient=");
		builder.append(ingredient);
		builder.append(", descripton=");
		builder.append(descripton);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		
		return builder.toString();
	}
	
	
	
	
}