package com.test.java;

public class Ex09_Casting {
	
	public static void main(String[] args) {
		
		/*
		 	
		 	
		 	형변환(자료형 형변환), Data Type Casting
		 	- 하나의 자료형(int)을 또 다른 자료형(long)으로 변환하는 작업
		 	- 코드 작성을 유연하게 하기 위한 도구
		 	
		 	
		 	1. 암시적 형변환, 자동 형변환, Promotion
		 		- 큰 형 = 작은 형;
		 				<-
		 		-
		 	
		 	
		 	2. 명시적 형변환, 강제 형변환, Casting
		 		- 작은 형 = 큰 형;
		 				  <-
		 
		  
		 
		 */
		
		int n1 = 10;
		int n2;
		
		// = 대입 연산자 오른쪽이 왼쪽에 대입
		//- LValue(공간) = RValue(값)
		//- LValue : 변수
		//- RValue : 상수(리터럴), 변수
		//- *** LValue와 RValue의 자료형이 반드시 동일해야 한다. -> 에러발생
		n2 = n1;
		
		System.out.println(n2);
		System.out.println();
		
		byte b1; //1byte(작은 형)
		short s1; //2byte(큰 형)
		
		b1 = 10; //원본
		
		// *** 문제 발생
		//short = byte - 불일치
		//s1 = b1; //복사 - 주 목적(암시적 형변환, 자동 형변환)
		
		//short = short
		s1 = (short)b1; //(자료형) : 형변환 연산자
						//- 임시로만 바꿔줌(근본은 안바뀜)
						//- 가독성 위해서 일부러 적기도함, 안적어도 되긴 함
		
		
		System.out.println(s1); //10 성공
		System.out.println();
		//
		byte b2;
		short s2;
		
		s2 = -278; //원본 
		
		//byte = short
		//작은 형 = 큰 형
		//b2 = s2;
		b2 = (byte)s2;
		
		System.out.println(b2); //10 성공 -> 비트로 변환해서보면 1000으로했을 때 짤리는 부분에 부호 부분이 1로 입려 돼서 - 24 나옴
		
		//오버플로우(Overflow)
		//- 값이 공간보다 더 커졌을 때 손실분이 발생하는 현상		
		//언더플로우(Underflow)
		//- 값이 공간보다 더 작아졌을 때 손실분이 발생하는 현상
		//대충 오버플로우라고 해도 됨
		
		//기업 은행 -> 계좌
		long m1 = 3000000000L; //계좌 1
		int m2; //계좌2
		
		//계좌 이체
		m2 = (int)m1;//Type mismatch: cannot convert from long to int
		
		System.out.printf("%,d원\n" ,m2);
		
		//큰 형 = 작은 형
		//long(8) = int(4)
		//long(8) = short(2)
		//long(8) = byte(1)
		//int(4) = short(2)
		//int(4) = byte(1)
		//short(2) = byte(1)
		
		//작은 형= 큰 형
		//byte(1) = long(8)
		//byte(1) = int(4)
		//byte(1) = short(2)
		//short(2) = int(4)
		//short(2) = long(8)
		//int(4) = long(8)
		
		
		//byte = int
		byte a1 = 10;//도구 자체가 상수 int -> 암시적 형변환
		
		//short = int
		short a2 = 10;//명시적이어야하는데 암시적으로 해줌
		
		//int = int
		int a3 = 10;//정석
		
		//long = int
		long a4 = 10;//암시적 형변환
		
		//float(4) = double(8)
		float f1 = (float)3.14;//(float) -> F랑 똑같음
		
		//double(80 = double(8)
		double d1 = 3.14;
	
		//주의!!
		
		//정수와 실수간의 형변환
		//- 정수 -> 정수
		//- 실수 -> 실수
		//- 실수 -> 정수 : 오버플로우 발생 가능!(명시적)
		//- 정수 -> 실수 : 안전(암시적)
		
		int o1 = 100;//원본(4)
		float o2;	 //복사본(4)
		
		//암시적 형변환 = 안전
		//float(4) = int(4)
		o2 = o1;
		
		System.out.println(o2);//문제 x -> 실수로 변환해서 소수 점.0 나옴
	
		int o3;					//복사본(4)
		float o4 = 10000000000F;//원본(4)
		
		o3 = (int)o4;//Type mismatch: cannot convert from float to int
		
		System.out.println(o3);//-> 여긴 왜 최대치지?
		
		long o5;		 //복사본(4)
		float o6 = 100F; //원본(4)
		
		//8byte = 4byte
		//작은 형 = 큰 형
		//float가 범위가 훨씬 큼
		o5 = (long)o6;
		
		System.out.println(o5);
		
		int o7 = 100;
		float o8;
		
		o8 = o7;
		
		System.out.println(o8);
		
		char c1 = 'A'; //내부는 숫자형 > 65 : 2byte
		short c2; //2byte
		
		
		//short(2) = char(2)
		//명시적 형변환 + 오버 플로우 발생 위험
		c2 = (short)c1;
		
		System.out.println(c2);
		
		
		
		char c3;
		short c4 = 97;
		
		//short(2) = char(2)
		//명시적 형변환
		//char -> 숫자 형변환 하려면 int 이상을 써야 함(범위가 안맞음)
		c3 = (char)c4;
		
		
		System.out.println(c3);
		
		
		//이러면 암시적 -> 안전
		char c5 = '가';
		int c6;
		
		c6 = c5;
		
		System.out.println(c6);
		
		
		//*** 기본형과 참조형 간에는 형변환이 절대 불가능.
		//- 근본적으로 자료형이 달라서 호환이 안됨
		
		//"100" : 참조형(String)
		//100 : 기본형(int)
		
		//Integer.pareseInt("100") //형변환이 아님
		
		//"100" -> 100 : 형변환 불가능
		//100 -> "100" : 형변환 불가능
		
//		System.out.println((int)"100"); -> 불가
		
		int num1 = 100; // "100"
		
		System.out.println(String.valueOf(num1) + 100);
		
		System.out.println(num1 + "" + 100);// -> ""도 문자열이라 숫자를 문자열로 바꿔버림
		
		
		
	}//main

}
