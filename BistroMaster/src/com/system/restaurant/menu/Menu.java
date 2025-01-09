package com.system.restaurant.menu;

import java.util.ArrayList;
import java.util.Objects;

import com.system.restaurant.inventory.Inventory;
import com.system.restaurant.inventory.InventoryService;

//메뉴
//1,삼겹살(200g),19000
public class Menu {
	private int no;
	private String name;
	private int price;
	private ArrayList<InventoryService> inventory;

	public Menu(int no, ArrayList<InventoryService> inventory, String name, int price) {
		this.no = no;
		this.inventory = inventory;
		this.name = name;
		this.price = price;
		
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	// 수량보다, 재고가 작을 시.
	public boolean isAvailalbeMenu(int amount) {
		for (InventoryService in : inventory) {
			if (in.getCount() < amount) {
				return false;
			}
		}
		return true;
	}

	public void reduceInventory(int amount) {
		for (InventoryService in : inventory) {
			in.reduceInventory(amount);
		}
	}


	//사용안할 코드
	public void restoreInventory(int amount) {
		for (InventoryService in : inventory) {
			in.restoreInventory(amount);
		}
	}

	public ArrayList<InventoryService> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<InventoryService> inventory) {
		this.inventory = inventory;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		return Objects.equals(name, other.name) && price == other.price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Menu [no=");
		builder.append(no);
		builder.append(", name=");
		builder.append(name);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}

}
