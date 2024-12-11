package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex11_Operator {
	
	public static void main(String[] args) throws IOException {
		
		
		/*
			
			비교 연산자
			- >(greater than), >=, <(less than), <=, ==(equal), !=(not equal)
			- 2항 연산자 : A > B
			- 피연산자들의 우위(동등) 비교
			- 피연산자는 숫자형(정수, 실수, 문자[캐릭터])을 가진다.
			- 연산의 결과가 항상 boolean. (true, false)
			
			
			
		 */
		
		int a = 10;
		int b = 3;
		
		System.out.printf("%d > %d = %b\n", a, b, a > b);
		System.out.printf("%d >= %d = %b\n", a, b, a >= b);
		System.out.printf("%d < %d = %b\n", a, b, a < b);
		System.out.printf("%d <= %d = %b\n", a, b, a <= b);
		System.out.printf("%d == %d = %b\n", a, b, a == b);
		System.out.printf("%d != %d = %b\n", a, b, a != b);
		System.out.println();
		
		//요구사항] 사용자 나이 입력 -> 18세 이상  통과, 미만 거절
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		
		System.out.print("나이 : ");
		String input = "20"; //reader.readLine(); "20" -> 숫자 20
		
		int age = Integer.parseInt(input);
		
		System.out.println(age >= 18);	//true, false -> 좋은 코드
		System.out.println(18 <= age);	//나쁜 코드
		System.out.println();
		
		char c1 = 'A';
		char c2 = 'B';
		
		System.out.println(c1 > c2);
		System.out.println(); 
		//회원가입 > 아이디 > 영어 소문자로만
		//- hong
		
		
		//==. !=
		//- 문자열은 비교에 절대 사용 x(논리 오류 발생)
		String s1 = "홍길동",
			   s2 = "아무개",
			   s3 = "홍";
		s3 = s3 + "길동";
		
		//System.out.println(s1 > s2);
		System.out.println(s1 == s2);
		
		
		System.out.println(s3);
		System.out.println(s1 == s3);
		
		
		//문자열 비교에는 반드시 equals() 사용
		System.out.println(s1.equals(s2)); 
		System.out.println(s1.equals(s3));

		System.out.println(!s1.equals(s3));
		
		
		
		
		
		
	}

}
