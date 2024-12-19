package com.test.java.question;

public class Q93_Class {

	public static void main(String[] args) {
		
		Note note = new Note();

		note.setSize("B4");
		note.setColor("노란색");
		note.setPage(25);
		note.setOwner("홍길동");

		System.out.println(note.info());


		Note note2 = new Note();

		note2.setSize("A4");
		note2.setColor("검정색");
		note2.setPage(100);

		System.out.println(note2.info());
		
	}
	
	
}

class Note  {
	   private String size;
	   private String color;
	   private int page;
	   private String owner;
	   private int price;

	   //setter, getter 구현

	

	public void setOwner(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setPage(int i) {
		// TODO Auto-generated method stub
		
	}

	public void setColor(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setSize(String string) {
		
		
	}
	
	public String info() {
	         return "";
	}
}