package com.test.java.collection;

import java.util.ArrayList;
import java.util.Random;

public class Ex56_ArrayList {

	public static void main(String[] args) {
		
		/*
		
		
			자바
			- 제어문
			- 배열(+ 컬렉션)
			- 클래스
			
			
			
			
			컬렉션, collection
			- JCF(Java Collection Framework)
			- 개조된 배열, 향상된 배열
			- 개조? 향상?
				1. 성능 향상
				2. 사용법 향ㅅ망
				3. 모든 컬렉션 > 길이 가변 > 배열의 길이가 늘었다 줄었다 가능
				
			컬렉션 종류
			1. List 계열(List 인터페이스)
				- ArrayList(*****)
				- LinkedList
				- Queue
				- Stack
				- vector(거의 안씀 -> ArrayList로 대체 많이 됨)
			
			2. Set 계열(Set 인터페이스)
				- HashSet(***)
				- TreeSet
			
			3. Map 계열(Map 인터페이스)
				- HashMap(*****)
				- TreeMap
				- Properties
				- HshTable(거의 안씀 -> HashMap으로 대체 많이 됨)
				
			ArrayList, HashMap 열심히 공부!!
			
			HashSet도 중요!!
				
			ArrayLsit 클래스
			- 왜 가장 많이 사용? > 순수 배열과 가장 유사
			- 구현한 인터페이스
				- List<E>
				- Collection<E>
				- Iterable<E>
			- Resizable-array implementation of the List interface.(가변 배열)
				
									
		
		 */
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		m6();
		
	}//main

	private static void m6() {
		
		//ArrayList의 길이는 가변이다.
		ArrayList<Integer> list = new ArrayList<Integer>(1000);//방을 1000칸으로 시작
		
//		System.out.println(list.size()); //길이 0
//		
//		list.add(100);	//new Object[4];
//		list.add(200);
//		list.add(300);
//		
//		System.out.println(list.size()); //길이 3
//										 //size는 length랑 다름 -> 빈 방 제외한 방의 갯수를 셈
//		list.add(400);
//		list.add(500);	//new Object[8]; 새로 만듦 <- new Object[4];에 있던 값을 덮어 씀
//						//2배씩 늘림
//		
//		list.trimToSize(); 	//남는 size만큼 trim해라
//							//-> 사용한 size 만큼의 방 갯수만큼 복사하고 거기에 덮어씀
//							//매번 복사해야해서 비용 발생 -> 자주하면 안좋음.
//							//데이터를 추가하게 될 지 예측하기 쉽지않음 -> 자주 안쓰게됨.
//		
//		
//		System.out.println(list.size()); //길이 5
//										 //new O\
		
		for (int i=0; i<1000; i++) {
			//4
			//8
			//16
			//32
			//64
			//128
			//256
			//512
			//1024
			list.add(i);//0칸으로 시작해서 2칸 그리고 2배씩 늘어나는데 이걸 1000개 들어갈 때까지 2배씩 늘려가면서 비용 반복 발생 -> 좋지않은 코드 ->캐퍼시티 사용
		}
		
		System.out.println(list.size()); //1000
		System.out.println(list);
		
		
	}

	private static void m5() {

		//성적표
		//- 성적(번호, 학생명, 국어, 영어, 수학, 총점, 평균)
		//- 성적 x N개(학생 수)
		
		//자료형?
		//- 성적 > 클래스 > Score.java
		//- 성적 x N개 > 배열 vs ArrayList > 길이? > ArrayList
		
		//학생(성적) 명단
		ArrayList<Score> list = new ArrayList<Score>();
		
		Random rnd = new Random();
		
		String[] names = { "홍길동", "아무개", "강아지", "고양이", "말", "병아리" };
		
		
		//학생(성적) 객체 생성 + 값 할당
		for(int i=0; i<names.length; i++) {
			
			//60 ~ 100
			// 0 ~ 	40
			//+ 60
			Score s = new Score(i + 1, names[i]
								, rnd.nextInt(41) + 60
								, rnd.nextInt(41) + 60
								, rnd.nextInt(41) + 60); 
		
			list.add(s); //명단에 추가
			
		}//for
		
		//출력
		System.out.println("======================================================");
		System.out.println("                   성적표");
		System.out.println("======================================================");
		System.out.println("[번호]\t[이름]\t[국어]\t[영어]\t[수학]\t[총점]\t[평균]");
		
		//정렬 기준
		//1. 고정폭 > 왼쪽, 가운데
		//2. 가변폭 > 왼쪽
		//1. 숫자
		// 1.1 수치 > 오른쪽
		// 1.2 식별자 > 왼쪽, 가운데
		
		for (Score s : list) {
			System.out.printf("%d\t%s\t%5d\t%5d\t%5d\t%5d\t%5.1f\n"
								, s.getSeq()
								, s.getName()
								, s.getKor()
								, s.getEng()
								, s.getMath()
								, s.getTotal()
								, s.getAvg()
								);
		}
		
		
		
	}

	private static void m4() {
		
		//배열
		//- int[] nums
		//- String[] txts
		//객체 배열
		//- Student[] list
		//- Random[] list
		//- Calendar[] list
		
		//Cup.java
		
		Cup[] list1 = new Cup[3];
		//Cup c1;
		//Cup c2;
		//Cup c3;
				
		System.out.println(list1[0]);
		
		list1[0] = new Cup("white", 10000);
		list1[1] = new Cup("green", 12000);
		list1[2] = new Cup("yellow", 15000);
		
		for (Cup c : list1) {
			System.out.println(c);
		}
		System.out.println();
		
		
		ArrayList<Cup> list2 = new ArrayList<Cup>();
		
		list2.add(new Cup("white", 10000));
		list2.add(new Cup("green", 12000));
		list2.add(new Cup("yellow", 15000));
		
		System.out.println(list2.size());
		System.out.println(list2);
		
		for (Cup c : list2) {
			System.out.println(c);
		}
		
		
	}

	private static void m3() {

		int[]		ns1 = new int[3];
		int[][]		ns2 = new int[2][3];
		int[][][]	ns3 = new int[2][3][4];
		
		//ns1
		ArrayList<Integer> ms1 = new ArrayList<Integer>();
		ms1.add(100);
		
		//ns2
		ArrayList<ArrayList<Integer>> ms2 
			= new ArrayList<ArrayList<Integer>>();
		
		ms2.add(new ArrayList<Integer>());//
		ms2.add(new ArrayList<Integer>());//바깥쪽 두 번째 방
		
		ms2.get(0).add(100);
		ms2.get(0).add(200);
		
					
		//ns3
		ArrayList<ArrayList<ArrayList<Integer>>> ms3 
			= new ArrayList<ArrayList<ArrayList<Integer>>>();
		
		ms3.add(new ArrayList<ArrayList<Integer>>());
		ms3.get(0).add(new ArrayList<Integer>());
		ms3.get(0).get(0).add(100);
				
		//복잡하니까 걍 쓰지말자
		
	}

	private static void m2() {

		
		//ArrayList 사용법(메서드)
		
		//String[] list
		ArrayList<String> list = new ArrayList<String>();
		
		
		//1. 요소 추가하기
		//- boolean add(T value)
		//- 항상 배열의 맨 끝에 추가 > Append Mode
		//- 배열 방 번호 생각 안해도 돼서 편함
		list.add("사과");
		list.add("귤");
		list.add("바나나");
		list.add("포도");
		list.add("파인애플");
		list.add("키위");
		
		//2. 요소 개수
		//list.size();
		System.out.println(list.size());
		
		//3. 요소 읽기
		//- T get(int index)
		System.out.println(list.get(0));
		System.out.println(list.get(2));
		System.out.println(list.get(list.size() - 1));
		//System.out.println(list.get(5)); - 에러 나는 것까지 똑같음
		
		//ArrayIndexOutOfBoundsException > 배열 첨자 오류
		//StringIndexOutOfBoundsException > 문자열 첨자 오류
		//IndexOutOfBoundsException > 컬렉션 첨자 오류
		
		//4. 요소 수정하기
		//- T set(int index, T newValue)
		
		//list[2] = "키위"; - 배열일 떄
		//list.수정(index, "키위");
		
		String temp = list.set(2, "키위");
		
		System.out.println(temp);//바나나(이전 값)을 넘겨줌
		System.out.println(list.get(2));//키위(바뀐 값)
		
		//5.요소(방) 삭제하기
		//- 방 없애기 > 배열의 길이 줄이기
		//- T remove(int index) > 방번호를 찾아서 삭제
		//- boolean remove(T value) > 값을 찾아서 삭제
		//- 시프트 발생 > 삭제된 방 이후로 모든 요소의 방번호 - 1
		
		System.out.println(list.size());
		System.out.println(list.get(1));
		//list.remove(2);//방빠지면 시프트 발생 -> 시프트 항상 주의 
		list.remove("키위");//그래도 방 번호를 더 많이 씀 -> 여러개면 첫 번째 놈만 지움
		System.out.println(list.size());
		System.out.println(list.get(1));
		
		
		//6. 요소 추가하기
		//- 원하는 위치에 삽입하기
		//- Insert Mode > 새치기
		//- void add(int index, T value)
		//- 시프트 발생 > 삽입된 방 이후의 모든 요소는 방번호 + 1
		System.out.println();
		
		System.out.println(list.get(0));
		list.add(0, "딸기");
		System.out.println(list.get(1));
		System.out.println();
		
		//7. 요소 검색
		//- int indexOf(T value)
		//- int lastIndexOf(T value)
		//- boolean contains(T value)
		
		System.out.println(list.indexOf("귤"));//2
		System.out.println(list.indexOf("망고"));//-1
		System.out.println();
		
		//8. 탐색
		for (int i=0; i<list.size(); i++) {
			System.out.println(i + ":" + list.get(i));
		}
		System.out.println();
		
		//for문
		//- 일반 for문
		//- 향상된 for문
		for (String item : list) {//바로 배열에가서 첫 번째 방에있는 것을 복사해서 item에 덮어버림 이걸 반복 그리고 방이 더 없으면 나옴 but 이거밖에 못함
			System.out.println(item);
		}
		System.out.println();
		
		//덤프 > Arrays.toString()
		//컬렉션들은 모두 override 돼 있음.
		System.out.println(list);
		System.out.println(list.toString());
		
		
		//9. 초기화
		//- 모든 요소 삭제 > 모든방.remove()
		//- void clear()
		
		list.clear();
		
		System.out.println(list);
		System.out.println(list.size());
		
		
		//10. 빈배열 확인
		//- boolean isEmpty()
		//- is로 시작하면 반환값 boolean
		
		System.out.println(list.isEmpty());
		System.out.println(list.size() == 0);//둘이 같음
		
				
		
		
	}

	private static void m1() {
		
		//배열
		//- 타입 명시 > 요소의 타입 > int
		//- 길이 명시 > 요소의 개수 > 3
		int[] nums1 = new int[3];
		
		//요소 접근 > 배열의 첨자(index) 사용
		nums1[0] = 100; //배열명[index] <- 표기법(인덱서(Indexer))
		nums1[1] = 200;
		nums1[2] = 300;
		
		System.out.println(nums1[0]);
		System.out.println(nums1[1]);
		System.out.println(nums1[2]);
		System.out.println(nums1.length);
		System.out.println();
		
				
		//컬렉션
		//- 타입 명시(X) > Object 배열 + 제네릭 -> 타입 내 맘대로 -> 넣으면 못바꿈
		//- 길이 명시(X) > 사이즈 변경 가능
		//ArrayList nums2 = new ArrayList();
		//ArrayList is a raw type. References to generic type ArrayList<E> should be parameterized
		
		//ArrayList nums2 = new ArrayList();
		ArrayList<Integer> nums2 = new ArrayList<Integer>();
		
		//요소 접근
		//nums2[0] = 100;//ArrayList -> 짭배열이라 안됨
		nums2.add(100); //nums2[0] = 100;
		nums2.add(200); //nums2[1] = 200;
		nums2.add(300); //nums2[2] = 300;
		
		System.out.println(nums2.get(0)); //nums2[0];
		System.out.println(nums2.get(1)); //nums2[1];
		System.out.println(nums2.get(2)); //nums2[2];
		
		System.out.println(nums2.size()); //length > size()
		
		nums2.add(400);
		nums2.add(500);
		
		System.out.println(nums2.size());
		System.out.println();
		
		for (int i=0; i<nums2.size(); i++) {
			System.out.println(nums2.get(i));
		}
		
	}
	
}//class

























