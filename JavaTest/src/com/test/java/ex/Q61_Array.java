package com.test.java.ex;

import java.util.Scanner;

public class Q61_Array {
	
	public static void main(String[] args) {
		
		int[] nums = new int[5];
		
		int inNums = 0;
		
		Scanner scan = new Scanner(System.in);
		
		for (int i=0; i<5; i++) {
			
			System.out.print("숫자: ");
			inNums = scan.nextInt();
			nums[i] = inNums; 
		}
	
		for (int i=4; i>-1; i--) {
			
			System.out.printf("Nums[%d] = %d\n", i, nums[i] );
			
		}
		
	}
		
	

}
