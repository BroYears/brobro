package com.test.java;

import java.io.IOException;

public class Ex06_Input {
	
	public static void main(String[] args) throws IOException {
		
		/*
		 	콘솔 입력
	  		1. System.in.read(); -> 출력 대응, 나머지는 생산성 위해서 다르게
	  			- 항상 버퍼에 들렀다가 입력
	  			- 한글 처리가 어려움
	  			
	  			
	  		2. ButteredReader
	  	
	  		3. Scanner
			
		
						
		*/
		
		//요구사항] 사용자에게 문자 1개를 입력-> 화면에 출력
		
		
		//Label
		System.out.print("문자 입력 : ");
		
		//Unhandled exception type IOException -> 예외
		
		//사용자로부터 키보드 입력을 받아라!!
		//- 현재 상태 -> 사용자가 키를 입력하기를 대기
		//- 입력 대기 상태(= 블럭)
		int code = System.in.read();//한 번에 한 번씩만 읽을 수 있음 -> 추가구현하면 가능
		//read()1회 호출 당 문자 1개
		
		System.out.println("입력 문자 : " + code); 
		System.out.printf("입력 문자 : %c\n", code);
		
		code = System.in.read();
		
		System.out.println("입력 문자 : " + code); 
		System.out.printf("입력 문자 : %c\n", code);
		
		code = System.in.read();
		
		System.out.println("입력 문자 : " + code); 
		System.out.printf("입력 문자 : %c\n", code);
		
		code = System.in.read();
		
		System.out.println("입력 문자 : " + code); 
		System.out.printf("입력 문자 : %c\n", code);

		code = System.in.read();
		
		System.out.println("입력 문자 : " + code); 
		System.out.printf("입력 문자 : %c\n", code);
		
		System.out.println("프로그램 종료");
		//a이후에 엔터 친 거 \r\n으로 인식
		
		
		
	}//main

}//class
