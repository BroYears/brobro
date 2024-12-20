package com.test.java;

import com.test.java.aaa.Red;
import com.test.java.aaa.Yellow;
//import com.test.java.bbb.Yellow; Yellow가 중복이라 안됨

public class Ex45_package {

	
	public static void main(String[] args) {
		
		/*
		  	
		  	패키지, Package
		  	- 클래스를 저장하기 위한 폴더
		  	- 많은 클래스들을 체계적으로 관리하기 위한 용도
		  	- 경로 -> C:aaa\bbb\ccc
		  	- 패키지 -> aaa.bbb.ccc
		  	
		  	obj1.member = 10;
		  	obj1.m1();
		  	aaa.bbb.ccc
		  	
		  	"com.test.java.aaa" -> "Red.java"
		  						-> "Yellow.java"
		  	"com.test.jave.bbb"	-> "Yellow.java" 
		  	"com.test.java.bbb.ccc" -> "Blue.java"
		  	
		  	패키지 역할 
		  	- 같은 성격의 클래스 집합
		  	- 논리적 역할 & 물리적 역할
		 	
		 	패키지 + 접근지정
		 	1. private > 100% 비공개
		 	2. public > 100% 공개
		 	------------------------
		 	3. (default)
		 		- 같은 패키지내에서는 100% 공개
		 		- 다른 패키지내에서는 100% 비공개
		 	4. protected
		 		- 같은 패키지내에서는 100% 공개
		 		- 다른 패키지내에서는 100% 비공개
		 		- 다른 패키지에 있어도 자식 클래스면 100% 
		 */
		
		//다른 패키지의 클래스를 인식하는 방법
		//1. 풀네임 사용
		//2. import 사용
		
		//com.test.java.aaa.Red r1 = new com.test.java.aaa.Red();
		Red r2 = new Red();
		
		Yellow y1 = new Yellow();
		
		com.test.java.bbb.Yellow y2 = new com.test.java.bbb.Yellow();
		
		
	}//main
}
