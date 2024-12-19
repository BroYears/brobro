package com.test.java.question;

public class Book {

	public static void main(String[] args) {
		
		Book b1 = new Book();

		b1.setTitle("자바의 정석");
		b1.setPrice(45000);
		b1.setAuthor("남궁성");
		b1.setPublisher("도우출판");
		b1.setIsbn("8994492038");
		b1.setPage(1000);

		System.out.println(b1.info());
		
	}//main
	
	
	private String title;
	private int price;
	private String author;
	private String publisher;
	private String pubYear = "2019";
	private String isbn; //책의 고유번호
	private int page;
	
	public String getTitle() {
		return title;
	}

	
	public void setTitle(String title) {
		//최대 50자 이내 + (한글, 영어, 숫자, 공백)
		
		if (title.length() > 50) {
			System.out.println("제목은 50자 이내로 입력하시오.");
			return; //빈 리턴문 -> 아무 값도 안돌려줌 -> 메서드 종료 like break;
		}
		
		for(int i=0; i<title.length(); i++) {
			char c = title.charAt(i);
			//System.out.println(c);
			
			if ((c <'가' || c > '힣')
				&& (c <'A' || c > 'Z')
				&& (c <'a' || c > 'z')
				&& (c <'0' || c > '9')
				&& c != ' ') {
				
				System.out.println("제목을 올바른 문자로 작성하시오.");
				return;
				
			}
		}
		
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		//0 ~ 1000000
		
		if (price < 0 || price > 1000000) {
			System.out.println("가격이 올바르지 않습니다.");
			return;
		}
		
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		//1.무제한
		if (page < 1) {
			System.out.println("페이지가 올바르지 않습니다.");
			return;
		}
		
		this.page = page;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPubYear() {
		return pubYear;
	}

	public String info() {
		return String.format("제목: %s\r\n"
							+ "가격: %,d\r\n"
							+ "저자: %s\r\n"
							+ "출판사: %s\r\n"
							+ "발행년도: %s년\r\n"
							+ "ISBN: %s\r\n"
							+ "페이지: %,d장"
							, this.title
							, this.price
							, this.author
							, this.publisher
							, this.getPubYear()
							, this.isbn
							, this.page);
		}
	
}
