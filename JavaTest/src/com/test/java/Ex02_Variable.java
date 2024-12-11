package com.test.java;

public class Ex02_Variable {

	public static void main(String[] args) {
		
		//주석 = 컴파일 작업에서 제외
		//단일 라인 주석, Comment
//		-Ctrl + / (범위 설정하고 가능)
		
		
		/*
		다중 라인 주석, Comment
		Ctrl + shift + /
		Ctrl + shift + \ - 주석 취소
		 */
		
//		주석임다
		//성적 처리 프로그램
		//- 학생 1명의 국어 점수
		
		//국어 점수
		//- 형태 > 90, 85.5 > 정수
		//- 길이 > 0~100 > byte
		
		//변수 <-> 상수
		//- 변수 : 표현은 일정, 의미는 변화
		//- 상수 : System.out.println(100);//정수형 리터럴
		//			데이터(값) = 리터럴(Literal)
		
		//변수 선언
		byte 국어점수;
		
		//변수 초기화 - 초기값 대입
		// = 대입 연산자
			국어점수 = 100;
			
		//변수 사용, 호출
		System.out.println(국어점수);
		
		//변수 치환
		//- 덮어쓰기 -> 수정
			국어점수 = 90;
		
		System.out.println(국어점수);
		
		System.out.println(100);
		
		//영어 점수
		//대부분 프로그래밍 한글식별자 사용 x
		byte eng;
			
			eng = 100;
		
		System.out.println(eng);
		
		byte kor;
		byte kor1;
		byte KOR;
		byte kor_1;
		
		//byte 1kor; - x
		byte _1kor;
		
		//byte byte; - x
		
		//수학점수
		byte math;
		byte Math;
		byte mAth;
		byte maTh;
		byte matH;
		//- 가독성 떨어짐 사용 x
		
		//Duplicate local variable kor
		//에러메세지 필독
//		byte kor;
		
		byte korScore;
		
//		byte a; - x
		
		//변수 선언 방식
		byte b1; //변수 선언 -> 비어있는 상태 -> null(널)
				 //- 사실은 가비지 있음
			b1 = 100;//초기화
			
		byte b2 = 100; //선언 + 초기화
		
		byte b3;
		byte b4;
		
		byte b5, b6;
		
		byte b7 = 100, b8 = 50, b9 = 110;
		
		byte b10 = 100, b11, b12;
		
		
		//지도 좌표(x, y)
		byte x1; //우리집 x좌표
		byte y1; //우리집 y좌표
		
		byte x2, y2;//친구집 x좌표, 친구집 y좌표
		
		byte x3, //마트 x좌표 
			 y3; //마트 y좌표
		
		//학교 x좌표
		byte x4;
		//학교 y좌표
		byte y4;
		
		byte width;
		
			width = 100;
			System.out.println(width);
		//The local variable width may not have been initialized
		//변수 반드시 초기화해야 사용 가능(***)
			
			
		//식별자 명명 규칙, Naming Convention
		//- 변수, 메서드, 클래스, 파일명, 폴더명 등등 대부분의 식별자 만들 때 권장 규칙
		
		//나이 변수
		byte byteAge; //무슨 변수인지 그대로 적음 -> 헝가리언 표기법
		
//		byteAge = 나이;
		
//		byte age;
//		
//		age = 19;//보여줘서 헝가리언 잘 안씀
//		
		
		//byte Age;
		byte StudentAge;//가독성을 위해 첫 문자 대문자 -> 파스칼 표기법(클래스 이름 등등)
		
		byte studentAge;//첫 단어 빼고, 나머지 단어의 문자 첫 문자는 대문자 -> 카멜 표기법(변수, 메서드 명)
		
		//english_score;스네이크 표기법 -> 자바에서는 정형화 x
		//english-score; 케밥 표기법 -> 자바에서는 사용불가
		
		//수학 계산 -> 원주율(PI)
//		double pi = 3.14;
//		
//			pi = 3.54;//누군가 실수로 바꿈
//		
//		System.out.println(pi * 2);
		
		
		//final 변수 = 상수
//		final double pi = 3.14;
//		
//			pi = 3.54;
//			
//		System.out.println(pi * 2);
		
		//상수는 무조건 대문자
		final double PI = 3.14;
		
		System.out.println(PI * 2);
		
		
		//byte HEIGHT;//이래도 상수로 생각해서 안건드림
		
		byte height = 100;
		
			height = 120;
			
		
		
		
	}
}
