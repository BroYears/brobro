package com.test.java.collection;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex65_LinkedList {

	public static void main(String[] args) {
		
		/*
		  
		 	Collection(I)	- List(I)
		 					- set(I)
		 	
		 	map(I)
		 	
		 	
		 	Collection(I) > List(I)  > LinkedList(c)
		 	- ArrayList
		 	- stack
		 	- Queue
		 	
		  	ArrayList vs LinkedList
		 	- 메서드 구성 유사 > 같은 인터페이스 > 사용법이 거의 유사
		 	- 추가 학습 비용 감소
		 	- 내부 구조가 다름 -> 사용 용도가 다름(***)
		 	- ArrayList가 가장 빠름
		 		- list[2501] -> 주소 값 + 4*2501 이런 식, 직관적으로 찾아감 
		 		- 삽입 위치(삭제 포함)에 따라 비용이 다르고 높음
		 	- LinkedList는 방마다 매번 링크되는 주소의 값을 따라가야 됨(비용 발생)
		 		- 그 전 방이랑 그 다음 방의 링크되는 주소를 변경해서 순서를 바꿔서 순서 맘대로 변경 가능
		 		- 삽입 위치(삭제포함)랑 상관 없이 비용이 비슷
		 	
		 	
		 	읽기만 주로 할 때 -> ArrayList -> 기본적으로 많이 사용
		 	조작, 수정, 삭제 등 변경이 있을 때 -> LinkedList 고려
		 	 	
		 	
		 	LinkedList 종류
		 	1. LinekedList
			2. Double LinkedList
				-이전 방의 주소를 기억
			3. Double Circular LinkedList
				- 꼬리의 꼬리를 무는 주소 기억 > 순환구조
				- 자바의 LinkedList
			
			
			
		 */
		
		//m1();
		m2();
		
	}//main

	private static void m2() {
		
		//ArrayList vs LinkedList 속도 비교
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		
		long begin = 0, 
			 end = 0;
		
		//1. 순차적으로 데이터 추가하기, Append
		System.out.println("[1.순차적으로 데이터 추가하기, Append]");
		
		begin = System.currentTimeMillis();
		
		for (int i=0; i<1000000; i++) {
			list1.add(i);
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("ArrayList 작업 시간: %,dms\r\n"
							, end - begin);
		
		
		
		
		begin = System.currentTimeMillis();
		
		for (int i=0; i<1000000; i++) {
			list2.add(i);
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("LinkedList 작업 시간: %,dms\r\n"
							, end - begin);
		
		//2. 중간에 데이터 추가하기, Insert
		//- Right Shift 발생
		System.out.println("[2.중간에 데이터 추가하기, Insert]");
		
		begin = System.currentTimeMillis();
		
		for (int i=0; i<100000; i++) {
			list1.add(0, i);
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("ArrayList 작업 시간: %,dms\r\n"
							, end - begin);
		
		
		
		
		begin = System.currentTimeMillis();
		
		for (int i=0; i<100000; i++) {
			list2.add(0, i);
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("LinkedList 작업 시간: %,dms\r\n"
							, end - begin);
		
		
		//3. 중간에 있는 데이터 삭제하기, Delete
		//- Left Shift 발생
		System.out.println("[3.중간에 데이터 삭제하기, Delete]");
		
		begin = System.currentTimeMillis();
		
		for (int i=0; i<100000; i++) {
			list1.remove(0);
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("ArrayList 작업 시간: %,dms\r\n"
							, end - begin);
		
		
		
		
		begin = System.currentTimeMillis();
		
		for (int i=0; i<100000; i++) {
			list2.remove(0);
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("LinkedList 작업 시간: %,dms\r\n"
							, end - begin);
		
		//4. 순차적으로 데이터 삭제하기, Delete
		//- Shift 발생 X
		System.out.println("[4.순차적으로 데이터 삭제하기, Delete]");
		
		begin = System.currentTimeMillis();
		
		for (int i=list1.size()-1; i>=0; i--) {
			list1.remove(i);
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("ArrayList 작업 시간: %,dms\r\n"
							, end - begin);
		
		
		
		
		begin = System.currentTimeMillis();
		
		for (int i=list2.size() -1; i>=0; i--) {
			list2.remove(i);
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("LinkedList 작업 시간: %,dms\r\n"
							, end - begin);
		
		
		
	}

	private static void m1() {
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		
		list1.add(100);
		list1.add(200);
		list1.add(300);
		
		
		list2.add(100);
		list2.add(200);
		list2.add(300);
		
		System.out.println(list1.size());
		System.out.println(list2.size());
		
		System.out.println(list1.get(0));
		System.out.println(list2.get(0));
		
//		list1.iterator();
//		list2.iterator();
		
		for (int n : list1) {
			System.out.println(n);
		}
		
		for (int n : list2) {
			System.out.println(n);
		}
		
		
		System.out.println(list1);
		System.out.println(list2);
		
		
	}
	
	
	
	
}//class
