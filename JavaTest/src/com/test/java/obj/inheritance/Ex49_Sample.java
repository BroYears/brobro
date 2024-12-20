package com.test.java.obj.inheritance;

public class Ex49_Sample {

	public static void main(String[] args) {
		
		
		//1. 추상 클래스 or 인터페이스
		//2. 참조형 형변환(다운 캐스팅, 업 캐스팅)
		
		
		//상황] 프린터 대리점 운영
		//1. LG100 모델 * 5대 , HP200 모델 * 3대
		//2. 하루 1번씩 > 제품 점검
		 
		//Printer p1 = new Printer(50000, 
		
		//추가 상황]
		//1. 프린터 재고 증가
		// - LG100 > 500대
		// - HP200 > 300대
		//2. 브랜드 증가 -> m3에선 좋음
		// - Dell300
		// - BenQ400
		//3. 점검 방식 추가 -> m2에선 좋음
		// - LG100 > selfTest()
		// - HP200 > call()
		
		//m1();
		//m2();
		m3();//개별기능에서 별로임
		
		
	}//main
	
	private static void m3() {
		
		//Printer <- LG100
		//Printer <- HP200
		
		
		LG100 lg1 = new LG100(300000, 10, "black", 4);
		HP200 hp1 = new HP200(350000, 12, "터치");
		
//		Printer p1 = new Printer();
		Printer p1;
		Printer p2;
		
		p1 = lg1;//업캐스팅
		p2 = hp1;
		
		Printer[] ps = new Printer[2];
		
		ps[0] = lg1;
		ps[1] = hp1;
		
			
		//case 3.
		Printer[] list = new Printer[8]; //LG(5) + HP(3)
		
		for (int i=0; i<list.length; i++) {
			
			if(i < 5) {
				list[i] = new LG100(300000, 10, "black", 4);
			} else {
				list[i] = new HP200(350000, 12, "터치");
			}
				
		}
		
		//점검시간
		for (int i=0; i<list.length; i++ ) {
			list[i].print();
			
//			list[i].selfTest();
//		
//			list[i].call(); -> 자식이 가지고 있는 것을 부모에게 원해서 불가능
			
			//instanceof
			//- 2항 연산자
			//- boolean 반환
			//- 객체 instanceof 타입
			
			//System.out.println(list[i] instanceof Printer);
			
			//*****
			if (list[i] instanceof LG100) { // 정말 자주 씀. 
				LG100 lg = (LG100)list[i]; //-> 형제끼리는 멤버가 달라서 형변환 안됨
				lg.selfTest();
			} else if(list[i] instanceof HP200) {
				HP200 hp = (HP200)list[i];
				hp.call();
			}
			
		}
		
		
		
	}

	private static void m2() {
		
		//Case 2.
		//- 같은 종류의 프린터 증가 > 가성비 높음
		//- 다른 종류의 프린터 증가 > 종류당 * 동일 증가 
		LG100[] lg = new LG100[500];
		HP200[] hp = new HP200[300];
		
		for (int i=0; i<lg.length; i++) {
			lg[i] = new LG100(300000, 10, "black", 4);
		}
		
		for (int i=0; i<hp.length; i++) {
			hp[i] = new HP200(350000, 12, "터치");
		}
		
		//점검시간
		for (int i=0; i<lg.length; i++) {
			lg[i].print();
			lg[i].selfTest();
		}
		
		for (int i=0; i<hp.length; i++) {
			hp[i].print();
			hp[i].call();
		}
		
		
		
	}

	private static void m1() {
		//case 1.
		//- 가장 비효율적인 방식
		//- 대당 비용 x 동일 증가
		LG100 lg1 = new LG100(300000, 10, "black", 4);
		LG100 lg2 = new LG100(300000, 10, "black", 4);
		LG100 lg3 = new LG100(300000, 10, "black", 4);
		LG100 lg4 = new LG100(300000, 10, "black", 4);
		LG100 lg5 = new LG100(300000, 10, "black", 4);
		
		HP200 hp1 = new HP200(350000, 12, "터치");
		HP200 hp2 = new HP200(350000, 12, "터치");
		HP200 hp3 = new HP200(350000, 12, "터치");


		
		//점검
		lg1.print();
		lg2.print();
		lg3.print();
		lg4.print();
		lg5.print();
		
		hp1.print();
		hp2.print();
		hp3.print();
		
		
	}
	
}//class

//클래스를 상속 > 부모 역할
//1. 일반 클래스
//2. 추상 클래스
//3. 인터페이스

//선택 기준
//1. 추상메서드가 필요한지? 
//	1) yes -> 추상 클래스 or 인터페이스
//		- 구현된 멤버를 상속 할 것인가?
//			a) yes -> 추상클래스
//			b) no -> 인터페이스
//	2) no -> 일반 클래스
//printer p1 = new Printer(50000, 5); -> x? 

abstract class Printer {
	
	private int price;
	private int weight;
	
	public Printer(int price, int weight) {
		this.price = price;
		this.weight = weight;
	}
	
	//공통 사용법
	//추상 클래스는 앞 부분 생략하면 안됨
	public abstract void print();
	
}

class LG100 extends Printer{

	private String color;
	private int size; //A4, A5
	
	public LG100(int price, int weight, String color, int size) {
		super(price, weight);
		this.color = color;
		this.size = size;
	}

	
	public void print() {
		System.out.printf("%d 사이즈로 출력합니다.\n", this.size);
	}
	
	public void selfTest() {
		System.out.println("자가 진단을 합니다.");
	}
	
}//LG100


//부모클래스에 인자를 가진 생성자 만들어 둬서 자식들에게 강요 값을 자식이 넣어야 됨
class HP200 extends Printer{
	
	private String type; //터치, 버튼을 누르는

	public HP200(int price, int size, String type) {
		super(price, size);
		this.type = type;
		
	}
	
//	public void output() {
//		System.out.printf("%s 방식으로 출력합니다.\n", this.type);
//	}
	
	@Override
	public void print() {
		System.out.printf("%s 방식으로 출력합니다.\n", this.type);
	}
	
	public void call() {
		System.out.println("상담원하고 AI와 연결합니다.");
	}
	
}//HP200








