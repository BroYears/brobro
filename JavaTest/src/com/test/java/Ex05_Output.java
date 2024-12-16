package com.test.java;

public class Ex05_Output {
	
	public static void main(String[] args) {
		
		/* 콘솔 입출력, Console Input Output -> IO
			- 기본 입력 장치 : 키보드
			- 기본 출력 장치 : 모니터
		  	
		  	
		  	콘솔 출력
		  	1. System.out.println(값);
		  	
		  	2. System.out.print(값);
		  	
		  	3. System.out.printf(값);
		  	
		  	
		  	콘솔 입력
		  	1. System.in.read(); -> 출력 대응, 나머지는 생산성 위해서 다르게
		  	
		  	2. ButteredReader
		  	
		  	3. Scanner
		  	
		  	
		  	System.out.println(값); -> pruntln으로만 불러도 됨
		  	- System : 클래스
		  	- out : 필드(변수)
		  	- pirntln() : 메서드
		  	- 값 : 인자
		  	
		  	
		  	
		  	*/
		
		//println()
		//- print line
		//- 값을 출력한 뒤 개행하세요.
		
		System.out.println(100);
		System.out.println(200);
		System.out.println(300);
		
		//print()
		//- print
		//- 값을 출력하세요.
		System.out.print(100);
		System.out.print(200);
		System.out.print(300);
		
		System.out.println(); //값 출력 + 엔터
		
		//성적표 출력하기
		String name1 = "홍길동";
		int kor1 = 100;
		int eng1 = 90;
		int math1 = 80;
		
		
		
		String name2 = "아무개";
		int kor2 = 95;
		int eng2 = 98;
		int math2 = 87;
		
		System.out.println("=========================");
		System.out.println("        성적표");
		System.out.println("=========================");
		System.out.println("[이름]\t[국어]\t[영어]\t[수학]");
		System.out.print(name1);
		System.out.print("\t");
		System.out.print(kor1 + "\t");
		System.out.print(eng1 + "\t");
		System.out.print(math1 + "\r\n");
		
		System.out.println(name2 + "\t" + kor2 + "\t" + eng2 + "\t" + math2);
		
		System.out.println();
		System.out.println(100);
		System.out.println(3.14);
		System.out.println("문자열");
		System.out.println('A');
		System.out.println(true);
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.print('값');//-> print는 값 넣어줘야 함
		System.out.println();
		System.out.println();
		//printf()
		//- print format
		//- 형식 문자를 사용해서 출력한다.(***)
		//- 가독성 향상(***)
		
		//요구사항] "안녕하세요. 홍길동님" 문장 출력.
		
		String name = "홍길동";//키보드 입력 가정
		
		System.out.println("안녕하세요. " + name + "님");
		System.out.printf("안녕하세요. %s님\r\n", name); //%는 임의의 변수 -> 뒷 값이 출력 전에 변수값으로 들어감
//		%s: 문자열
//		%d: 정수
//		%f: 실수
//		%b: 불린
//		%n: 줄바꿈
//		%t: 날짜/시간
//		%c: 문자
		
		//요구사항]"안녕하세요. 홍길동님. 안녕히가세요. 홍길동님"문장을 출력하세요.
		
		System.out.println("안녕하세요. " + name + "님. 안녕히가세요. " + name + "님.");
		System.out.printf("안녕하세요. %s님. 안녕히가세요. %s님.", name, name);//->갯수 제대로 맞추기
		
		System.out.println();
		
		System.out.printf("문자열: %s\n", "문자열");
		System.out.printf("정수: %d\n", 100);//%d -> byte, short, int, long
		System.out.printf("실수: %f\n", 3.14);//%f -> float, double
		System.out.printf("문자: %c\n", 'A');
		System.out.printf("논리: %b\n", true);
		System.out.println();
		
		System.out.printf("문자열: %s\n", 100);//%s만 다른 거 넣어도 됨
		
		System.out.printf("정수: %d\n", 3);
		System.out.println();
		
		//형식 문자 확장 기능
		//1. %숫자d, %숫자s, %숫자f, %숫자c, %숫자b
		//- 숫자 : 정수
		//- 출력 할 공간(너비, 칸수)
		//- 탭처럼 열을 맞출 때 사용
		//- (+) : 우측 정렬
		//- (-) : 좌측 정렬
		
		//하드 코딩 - 한 땀 한 땀
		//ctrl + alt + 방향키 아래
		//Alt + 방향키(아래/위)
		//
		
		int num = 123;
		System.out.printf("[%d]\n", num); 
		System.out.printf("[%10d]\n", num); 
		System.out.printf("[%-10d]\n", num);
		System.out.println();
		
		//숫자 변수 생성!!
		//1. 정수
		//- byte, short, int, long
		//- 현실 -> int 대부분 사용 + long
		//- byte, short 거의 사용 x
		
		//2. 실수
		//- float, double
		//- 현실 -> 거의 대부분 double 사용
		
		
		
		//2. %.숫자f
		//- 소수점 이하 자릿수 지정
		//- 반올림 주의
		double num2 = 3.19;
		
		System.out.println(num2);
		System.out.printf("%f\n", num2);
		System.out.printf("%.2f\n", num2);
		System.out.printf("%.1f\n", num2);
		System.out.printf("%.0f\n", num2);
		System.out.println();
		
		//3. %d, %f
		//- 숫자만 가능
		//- 자릿수 표기 지원
		int price = 1234567;
		
		System.out.printf("금액 : %d원\n", price);
		System.out.printf("금액 : %,d원\n", price);//선택이 아니라 필수
		System.out.println();
		
		//1+2+3
		//- 천단위 + 소수이하(2자리) + 출력너비(20자리, 우측정렬)
		double num3 = 1234567.89012345;
		System.out.printf("금액 : %,20.2f원", num3);//, 너비, 소수점자리 순
		System.out.println();
		System.out.println();
		
		//메뉴판 출력
		//***
		System.out.println("=======================");
		System.out.println("      음료 가격");
		System.out.println("=======================");
		System.out.printf("콜라:\t\t%,6d원\n", 2500);
		System.out.printf("사이다:\t\t%,6d원\n", 3500);
		System.out.printf("스무디:\t\t%,6d원\n", 500);
		System.out.printf("아메리카노:\t%,6d원\n", 15000);
		System.out.println();
		
		
		
		
		
		
	} //main


} //Class
