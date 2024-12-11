package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex12_Operator {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		/*
			논리 연산자
			- &&(and), ||(or), !(not)
			- 2항 연산자(&&, ||)
			- 1항 연산자(!)
			- 피연산자의 자료형은 boolean
			- 연산의 결과 boolean
			- 피연산자를 정해진 규칙에 따라 연산을 한 후 값을 반환
			
			
			
			A && B = ? > 논리곱
			----------
			T && T = T
			T && F = F
			F && T = F
			F && F = F
			
			A || B = ? > 논리합
			----------
			T || T = T
			T || F = T
			F || T = T
			F || F = F
			
			소개팅 > 남자
			1. 키 180cm 이상
			2. 잘생김
			
			!A
			--
			!T = F
			!F = T
			
			A ^ B = ? 베타적 논리합(exclusive or, xor)
			----------
			T ^ T = F
			T ^ F = T
			F ^ T = T
			F ^ F = F
			
			
			
			
			
			
		 */
		
		
		//나이 입력 > 18세 이상 + 60세 미만
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("나이 : ");
		int age = 20;//Integer.parseInt(reader.readLine());
		
		//String input = reader.readLine();
		//int age = Integer.parseInt(input);
		
		System.out.print("성별(m, f) : ");
		String gender = "m";//reader.readLine();
		
		System.out.println(age >= 18);	//T T F
		System.out.println(age < 60);	//T F T
		System.out.println(gender.equals("m"));
		
		System.out.println(((age >= 18) && (age < 60)) && gender.equals("m"));//-레벨이 달라서 레벨끼리 묶어주고 급을 맞춰줘야 함
		//System.out.println(18 <= age < 60); -> 불가
		//- 이렇게하면 (true < 60)이 됨
		
		//*** 연산자 우선 순위
		//- 한 문장내에서 연산자들 간의 실행 순사
		//- () > 산술 연산자 > 비교 연산자 > 논리 연산자 > 대입 연산자
		

		//***연산자의 연산방향
		//- 한 문장 내에서 같은 우선 순위를 가지는 연산자들 간의 실행 순서
		//- 대부분의 연산자: 왼쪽 -> 오른쪽.
		//- 증감/대입 연산자 : 오른쪽 > 왼쪽
		//- 1 + 2 + 3
		
		/*
			
			대입 연산자, 할당 연산자
			- =
			- +=, -=, *=, /=, %=(복합 대입 연산자)
			- LValue(변수) = RValue(변수, 상수)
			- LVaule와 RValue는 자료형이 동일해야 한다. > 형변환
			
		*/
		
		/*
					3	2	1
			int sum = 1 + 2 * 3;
			
			
						  2 * 3
						  6
			int sum = 1 + 6;		  
			
			
					  1 + 6
			int sum = 7;
			
				sum = 7
				sum
				
		 */
		
		
		
		int sum = 1 + 2 * 3;
		
		System.out.println(sum);
		
		int m1 = 100;
		int m2; //m1(100)
		int m3; //m2(100)
		
		//m2 = m1;
		//m3 = m1;
		
		
		
		m3 = m2 = m1;
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		System.err.println();
		
		
		//+=, -=, *=, /=, %=(복합 대입 연산자)
		
		int n = 10;
		
		//n에 1을 더하시오 >  n이 가진 10에 1일 더해 다시 n에다 덮어쓰기 > 누적
		n = n + 1; //누적
		System.out.println(n);
		
		n += 1;
		
		n += 3;// n = n + 1;
		System.out.println(n);
		
		n = n - 1;
		System.out.println(n);
		
		n -= 1;
		System.out.println(n);
		
		n -= 3;
		System.out.println(n);
		
		n *= 2;
		System.out.println(n);
		
		n = n / 5;
		System.out.println(n);
		
		n /= 4;
		System.out.println(n);
		
		n = n % 2;
		System.out.println(n);
		
		n = 10;
		n %= 3;
		System.out.println(n);
		
		n = 10 - n;
		
		n -= 10; //x
		System.out.println(n);
		
		
		/*
			
			증감 연산자
			- ++(증가), --(감소)
			- 1항 연산자
			- 피연산자는 숫자형이다.
			- 누적 연산을 한다.
			- 기존의 값에 1을 더하거나 1 을 뺀다.
		
			***연산자와 피연산자의 위치를 바꿀 수 있다.
			- 연산자의 위치에 따라 연산자 우선 순위가 변한다.
			1. ++n : 전위배치 > 연산자 우선 순위가 가장 높다.
			2. n++ : 후위배치 > 연산자 우선 순위가 가장 낮다.
			
			
			
			
		 */
		
		
		n = 10;
		
		n = n + 1;
		n += 1;
		++n;
		
		System.out.println(n);

		n = n -1;
		n -= 1;
		--n;
		
		System.out.println(n);
		
		n = n + 5;
		n += 5;
		++n; //불가능(+1)
		
		n = 10;
		++n; //전위, 전치
		
		System.out.println(n);
		
		n++;//후위, 후치
		
		System.out.println(n);
		
		n = 10;
		int result = 0;
		
		++n;//문장 따로 빼서 하는게 안 헷갈림
		result = 10 + n;
		
		//	   3    2  1 
		//result = 10 + ++n;
		
		//			  ++n(10)
		//			  n(11)
		
		//		 10 + n(11)
		//		 21
		
		//r	   = 2
		
		
		System.out.println("result : " + result);
		
		n = 10;
		result = 0;
		
		result = 10 + n;
		n++;
		
		//*** 증감연산자는 전치/후치 상관없이 다른 연산자와 한 문장에 넣지 말 것
		
		//	   2    1  3
		//result = 10 + n++;//n++ -> 대입연산자 보다도 늦게 연산됨
		//		 10 + n(10)
		//		 20
				
		
		//r	   = 20
		
		//			  n++(10)
		//			  n(11)
		
		System.out.println("result : " + result);	
		System.out.println(n);
		
		int o = 10;
		
		System.out.println(--o - o--);
		System.out.println();
		
		
		/*
			
			조건 연산자
			- ?: 
			- 3항 연산자
			- A ? B : C
			- 조건 ? 참 : 거짓
			- A : boolean > 조건으로 사용
			- B, C : 값(상수, 변수) > 연산의 결과로 사용
			- A가 참이면 B를 반환, A가 거짓이면 C를 반환
			
			
		 */
		
		System.out.println(1 + 2);
		System.out.println(true ? 100 : 200); //Dead code
		System.out.println(false ? 100 : 200);//Dead code
		
		
		age = 15;
		
		System.out.println(age >= 18 ? "통과" : "거절");
		
		//3항 연산자 == if문 역할 유사
		
		//조건 검사 > 값을 생성
		n = 10;	//짝수? 홀수?
		
		System.out.printf("숫자 %d는 %s입니다.\n"
							, n
							, n % 2 == 0 ? "짝수" : "홀수");
		
		n = 5;
		
		//System.out.println(n % 2 == 0 ? "짝수" : 100);//근본 x
														//리턴 값 자료형 통일
		
		//int result = n % 2 == 0 ? "짝수" : 100; 실행 자체가 안됨
		
		int a = 5;
		int b = 3;
		
		System.out.println(a & b);//논리 연산자면서 비트연산자
		
		//비트연산자 - 비트끼리 연산함
		
		
		
		
		
		
	}//main
	
}
