package com.test.java;

public class Q17_MethodOver {
	
	public static void main(String[] args) {
		
		position("홍길동");
		position("홍길동", "유재석");
		position("홍길동", "유재석", "박명수");
		position("홍길동", "유재석", "박명수", "정형돈");
		
	}

	private static void position(String name1, String name2, String name3, String name4) {
		
		System.out.printf("사원: %s\n", name1);
		System.out.printf("대리: %s\n", name2);
		System.out.printf("과장: %s\n", name3);
		System.out.printf("부장: %s\n\n\n", name4);
		
	}

	private static void position(String name1, String name2, String name3) {
		
		System.out.printf("사원: %s\n", name1);
		System.out.printf("대리: %s\n", name2);
		System.out.printf("과장: %s\n\n\n", name3);
	}

	private static void position(String name1, String name2) {
		
		System.out.printf("사원: %s\n", name1);
		System.out.printf("대리: %s\n\n\n", name2);
		
	}

	private static void position(String name1) {
		
		System.out.printf("사원: %s\n\n\n", name1);
		
	}
	
	

}
