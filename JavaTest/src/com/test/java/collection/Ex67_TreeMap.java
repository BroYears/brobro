package com.test.java.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.Vector;

public class Ex67_TreeMap {

	public static void main(String[] args) {
		
		/*
		  	
		  	
		  	TreeMap
		  	- 2진 탐색 트리 구조 > 내부 데이터 정렬
		  	- 키 + 값
		  	
		  	List
		  	- ArrayList > 기본 사용
		  	- LinkedList > 잦은 조작
		  	- Stack > 후입선출
		  	- Queue > 선입선출
		  	- Vector >>> ArrayList으로 대체
		  	
		  	Set
		  	- HashSet > 기본 사용
		  	- TreeSet > 정렬
		  	
		  	Map
		  	- HashMap > 기본 사용
		  	- TreeMap > 정렬
		  	- HashTable >>> HashMap으로 대체
		  	
		  	
		  	- Tree는 기본적으로 정렬 할 때 사용
		  
		 */
		
		TreeMap<String, String> map = new TreeMap<>();
		
		map.put("red", "빨강");
		map.put("yellow", "노랑");
		map.put("blue", "파랑");
		map.put("white", "하양");
		map.put("black", "검정");
		
		System.out.println(map);
		
		
		//List > 없는 방 번호 호출 > 에러(IndexOutofBoundException)
		//Map > 없는 방 번호 호출 > null
		System.out.println(map.get("white"));
		System.out.println(map.get("green"));
		
		System.out.println(map.firstKey());//key만
		System.out.println(map.lastKey());
		
		System.out.println(map.firstEntry());//key랑 값 전부
		System.out.println(map.lastEntry());
		
		System.out.println(map.headMap("m")); //a~l까지 찾아라
		System.out.println(map.tailMap("m")); //m~z
		System.out.println(map.subMap("r", "w")); //r~v
		
		
		//Thread 작업 안전, 불안전
		//- vector 불안전
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		Vector<Integer> list2 = new Vector<Integer>();
		
		list1.add(100);
		list2.add(100);
		
		HashMap<String, Integer> map1 = new HashMap<>();
		Hashtable<String, Integer> map2 = new Hashtable<>();
		
		map1.put("키", 100);
		map2.put("키", 100);
		
		
		
		
		
	}//main
	
	
}//class
