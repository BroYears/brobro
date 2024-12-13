package com.test.java;

public class Ex26_Array {

	public static void main(String[] args) {
	
		/*
			- 자료구조 > 데이터 저장하는 물리적인 구조 ex)집합
		 
			배열, Array
			
			- 데이터 집합 > 변수를 모아놓은 집합
			- 같은 자료형을 저장하는 데이터의 집합
			
			
		
		 */
		
		//m1();
		m2();
		
		
	}

	private static void m2() {
		
		//요구사항] 학생 3명 > 국어 점수 > 총점, 평균
		//추가사항] 학생 수 증가 > 300명
		
		//배열 선언하기
		//- 자료형[] 변수명 = new 자료형[길이];
		//- 배열타입 배열명 = new 배열타입[배열의 길이];
		int[] kors = new int[3];
		
		//kors = 점수;
		
		kors[0] = 100;
		kors[1] = 90;
		kors[2] = 80;
		
		int index = 0;
		kors[0] = 100;
		kors[index] = 100;
		
		//int total = kors[0] + kors[1] + kors[2]; // ... + kor300
		int total = 0;
		
		System.out.println(kors.length);
		
		for (int i=0; i<kors.length; i++) {
			total += kors[i];
		}
			
		
		double avg = (double)total / kors.length;//3.0 > 300.0
		
		System.out.printf("총점: %d점, 평균: %.1f점\n", total, avg);	
		
		
	}

	private static void m1() {
		
		//요구사항] 학생 3명 > 국어 점수 > 총점, 평균
		//추가사항] 학생 수 증가 > 300명
		
		int kor1;
		int kor2;
		int kor3;
		//+297 추가 선언
		
		kor1 = 100;
		kor2 = 90;
		kor3 = 80;
		//+297
		
		int total = kor1 + kor2 + kor3; // ... + kor300
		
		double avg = total / 3.0;//3.0 > 300.0
		
		System.out.printf("총점: %d점, 평균: %.1f점\n", total, avg);		
		
	}
	
}














