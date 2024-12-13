package com.test.java;

import java.util.Arrays;
import java.util.Calendar;

public class Ex26_Array {

	public static void main(String[] args) {
	
		/*
			- 자료구조 > 데이터 저장하는 물리적인 구조 ex)집합
		 
			배열, Array
			
			- 데이터 집합 > 변수를 모아놓은 집합
			- 같은 자료형을 저장하는 데이터의 집합
			- 배열은 생성 후 초기화 하지않아도 자동으로 초기화
			- 개발이 끝났을 때 수정 빡셈 -> 적정선에서 몇 프로 이상 하는 경우가 많음
			- 번호로 바로 가는게 아니라 번지 수 계산해서 찾음
			
			
		 */
		
		//m1();
		//m2();
//		m3();
		//m4();
//		m5();
		//m6();
//		m7();
//		m8();
		m9();
		
	}

	private static void m9() {
		
		//Arrays 클래스
		//- 유틸리티 클래스
		//- 배열과 관련된 여러가지 기능을 제공하는 클래스
		
		int[] nums = new int[3];
		
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		
		
		//자료형 @ 해시코드(메모리 주소값) -> 무쓸모
		//[I @ 1f32e575 - @는 구분자 
		System.out.println(nums); 
		
		printArray(nums);
		
		System.out.println(Arrays.toString(nums));//개발자가 중간에 확인 하려고 많이 씀.
												  //dump한다고 말함

		//nums > copy
		//Arrays.copyOfRange(배열이름, 첫방, 마지막방(nums.length)); 방의 범위 복사
		int[] copy = Arrays.copyOfRange(nums, 0, nums.length); //깊은 복사 똑같은 배열을 가지게 됨
		
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(copy));
		
		
	}

	private static void printArray(int[] nums) {

		for(int i=0; i<nums.length; i++) {
			System.out.printf("nums[&d] = %d\n", i, nums[i]);
		}
		
	}

	private static void m8() {
		
		//배열 복사
		//1. 얕은 복사, Shallow Copy
		//	- 참조 변수끼리의 복사
		//	- 주소값 복사
		//	- 원본 수정 > 복사본 수정: SideEffect 발생
		//	- 기본 동작
		
		//2. 깊은 복사, Deep Copy
		//	- 실제 배열을 복사
		//	- 원본 수정 > 복사본 영향 없음: SideEffect 발생 안함
		//	- 필요 할 때 직접 구현~
		
		int[] nums = new int[3];
		
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		
//		int[] copy;
//		copy = nums;
		
		int[] copy = new int[3];
		
		//int = int > 기본형 복사
//		copy[0] = nums[0];
//		copy[1] = nums[1];
//		copy[2] = nums[2];
		
		for (int i=0; i<nums.length; i++) {
			copy[i] = nums[i];
		}
		
		
		nums[0] = 1000;
		
		System.out.println(copy[0]);
	}

	private static void m7() {
		
		int a = 10; //원본(기본형)
		changeValue(a);
		System.out.println(a); //10 변화, x : SideEffect 발생 x
		
		int[] nums = new int[3]; //원본(참조형)
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		
		changeValue(nums);
	
		System.out.println(nums[0]);//1000, 변화 o : SideEffect 발생
		
	}

	private static void changeValue(int[] nums) {
		
		nums[0] = 1000;
		System.out.println(nums[0]);//1000
		
	}

	private static void changeValue(int a) {
		
		a = 20;
		System.out.println(a);//20
		
	}

	private static void m6() {
		
		//배열 복사(= 모든 참조형의 복사)
		
		int a = 10;
		int b;
		
		b = a; //기본형 복사
		
		a = 20;//원본 수정
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);//기본형에서만 이렇게 됨
		System.out.println();
		
		int[] nums = new int[3];
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		
		int[] copy;
		
		//int[] = int[] 인티저(Integer) 배열
		copy = nums;
		
		System.out.println(copy[0]);
		System.out.println(copy[1]);
		System.out.println(copy[2]);
		System.out.println();
		
		nums[0] = 100; //원본 수정 -> Heap에 있는 데이터 수정
		System.out.println(nums[0]);
		System.out.println(nums[1]);
		System.out.println(nums[2]);
		System.out.println();
		
		System.out.println(copy[0]);
		System.out.println(copy[1]);
		System.out.println(copy[2]);//참조형은 원본만 수정해도 복사본도 영향이 감.
									//주소를 복사해서 그럼(얕은 복사)
		
	}

	private static void m5() {
		
		//기본형 vs 참조형
		//- 기본형(값형) > 변수에 데이터를 직접 저장
		//- 참조형 > 변수에 데이터 따로, 변수 따로 생성 > 둘을 연결
		
		//여태 수업의 참조형
		//1. 문자열
		//2. 배열

		//기본형 vs 참조형
		//- 기본형(값형) > 변수에 데이터를 직접 저장
		//- 참조형 > 변수에 데이터 따로, 변수 따로 생성 > 둘을 연결
		
		//- 데이터의 크기가 일정함 > 기본형
		//- 변수만 보고 데이터의 길이를 추측 가능 > 기본형
		
		//- 데이터의 크기가 일정하지 않음 > 참조형
		//- 변수만 보고 데이터의 길이를 추측 불가능 > 참조형
		
		
		//- 모든 지역은 Stack에 만들어짐
		int a1 = 10;
		int a2 = 2000000000;//기본형 > 10이나 200000000이나 숫자가 들어가는 공간의 크기는 같음(4byte)
							//- 할당된 수에서 경우의 수를 표시 해준다는 뜻(Stack에 저장)
		
		String s1 = "홍길동";//- 6byte
		String s2 = "동해물과백두산이마르고닳도록";//- 28byte
											//참조형 > 데이터의 길이다 제 각각임
											//Heap에 그대로 저장 Heap의 주소를 Stack에 가져옴(4Byte)
											//말 그대로 참조형으로 데이터 보여줌												
		
		int[] nums1 = new int[3]; //[방의 수, 3개]
		int[] nums2 = new int[10];//[10개]
		
		int n1 = 10;
		int n2 = 20;
		System.out.println(n1 + n2); //30
		
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.DATE, 25);
		//System.out.println(c2 - c1);//참조형은 주소값이 들어가 있음. 
									  //주소값으로 연산 하려고해서 산술연산 안 됨
	
		
		
		
		
	}

	private static void m4() {
		
		//각 자료형 > 배열
		
		//정수 배열(byte, short, int, long)
		long[] list1 = new long[5];
		list1[0] = 10L;
		System.out.println(list1[0]);
		System.out.println(list1[4]);
		
		//실수 배열(flaot, double)
		double[] list2 = new double[5];
		list2[0] =3.14;
		System.out.println(list2[0]);
		System.out.println(list2[4]);
						
		//문자 배열(char) == String - 내부적으로 char랑 배열 똑같음 -> char를 개량한게 String
		char[] list3 = new char[5];
		list3[0] = 'A';
		System.out.println(list1[0]);
		System.out.println(list1[4]);
		
		//논리 배열(boolean)
		boolean[] list4 = new boolean[5];
		list4[0] = true;
		System.out.println(list4[0]);
		System.out.println(list4[4]);
		
		//문자열(참조형) 배열(String)
		String[] list5 = new String[5];
		list5[0] = "홍길동";
		System.out.println(list5[0]);
		System.out.println(list5[4]);
		
//		Calendar c1 = Calendar.getInstance();
//		Calendar c2 = Calendar.getInstance();
//		Calendar c3 = Calendar.getInstance();//배열에는 삽입이 안됨 즉 아래 배열이랑 따로 임 c1 != cs[0]
		
		Calendar c1;
		Calendar c2;
		Calendar c3;
		
//		System.out.printf("%tF\n", c1);
		
		Calendar[] cs = new Calendar[3];//
		cs[0] = Calendar.getInstance();
		
		
		
		System.out.printf("%tF\n", cs[0]);
		
		int n1;
		int n2;
		int n3;
		
		int[] ns = new int[3];
		
		
		
		
	}

	private static void m3() {
		
		//배열 > 생성 직후의 상태
		// - 배열은 생성 후 초기화 하지않아도 자동으로 초기화
		int[] nums = new int[5];
		
		nums[0] = 10;
		nums[1] = 20;
		
		System.out.println(nums[0]);	//10
		System.out.println(nums[1]);	//20
		System.out.println(nums[2]);	//0
		System.out.println(nums[3]);	//0
		System.out.println(nums[4]);	//0 -> 입력 안하면 자바가 0으로 넣음(모든 참조형)
		
		
		//배열의 길이 == 배열의 내의 방 개수
		
		//배열의 길이 = 5
		//첨자의 범위 = 0 ~ 4
		//첨자의 범위 = 0 ~ 배열의 길이 - 1
		
		System.out.println(nums.length);
		
		//ArrayIndexOutOfBoundsException
		//- 없는 방번호(0~4) -> 무조건 에러
		//System.out.println(nums[5]); 
		
		//배열 탐색 -> for문 사용
		for (int i=0; i<nums.length; i++) {
			System.out.printf("nums[%d] = %d\n", i, nums[i]);
		}
		
		
		
		
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














