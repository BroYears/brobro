package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex13_Operator {

	public static void main(String[] args) throws IOException {
				
		//요구사항] 사용자로부터 문자 1 개입력 > 영어 소문자인지 아닌지 검사?
		
		//시나리오] 제어 흐름 설계
		//1. BufferedReader 생성
		//2. 안내 메시지 출력(Label)
		//3. 입력 > 문자 1개 얻음
		//4. 유효성 검사(Validation)
		//	4.1 문자 > 문자 코드
		//	4.2 소문자 범위에 속하는지?
		//	4.3 결과 도출
		//5. 결과 출력
		
		//1.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//2.
		System.out.print("문자 입력 : ");
		
		//3.
		// - reader.read() -> int
		// - reader.readLine() -> String, N문자. (int)String. (int)String.charAt(0)
		int code = reader.read();
		
		//4.
		String result = (code >= 97 && code <= 122) ? "소문자입니다." : "소문자가 아닙니다.";
		
		
		//5.
		System.out.printf("입력하신 문자 '%c'는 %s\n", code, result);
		
		
		
		
	}
	
}
