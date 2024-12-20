package com.test.java.bbb.ccc;

import com.test.java.aaa.Red;

public class Blue extends Red {
	
	int a;
	int b; // public 으로 여는건 귀찮고 열긴 열어야 할 때

	public void test() {
	
		//Red> com.test.java.aaa
		//Blue > com.test.java.bbb.ccc
	
	
		//타지에 사는 자식
		this.a = 10; //public
		//this.b = 20; //private
		//this.c = 30; //default
		this.d = 30; //protected
		
		
	}
}
