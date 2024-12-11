package com.test.java;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Ex15_Method {

	
	public static void main(String[] args) {
		
		//public static void hello()
		
		//void
		//- 반환 자료형
		//- 자료형을 기입
		//- void(아무것도 없다.)
		
		
		
		//()(인자 리스트)
		//- 파라미터(parameter)
		//- 인자(Argument)
		//- 매개변수
		
		//요구사항] '홍길동'에게 인사를 하는 메서드를 구현
		//요구사항] '아무개'에게 인사를 하는 메서드를 구현
		//요구사항] '테스트'에게 인사를 하는 메서드를 구현
		//요구사항] 우리 강의실에 있는 모든 사람~ x 20명
		//요구사항] 대한민국 모든 사람~
		
		//hello();
		hello2();
		hello3();
		
		hello("홍길동");
		hello("아무개");
		hello("테스트");
		
		int age = 20;
		
		String result = age >= 18? "통과" : "거절";
		System.out.println(result);
		
//		int age = 15;
//		
//		String result = age >= 18? "통과" : "거절";
//		System.out.println(result);
//		
//		int age = 30;
//		
//		String result = age >= 18? "통과" : "거절";
//		System.out.println(result);
		
		checkAge(15);
		checkAge(30);
		
		//checkAge("홍길동");//실인자
		
		byte b1 = 20;
		checkAge(b1);
		
		long l1 = 20;
		checkAge((int)l1);
		
		//checkAge();
		
		//checkAge(10, 20);
		
		
		//성적 평가 메서드
		
		checkScore(70, 80, 90);
		checkScore(90, 100, 50);
		//checkScore(90, 100);
		//checkScore(90, 100, 50, 70);
		
		//**실인자와 가인자의 갯수 일치
		//**실인자와 가인자의 자료형이 일치해야한다.(형변환 허용)		
		
		
		int a = 10;
		int b = 20;
		
		sum(a, b);//매개변수가 두 개만 필요함
		
		
		a = 30;
		b = 40;
		
		sum(a, b);
		
		substract(a, b);
		
		
	}//main

	public static void substract(int a, int b) {
		// TODO Auto-generated method stub
		int c = a - b;
		System.out.printf("%d - %d = %d\n", a, b, c);

		
	}

	public static void sum(int a, int b) {
		int c = a + b;
		System.out.printf("%d + %d = %d\n", a, b, c);
	}
	
	/**문서 주석
	 * 성적을 평가합니다.
	 * @param kor 국어점수
	 * @param eng 영어점수
	 * @param math 수학점수
	 */
	public static void checkScore(int kor, int eng, int math) {
		
		int total = kor + eng + math;
		
		double avg = total / 3D;
		
		String result = avg >= 60 ? "합격" : "불합격";
		
		System.out.printf("평균 점수 %.1f점은 %s입니다.\n", avg, result);
		
	}
	
	public static void checkAge(int age) { //가인자
		String result = age >= 18 ? "통과" : "거절";
		System.out.println(result);
	}
	
	public static void hello(String name) {
		
		//String name = "홍길동";
		
		System.out.println(name + "님 안녕하세요.");
	}
	
	//식별자1
	//식별자2
	//식별자 넘버링 금지
	public static void hello2() {
		//String name = "홍길동";
		System.out.println("아무개님 안녕하세요.");
	}
	
	public static void hello3() {
		
		System.out.println("테스트님 안녕하세요.");
	}
	
	public static void hello4() {
		
		
	}
	
}//class
