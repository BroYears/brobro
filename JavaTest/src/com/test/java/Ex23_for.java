package com.test.java;

import java.util.Scanner;

public class Ex23_for {
	
	public static void main(String[] args) {
		
		/*
			
			
			제어문
			- 조건문(if, switch)
			- 반복문
			- 분기문
			
			
			for문 - 가독성 제일 좋고, 쉽게 의도됨
			
			for (초기식; 조건식; 증감식) {
				문장;
			}
			
			
			
			
		 */
		
//		m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		//m8();
		//m9();
		//m10();
		//m11();
		m12();
		
	}

	private static void m12() {
		//Hello Java
		//1. javac.exe Hello.java > Hello.class(바이트, 실행)
		//2. java.exe Hello > 실행
		
		//이클립스 > Ctrl + f11(Run > javac.exe + java.exe)
						
		System.out.println("일이삼\r사오");//사오삼
		
		System.out.println("일이삼사\b\b오");//일이오사
											  //한 칸 하려면
		
	}

	private static void m11() {
		
		
		//난수 만들기
		//-임의의 수
		
		//1. Math 클래스
		//2. Random 클래스
	
		System.out.println(3.14);
		System.out.println(Math.PI);//Math. -> 수학관련 각종 도구
		
		//Returns a double value with a positive sign
		//greaterthan or equal to 0.0 and less than 1.0
		//- 0 ~ 1 사이의 값
		for (int i=0; i<10; i++ ) {
			
			//System.out.println(Math.random()); //난수
			
			//가공
			//- 0.0 > 0.0 > 0 
			//- 0.1 > 1.0 > 1
			//- 0.5 > 5.0 > 5
			//- 0.9 > 9.0 > 9
			//System.out.println((int)(Math.random() * 10));
		
			//주사위(1~6)
			//- 1 ~ 6
			//- 0 ~ 5
			//System.out.println((int)(Math.random() * 5)); //0~4
			//System.out.println((int)(Math.random() * 6) + 1);//0~5 < 1~6
			
			//5~8
			//0~3 + 5 = 5 ~ 8
			System.out.println((int)(Math.random() * 4) + 5);//0~3 -> 5~8
			
			//2, 5, 9, 11
			
			
			
			
		}
	}

	private static void m10() {
		
		// 선생님 > 학생 상담(30명)
		for (int i=1; i<=30; i++) {
			
//			if (i >= 16) {
//				break;
//			}
			
			if (i == 10 || i == 12 || i == 25) {
				continue;
			}
			
			
			
			System.out.println(i + "번 학생 상담 중...");
			
		}
		
	}

	private static void m9() {
		
		//break, continue;
		
		for (int i=1; i<=10; i++) {
			if(i == 5) {
				break;//자신이 탈출, 클릭하면 탈출 하는 범위 알려줌.
					  //if문을 탈출하면 의미가 없어져서 예외적으로 상위 조건문 탈출
			}
			System.out.println(i);
		}
		System.out.println();
		
		
		for (int i=1; i<=10; i++) {
			if(i == 5) {
				continue;//만나면 하던 일을 멈추고 머리로 이동
			}
			System.out.println(i);
		}
		System.out.println();
	
	
	
	
	}

	private static void m8() {
		
		//무한 루프, Infinite Loop
		//1. 사용자 실수
		//2. 의도적 > 회전수 알 수 없
		
//		for (int i=0; i<10; i--) {
//			System.out.println(i);
//		}
		
//		int num = Integer.MIN_VALUE;
//		System.out.println(num);
//		
//		
//		num--;
//		System.out.println(num);
//		
//		for (int i=0; true; i--) {
//			System.out.println("실행문");
//		}
		
//		for (; ;) {//비워두면 무한 루프
//			System.out.println("실행문");
//		}
		
//		for (int i=0;;i++) { //비워두면 무한 루프
//			System.out.println("실행문");
//		}
		
		//회전을 몇 번? > 무한 루프
		//요구사항] 사용자가 입력 모든 숫자의 합?
		//			종료 의사 표현 > 0 입력 
		Scanner scan = new Scanner(System.in);
		
		int sum = 0;
		
		for (;;) {
			
			System.out.print("숫자: ");
			int num = scan.nextInt();
			
			if (num == 0) {
				break;
			}
			
			sum += num;
			
		}
		
		System.out.println(sum);
		
	}

	private static void m7() {
		//요구사항] 구구단 출력
		/*
		  	
		  	5 x 1 = 5
		  	5 x 2 = 10
		  	5 x 3 = 15
		  	5 x 4 = 20
		  	...
		  	5 x 9 = 45
		  	
	
		 */
		
		for (int i=1; i<10; i++) {
			
			int result = i * 5; 
			
			System.out.printf("5 x %d = %2d\n", i, result);	
		}
		System.out.println();
		
		//요구사항] 사용자가 원하는 단을 출력		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("단: ");
		int dan = scan.nextInt();
		
		for (int i=1; i<10; i++) {
			
			int result = i * dan; 
			
			System.out.printf("%d x %d = %2d\n", dan, i, result);		
		}
		
		System.out.println();
		
		
	}

	private static void m6() {
		//요구사항] 사용자가 입력한 임의의숫자 10개의 합을 구하시오
		
		Scanner scan = new Scanner(System.in);
		
		int sum = 0;
		
		for (int i=1; i<=10; i++) {
			
			System.out.print(i + ".숫자: ");
			int num = scan.nextInt();
			
			sum = sum + num;
		}
		
		System.out.println(sum);
	}

	private static void m5() {
		
		
		//요구사항] 1 ~ 사용자가 입력한 숫자까지의 합?
		//숫자: 5
		//1 ~ 5 = 15
		
		int sum = 0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자: ");
		int num = scan.nextInt();
		
		for (int i=1; i<=num; i++) {
			sum = sum + i;
		}
		System.out.println(sum);
	
		
		
		
	}

	private static void m4() {
		
		
		//요구사항] 1~10까지의 합 > 누적 연산
		
		//누적 변수(0으로 초기화)
		int sum = 0;
		
		//sum = 1+ 2 + 3 + 4 + 5 + 6 + 7 + 9 + 10;
		//System.out.println(sum);
		
		for (int i=1; i<=100 ; i++) {
			
			//System.out.println(i);
			sum = sum + i;
			//i(1) -> 1 = 0 + 1
			//i(2) -> 3 = (0 + 1) + 2
			//i(3) -> 6 = (0 + 1 + 2) + 3
			//i(4) -> 3 = (0 + 1 + 2 + 3) + 4
			//i(5) -> 3 = (0 + 1 + 2 + 3 + 4) + 5
			//i(6) -> 3 = (0 + 1 + 2 + 3 + 4 + 5) + 6
			//i(7) -> 3 = (0 + 1 + 2 + 3 + 4 + 5 + 6) + 7
			//i(8) -> 3 = (0 + 1 + 2 + 3 + 4 + 5 + 6 + 7) + 8
			//i(9) -> 3 = (0 + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8) + 9
			//i(10) -> 3 = (0 + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9) + 10
			
		}
		
		System.out.println(sum);
		
		
		
	}

	private static void m3() {
		
		
		//반복문 목적
		//1. 회전수 제어*
		//2. 루프 변수 통제(*********)
		
		//요구사항] 숫자 1~10까지 출력
		
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
		System.out.println(6);
		System.out.println(7);
		System.out.println(8);
		System.out.println(9);
		System.out.println(10);
		System.out.println();
		
		int num = 1;
		
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println();
		
		
		num = 1;
		
		for (int i=0; i<10; i++) {
			System.out.println(num);
			num++;
		}
		System.out.println();
		
		
		//루프 변수 > 수열 얻을 때 많이 사용.
		for (int i=1; i<11; i+=2) {
			System.out.println(i);
		}
		System.out.println();
		
		for (int i=2; i<=10; i+=2) {
			System.out.println(i);
		}
		System.out.println();
	
		for (int i=5; i<=100; i+=5) {
			System.out.println(i);
		}
		System.out.println();
		
		//10. 9. 8. ...
		for (int i=10; i>=1; i--) {
			System.out.println(i);
		}
		System.out.println();
		
		
		
	}

	private static void m2() {
		
		//반복문 > 회전수 제어
		
		//반복문 > Loop
		//i > 루프 변수(지역 변수)
		for (int i=1; i<=5; i++) {
			System.out.println("실행문");
		}
		System.out.println();
		
		for (int i=5; i>=1; i--) {
			System.out.println("실행문2");
		}
		System.out.println();
		
		for (int i=1; i<=21; i+=5) {
			System.out.println("실행문4");
		}//회전 수 조건 맘대로 써라
		System.out.println();
		
		for (int i=0; i<5; i++) {
			System.out.println("실행문5");
		}//이걸 제일 많이 씀, 대부분 초기식 0으로 시작, 조건식 이퀄 잘 안넣음
		System.out.println();
		
		
		
		
		
		
		//System.out.println(i);
		
	}

	private static void m1() {
		
		//요구사항] "안녕하세요." x 500회 출력
		System.out.println("안녕하세요.");
		System.out.println("안녕하세요.");
		System.out.println("안녕하세요.");
		System.out.println("안녕하세요.");
		System.out.println("안녕하세요.");//500번은 너무 많아
		System.out.println();
		
		hello();
		hello();
		hello();
		hello();
		hello();//500번은 너ㅓ무 많아
		System.out.println();
		
		
		//순서
		//1. 초기식 int i = 1;
		//2. i <= 5; 조건식
		//3. 구현부 실행
		//4. i++ 증감식
		//5. i<=5;
		//6. i++
		//...
		//10. i++ -> 6
		//11. i >= false -> 탈출
		
		for (int i=1; i<=500; i++) {
//			System.out.println("안녕하세요.");
			hello();
		}//반복문이라 머리로 돌아감
		
	}

	private static void hello() {
		System.out.println("안녕하세요.");
		}

}









