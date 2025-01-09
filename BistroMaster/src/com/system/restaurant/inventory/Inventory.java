package com.system.restaurant.inventory;


public class Inventory {  //유통기한

	 private String name;         		 // 품목명  
	    private int quantity;      		 // 수량  
	    private int price;            	 // 가격  
	    private String expiryDate;       // 유통기한
	     
	    public Inventory(String name, int quantity, int price, String expiryDate) {  
	        this.name = name;  
	        this.quantity = quantity;  
	        this.price = price;  
	        this.expiryDate = expiryDate;  
	    }


		public String getName() {  
	        return name;  
	    }  

	    public int getQuantity() {  
	        return quantity;  
	    }  

	    public int getPrice() {  
	        return price;  
	    }  

	    public String getExpiryDate() {  
	        return expiryDate;  
	    }  

	    @Override  
	    public String toString() {  
	        // 유통기한과 수량 형식 정리  
	        return String.format("%s,%d,%d,%s",   
	        		name, quantity, price, expiryDate);  
	    }

		public void setName(String name) {
			this.name = name;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public void setExpiryDate(String expiryDate) {
			this.expiryDate = expiryDate;
		}
		
}//class