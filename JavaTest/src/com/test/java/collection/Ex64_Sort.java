package com.test.java.collection;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

public class Ex64_Sort {

	
	public static void main(String[] args) {
		
		
		//배열 or 컬렉션(List만)
		//- 순서가 있는 집합 > 정렬 가능
		
		//정렬 도구
		//1. 직접 구현 > 알고리즘
		//2. JDK 제공 가능 > Arrays.Sort()
		
		//m1();
		//m2();
		//m3();
		//m4();
		m5();
		
	}//main

	private static void m5() {

		
		Calendar c = Calendar.getInstance();
		c.set(2020, 0, 10);
		//user u1 = new User("홍길동", 1, c, "서울");
		
		User u1 = new User("홍길동", 1, 2020, 0, 10, "서울");
		
		ArrayList<User> list = new ArrayList<User>();
		
		
		//서울, 인천, 대전, 부산, 제주
		//부장, 과장, 대리, 사원
		list.add(new User("홍길동", 1, 2022, 2, 10, "서울"));
		list.add(new User("아무개", 5, 2023, 5, 20, "인천"));
		list.add(new User("강아지", 3, 2024, 3, 3, "서울"));
		list.add(new User("고양이", 2, 2022, 10, 17, "제주"));
		list.add(new User("병아리", 1, 2021, 5, 25, "부산"));
		list.add(new User("사자", 2, 2022, 2, 1, "대전"));
		list.add(new User("호랑이", 1, 2023, 1, 8, "서울"));
		list.add(new User("코끼리", 3, 2021, 9, 9, "제주"));
		list.add(new User("이구아나", 4, 2022, 12, 29, "부산"));
		list.add(new User("타조", 5, 2024, 11, 11, "대전"));

		//Arrays.sort()
		//Collection.sort()
		//Collections.sort(컬렉션, Comparator);

		//Collections.sort(list);//오름차순 할 게 많아서 뭘로해야 할지 모름
		Collections.sort(list, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				
				//return o1.getLevel() - o2.getLevel();
				//return o1.getName().compareTo(o2.getName());
				//return o1.getRegdate().getTimeInMillis() - o2.getRegdate().getTimeInMillis(); 너무커서 사용 X
				//return o1.getRegdate().compareTo(o2.getRegdate());//문자열과 문자열은 compareTo
				//return o1.getCity().compareTo(o2.getCity());
				//서울(1), 인천(2), 대전(3), 부산(4), 제주(5)
				
				int city1 = -1;	//첫 번째 User의 지역
				int city2 = -2;	//두 번째 User의 지역 
				
				city1 = getcityNumber(o1.getCity());
				city2 = getcityNumber(o2.getCity());
				
				return city1 - city2;
				
			}

			private int getcityNumber(String city) {

				if (city.equals("서울")) return 1;
				else if (city.equals("인천")) return 2;
				else if (city.equals("대전")) return 3;
				else if (city.equals("부산")) return 4;
				else if (city.equals("제주")) return 5;
				return 0;
			}
		});
		
		//list.sort((u1, u2) -> u1.getLevel() -u2.getLevel());
		
		System.out.println(list);
	}
	

	private static void m4() {
		
		
		
		String[] names = {"홍길동", "사자", "꿩", "바다코끼리", "강아지", "고양이", "병아리", "송아지", "망아지", "두루미", "기러기"};
		
		Arrays.sort(names);
		
		//오름차순 -> 문자코드 우위 비교
		//Arrays.sort(names)
		
		Arrays.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
			
//				if(o1.length() == o2.length()) {// 왜 안돼?
//					return o1 - o2;
//				} else {
//				return o2.length() - o1.length();
//				}
//			}
				
				if(o1.length() > o2.length()) {
				return 1;
				} else if (o1.length() < o2.length()) {
				return -1;
				} else {
					return o2.compareTo(o1);
				}
			
			}
		});
		
		
		//오름차순(글자 수)
		System.out.println(Arrays.toString(names));
		
	}

	private static void m3() {

		Integer[] nums1 = {1, 5, 3, 4, 2};
		
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		};
		
		Arrays.sort(nums1, comparator);
		System.out.println(Arrays.toString(nums1));
		
		
		Arrays.sort(nums1, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o1 - o2;
			}
		});
		System.out.println(Arrays.toString(nums1));
		
	}

	private static void m2() {

		Integer[] nums1 = {1, 5, 3, 4, 2};
		String[] names1 = {"유재석", "아무개", "강아지", "고양이", "병아리"}; 
		
		//내림차순?
		//Arrays.sort(배열, comparator??);//정렬왕 comparator > 인터페이스 내놔라 
		Comparator<Integer> comparator = new MyComparator(); 
		
		Arrays.sort(nums1, comparator);//비교해서 큰 걸 뒤로 작은 걸 앞으로 -> 오름차순 -> compare로 사용자가 바꿀 수 있음
		//Arrays.sort(nums1, comparator)
		
		System.out.println(Arrays.toString(nums1));
		
		
		Arrays.sort(names1, new MyStringComparator() );
		System.out.println();
		
		System.out.println(Arrays.toString(names1));
		
	}

	private static void m1() {

	
		 
		
		//1.a 숫자 + 배열
		int[] nums1 = {1, 5, 3, 4, 2};
		
		
		//오름차순 정렬
		Arrays.sort(nums1);//내림차순은 따로 구현해야함
		
		System.out.println(Arrays.toString(nums1));
		System.out.println();
		
		//1.b 숫자 + 컬
		ArrayList<Integer> nums2 = new ArrayList<Integer>();
		
		
		nums2.add(1);
		nums2.add(5);
		nums2.add(3);
		nums2.add(4);
		nums2.add(2);

		Collections.sort(nums2);
		
		System.out.println(nums2);
		System.out.println();
		
		
		//2.a 문자열 + 배열
		String[] names1 = {"유재석", "아무개", "강아지", "고양이", "병아리"}; 		
		
		Arrays.sort(names1);
		System.out.println(Arrays.toString(names1));
		System.out.println();
		
		ArrayList<String> names2 = new ArrayList<String>();
		
		names2.add("홍길동");
		names2.add("아무개");
		names2.add("강아지");
		names2.add("고양이");
		names2.add("병아리");
		
		Collections.sort(names2);
		
		System.out.println(names2);
		System.out.println();
		
		//3. a 날짜시간 + 배열
		Calendar c1 = Calendar.getInstance();
		c1.add(Calendar.DATE, 0);
		
		Calendar c2 = Calendar.getInstance();
		c2.add(Calendar.DATE, -1);
		
		Calendar c3 = Calendar.getInstance();
		c3.add(Calendar.DATE, 2);
		
		Calendar c4 = Calendar.getInstance();
		c4.add(Calendar.DATE, -5);
		
		Calendar c5 = Calendar.getInstance();
		c5.add(Calendar.DATE, 7);
		
		
		Calendar[] dates1 = new Calendar[5];
		dates1[0] = c1;
		dates1[1] = c2;
		dates1[2] = c3;
		dates1[3] = c4;
		dates1[4] = c5;
		
		Arrays.sort(dates1);
		
		for (Calendar c : dates1 ) {
			System.out.printf("%tF\n", c);
		}
		System.out.println();
		
		ArrayList<Calendar> dates2 = new ArrayList<Calendar>();
		
		dates2.add(c1);
		dates2.add(c2);
		dates2.add(c3);
		dates2.add(c4);
		dates2.add(c5);
		
		Collections.sort(dates2);
		
		//System.out.println(dates2);
		
		for (Calendar c : dates2 ) {
			System.out.printf("%tF\n", c);
		}
		System.out.println();
		
	}//m1
	
}//class

//Comparator<요소의 타입>
class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		
		System.out.println(o1 + ":" + o2);
		
		//compare > 2개의 매개변수를 비교 > 크다/작다/같다 > 우위 비교
		//- o1 > o2 : 양수
		//- o1 < o2 : 음수
		//- o1 = o2 : 0
		
//		if (o1 > o2)  {
//			return -1;
//		} else if(o1 < o2) {
//			return 1;
//		} else {
//			return 0;
//		}

		return o2 - o1;//거의 이걸로 함 이걸로도 오름 내
		
		
	}
	
}


class MyStringComparator implements Comparator<String> {
//여러 경우를 만들려고 만든게아니라서 비용과다 -> 익명으로 만드는게 맞음 
	
	
	@Override
	public int compare(String o1, String o2) {
		
		
		//		o1 - o2
		//return o1.compareTo(o2);//문자열이지만 이런식으로 비교 앞에거가 크면 양수, 뒤에거가 크면 음수
		return o2.compareTo(o1);
		
	}
	
}
