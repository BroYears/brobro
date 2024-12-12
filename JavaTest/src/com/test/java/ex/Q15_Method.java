package com.test.java.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15_Method {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("맑은 날: ");
		String input1 = reader.readLine();
					
		System.out.print("흐린 날: ");
		String input2 = reader.readLine();
		
		int sunny = Integer.parseInt(input1);
		int foggy = Integer.parseInt(input2);
		
		getApple(sunny, foggy);
		
		
	}

	public static int getApple(int sunny, int foggy) {
		
		int tree = 0;
		int apple = 0;
		
		int sunnyResult = 5 * sunny;
		int foggyResult = 2 * foggy;
		
		tree = sunnyResult + foggyResult;
		apple = tree>= 100 ? (tree - 100) / 10 : 0;
		
		System.out.printf("사과가 총 %d개 열렸습니다.", apple);
		
		return apple;
		
	}
	
	
}
