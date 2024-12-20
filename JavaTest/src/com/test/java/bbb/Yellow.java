package com.test.java.bbb;

import com.test.java.aaa.Red;

public class Yellow {

	public void test() {
		// Red와 다른 패키지의 클래스 > Yellow(다른 동네 사람 > 외지인)
		Red r1 = new Red();
		
		r1.a = 10;
		//r1.b = 20;
		
		r1.a = 10;
		//r1.b = 20;
		
	}
		
}
