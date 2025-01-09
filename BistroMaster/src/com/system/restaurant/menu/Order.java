package com.system.restaurant.menu;

//주문
//no,품명,수량,가격,테이블명,주문일자
public class Order {
	private int no;
	private Menu menu;
	private int quantity;
	private String orderDate;

	public Order(int no, Menu menu, int quantity, String orderDate) {
		this.no = no;
		this.menu = menu;
		this.quantity = quantity; 
		this.orderDate = orderDate;	
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	//추후 매출시 사용할 데이터
	public int getTotalPrice() {
		return quantity * menu.getPrice();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [no=");
		builder.append(no);
		builder.append(", menu=");
		builder.append(menu);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", orderDate=");
		builder.append(orderDate);
		builder.append("]");
		return builder.toString();
	}

}
