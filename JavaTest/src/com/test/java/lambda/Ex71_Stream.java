package com.test.java.lambda;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.test.data.Data;
import com.test.data.Item;
import com.test.data.User;
import com.test.util.MyUtil;

public class Ex71_Stream {

	
	public static void main(String[] args) {
		
		/*
			  	
		  	자바 스트림 -> 스트림은 꼭 손 대야됨
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
		 	1. 중간 파이프 > 또 다른 스트림 객체를 반환
		 	2. 최종 파이프 > 반환값이 없거나(void) 혹은 스트림이 아닌 값
		 	
		 	최종 처리
		 	- forEach(Consumer) -> Consumer라 일이 끝남
		 	- 최종 파이프
		 	- 앞의 스트림으로부터 요소를 차례대로 받아서 최종 처리하는 작업을 하는 메서드(파이프)
		 	
		 	필터링
		 	- filter(Predicate)
		 	- 중간 파이프
		 	- 앞의 스트림으로부터 요소를 차례대로 받아서 조건을 검사 후 조건을 만족하는 요소는 남기고, 불만족하는 요소는 버리는 작업을 하는 파이프
		 	
		 	중복 제거
		 	- distinct()
		 	- 중간 파이프
		 	- 앞의 스트림으로부터 중복 요소들을 제거한다.
		 	- 유일한 요소들로만 이루어진 스트림을 반환.
		 	- like set
		 	
		 	변환 > mapping
		 	- map(Function), mapXXX(Function)
		 	- 중간 파이프
		 	- 앞의 스트림으로부터 요소를 받아 그 요소를 다른 형태로 변환 후 새로운 스트림 반환
		 	
		 	정렬
		 	- sorted(Comparator)
		 	- 중간 파이프
		 	- 사용법 > 배열, 컬렉션의 sort 메서드와 동일
		 	
		 	매칭
		 	- allMatch(), anyMatch(), noneMatch()
		 	- 최종 파이프
		 	- boolean allMatch(predicate)	: 모든 요소가 조건을 일치하는지
		 	- boolean anyMatch(predicate)	: 일부 요소가 조건을 만족하는지
		 	- boolean noneMatch(predicate)	: 모든 요소가 조건을 불일치하는지 > allMatch의 반대
		 	
		 	집게/통계, Reduce
		 	- count()
		 	- max()
		 	- min()
		 	- sum()
		 	- avg()
		 	- 최종 파이프
		 	- 앞의 스트림의 요소를 취합해서 하나의 통곗값을 반환
		 	
		 	
		 	
		*/
		
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		m8();
		
		
	}//main

	private static void m8() {
		
		//count()
		long count = Data.getIntList().stream().count();
		System.out.println(count);
		
		System.out.println(Data.getUserList().stream().filter(user -> user.getGender() == 1).count());
		System.out.println(Data.getUserList().stream().filter(user -> user.getGender() == 2).count());
		System.out.println();
		
		//max(), min()
		List<Integer> nums = Data.getIntList(); //0~99 new Optional<Integer>
		
		
		System.out.println(nums);
		
		
		int max = -1; //nums안의 모든 숫자 중 가장 작은 숫자 - 1
		int min = 100;
		
		for (int n : nums) {
			if (n > max) {
				max = n;
			}
		}

		for (int n : nums) {
			if (n < min) {
				min = n;
			}
		}
		
		System.out.println(max);
		System.out.println(min);
		
		//Optional <Integer>
		//- Integer or int 타입과 동일한 자료형
		//- 기본형은 null을 가질 수 없다.
		//- 참조형이 null을 가질 수 있다. > null을 가질 수 있는 int
		System.out.println(nums.stream().max((a, b) -> a - b));
		
		Optional<Integer> result = nums.stream().max((a, b) -> a - b);
		if (result.isPresent()) {//result.isEmpty()
			System.out.println(result);
		} else {
			System.out.println("최댓값 존재 안함");
		}
		
		int a1 = 10;
		Integer a2 = 20; //new Integer(20);
		Optional<Integer> a3 = Optional.of(30); //wrap
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a3.get());//.get으로 꺼낼 수 ㅣㅇㅆ음
		
		//*** 기본형(8개)은 null을 가질 수 없다.
		//*** 참조형은 null을 가질 수 있다.
		
		String str1 = "홍길동";
		str1 = null;
		
		int a4 = 10;
		//a4 = null;
		
		Optional<User> user = Data.getUserList().stream()
								.max((user1, user2) -> user1.getHeight() - user2.getHeight());
		
		if (user.isPresent()) {
			System.out.println(user.get().getName());
			System.out.println(user.get().getHeight());
		}
		
		
		//스트림 요소 자료형 > 숫자 / 문자열 / 날짜시간
		//- count(), max(), min() > 적용 가능
		//- 어디에 적용해도 다 가능
		
		//스트림 요소 자료형
		//- sum(), average()
		//- 숫자일 때 만 가능
		
		
		nums = Data.getIntList(10);
		System.out.println(nums);
		
		//nums.stream() == Stream<Integer>
		//nums.stream().mapToInt(n -> n) == IntStream
		
		//System.out.println(nums.stream().sum());//stream은 범용 타입이라 지원안함
		
		System.out.println(nums.stream().mapToInt(n -> n).sum());//Optional아님 더하면 값이 없을 수는 없다
		
		System.out.println(nums.stream().mapToInt(n -> n).average().getAsDouble());//값이 없을 수도 있다라고 판단
		System.out.println();
		
		
		//User > 남자 평균 키?
		double height = Data.getUserList().stream()
							.filter(u -> u.getGender() == 1)
							//Stream<User> -> IntStream >>average() 호출
							.mapToInt(u -> u.getHeight())
							.average()
							.getAsDouble();
		System.out.println(height);
		

	}
	
	private String getName(int seq) {
		
		if (seq == 10) {
			return "홍길동";
		}
		
		return null;//참조형은 null로 돌려주면 깔끔함
		
	}
	
	private int getAge(int seq) {
		
		if (seq == 10) {
			return 20;
		}
		
		return -1;//값 형은 무조건 숫자로 돌려줘야 함
	}
	
	private static void m7() {

		int[] nums = {2, 4, 6, 8, 10};
		
		//요구사항 배열에 짝수만 존재? 네/아니오
		boolean result = true;
		
		for (int n : nums) {
			if ( n % 2 == 1) {
				result = false;
				break;
			}
		} 
		
		result = Arrays.stream(nums).allMatch(num -> num % 2 == 0);
				
		if (result) {
			System.out.println("짝수만 존재");
		} else {
			System.out.println("훌수가 발견 됐어요");
		}
	
		nums = new int[] {2, 4, 6, 8, 10};
		
		//홀수가 1개 이상 존재?
		result = Arrays.stream(nums).anyMatch(num -> num % 2 == 1);
		System.out.println(result);
		
		Data.getUserList()
				.forEach(user -> System.out.println(user));
		
		//모든 남자 > 키가 160cm 이상?
	    result = Data.getUserList()
	    	.stream()
	    	.filter(user -> user.getGender() == 1)
	    	//.allMatch(user -> user.getHeight() >= 160);
	    	.anyMatch(user -> user.getHeight() >= 180);
	    
	    System.out.println(result);
		
		
	}
	

	private static void m6() {
		
		//숫자
		Data.getIntList(10).stream()
							.sorted() //똑같이 기본 오름차순
							.forEach(n -> System.out.println(n));
		System.out.println();
		
		Data.getIntList(10).stream()
							.sorted((a, b) -> b - a) //내림차순
							.forEach(n -> System.out.println(n));
		System.out.println();
		
		Data.getIntList(10).stream()
							//.sorted(Comparator.naturalOrder()) //똑같이 기본 오름차순
							.sorted(Comparator.reverseOrder())
							.forEach(n -> System.out.println(n));
		System.out.println();
		
		//문자여
		Data.getStringList(10).stream()
								//.sorted()
								//.sorted(Comparator.reverseOrder())
								.sorted((a, b) -> b.compareTo(a))
								.forEach(word -> System.out.println(word));
		System.out.println();
		
		
		//날짜
		Data.getItemList().stream()
						//.sorted()
						.sorted((a,b) -> a.getDate().compareTo(b.getDate()))
						.forEach(item -> System.out.println(item));
		System.out.println();
		
		Data.getIntList()
			.stream()
			.distinct()
			.filter(n -> n % 2 == 0)
			.map(n -> n * 10)
			.sorted()
			.forEach(n -> System.out.println(n));
		System.out.println();
		
	
		
	}

	private static void m5() {
		
		List<String> list = Data.getStringList(10);
		System.out.println(list);
		System.out.println();
		
		//5글자 이상? 긴 단어 or 짧은 단어
		
		for( String word : list) {
			if (word.length() >= 5) {
				System.out.println("긴 단어");
			} else {
				System.out.println("짧은 단어");
			}
		}
		System.out.println();
		
		list.stream()
			.map(word -> word.length()) //변환(문자열 -> 숫자)
			.forEach(length -> System.out.println(length));
		System.out.println();
		
		list.stream()
			.map(word -> word.length()>= 5 ? "긴 단어" : "짧은 단어")//map 잘 쓰면 굉장히 편함 
			.forEach(result -> System.out.println(result));
		System.out.println();
		
		Data.getUserList().stream()
//						.map(user -> user.getName())
//						.map(user -> user.getAge())
//						.map(age -> age >= 25 ? "고참" : "신입")
						.map(user -> user.getGender() == 1 ? "남자" : "여자")
						.forEach(user -> System.out.println(user));
		System.out.println();
		
		
		//name > Member 객체로 변환
		String[] names = {"홍길동", "아무개", "강아지", "고양이", "거북이" };
		
		//new Member(names[i], 20)
		
		Arrays.stream(names)
				.map(name -> new Member(name, 20))	
				.forEach(m -> System.out.println(m));
		System.out.println();
		
		//User -> (변환) -> Member
		Data.getUserList().stream()
							.map(user -> new Member(user.getName(), user.getAge()))
							.forEach(m -> System.out.println(m));
		System.out.println();
		
		
	}

	private static void m4() {

		Data.getIntList().stream().filter(num -> num % 3 == 0)
								  .filter(num -> num % 2 == 0)
								  .forEach(num -> System.out.println(num));
		System.err.println();
		
		
		List<Integer> list = Data.getIntList();
		System.out.println(list.size());
		System.out.println();
		
		//위의 집합에서 중복값을 제거한 후 출력하시오.
		//case 1.
		//List(원본) > 옮겨담기 > Set(결과본)
		Set<Integer> set = new HashSet<Integer>();
		for (int n : list) {
			set.add(n); // 중복값 배제
		}
		System.out.println(set.size());
		
		//Case 2.
		Set<Integer> set2 = new HashSet<Integer>(list);//Set -> List, for문을 돌려줌
		System.out.println(set2.size());
		
		//set 보유 > list 변환
		List<Integer> list2 = new ArrayList<Integer>(set2);//List -> Set
		
		//Case 3.
		System.out.println(list.stream().count());//count 요소 개수 카운팅
		System.out.println(list.stream().distinct().count());
		
		System.out.println();
		Data.getStringList().stream()
							.filter(word -> word.length() > 4)
							.distinct()
							.forEach(word -> System.out.println(word));
		
		//Member.java
		ArrayList<Member> ulist = new ArrayList<Member>();
		
		ulist.add(new Member("홍길동", 20));
		ulist.add(new Member("아무개", 22));
		ulist.add(new Member("호호호", 25));
		ulist.add(new Member("강아지", 26));
		ulist.add(new Member("고양이", 30));
		ulist.add(new Member("호호호", 25)); //중복값 O,X
				
		
		ulist.stream()
			.distinct()
			.forEach(m -> System.out.println(m));
	}

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
	
	
	
	
	

