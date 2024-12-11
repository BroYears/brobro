package com.test.java;

public class Q18_MethodOver {
	
	public static void main(String[] args) {
		
		int count = 0;
		
		count = positive(10);
		count = positive(10, 20);
		count = positive(10, 20, -30);
		count = positive(10, 20, -30, 40);
		count = positive(10, 20, -30, 40, 50);
		
		
		
	}

	private static int positive(int n1, int n2, int n3, int n4, int n5) {
		
		int count1 = n1 > 0 ? 1 :0;
		int count2 = n2 > 0 ? 1 :0;
		int count3 = n3 > 0 ? 1 :0;
		int count4 = n4 > 0 ? 1 :0;
		int count5 = n5 > 0 ? 1 :0;
		
		int result = count1 + count2 + count3 + count4 + count5 ;
		
		System.out.print("양수: " + result + "개");
		
		return result;
	}

	private static int positive(int n1, int n2, int n3, int n4) {
		
		int count1 = n1 > 0 ? 1 : 0;
		int count2 = n2 > 0 ? 1 : 0;
		int count3 = n3 > 0 ? 1 : 0;
		int count4 = n4 > 0 ? 1 : 0;
		
		int result = count1 + count2 + count3 + count4 ;
		
		System.out.print("양수: " + result + "개\n");
		
		return result;
	}

	private static int positive(int n1, int n2, int n3) {
		
		int count1 = n1 > 0 ? 1 : 0;
		int count2 = n2 > 0 ? 1 : 0;
		int count3 = n3 > 0 ? 1 : 0;
		
		int result = count1 + count2 + count3;
		
		System.out.print("양수: " + result + "개\n");
		
		return result;
	}

	private static int positive(int n1, int n2) {
		
		int count1 = n1 > 0 ? 1 : 0;
		int count2 = n2 > 0 ? 1 : 0;
		
		int result = count1 + count2;
		
		System.out.print("양수: " + result + "개\n");
		
		return result;
	}

	private static int positive(int n1) {
		
		int count1 = n1 > 0 ? 1 : 0;
		
		int result = count1;
		
		System.out.print("양수: " + result + "개\n");
		
		return result;
	}

}
