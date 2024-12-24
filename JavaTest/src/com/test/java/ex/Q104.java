package com.test.java.ex;

public class Q104 {

	public static void main(String[] args) {
		
		//Q104
		//MyArrayList.java
		
		Q104_MyArrayList list = new Q104_MyArrayList();
		
		System.out.println(list);
		
		list.add("홍길동");
	
		System.out.println(list);
		
		list.add("아무개");
		list.add("강아지");
		//list.add("고양이");
		
		
		System.out.println(list);
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		//System.out.println(list.get(3));
		
		System.out.println();
		
		System.out.println(list.size());
		 
		System.out.println(list);
		
		list.add("고양이");
		
		System.out.println(list);
		
		list.add("거북이");
		
		System.out.println(list);
		
		list.add("가가가");
		list.add("나나나");
		list.add("다다다");
		
		System.out.println(list);
		
		list.add("라라라");
		
		System.out.println(list);
		
	}
	
	
}
