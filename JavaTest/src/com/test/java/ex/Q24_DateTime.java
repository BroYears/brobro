package com.test.java.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q24_DateTime {
	
	public static void main(String[] args) throws IOException {
			
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
		System.out.println("음식을 받기 원하는 시각");
			
		System.out.print("시: ");
		String hourIn = reader.readLine();
			
		System.out.print("분: ");			
		String minuteIn = reader.readLine();
		
		int hour = Integer.parseInt(hourIn);
		int minute = Integer.parseInt(minuteIn);
		
		System.out.printf("짜장면 : %d시 %d분\n",
							hour + ((minute - 10) < 0 ? (minute - 10 - 60) / 60 : 0), 
							(minute - 10) < 0 ? 60 + minute - 10 : minute - 10 );
		
		System.out.printf("치킨 : %d시 %d분\n",
							hour + ((minute - 18) < 0 ? (minute - 18 - 60) / 60 : 0), 
							(minute - 18) < 0 ? 60 + minute - 18 : minute - 18 );
		
		System.out.printf("피자 : %d시 %d분\n",
							hour + ((minute - 25) < 0 ? (minute - 25 - 60) / 60 : 0), 
							(minute - 25) < 0 ? 60 + minute - 25 : minute - 25 );//오후 11시 이후 표시
		
		System.out.printf(hour >= 23 ? "짜장면 : 주문 불가\n" : "짜장면 : %d시 %d분\n",
							hour + ((minute - 10) < 0 ? (minute - 10 - 60) / 60 : 0), 
							(minute - 10) < 0 ? 60 + minute - 10 : minute - 10 );
		
		System.out.printf(hour >= 23 ? "치킨 : 주문 불가\n" : "치킨 : %d시 %d분\n",
							hour + ((minute - 18) < 0 ? (minute - 18 - 60) / 60 : 0), 
							(minute - 18) < 0 ? 60 + minute - 18 : minute - 18 );
		
		System.out.printf(hour >= 23 ? "피자 : 주문 불가" : "피자 : %d시 %d분\n",
							hour + ((minute - 25) < 0 ? (minute - 25 - 60) / 60 : 0), 
							(minute - 25) < 0 ? 60 + minute - 25 : minute - 25 );//오후 11시 이후 불가

 
	}//main

}