package com.test.java;

public class Q16_MethodOver {
	
	public static void main(String[] args) {
		
		
		sum(10);
		sum(10, 20);
		sum(10, 20, 30);
		sum(10, 20, 30, 40);
		sum(10, 20, 30, 40, 50);
		
	}


	private static void sum(int i, int j, int k, int l, int m) {
		
		int result = i + j + k + l + m;
		
		System.out.printf("%d + %d + %d + %d + %d = %d", i, j, k, l, m, result);
		
	}


	private static void sum(int i, int j, int k, int l) {

		int result = i + j + k + l;
		
		System.out.printf("%d + %d + %d + %d = %d\n", i, j, k, l, result);
	}
	
	private static void sum(int i, int j, int k) {

		int result = i + j + k;
		
		System.out.printf("%d + %d + %d = %d\n", i, j, k, result);
		
	}

	private static void sum(int i, int j) {

		int result = i + j;
		
		System.out.printf("%d + %d = %d\n", i, j, result);
	}

	private static void sum(int i) {

		int result = i;
		
		System.out.printf("%d = %d\n", i, result);
		
	}
	
	

}
