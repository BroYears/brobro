package com.test.java.obj.inheritance;

import java.util.Date;

public class Ex43_Overriding {

	public static void main(String[] args) {
		
		Time t1 = new Time(2, 30);
		Time t2 = new Time(3, 50);
		
		System.out.println(t1.info());
		System.out.println(t2.info());
		
		System.out.println(t1.toString());
		System.out.println(t2.toString());//객체를 그냥 프린트하면 나왔던 거처럼 나옴 Time@1218025c
		
		System.out.println(t1);
		System.out.println(t2);//객체를 그냥 찍으면 toString 자동으로 호출
		
		Date now = new Date();
		System.out.println(now);
		System.out.println(now.toString());//위에서 쓰는 toString이랑 다른 메서드 -> 오버라이딩
		
		BBBBB b1 = new BBBBB();
		b1.test(); //부모.test()
		b1.test(); //자식.test()
		b1.test();
		
		
	}//main
	
	
}

class AAAAA {
	public void test() {
		
	}
}

class BBBBB extends AAAAA {
	@Override
 	public void test() {
	
	 	super.test();
 	}
}

//시간(시:분)
class Time { //extends Object 없어도 있다.
	
	private int hour;
	private int minute;
	
	public Time(int hour, int minute) { //source에서 만들기 가능
		this.hour = hour;
		this.minute = minute;
	}
	
	public String info() {
		
		return this.hour + ":" + this.minute;
		
	}

	//어노테이션(Annotation) 
	//- 일종의 주석(기능이 존재)
//	@Override 
//	public String toString() {
//		return String.format("Time [hour=%s, minute=%s]", hour, minute);
//	}

//	@Override
//	public String toString() {
//		return "Time [hour=" + hour + ", minute=" + minute + "]";
//	}
	
//	public String toString() {//개발자가 보기에만 볼만함 -> 사용자는 볼 필요 x
//		
//		return this.hour + ":" + this.minute;
//	}
	
	@Override
	public String toString() {//정말 많이 씀.
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}



