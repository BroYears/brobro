package com.test.java.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Ex69_Lamda {

	
	public static void main(String[] args) {
		
	
		//람다식 사용 예 == 익명 객체 사용 예
		//> 배열, 컬렉션 정렬 > sort(
		
		
		Random rnd = new Random();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		for (int i=0; i<10; i++) {
			nums.add(rnd.nextInt(50) + 1 );//1~50
		}
		
		System.out.println(nums);
		
		//Collections.sort(nums);
		Collections.sort(nums, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		Collections.sort(nums, (o1, o2) -> o1 - o2);//기본식도 사용 가능
		
		//nums.sort(null); Comparator를 요구하는 애만 있음
		
		nums.sort((n1, n2) -> n2- n1);
		
		System.out.println(nums);
		
		
	}//main
	
}//class
