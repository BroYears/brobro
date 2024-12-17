package com.test.java.ex;

public class Q84_String {
	
	public static void main(String[] args) {
		
		String content = "안녕~ 길동아~ 잘가~ 길동아~";
		String word = "길동";
		int txtNum = 0;
		int index = -1;
		
		
		for (int i=0;i<content.length();i++) {
			if(content.indexOf(word, index) > -1) {
				txtNum ++;
				index = content.indexOf(word, index) + 2;
			} else {
				break;
			}
		} 
		System.out.printf("'%s'을 총 %d회 발견했습니다.", word, txtNum );	
	}

}