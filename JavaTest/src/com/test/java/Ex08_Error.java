package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex08_Error {
	
	public static void main(String[] args) throws IOException {
		
		/*
		   	에러, Error
		   	- 오류, 버그(Bug), 예외(Exception) 등...
			
			1. 컴파일 에러
				- 컴파일 작업 중 발생하는 오류
				- 컴파일러가 발견!! -> 번역하다가.. -> 문법이 틀려서!!
				- 발견!! -> 컴파일 작업 중단
				- 반드시 해결해야하는 오류
				- 난이도가 가장 낮음 -> 컴파일러가 알려줌 -> 에러 메시지
				- 오타주의!(빨간 밑줄)
				
			2. 런타임 에러 -> 예외(Exception)
		   		- 런타임(Runtime- 프로그램이 실행 중)시에 발생
				- 컴파일 작업 중에는 없었는데..-> 실행 중에 발생하는 에러
				- 난이도 중간 -> 발견 할 수도 못 할 수도.. 
				 
			3. 논리 에러
				- 컴파일 성공!! + 런타임 성공!! -> 결과 이상해 ㅠ
				- 
				
				
				
			
		 */
		//int num = 10;
		//System.out.println(num); //빨간 줄은 다 컴파일 에러
		
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		
//		System.out.print("숫자: ");
//		String input = reader.readLine();
//		int num = Integer.parseInt(input);
//		
//		System.out.println(100 / num);
//		
		int a = 10;
		
		int b = 5;
		
		System.out.println(a - b);
		
		
		
		
		
	}

}
