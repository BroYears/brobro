package com.test.java.obj.inheritance;

import java.util.Scanner;

public class Ex41_Object {

	public static void main(String[] args) {
		
		/*
		  
		  //Object class
		  
		  
		 */
		
		//java.lang.Object
		//java.lang > 모든 패키지 중 최상위 패키지
		//- 어떤 상황에서도 쓸 수 있는 기본적인 클래스가 들어있음
		//Ex) Object, String ...
		//- import 안해도 자동으로 됨
		Object o1 = new Object();
		
		Test t1 = new Test();
		
		//Class Object is the root of the class hierarchy.
		//Every class has Object as a superclass. -> superclass는 부모클래스 
		//All objects,including arrays, implement the methods of this class.
		int[] nums = new int[3];
		
		
	}//main
}//class

//자동으로 extends Object가 됨
//a, b 제외하고 있는 멤버들은 자동상속받은 것
//- Object가 소매넣기하고 감
//- extends Object 없어도 상속 되어있음
//- 단군할아버지 느낌 -> 루트(뿌리) 근본 그 자체
class Test extends Object{
	public int a;
	public int b;
}

