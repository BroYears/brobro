package com.test.java.lambda;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.test.data.Data;
import com.test.data.Item;
import com.test.data.User;
import com.test.util.MyUtil;

public class Ex71_Stream {

	
	public static void main(String[] args) {
		
		/*
			  	
		  	자바 스트림
		  	1. 입출력 스트림
		  		- 파일 입출력, 콘솔 입출력, 네트워크 입출력 등..
		  	2.스트림
		  		- Java 8(JDK 1.8) + 람다식과 같이
		  		- 배열(컬렉션)의 탐색(+ 조작) 기술(**********)
		  		- 파일 입출력지원
		  		- 디렉토리 탐색 지원
		  		- 기타 등등.
		  		- 익명 객체를 요구 > 람다식 사용 + 함수형 인터페이스
		 	
		 	표준 API 함수형 인터페이스
		 	1. Consumer
		 		- (매개변수) -> {}
		 		
		 	2. Supplier
		 		- () -> { return 값;}
		 	
		 	3. Function
		 		- (매개변수) -> {return 값;}
		 		
		 	4. Operator
		 		- (매개변수) -> {return 값;}
		 		- 매개변수와 반환값이 동일한 자료형
		 	
		 	5. Predicate
		 		- (매개변수) -> {return 값;}	
		 		- 반환값이 boolean
		 		
		 		
		 	파이프, pipe
		 	- 스트림 객체 메서드
		 	1. 중간 파이프
		 	2. 최종 파이프
		 	
		 	최종 처리
		 	- forEach(Consumer) -> Consumer라 일이 끝남
		 	- 최종 파이프
		 	- 앞의 스트림으로부터 요소를 차례대로 받아서 최종 처리하는 작업을 하는 메서드(파이프)
		 	
		 	필터링
		 	- filter(Predicate)
		 	- 중간 파이프
		 	- 앞의 스트림으로부터 요소를 차례대로 받아서 조건을 검사 후 조건을 만족하는 요소는 남기고, 불만족하는 요소는 버리는 작업을 하는 파이프
		 	
		 	
		 	
		 		
		 		
		 		
		
		
		
		 */
		
		
		//m1();
		//m2();
		m3();
		
	}//main

	private static void m3() {

		//스트림을 얻어오는 방법
		//- stream() 메서드를 사용한다.
		//1. 배열로부터
		//2. 컬렉션으로부터
		//3. 숫자 범위
		//4. 파일로부터
		//5. 디렉토리로부터
		
		//1.
		int[] nums1 = { 10, 20, 30, 40, 50 };
		Arrays.stream(nums1).forEach(num -> System.out.println(num));
		System.out.println();
		
		//2.
		ArrayList<Integer> nums2 = new ArrayList<Integer>();
		nums2.add(100);
		nums2.add(200);
		nums2.add(300);
		nums2.stream().forEach(num -> System.out.println(num));
		System.out.println();
		
		LinkedList<Integer> nums3 = new LinkedList<Integer>();
		nums3.add(1000);
		nums3.add(2000);
		nums3.add(3000);
		nums3.stream().forEach(num -> System.out.println(num));
		System.out.println();
	
		HashSet<Integer> nums4 = new HashSet<Integer>();
		nums4.add(10000);
		nums4.add(20000);
		nums4.add(30000);
		nums4.stream().forEach(num -> System.out.println(num));
		System.out.println();
		
		//Collection 상송, set 등은 Stream 지원 가능 -> 향상된 for문이 가능한 애들은 다 가능
		
		HashMap<String, Integer> map;
		//map.stream(); -> 못돌림
		//요소를 빼내서 이용하면 돌릴 수는 있음
		//map.keySet().stream();
		//map.values().stream();
		
		//3.
		//- Stream<T>
		//- IntStream
		//- DoubleStream
		
		IntStream.range(1, 11)//일련번호의 집합
					.forEach(item -> System.out.println(item));
		System.out.println();
		
		try {
			
			//4. 파일 > 읽기 작업
			Path path = Paths.get(".\\data\\score.txt");
			Files.lines(path)//Stream 리턴
				.forEach(str -> System.out.println(str));
			System.out.println();
			
			
			//5. 디렉토리
			Path path2 = Paths.get("C:\\class\\deV\\eclipse");
			Files.list(path2).forEach(p -> {
				System.out.println(p.getFileName());
			});
			//Stream <Path>
			
			
			
			
		} catch (Exception e) {										
			e.printStackTrace();
		}
		
		
		
		
	}

	private static void m2() {

		
		
		//배열(컬렉션) 순차 탐색 + 출력
		List<String> list = Data.getStringList(10);
		
		System.out.println(list);
		System.out.println();
		
		//1. for문 (while문)
		for (int i=0; i<list.size(); i++) {
			System.out.printf("%s\t", list.get(i));
		}
		System.out.println();
		
		//2. 향상된 for문 == foreach
		for (String word : list) {
			System.out.printf("%s\t", word);
		}
		System.out.println();
		System.out.println();
		
		//3. Iterator
		Iterator<String> iter = list.iterator();
		
		while (iter.hasNext()) {
			System.out.printf("%s\t", iter.next());
		}
		System.out.println();
		System.out.println();
		
		//4. stream
		Stream <String> stream = list.stream();
		
		//애플 아케이드 > c1.accept("애플아케이드") 호출
		//국내 > c1.accept("국내") 호출
		//서비스 > c1.accept("서비스") 호출
		stream.forEach(param -> System.out.println(param)); //forEach 배열을 찾아가서 첫번째 방을 꺼내고 accept 메소드 호출 -> param에 데이터 꺼내오고 - > 반복 -> 향상된 for문 처럼 루프를 도는 것과 비슷하게됨
		System.out.println();
		System.out.println();
		
		
		
		List<Integer> nums = Data.getIntList(10);
		System.out.println();
		
		
		Stream<Integer> stream2 = nums.stream();
		stream2.forEach(num -> System.out.println(num));//최종 파이프로 닫아버림
		System.out.println();
		
		stream2 = nums.stream();//값설정 다시 해주면 됨
		
		stream2.forEach(num -> System.out.println(num));// java.lang.IllegalStateException: stream has already been operated upon or closed
		System.out.println();
		
		stream2 = nums.stream();
		
		stream2
			.filter(num -> num % 2 == 0)
			.forEach(num -> System.out.println(num));//forEach -> 필터가 물고있는 데이터를 필터링하고 그 다음 물고물고 ~ 체인
		//리턴 값 보면 최종 파이프인지 아닌지 알 수 있음
		System.out.println();
		
		//배열.stream().pipe().pipe().pipe().pipe().pipe(); -> 문장이 왕 길어짐
		//호불호 갈림
		
		nums.stream().filter(num -> num >= 50 && num % 2 == 1)
					 .forEach(num -> System.out.println(num));
		System.out.println();
		
		nums.stream().filter(num -> num >= 50)
					 .filter(num -> num % 2 == 1)//걍 파이프 하나 껴주나 조건 하나 추가하나 똑같음 -> 가독성 차이, 필터 순서를 생각해보면 비용 줄일 수 있음
					 .forEach(num -> System.out.println());
		System.out.println();
		
		list.stream()
					.filter(word -> word.length() >= 3)
					.forEach(word -> System.out.println(word)); //일부 필터만 주석 달기도 좋음
		System.out.println();
		
		
		
	}

	private static void m1() {
		
		
		MyUtil util = new MyUtil();
		System.out.println(util.sum(10,20));
		System.out.println(util.sum(10,20, 30));
		
		int[] nums1 = Data.getIntArray();
		
		
		
		
		
		
		List<Integer> nums3 = Data.getIntList();
		//System.out.println(nums3 );
		
		List<Integer> nums4 = Data.getIntList(5);
		System.out.println(nums4);
		
		String[] txt1 = Data.getStringArray(5);
		System.out.println(Arrays.toString(txt1));
		
		User[] ulist = Data.getUserArray();
		System.out.println(Arrays.toString(ulist));
		
		Item[] ilist = Data.getItemArray();
		System.out.println(Arrays.toString(ilist));
		
		
		
		
	}

	

		
		
		
}
	
	
	
	
	

