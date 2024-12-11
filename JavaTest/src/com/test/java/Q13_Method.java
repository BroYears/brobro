package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q13_Method {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("국어: ");
		String kor = reader.readLine();
		
		System.out.print("영어: ");
		String eng = reader.readLine();
		
		System.out.print("수학: ");
		String math = reader.readLine();
		
		int korScore = Integer.parseInt(kor);
		int engScore = Integer.parseInt(eng);
		int mathScore = Integer.parseInt(math);
		
		test(korScore, engScore, mathScore);
		
	}//main

	public static String test(int kor, int eng, int math) {
		
		double avg = (kor + eng + math) / 3D;
		
		String result = avg <= 60 || (kor < 40 || eng < 40 || math < 40)  ? "불합격" : "합격" ;
		
		System.out.printf("%s입니다", result);
		
		return result;
		
	}//test
}
