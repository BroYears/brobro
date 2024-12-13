package com.test.java.ex;

import java.util.Scanner;

public class Q31_Cond {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int even = 0;
		int odd = 0;
		
		for (int i=0; i<5; i++) {
			System.out.print("숫자 입력: ");
			int num = scan.nextInt();
			int mod = num % 2;
			
			switch (mod) {
				case 0:
					even++;
					break;
				case 1:
					odd++;
					break;
			}
			
		}
		
		System.out.printf("짝수는 %d개 홀수는 %d개 입력했습니다.\n%s가 %s보다 %d개 더 많습니다.",
							even,
							odd,
							even > odd ? "짝수" : "홀수",
							even < odd ? "짝수" : "홀수", 
							even > odd ? even - odd : odd - even
						  );
	}
}
