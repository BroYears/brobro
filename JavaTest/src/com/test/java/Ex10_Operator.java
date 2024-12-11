package com.test.java;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Ex10_Operator {
	
	public static void main(String[] args) {
		
		
		/*
			
			
			연산자, Operator
			- 수학연산자 -> 프로그래밍 언어 연산자
			- 피연산자(Operand)를 대상으로 연산 후 값을 반환
			- 주로 기호를 사용 + 영어 단어 사용
			- 연산자 우선 순위는 일반적 연산이랑 똑같음
			- 단항, 대입 연산자는 진행방향이 반대(오른쪽부터)
			- %는 나머지 연산자
			- == 이퀄 두 번
			- != !,= !는 not
					
					
		 */
		
		int sum = 10 + 20;//int sum(x) 표현식이 아니라 변수 선언문
						  //표현식은 무조건 하나의 값이 결과로 나오면 표현식
						  //+, = 연산자
						  //피연산자
						  //- + : 10, 20
						  //- = : sum, 30
			
		System.out.println(sum);
		
		//산술 연산자
		//- +, -, *, /, %(나머지, mod)
		//- 2항연산자
		//- 피연산자를 숫자로 함(정수, 실수)
		//
		
		int a = 10;
		int b = 3;
		
		System.out.printf("%d + %d = %d\n", a, b, a + b);
		System.out.printf("%d - %d = %d\n", a, b, a - b);
		System.out.printf("%d * %d = %d\n", a, b, a * b); 
		System.out.printf("%d / %d = %d\n", a, b, a / b); //몫
		System.out.printf("%d %% %d = %d\n", a, b, a % b);//나머지
		//이스케이프 할 때 대부분 같은 특수문자 쓰면 됨
		
		//자판
		//- 한글 자판(두벌식) -> 자음 + 모음
		//- 한글 자판(세벌식) -> 초성 + 중성 + 종성
		//- 영문 자판(QWERTY)
		//- 영문 자판(드보락)
		
		//나누기 -> 몫(x)
		System.out.println();
		System.out.printf("%d / %d = %d\n", a, b, a / b);
		
		double c = 10;
		double d = 3;
		System.out.printf("%f / %f = %f\n", c, d, c / d);
		
		//정수 / 정수 = 정수
		//실수 / 실수 = 실수
		//정수 / 실수 = 실수
		//실수 / 정수 = 실수
		
		//***** 모든 산술 연산의 결과값의 자료형 -> 두개의 피연산자 중 더 크기가 큰 자료형으로 반환 -> 데이터 손실을 최소화	
		System.out.println(10 / 3);		//int / int = int
		System.out.println(10D / 3D);	//double / double = double
		System.out.println(10 / 3D);	//int / double = double
		System.out.println(10.0 / 3);	//double / int = double
		
		System.out.println((int)(10.5 / 3.3));
		System.out.println(10.5 / 3);
		System.out.println();
		
		int a1 = 1000000000;
		int a2 = 2000000000;
		int a3 = a1 + a2;		//int + int = int
		long a4 = (long)a1 + a2;//a1 + a2 여기서 이미 오버플로우
								//long + int = long
		
		System.out.println(a3);
		System.out.println(a4);
		
		int a5 = -1000000000;
		int a6 = 2000000000;
		
		System.out.println(a5 - a6);//언더플로우
		
		
		int a7 = 1000000;
		System.out.println(a7 * 100000);//오버플로우
		
		//나누기
		//나머지
		
		
		byte a8 = 10;
		byte a9 = 20;
		
		//*** byte와 short의 연산은 항상 int가 됨
		//- int보다 작은 자료형들은 강제로 int로 변환시킨다.
		//- CPU -> int 단위 = CPU가 한 번에 읽어가는 크기
		
		//Type mismatch: cannot convert from int to byte
		byte a10 = (byte)(a8 + a9); //byte + byte = byte(x)
		
		//정수형 -> int, long
		//short -> 이전 세대의 int, 16bit일 때의 int
		
		
		//%(mod)
		//- 패턴 생성
		
		//달력 만들기(2024년 12월)
		//1. 월의 1일 -> 무슨 요일? -> 기준점(1년 1월 1일) -> 수
		//2. 월 -> 마지막 날짜? -> 31일
		//나머지로 특정 요일 계산
		//다음 주로 넘어 갈 때 println
		
		/*
			
			일	월	화	수	목	금	토
						1	2	3	4
			5	6	7	8	9	10	11
			12	13	14	15	16	17	18
			19	20	21	22	23	24	25
			26	27	28	29	30	31
			
			
		*/
		
		
		
		
		
		
		
		
	}//main

}
