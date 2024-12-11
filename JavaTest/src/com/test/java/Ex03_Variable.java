package com.test.java;

public class Ex03_Variable {
	
	public static void main(String args[]) {
		
		//모든 자료형 + 변수 생성
		
		//정수형(byte, short, int, long)
		byte b1;
		
			b1 = 100; //100 -> 상수
			System.out.println(b1);
		
			b1 = Byte.MAX_VALUE;
			System.out.println(b1);
		
			b1 = Byte.MIN_VALUE;
			System.out.println(b1);
		
		short s1; //2byte 정수
		
			s1 = 100;//정수형 리터럴
			System.out.println(s1);
			
			
			s1 = 1000;
			System.out.println(s1);
			
			System.out.println(Short.MIN_VALUE);
			System.out.println(Short.MAX_VALUE);
			
		int n1; //4byte 정수
		
			n1 = 100;
			System.out.println(n1);
			
			n1 = 1000;
			System.out.println(n1);
			
			n1 = 1_000_000_000;
			System.out.println(n1);
			
			System.out.println(Integer.MIN_VALUE);
			System.out.println(Integer.MAX_VALUE);
			
		long l1; //8byte  정수
		
			l1 = 100;
			System.out.println(l1);
			
			//The literal 10000000000 of type int is out of range
			//설정한 값부터 찾아감, 100 -> num, 처음에 100이 몇 byte인지 모름 -> 4byte로 고정(int) ->long 에러(100억 넘 많)
			//l1 = 10000000000;
			//System.out.println(l1);
		
			//*** 정수형 리터럴 -> 자료형이 int -> 32bit 운영체제 -> 앞으로도 거의 고정(?)
			
			l1 = 10000000000L;//L -> long
			System.out.println(l1);
			
		byte num;
		
			num = 100;
			
		//실수
		//*** 실수형 리터럴 -> double 형	
			
		float f1;//단정도형
		
			f1 = 3.14F;//Type mismatch: cannot convert from double to float
		System.out.println(f1);
		
		
		double d1;//배정도형
		
			d1 = 3.14D;
		System.out.println(d1);
		
			f1 = 123.12345678901234567890123456789F;
			d1 = 123.12345678901234567890123456789D;
		
		System.out.println(f1);//123.12346
		System.out.println(d1);//123.12345678901235
							   //두 배 정도 차이남
		
		
			f1 = 123456789012345678901234567890123456789F;
			d1 = 123456789012345678901234567890123456789D;
		
		
		//   123456789000000000000000000000000000000
		//   123456789012345680000000000000000000000
		System.out.println(f1);
		System.out.println(d1);
		
		System.out.println(Float.MAX_VALUE);
		System.out.println(Double.MAX_VALUE);
		
		double d2 = 0.2;
		double d3 = 0.1;
		
		System.out.println(d2 + d3);//0.30000000000000004
		
		//0.2 x 10 =2
		//0.1 x 10 =1
		//2 + 1
		//3 / 10 = 0.3
		
		//BigDecimal
	
		//문자형
		char c1;
		c1 = 'A'; //문자형 리터럴 ('_')
		System.out.println(c1);
		
		c1 = '가';
		System.out.println(c1);
		
		c1 = '1';//문자 1 -> 문자코드 -> 49
		b1 = 1;	 //숫자 1
		System.out.println(c1);
		
		c1 = '@';
		System.out.println(c1);
		
		//Invalid character constant
		//char -> 1개의 문자를 저장하는 자료형 -> 2개 이상의 문자(ex - 방구 등) 불가
//		c1 = '홍';
//		c2 = '길';
//		c3 = '동';
		
		
		//논리형
		//- boolean(불리언), bool(불, 부울)
		boolean flag;
		
		flag = true; //논리형 상수, 논리형 리터널
		flag = false;
		
		
		System.out.println(flag);
		
		
		//---------------------------------------------
		
		//추가 자료형
		
		//string, 문자열
		//-문자 열 -> 문자들이 열을 지어 있는 형태 -> char 변수를 여러개 모아놓은 자료형
		
		//홍길동
//		char name1 = '홍';
//		char name2 = '길';
//		char name3 = '동';
		
		String name;
		
			name = "홍길동"; //문자열 상수, 문자열 리터럴
		
		System.out.println(name);
		
		
		char m1 = 'A';
		String m2 = "A";
		
		System.out.println(m1);
		System.out.println(m2);
		
		
		//빈 문자열, Empty String
		//- 문자열 변수를 초기화하려고 사용
		String m3 = "";
		System.out.println(m3);
		
		//char m4 = ''; -> 불가
		
		//각 자료형별(9가지)
		//1. 변수 1개 만들기
		//2. 값을 대입하기
		//3. 출력하기
		
		//ex)
		//1. 데이터 선정
		//- 몸무게
		
		
		//2. 1의 데이터 자료형 선택
		//- 형태 + 길이(범위)
		//- 1kg ~ 150kg + 실수 = float/double > float
		
		//3. 코드 작성
//		float myWeight;
//		
//			myWeight = 72.5F;
//		
//		System.out.println("제 몸무게는" + myWeight + "kg입니다");
		
		
		byte z1;
		
			z1 = 100;
			
		System.out.println(z1);
		
		
			z1 = 101;
			
		System.out.println(z1);
		
			z1 = 102;
		
		System.out.println(z1);
		
			z1 = 103;
			
		System.out.println(z1);
		
			z1 = 104;
			
		System.out.println(z1);
		
			z1 = 105;
			
		System.out.println(z1);
		
			z1 = 106;
			
		System.out.println(z1);
		
			z1 = 107;
			
		System.out.println(z1);
		
			z1 = 108; 
			
		System.out.println(z1);
			
			z1 = 109;
		
		System.out.println(z1);
		
		short myAmericano;
		
			myAmericano = 300;
		
		System.out.println(myAmericano);
		
			myAmericano = 301;
			
		System.out.println(myAmericano);
		
			myAmericano = 302;
			
		System.out.println("제 아메리카노는" + myAmericano +"ml 남았습니다.");
		
			myAmericano = 303;
			
			System.out.println("제 아메리카노는" + myAmericano +"ml 남았습니다.");
			
			myAmericano = 304;
			
			System.out.println("제 아메리카노는" + myAmericano +"ml 남았습니다.");
			
			myAmericano = 305;
			
			System.out.println("제 아메리카노는" + myAmericano +"ml 남았습니다.");
			
			myAmericano = 306;
			
			System.out.println("제 아메리카노는" + myAmericano +"ml 남았습니다.");
			
			myAmericano = 307;
			
			System.out.println("제 아메리카노는" + myAmericano +"ml 남았습니다.");
			
			myAmericano = 308;
			
			System.out.println("제 아메리카노는" + myAmericano +"ml 남았습니다.");
			
			myAmericano = 309;
			
			System.out.println("제 아메리카노는" + myAmericano +"ml 남았습니다.");
		
		int mySubway;
		
			mySubway = 48000;
		
			System.out.println(mySubway);
			
			mySubway = 48100;
			
			System.out.println("한 달동안 이용한 지하철 요금은 " + mySubway + "원 입니다");
			
			mySubway = 48200;
			
			System.out.println(mySubway);
			
			mySubway = 48300;
			
			System.out.println("한 달동안 이용한 지하철 요금은 " + mySubway + "원 입니다");
			
			mySubway = 48400;
			
			System.out.println("한 달동안 이용한 지하철 요금은 " + mySubway + "원 입니다");
			
			mySubway = 48500;
			
			System.out.println("한 달동안 이용한 지하철 요금은 " + mySubway + "원 입니다");
			
			mySubway = 48600;
			
			System.out.println("한 달동안 이용한 지하철 요금은 " + mySubway + "원 입니다");
			
			mySubway = 48700;
			
			System.out.println("한 달동안 이용한 지하철 요금은 " + mySubway + "원 입니다");
			
			mySubway = 48800;
			
			System.out.println("한 달동안 이용한 지하철 요금은 " + mySubway + "원 입니다");
			
			mySubway = 48900;
			
			System.out.println("한 달동안 이용한 지하철 요금은 " + mySubway + "원 입니다");
			
		long worldPeople;
		
			worldPeople = 6000000000L;
			
			System.out.println("세계 인구는 " + worldPeople + "명 입니다.");
			
			worldPeople = 6100000000L;
			
			System.out.println("세계 인구는 " + worldPeople + "명 입니다.");
			
			worldPeople = 6200000000L;
			
			System.out.println("세계 인구는 " + worldPeople + "명 입니다.");
			
			worldPeople = 6200000000L;
			
			System.out.println("세계 인구는 " + worldPeople + "명 입니다.");
			
			worldPeople = 6300000000L;
			
			System.out.println("세계 인구는 " + worldPeople + "명 입니다.");
			
			worldPeople = 6400000000L;
			
			System.out.println("세계 인구는 " + worldPeople + "명 입니다.");
			
			worldPeople = 6500000000L;
			
			System.out.println("세계 인구는 " + worldPeople + "명 입니다.");
			
			worldPeople = 6600000000L;
			
			System.out.println("세계 인구는 " + worldPeople + "명 입니다.");
			
			worldPeople = 6700000000L;
			
			System.out.println("세계 인구는 " + worldPeople + "명 입니다.");
			
			worldPeople = 6800000000L;
			
			System.out.println("세계 인구는 " + worldPeople + "명 입니다.");
			
			worldPeople = 6900000000L;
			
			System.out.println("세계 인구는 " + worldPeople + "명 입니다.");
			
			
		float myAge;
		
		 	myAge = 31.9F;
		 	
		 	System.out.println("제 나이는 " + myAge + "살 입니다");
		 	
		 	myAge = 31.91F;
		 	
		 	System.out.println("제 나이는 " + myAge + "살 입니다");
		 	
		 	myAge = 31.92F;
		 	
		 	System.out.println("제 나이는 " + myAge + "살 입니다");
		 	
			myAge = 31.93F;
			
			System.out.println("제 나이는 " + myAge + "살 입니다");
			
			myAge = 31.94F;
			
			System.out.println("제 나이는 " + myAge + "살 입니다");
			
			myAge = 31.95F;
			
			System.out.println("제 나이는 " + myAge + "살 입니다");
			
			myAge = 31.96F;
			
			System.out.println("제 나이는 " + myAge + "살 입니다");
			
			myAge = 31.97F;
			
			System.out.println("제 나이는 " + myAge + "살 입니다");
			myAge = 31.98F;
			
			System.out.println("제 나이는 " + myAge + "살 입니다");
			
			myAge = 31.99F;
			
			System.out.println("제 나이는 " + myAge + "살 입니다");
			
		double myWeight;
		
			myWeight = 77D;
			
			System.out.println("제 몸무게는 " + myWeight + "kg 입니다." );
			
			myWeight = 77.1D;
			
			System.out.println("제 몸무게는 " + myWeight + "kg 입니다." );
			
			myWeight = 77.2D;
			
			System.out.println("제 몸무게는 " + myWeight + "kg 입니다." );
			
			myWeight = 77.3D;
			
			System.out.println("제 몸무게는 " + myWeight + "kg 입니다." );
			
			myWeight = 77.4D;
			
			System.out.println("제 몸무게는 " + myWeight + "kg 입니다." );
			
			myWeight = 77.5D;
			
			System.out.println("제 몸무게는 " + myWeight + "kg 입니다." );
			
			myWeight = 77.6D;
			
			System.out.println("제 몸무게는 " + myWeight + "kg 입니다." );
			
			myWeight = 77.7D;
			
			System.out.println("제 몸무게는 " + myWeight + "kg 입니다." );
			
			myWeight = 77.8D;
			
			System.out.println("제 몸무게는 " + myWeight + "kg 입니다." );
			
			myWeight = 77.9D;
			
			System.out.println("제 몸무게는 " + myWeight + "kg 입니다." );
			
		char that;
		
			that = '감';
			
			System.out.println("이 과일은 " + that + "입니다.");
			
			that = '배';
			
			System.out.println("이 과일은 " + that + "입니다.");
			
			that = '똥';
			
			System.out.println("이 과일은 " + that + "입니다.");
			
			that = '차';
		
			System.out.println("저것은 " + that + "입니다.");
			
			that = '삵';
			
			System.out.println("저것은 " + that + "입니다.");
			
			that = '칡';
			
			System.out.println("저것은 " + that + "입니다.");
			
			that = '불';
			
			System.out.println("저것은 " + that + "입니다.");
			
			that = '물';
			
			System.out.println("저것은 " + that + "입니다.");
		
			that = '꽃';
			
			System.out.println("저것은 " + that + "입니다.");
			
		String myLol;
		
			myLol = "골드1 1점";
			
			System.out.println("제 롤 티어는 " + myLol + "입니다");
			
			myLol = "골드1 11점";
			
			System.out.println("제 롤 티어는 " + myLol + "입니다");
			
			myLol = "플레4 10점";
			
			System.out.println("제 롤 티어는 " + myLol + "입니다");
			
			myLol = "플레3 15점";
			
			System.out.println("제 롤 티어는 " + myLol + "입니다");
			
			myLol = "플레2 20점";
			
			System.out.println("제 롤 티어는 " + myLol + "입니다");
			
			myLol = "플레1 30점";
			
			System.out.println("제 롤 티어는 " + myLol + "입니다");
			
			myLol = "에메랄드1 10점";
			
			System.out.println("제 롤 티어는 " + myLol + "입니다");
			
			myLol = "에메랄드2 20점";
			
			System.out.println("제 롤 티어는 " + myLol + "입니다");
			
			myLol = "다이아2 30점";
			
			System.out.println("제 롤 티어는 " + myLol + "입니다");
			myLol = "마스터 100점";
			
			System.out.println("제 롤 티어는 " + myLol + "입니다");
			
		boolean real;
		
			real = true;
			
			System.out.println(real);
		
			real = false;
			
			System.out.println(real);
		
			real = true;
			
			System.out.println("This is " + real);
			
			real = false;
			
			System.out.println("This is " + real);
			
			real = true;
			
			System.out.println("This is " + real);
			
			real = false;
			
			System.out.println("This is " + real);
			
			real = true;
			
			System.out.println("This is " + real);
			
			real = false;
			
			System.out.println("This is " + real);
			
			real = true;
			
			System.out.println("This is " + real);
			
			real = false;
			
			System.out.println("This is " + real);
		
		
		int a = 10;
		int b = 20;
		
		//연산자
		//- 연산자 우선 순위
		//- 연산자 실행 방향
		System.out.println(a + " + " + b + " = " + (a + b));

		//"10 + 20 =
		//1 + 2 + 3
		//왼쪽에서 오른쪽
		
		//10 + "문자열" -> 문자열 하나라도 있으면 "10" + "문자열"로 인식
		// = 10 문자열
			
		//주민등록번호 입력 -> 출력
		//ex) 951206
		
		int jumin1 = 961206;
		
		System.out.println("주민등록번호 : " + jumin1);
		
			jumin1 = 030711;//0을 붙으면 int에서 8진수
			
		System.out.println("주민등록번호 : " + jumin1);
		
		//자바의 소스상 기수법
		//- 10진수
		//- 8진수
		//- 2진수
		//- 16진수
		System.out.println(10);		//10진수
		System.out.println(010);	//8진수 -> 출력은 10진수로
		System.out.println(0x10);	//16진수 -> 색상값 표현 할 때 이용
		System.out.println(0b10);	//2진수
		
		//진법 변환
		
		String jumin2 = "030711";
		System.out.println(jumin2);
		
		//*** 숫자의 모양 -> 진짜 숫자? vs 문자열?
		
		//실수 리터럴
		double d4 = 1200;
		double d5 = 1.2e+3;
		
		double d6 = 0.012;
		double d7 = 1.2e-2;
		
		System.out.println(d5);
		System.out.println(d7);

		//Ex04_Escape.java
		
		
		
		
		
	}

}
