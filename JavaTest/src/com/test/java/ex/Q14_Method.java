package com.test.java.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14_Method {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("역의 개수: ");
		String input1 = reader.readLine();
		
		System.out.print("환승역의 개수: ");
		String input2 = reader.readLine();
		
		System.out.print("시간대(1.평상시, 2. 출근시, 3.퇴근시): ");
		String input3 = reader.readLine();
		
		int station = Integer.parseInt(input1);
		int change = Integer.parseInt(input2);
		int time = Integer.parseInt(input3);
		
		getTime(station, change, time);
		
		
	}

	public static int getTime(int station, int change, int time) {
		
		int result = station * 2 + change * (time == 3 ? 5 : time == 2 ? 4 : 3);
		
		System.out.printf("총 소요 시간은 %d분입니다.", result);
		
		return result;
		
		
	}
}
