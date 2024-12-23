package com.test.java.collection;

import java.util.ArrayList;

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
		m2();
		
		
	}//main

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

























