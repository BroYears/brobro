package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import
//- 미리 만들어져있는 기능을 가져옴
//- 가져올 패키지 이름 확인
//import 패키지.클래스;
//import java.io.bufferedReader;
//import java.io.InputStreamReader;

//import java.io.*; // 모든 클래스





public class Ex07_BufferedReader {
	
	public static void main(String[] args) throws IOException {
		
		//요구사항] 사용자로부터 문자 1 개입력 -> 출력
		//메서드 -> 클래스 -> 패키지 -> 압축파일.jar
		//Ctrl + shift + O
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		
		//reader -> 입력기(도구)
		
		//System.out.print("입력 : ");
		
		//System.in.read()
		//read 들어가면 무조건 빨간줄 add
		//유니코드 읽을 수 있음(한글 등)
		//int code = reader.read();
		
		//A(65) ~ Z(90)***
		//a(97) ~ z(122)***
		//0(48) ~ 9(57)***
		//\r(13)
		//\n(10)
		//스페이스(32)
		//탭(9)
		//가(44032) ~ 힣(55203)
		
		
		//한글 - 완성형 vs 조합형
		//- 완성형 : 문자 1개 -> 1개의 그림
		//- 조합형 : 자음, 모음 -> 문자 1개
		
		//System.out.println(code);
		//System.out.printf("%c\n", code);
		
		//이름 입력
		int code = -1;//-1??????? -> 문자코드 값은 0부터 시작
		//유효하지 않은 값으로 초기화 -> 잘못된 일 방지(방어기재)
		
//		System.out.print("이름 입력 : ");
//		
//		code = reader.read();
//		System.out.printf("%c", code);
//		code = reader.read();
//		System.out.printf("%c", code);
//		code = reader.read();
//		System.out.printf("%c", code);
//		
		
		//int code = reader.read();//read에 커서대면 받는 값 자료형 나옴
		
		//사용자 -> 이름, 나이 입력
		//			"홍길동"님의 나이는 20살입니다.
		
		
//		System.out.print("이름 입력 : ");
//		String name = reader.readLine();//문자열을 돌려줌
//		
//		//System.out.println(name);
//		
//		System.out.print("나이 입력 : ");
//		String age = reader.readLine();
//		
//		System.out.printf("'%s'님의 나이는 %s살입니다.", name, age);
		
		//요구사항 숫자 2개를 입력받아 두 수를 합하시오.
		
		System.out.print("첫번째 숫자 : ");
		String input1 = reader.readLine();
		
		System.out.print("두번째 숫자 : ");
		String input2 = reader.readLine();
		
		System.out.println(input1 + input2); //"5" + "3" 유니코드 더해버림
		//reader.readline() 문자열 -> (변환) -> 숫자
		
		//Wrapper Class, Util Class
		//- Integer : Integer.parseInt
		//- Byte : Byte.parseByte
		//- Short : Short.parseShort
		//- Long : Long.parseLong
		//- Float : Float.parseFloat
		//- Double : Double.parseDouble
		//- Boolean : Boolean.parseBoolean("문자열")
		//- Character : x
		
//		System.out.println(Integer.MAX_VALUE);
		
		//문자열 -> 변환 -> 기본자료형
		//"100" -> 100(?)
		//int result = Integer.parseInt("100");
		
//		int num1 = Integer.parseInt(input1);		
//		int num2 = Integer.parseInt(input2);
//		
//		System.out.println(num1 + num2);
		
		double num1 = Double.parseDouble(input1); //"3.5 -> 3.5
		double num2 = Double.parseDouble(input2);
		
		System.out.println(num1 + num2);
		
		//BufferedReader
		//1. reader.read() -> 문자 1개 입력 -> 문자코드 반환
		//2. reader.readLine() -> 문자 N개 입력 -> 문자열 반환
		
		
		
		
		
	}

}
