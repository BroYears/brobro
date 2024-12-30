package com.test.java.collection;

import java.util.Iterator;
import java.util.TreeSet;

public class Ex66_TreeSet {

	
	public static void main(String[] args) {
		
		
		/*
		  	
		  	컬렉션 이름
		  	
		  	[물리구조]	[사용법 > 인터페이스]
		  	Array		List (***)
		  	Linked		List
		  	Hash		Set  (***)
		  	Tree		Set
		  	Hash		Map  (***)
		  	Tree		Map
		  	
		  	- 별표 친 애들만 잘 알아도 됨
		  	- 나머지 애들은 뭔지만 알 것
		  	
		  	Hash -> 속도가 빠름
		  	Tree -> Tree구조 
		  	
		  	TreeSet
		  	- 유일한 요소들을 가진 집합(중복값 X)
		  	- 트리 구조 > 2진 탐색 트리 구조(Binary Search Tree)
		  					> 내부 데이터가 자동으로 정렬된 상태
		  	- Hash보다 느리다
		  
		 */
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		set.add(5);
		set.add(3);
		set.add(8);
		set.add(2);
		set.add(1);
		set.add(4);
		set.add(7);
		set.add(9);
		set.add(10);
		set.add(6);
		set.add(10);
		
		System.out.println(set);
	
		//범위 or 순서 관련 기능 제공
		System.out.println(set.first());	//첫번째 방
		System.out.println(set.last());		//마지막 방
		
		System.out.println(set.headSet(4)); //앞 부분에서 4를 만나기 전까지 - 머리부터라 headSet(?)
		System.out.println(set.tailSet(7)); //시작위치 포함 끝위치는 미포함
		System.out.println(set.subSet(4, 7)); //시작위치 포함 끝위치는 미포함
		
		Iterator<Integer> iter = set.iterator();
		//향상된 for문이 더 편함
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		for (int n : set) {
			System.out.println(n);
		}
		
		
	
	}//main


}//class
