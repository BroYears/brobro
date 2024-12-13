package com.test.java.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q30_Cond {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문자: ");
		int txt = reader.read();
		
		//A(65) ~ Z(90)***
		//a(97) ~ z(122)***
		if (txt >= 65 && txt <= 90) {
			System.out.printf("'%s'의 소문자는 '%s'입니다.", (char)(txt), (char)(txt + 32));
		} else if (txt >= 97 && txt <= 122) {
			System.out.printf("'%s'의 대문자는 '%s'입니다.", (char)(txt), (char)(txt - 32));
		} else {
			System.out.print("영문자만 입력하시오.");
		}
	
	}

}
