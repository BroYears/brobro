package com.test.java.obj;

public class Ex38_static {

	public static void main(String[] args) {
		
		//Ex38
		
		//요구사항]
		//1. 펜을 생산하시오.
		//2. 생산된 펜의 개수 계산
		
		//Case 1.
		//- 간편함
		//- Pen과 count의 관계성 부족
		//- 안정성 낮음(count ++ 누락 위험)
		
		/*
		int count = 0;
		
		Pen p1 = new Pen("MonAmi", "Black");
		count ++;
		
		Pen p2 = new Pen("MonAmi", "Black");
		count ++;
		
		Pen p3 = new Pen("MonAmi", "Black");
		count ++;
		
		System.out.println("볼펜 개수: " + count);
		*/
		 
		//case 2.
		//- Pen 클래스와 count 변수간의 관계 강화
		//- count 변수가 많아서 몰아주거나 해야함(객체변수) -> 공용데이터로 만드는게 맞음 
		
		/*
		Pen p1 = new Pen("MonAmi", "Black");
		p1.count++;
		
		Pen p2 = new Pen("MonAmi", "Black");
		p1.count++;
		
		Pen p3 = new Pen("MonAmi", "Black");
		p1.count++;
		
		System.out.println("볼펜 개수: " + p1.count);
		System.out.println("볼펜 개수: " + p2.count);
		System.out.println("볼펜 개수: " + p3.count);
		*/
		
		//case 3.
		//- Pen 클래스와 count변수 간의 관계 명확
		//- 개인 데이터와 공용데이터의 구분 명확
		//- 아직 count 안정성 낮음
		/*
		Pen p1 = new Pen("MonAmi", "Black");
		Pen.count++;
		
		Pen p2 = new Pen("MonAmi", "Black");
		Pen.count++;
		
		Pen p3 = new Pen("MonAmi", "Black");
		Pen.count++;
		
		System.out.println("볼펜 개수: " + Pen.count);
		*/
		
		//case 4.
		Pen p1 = new Pen("MonAmi", "Black");
		Pen p2 = new Pen("MonAmi", "Black");
		Pen p3 = new Pen("MonAmi", "Black");
		
		System.out.printf("볼펜 개수: %d", Pen.count);
		
		
		
		
	}
}

//case 4.
class Pen {
	
	private String model;
	private String color;
	public static int count = 0;
	
	public Pen(String model, String color) {
		this.model = model;
		this.color = color;
		Pen.count ++; //앞 case들이랑 다르게 돌때마다 여기서 해줌
					 //count 안정성 향상
	}
	
	public String info() {
		return String.format("[model:%s,color:%s]"
							, this.model
							, this,color);
	}
}


//case 3.
//class Pen {
//	
//	private String model;
//	private String color;
//	public static int count = 0;
//	
//	public Pen(String model, String color) {
//		this.model = model;
//		this.color = color;
//	}
//	
//	public String info() {
//		return String.format("[model:%s,color:%s]"
//							, this.model
//							, this,color);
//	}
//}




//case 2.
//class Pen {
//	
//	private String model;
//	private String color;
//	public int count = 0;
//	
//	public Pen(String model, String color) {
//		this.model = model;
//		this.color = color;
//	}
//	
//	public String info() {
//		return String.format("[model:%s,color:%s]"
//							, this.model
//							, this,color);
//	}
//}



//case 1.
//class Pen {
//	
//	private String model;
//	private String color;
//	
//	
//	public Pen(String model, String color) {
//		this.model = model;
//		this.color = color;
//	}
//	
//	public String info() {
//		return String.format("[model:%s,color:%s]"
//							, this.model
//							, this,color);
//	}
//}
//
