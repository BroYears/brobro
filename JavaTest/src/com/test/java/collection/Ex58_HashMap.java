package com.test.java.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Ex58_HashMap {

	
	public static void main(String[] args) {
		
		
		/*
		  
			순서가 있는 집합
			- List > ArrayList, Stack, Queue
			
			순서가 없는 집합
			-Set
			-Map
		  	
		  	
		  	ArrayList
		  	- 요소 접근 > 첨자(index) 사용 > 방 번호
		  	- 순서가 있는 집합
		  	ex) 1강의실, 2강의실, 3강의실...
		  	- 스칼라 배열(Scalar Array)
		  	- 요소 = 첨자 (index) + 값(value)
		  	- 첨자(index)는 유일하다. 
		  	- 값(value)은 중복이 가능하다. > 방번호가 유일해서
		  	
		  	HashMap
		  	- 요소 접근 > 키(key) 사용 > 방 이름 
		  	- 순서가 없는 집합
			ex) 햇님반, 달님반, 별님반
			- 연관 배열, 사전 구조(Dictionary)
			- 요소 = 키(key) + 값(value)
			- 키(key)가 유일하다.
			- 값(value)은 중복이 가능하다. > 키가 유일하니까
				  	
		  
		 */
		
		//m1();
		//m2();
		//m3();
		//m4();
		m5();
		
	}//main
	
	private static void m5() {

		//한 학급 > 명단
		//- 3명
				
		Student s1 = new Student("홍길동", "남자");
		Student s2 = new Student("아무개", "남자");
		Student s3 = new Student("호호호", "여자");
		
		//순서 > 루프 or 개별 관리 > 
		ArrayList<Student> list = new ArrayList<Student>();
		
		
		
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		for (Student s : list) {
			System.out.println(s.getName());
		}
		
		HashMap<String, Student> map = new HashMap<>();
		
		map.put("반장", s1);
		map.put("부반장", s2);
		map.put("체육부장", s3);
		
		System.out.println(map.get("반장"));
		
		
	}

	private static void m4() {
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(0, "강아지");
		map.put(1, "고양이");
		map.put(2, "병아리");//key에 숫자 잘 안씀

		System.out.println(map);
		
		for (int i=0; i<map.size(); i++){//바보같은 행동 차라리 다른 거 써라
			System.out.println(map.get(i));
			}
		
		
		
		HashMap<Boolean, String> map2 = new HashMap<Boolean, String>();
		
		map2.put(true, "정답");
		map2.put(false, "오답");
		//map2.put() - 효율 떨어짐
		
		
		
		
	}
	
	
	
		

	private static void m3() {
		
		HashMap<String, String> map = new HashMap<>();
		
		
		map.put("red", "빨강");
		map.put("yellow", "노랑");
		map.put("blue", "파랑");
		
		//Loop 탐색
		Set<String> keys = map.keySet(); //키 배열
		System.out.println(keys);
		
		for (String key : keys) {
			System.out.println(key);
		}
		
		Collection<String> valuse = map.values(); //값 배열
		System.out.println(valuse);//Set, Collection -> 방번호 X
		
		for (String value : valuse) {
			System.out.println(value);
		}
		
		
		//HashMap Loop 탐색
		for (String key : keys) {
			System.out.println(key + ":" + map.get("red"));
		}
		
		
		
	}

	private static void m2() {

		HashMap<String, String> map = new HashMap<>();
		
		//1.요소 추가
		map.put("red", "빨강");
		map.put("yellow", "노랑");
		map.put("blue", "파랑");
		
		//2. 요소 개수
		System.out.println(map.size());
		
		//3. 요소 읽기
		System.out.println(map.get("red"));
		System.out.println(map.get("yellow"));
		System.out.println(map.get("blue"));
		System.out.println(map.get("green"));//어? 못찾았는데?
		
		//4. 요소 수정 > 키는 유일하다.
		map.put("blue", "푸른");
		System.out.println(map);//들어가있는 순서 알빠아님
		
		//5. 요소 삭제
		map.remove("blue");
		System.out.println(map);
	
		map.remove("blue");//없어도 에러는 안남 걍 못찾은대로 나옴
		System.out.println(map);
		
		//6. 검색
		//- indexOf, lastIndexOf > X
		//- contains
		System.out.println(map.containsKey("red"));
		System.out.println(map.containsValue("빨강"));
		
		//7. 초기화
		map.clear();
		System.out.println(map);
		System.out.println(map.size());
		
		
		
		
		
		
	}

	private static void m1() {
		
		//학생 1 명의 국어, 영어, 수학 점수 저장 > 집합?
		//1. 배열
		//2. ArrayList
		//3. Class
		//4. HashMap
		
		//1. 배열
		//- 장접: 집합, 방번호(루프)
		//- 단점: 방번호 > 의미없다. > 데이터 식별 불편 
		
		int[] s1 = new int[3];
		
		s1[0] = 100;
		s1[1] = 90;
		s1[2] = 80;

		System.out.println(s1[0] + s1[1] + s1[2]);
		
		//2. ArrayList
		//- 장점: 집합, 방번호(루프), 과목 동적 추가/삭제
		//- 단점: 방번호 > 의미없다. > 데이터 식별 불편
		ArrayList<Integer> s2 = new ArrayList<Integer>();
		
		s2.add(100);
		s2.add(90);
		s2.add(80);
		
		System.out.println(s2.get(0) + s2.get(1) + s2.get(2));
		
		//3. 클래스
		//- 장접: 집합, 요소 구분 > 이름으로 구분 > 가독성 높아짐
		//- 단점: 클래스 선언 비용 발생
		//- 두 개 이상일 경우 클래스로 만드는게 이득
		Subject s3 = new Subject(100, 90, 80);
		s3.setKor(100);
		System.out.println(s3.getTotal());
		
		//4. HashMap
		//- 장점: 집합, 요소 구분 > 이름(k으로 구분 > 가독성 높아짐
		//- 단점: 클래스처럼 선언 안함.
		//- 일회용 클래스같은 느낌
		//- 한 두개 만들 때는 HashMap이 이득
		HashMap<String, Integer> s4 = new HashMap<String, Integer>();
		
		s4.put("kor", 100); //int kor;
		s4.put("eng", 90);
		s4.put("math", 80);
		
		System.out.println(s4.get("kor") + s4.get("math") + s4.get("eng"));
		
		HashMap<String, Integer> s5 = new HashMap<String, Integer>();
		
		s5.put("kor", 100); //int kor;
		s5.put("eng", 90);
		s5.put("math", 80);
		
		System.out.println(s5.get("kor") + s5.get("math") + s5.get("eng"));
		
		
	}//m1
	
		
}


class Subject {
	private int kor;
	private int eng;
	private int math;
	
	public Subject(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	
	public int getTotal() {
		return this.kor + this.eng + this.math;
	}


	public int getKor() {
		return kor;
	}


	public void setKor(int kor) {
		this.kor = kor;
	}


	public int getEng() {
		return eng;
	}


	public void setEng(int eng) {
		this.eng = eng;
	}


	public int getMath() {
		return math;
	}


	public void setMath(int math) {
		this.math = math;
	}
	
}














