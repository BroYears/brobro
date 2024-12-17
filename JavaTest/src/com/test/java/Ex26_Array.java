package com.test.java;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

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
		//m9();
		//m11();
		//m12();
		//m13();
		//m14();
		//m15();
		//m16();
		//m17();
		//m18();
		//m19();
		//m20();
		m21();
	
		
		
		
	}

	private static void m21() {

		int[][] nums = new int [5][5];
		
		//입력
		int num =1;
		
		for (int i=0; i<nums.length; i++) {
			for (int j=0; j<nums[i].length; j++) {
				nums[i][j] = num;
				num++;
			}
		}
		//출력 > 항상동일하게
		printArray(nums);
		
		
	}

	private static void m20() {
		//배열의 길이는 불변
		//1. 배열의 길이는 런타임 시에 (동적으로) 결정 할 수 있다.
		//2. 같음 참조 변수를 계속 사용해서 배열의 길이가 변하 것 처럼 꾸밀 수 있다.
		
		
		
		
		
		
		
		//int[] kor = new int[300];
		/*
		 * case1.
		 * 
		Scanner scan = new Scanner(System.in);
		System.out.print("학생 수: ");
		int length = scan.nextInt();
		
		int[] kor = new int[length]; //컴파일 시 길이? 런타임 시 길이!!
		
		System.out.println(kor.length);
		System.out.println(Arrays.toString(kor));
		*/
		
		//case 2.
		int[] kor = new int[5];
		System.out.println(kor.length); //5
		
		
		kor = new int[10];
		System.out.println(kor.length); //10
		
		//새로운 배열이 생김 -> 기존 주소값에 덮어 씌움 -> 기존 참조가 끊김 -> heap에 저장된 기존 데이터 garbage 됨 
		
		
		
		
		
	}

	private static void m19() {
		
		//배열 초기화 리스트
		
		int[] nums1 = { 10, 20, 30 };
		
		int[][] nums2 = 
			{ 
				{ 10, 20, 30 },
				{ 40, 50, 60 }
			};
		
		int[][][] nums3 = 
			{ 
				{
					{ 10, 20, 30 },
					{ 40, 50, 60 }
				
				},
				{
					{ 70, 80, 90 },
					{ 100, 110, 120 }
				}
			};
		
	}

	private static void m18() {
		
		
		//배열의 차원
		//- 1차원 배열, 2차원 배열, 3차원 배열...
		//
		
		//1차원 배열
		int[] nums1 = new int[3];
		nums1[0] = 10;
		nums1[1] = 20;
		nums1[2] = 30;
		
		System.out.println(Arrays.toString(nums1));
		
		
		//2차원 배열
		int[][] nums2 = new int[2][3];//2행 3열
		
		//질문 (자료형)
		//1. nums2 			> int[][] 배열 입니다.
		//2. nums2[0][0]	> int 입니다
		//3. nums2[0]		> int[] 입니다.
		
		
		System.out.println("nums2.length: " + nums2.length);
		System.out.println("nums2[0].length: " + nums2[0].length);//안에 몇 칸 있나 보고왔어용
		System.out.println("nums2[1].length: " + nums2[1].length);
		
				
		nums2[0][0] = 10;
		nums2[0][1] = 20;
		nums2[0][2] = 30;

		
		nums2[1][0] = 40;
		nums2[1][1] = 50;
		nums2[1][2] = 60;
		
		//System.out.println(Arrays.toString(nums2)); 1차원 배열
		System.out.println(Arrays.deepToString(nums2)); //2차워 배열
		
		//2차원 탐색 > 2중 for문
		for (int i=0; i<nums2.length; i++) {
			for(int j=0; j<nums2[0].length; j++) {
				System.out.printf("%4d", nums2[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		//3차원 배열
		int[][][] nums3 = new int [2][2][3];
		
		nums3[0][0][0] = 10;
		nums3[0][0][1] = 20;
		nums3[0][0][2] = 30;
		
		nums3[0][1][0] = 40;
		nums3[0][1][1] = 50;
		nums3[0][1][2] = 60;
		
		nums3[1][0][0] = 70;
		nums3[1][0][1] = 80;
		nums3[1][0][2] = 90;
		
		nums3[1][1][0] = 100;
		nums3[1][1][1] = 110;
		nums3[1][1][2] = 120;
		
		//3차원 배열 탐색 -> 3중 for문
		
		
		for (int i=0; i<nums3.length; i++) {
			for (int j=0; j<nums3[0].length; j++) {
				for (int k=0; k<nums3[0][0].length; k++) {
					System.out.printf("%5d", nums3[i][j][k]);
				}
				System.out.println();
			}
			System.out.println();
		}
		
		
	}

	private static void m17() {
		int[] nums = new int[10];
		nums[0] = 1;
		nums[1] = 2;
		nums[2] = 3;
		nums[3] = 4;
		nums[4] = 5;
		nums[5] = 6;
		nums[6] = 7;
		nums[7] = 8;
		nums[8] = 9;
		nums[9] = 10;
		
		int index = 1;

		System.out.println(Arrays.toString(nums));
		
		for (int i=index+1; i<nums.length; i++) {
			nums[i-1] = nums[i];//shift
		}
		
		nums[nums.length - 1] = 0;
		System.out.println(Arrays.toString(nums));
		
	}

	private static void m16() {
		
		//배열 조작
		//- 요소 삽입, 
		//- 요소가 움직임
		
		//배열 요소 삽입(Insertion)
		//- Right Shift > 모든 요소가 오른쪽으로 한 칸씩 이동
		//int[] nums = {1, 2, 3, 4, 5}; //1, 9, 2, 3, 4
		int[] nums = new int[10];
		nums[0] = 1;
		nums[1] = 2;
		nums[2] = 3;
		nums[3] = 4;
		nums[4] = 5;
		
		
		int index = 1;
		int value = 9;
		
		System.out.println(Arrays.toString(nums));
		
		for (int i=nums.length-2; i>=index; i--) {
			nums[i+1] = nums[i]; //shift 발생
		}
		
		nums[index] = value;
		
		System.out.println(Arrays.toString(nums)); 
		
		
	}

	private static void m15() {
		// TODO Auto-generated method stub
		int[] nums = {1, 5, 3, 2, 4};
		Arrays.sort(nums); //Quick search 구현
		System.out.println(Arrays.toString(nums));
		
		String[] names = { "홍길동", "아무개", "강아지", "고양이", "병아리"};
		Arrays.sort(names); //Quick search 구현
		System.out.println(Arrays.toString(names));
		
		Calendar[] clist = new Calendar[5];
		
		
		clist[0] = Calendar.getInstance();
		clist[0].add(Calendar.DATE, -7);
		
		clist[1] = Calendar.getInstance();
		clist[1].add(Calendar.DATE, -3);
		
		clist[2] = Calendar.getInstance();
		clist[2].add(Calendar.DATE, -2);		
		
		clist[3] = Calendar.getInstance();
		clist[3].add(Calendar.DATE, -1);
		
		clist[4] = Calendar.getInstance();

		Arrays.sort(clist); //Quick search 구현
		
		for(int i=0; i<clist.length; i++ ) {
			System.out.printf("%tF\n", clist[i]);
		}
		//Arrays.sort() : 오름차순
		//				: 내림차순 x > 직접 구현(
	}

	private static void m14() {
		
		//데이터 비교?
		//1. 숫자 비교
		//2. 문자열 비교
		//3. 날짜 시간 비교
		
		//1.숫자 비교
		int a = 10;
		int b = 5;
		
		System.out.println(a > b);
		
		//2. 문자열 비교
		char c1 = 'A';
		char c2 = 'B';
		
		System.out.println((int)c1 > (int)c2); //int > int
		System.out.println(c1 > c2); //char > char -> 어차피 정수
		
		String s1 = "A"; //65
		String s2 = "B"; //66
		
		//The operator > is undefined for the argument type(s) java.lang.String, java.lang.String
		//- String > String
		
		//(거의) 모든 연산자는 참조형을 피연산자를 가지지 않는다.
		//System.out.println(s1 > s2);
		
		//"A" > 'A'
		//문자열을 찾아가서 0번째 글자를 뽑아서 char로 바꿔주세요.
		c1 = s1.charAt(0); //추출 메서드
		c2 = s2.charAt(0); //"B" > 'B'
		
		System.out.println(c1 > c2);
		
		s1 = "홍길동님";
		s2 = "홍무개";
		
		//System.out.println(s1 > s2);
		
		
		if (compare(s1, s2) > 0) {
			System.out.println((s1 + " >> " + s2));
		} else if (compare(s1, s2) < 0) {
			System.out.println((s1 + " << " + s2));
		} else {
			System.out.println((s1 + " = " + s2));
		}
		
		System.out.println(s1.compareTo(s2)); //1
		
		System.out.println("홍길동".compareTo("아무개"));	//4361
		System.out.println("아무개".compareTo("홍길동"));	//-4361
		System.out.println("홍길동".compareTo("홍길동"));	//0
		
		//3. 날짜시간 비교
		Calendar day1 = Calendar.getInstance();
		Calendar day2 = Calendar.getInstance();
		day2.add(Calendar.DATE, -2);
		
		System.out.printf("day1: %tF\n", day1);
		System.out.printf("day2: %tF\n", day2);
		
		System.out.println(day1.getTimeInMillis() > day2.getTimeInMillis());
		
		System.out.println(day1.compareTo(day2)); //양수, 음수, 0
		
		//문자열 정렬
		//날짜 정렬
		
		String[] names = { "홍길동", "아무개", "강아지", "고양이", "병아리"};
		
		for (int i=0; i<names.length; i++) {
			for (int j=0; j<names.length-1-i; j++) {
				if (names[j].compareTo(names[j+1]) > 0) {
					String temp = names[j];
					names[j] = names[j+1];
					names[j+1] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(names));
		
		
		//날짜 정렬
		Calendar[] clist = new Calendar[5];
		
		
		clist[0] = Calendar.getInstance();
		clist[0].add(Calendar.DATE, -7);
		
		clist[1] = Calendar.getInstance();
		clist[1].add(Calendar.DATE, -3);
		
		clist[2] = Calendar.getInstance();
		clist[2].add(Calendar.DATE, -2);		
		
		clist[3] = Calendar.getInstance();
		clist[3].add(Calendar.DATE, -1);
		
		clist[4] = Calendar.getInstance();
				
		for (int i=0; i<clist.length -1; i++) {
			for(int j=0; j<clist.length -1 -i; j++) {
				if(clist[j].compareTo(clist[j+1]) > 0) {
					
					Calendar temp = clist[j];
					clist[j] = clist[j+1];
					clist[j+1] = temp;
					
					
				}
			}
		
		}
		for(int i=0; i<clist.length; i++ ) {
			System.out.printf("%tF\n", clist[i]);
		}
		
		
	}
	
	public static int compare(String s1, String s2) {
		
		//s1 크다 > 1
		//s2 크다 > -1
		//동일    > 0
		
		//s1 = "홍길동님";
		//s2 = "아무개";
		
		int length = s1.length() > s2.length() ? s2.length() : s1.length();
		
		for (int i=0; i<length; i++) {
						
			if (s1.charAt(i) > s2.charAt(i)) {
				return 1; //값 변환 + 메서드 종료				
			} else if (s1.charAt(i) < s2.charAt(i)) {
				return -1;
			} 
//			else {
//				
//			}
		
		
		}//for
		if(s1.length() > s2.length()) {
			return 1;
		} else if (s1.length() < s2.length()) {
			return -1;
		} else { 
			return 0;
		}
		
	}

	private static void m13() {
		
		//정렬
		//- 크기 비교 후 > 재배치
		
		//1. 오름차순
		// a. 숫자: 작은 수 >> 큰 수
		// b. 문자열: 문자코드값 순서대로
		// c. 날짜시간: 과거 >> 미래

		
		//2. 내림차순
		// a. 숫자: 큰 수 >> 작은 수
		// b. 문자열: 문자코드 값 역순서대로
		// c. 날짜시간: 미래 >> 과거
		
		//- 세 경우 다 숫자
		
		//정렬 구현
		//1. 직접 구현 > 정렬 알고리즘
		//2. JDK 제공 + 사용 >> 0
		//https://rebugs.tistory.com/568
						
		// 버블 정렬 + swap
		
		//swap > 두 공간의 데이터를 서로 교환하는 행동
		int a = 10;
		int b = 5;
		
		int temp; //빈 컵
		
		temp = a;
		a = b;
		b = temp;
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		
		int[] nums = {5, 3, 1, 4, 2};
		
		System.out.println(Arrays.toString(nums));
		
		for(int i=0; i<nums.length - 1; i++) { // -1은 마지막에 결정 돼도 한 번 더 돌게됨.(0, 1, 2, 3)
			for(int j=0; j<nums.length - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {//하나 뒤의 방과 비교 -> 반대로 하고싶으면 부등호 바꾸면 됨
					//System.out.println("i: " + i + ", j: " + j);
					
					temp = nums[j];
					nums[j] = nums [j + 1];
					nums[j+1] = temp;//temp에 옮기는 거, swap
				}
			}
		}
		
		System.out.println(Arrays.toString(nums));
	}

	private static void m12() {
	
			
		//배열 초기화 리스트
		int[] nums1 = new int[5];
		
		
		//규칙을 가지는 값으로 초기화
		for (int i=0; i<nums1.length; i++) {
			nums1[i] =i;
		}
		System.out.println(Arrays.toString(nums1));

		//규칙이 없는 값으로 초기화
		nums1[0] = 5;
		nums1[1] = 3;
		nums1[2] = 4;
		nums1[3] = 1;
		nums1[4] = 2;
		System.out.println(Arrays.toString(nums1));
		
		//int[] nums2 = new int[] {5, 3, 4, 1, 2};
		int[] nums2;
		nums2 = new int[] {5, 3, 4, 1, 2};//둘 다 됨
		System.out.println(Arrays.toString(nums2));
		
		int[] num3 = {5, 3, 4, 1, 2};//제일 많이 씀 - 편함
		//int[] nums3;
		//nums3 = {5, 3, 4, 1, 2};- 이거는 안됨
		System.out.println(Arrays.toString(num3));
		
		
		String[] names1 = new String[3];
		names1[0] = "홍길동";
		names1[1] = "아무개";
		names1[2] = "하하하";
		
		String[] names2 = {"홍길동", "아무개", "하하하"};
		
		System.out.println(Arrays.toString(names1));
		System.out.println(Arrays.toString(names2));
		
		
		
	}

	private static void m11() {
	
		//배열 자동 초기화
		//- 배열의 생성 직후 모든 요소(방) 초기화
		//- 배열 뿐 아니라 모든 참조형의 특징
		
		//초기화 규칙
		//1. 정수 배열 > 0
		//2. 실수 배열 > 0.0
		//3. 문자 배열 > \0(\u0000)
		//4. 논리 배열 > false
		//5. 참조형 배열 > null
		int[] list = new int[5];
		System.out.println(Arrays.toString(list));
		
		double[] list2 =new double[5];
		System.out.println(Arrays.toString(list2));
		
		char[] list3 = new char[5];
		System.out.println(Arrays.toString(list3));

		
		
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
		
//		printArray(nums);
		
		System.out.println(Arrays.toString(nums));//개발자가 중간에 확인 하려고 많이 씀.
												  //dump한다고 말함

		//nums > copy
		//Arrays.copyOfRange(배열이름, 첫방, 마지막방(nums.length)); 방의 범위 복사
		int[] copy = Arrays.copyOfRange(nums, 0, nums.length); //깊은 복사 똑같은 배열을 가지게 됨
		
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(copy));
		
		
	}

	private static void printArray(int[][] nums) {

		for(int i=0; i<nums.length; i++) {
			for (int j=0; j<nums[0].length; j++) {
				System.out.printf("%3d", nums[i][j]);
			}
			System.out.println();
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














