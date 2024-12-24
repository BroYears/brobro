package com.test.java.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Ex59_HashSet {

	
	public static void main(String[] args) {
		
		
		/*
		  
		  	1.List
		  		- 순서가 있는 집합
		  		- 첨자(방번호)
		  		- 데이터 중복을 허용
		  		- 루프 중심
		  		
		  	2. Map
		  		- 순서가 없는 집합
		  		- 키(방이름)
		  		- 데이터 중복을 허용
		  		- 의미 중심
		  		
		  	3. Set
		  		- 순서가 없는 집합
		  		- 요소의 식별자가 없다. > 방 번호(X), 방 이름(X) > 방을 구분 할 수가 없다.
		  		- 데이터 중복을 허용 X(***) -> 식별자가 없기 때문에
		  		- 중복 방지 중심
		  
		  
		 */
		
		//m1();
		m2();
		
		
		
	}//main

	private static void m2() {
		
		//로또 번호 > 난수 + 유일한 숫자들로만
	
		Random rnd = new Random();
		
		//Case 1.
		ArrayList<Integer> lotto = new ArrayList<Integer>();
		
//		for(int i=0; i<6; i++) {
//			
//			int n = rnd.nextInt(45) + 1;
//			
//			if(checkNumber(lotto, n)) {
//				lotto.add(n);			
//			} else {
//				i--;
//			}
//			
//		}
		
		while(lotto.size() < 6) {
			
			int n = rnd.nextInt(45) + 1;
			
			if(checkNumber(lotto, n)) {
				lotto.add(n);			
			} 			
		}
			
		System.out.println(lotto);
			
		
		//case 2.
		HashSet<Integer> lotto2 = new HashSet<Integer>();//중복된 값 싫으면 set 쓰는게 나음
		
//		for (int i=0; i<6; i++) {
//			int n = rnd.nextInt(45) + 1;
//			lotto2.add(n);
//		}
		
		while(lotto2.size() < 6) {
			
			int n = rnd.nextInt(45) + 1;
			lotto2.add(n);			
		 			
		}
			
		System.out.println(lotto2);
			
	}//m2
		
	

	private static boolean checkNumber(ArrayList<Integer> lotto, int n) {
		
		for (int i=0; i<lotto.size(); i++) {
			if (lotto.get(i) == n) {
				return false;
			}
			
			
		}
		
		
		return true;
	}

	private static void m1() {
		
		HashSet<String> set = new HashSet<String>();
		
		//1. 요소 추가
		set.add("사과");
		System.out.println(set.add("딸기"));//true
		set.add("바나나");
		set.add("포도");
		
		System.out.println(set.size());
		
		System.out.println(set.add("딸기"));//-> 중복이라 add 허락이 안됨, false
		
		//2. 요소 개수
		System.out.println(set.size());
		System.out.println();
		//3. 요소 읽기
		//set.get(식별자); -> 식별자가 없어서 방 구분 불가능 -> 원하는 요소 지정 불가 -> 읽기 메서드 없음.
		
		//읽기 도구 제공(*****************************)
		//- Iterator
		
		//컬렉션.iterator() -> iterator 지원받는다는 뜻
		
		Iterator<String> iter = set.iterator();	//화살표를 하나 받음 -> 명령어 따라 이동 가능(BOF -> EOF)
												//데이터의 집합을 File이라고 부름
		
		//향상된 for문의 구동 원리
//		System.out.println(iter.hasNext());//이동하면 데이터가 있니?
//		System.out.println(iter.next());//화살표를 한 칸 옮기고 그 데이터를 반환해줘
//		
//		System.out.println(iter.hasNext());
//		System.out.println(iter.next());
//		
//		System.out.println(iter.hasNext());
//		System.out.println(iter.next());
		
//		System.out.println(iter.hasNext());//없어서 false
//		System.out.println(iter.next());//NoSuchElementException

		//향상된 for문
//		while (iter.hasNext()) {
//			System.out.println(iter.next());
//		}
//		
		//화살표 > EOF
		//- 커서 다시 끌어올리는 메서드 없음
		//- 이름 자체가 전진 커서
		//- 이게 처리속도 빠름
		//- 새로 만들면 됨
		
		
		//또 읽기
//		iter = set.iterator();
//	
//		while (iter.hasNext()) {
//			String item = iter.next();
//			//item = iter.next(); //디버그 > 한번 더 호출 -> 에러는 갯수 안맞아서 났음
//			System.out.println(item);
//		}
		
		for (String item : set) {
			System.out.println(item);
		}

		for (String item : set) {
			System.out.println(item);
		}//향상된 for문이 실행 될 때마다 iterator 만들어짐 -> 개꿀
		
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("강아지");
		list.add("고양이");
		list.add("병아리");
		
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println();
		
		for (String item : list) {
			System.out.println(item);
		}
		System.out.println();
		
		Iterator<String> iter2 = list.iterator();
		
		while (iter2.hasNext()) {
			System.out.println(iter2.next());
		}
		
	}
	
	
}//class












