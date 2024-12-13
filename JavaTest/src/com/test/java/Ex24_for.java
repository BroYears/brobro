package com.test.java;

public class Ex24_for {

	public static void main(String[] args) {
	
		/*
			단일 for문
			
			
			for () {
			
			}
			
			중첩된 for문
			
			
			for () {
				for () {
					
				
				}
			}
			
			
			for () {
				for () {
					for () {
					
					}
				}
			}
			
		
		
		 */
		
		//m1();
		//m2();
		//m3();
		m4();
		
	}

	private static void m4() {
		
		
		//문제 > 별찍기(5x5
		
		for (int i=0; i<5; i++) {//여러 줄 반복	> 행
			for (int j=0; j<=i; j++) {//한 줄 반복	> 열
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		
		
	}

	private static void m3() {
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				
				//break or continue
				//if (j == 5) {
				if (i == 5 || j == 5) {
					break;	//밖으로
					//continue; 	//머리로
				}
				
				
				System.out.printf("i: %d, j: %d\n", i, j);
			}
		}
	}
	
	private static void m2() {
		
		//구구단
		//- 2단 ~ 9단
		
		/*
		 
		 	2 x 1 = 2
		 	2 x 2 = 4
		 	...
		 	2 x 9 = 18
		 	
		 	3...
		 	
		 	4...
		
			...
		
			9...
		 */
		
//		int dan = 2;
//		
//		for (int i=1; i<9; i++) {//앞 숫자
//				
//			for (int j=1; j<10; j++) {//뒷 숫자
//				System.out.printf("%d x %d = %d\n", dan, j, dan * j);
//			}//구구단
//			
//			dan++;
//			
//		}
		
		
		
		for (int i=2; i<10; i++) {//앞 숫자
			
			System.out.println("=========");
			System.out.printf("  %d단\n", i);
			System.out.println("=========");
			
			for (int j=1; j<10; j++) {//뒷 숫자
				System.out.printf("%d x %d = %d\n", i, j, i * j);
			}//구구단
		}
		
		
	}

	private static void m1() {
		
		//단일 for 문
		for (int i=0; i<10; i++) {
			System.out.println("i: " + i);
			
		}
		System.out.println();
		
		//2중 for문
		for (int i=0; i<10; i++) {//대회전
			for (int j=0; j<10; j++) {//소회전
				System.out.printf("i: %d, j: %d\n", i, j);
			}//회전 100번
		}
		
		//3중 for문 > 시계(시침, 분침, 초침)
		for (int i=0; i<24; i++) {//대회전 > 시침
			for (int j=0; j<60; j++) {//중회전 > 분침
				for (int k=0; k<60; k++) {//소회전 > 초침
					System.out.printf("i: %d, j: %d, k: %d\n", i, j, k);
				}
			}//버퍼 부족하면 콘솔 앞 부분 지움
		}
		System.out.println();
		
		/*
		
			중학교
			for (학년) {
				for (반) {
					for (번호) {
					
					}
				}
				
			}
			
			아파트
			for (단지 {
				for (동) {
					for (층) {
						for(호) {
					
						}
					}
				}
			}
		
			보통 2~3중 for문까지 사용
			- 주변 데이터가 3중넘는 중첩 별로 없음
		
		 */
		
		
		
	}
	
	
	
}
