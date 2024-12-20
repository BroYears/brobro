package com.test.java.obj.inheritance;

import java.util.Scanner;

public class Ex50_Object {

	
	public static void main(String[] args) {
		
		//Object 클래스
		//- 모든 클래스의 부모 클래스이다.(Root Class)
		//- 업캐스팅/다운캐스팅 > 모든 자료형을 담을 수 있다.
		
		m1();
		
		
	}//main

	private static void m1() {
		
		AA a1 = new AA();
		BB b1 = new BB();
		CC c1 = new CC();
		
		AA a2 = new BB(); //a2 = b1;
		AA a3 = new CC(); //세대랑 상관없이 업캐스팅 무조건 가능
		
		Object o1 = new Object();//Object는 자신의 객체를 만들 일이 없음 비어있음
		Object o2 = new AA();
		Object o3 = new BB();
		Object o4 = new CC();
		Object o5 = new Scanner(System.in);//만능 주머니, 다 넣을 수 있음.
		Object o6 = new Student();		   //다 넣을 수 있어서 집어넣을 때 편하지만 반대로 꺼낼 때 귀찮음.
		
		
		//Ex) ((Scanner)o5).nextLine(); 이런식으로 꺼낼 때 귀찮아짐
		//Ex) ((Scanner)o3).nextLine(); 까먹기도 쉬움, 컴파일러가 문법은 못잡아서 더 문제
		
		//클래스 변수 = 기본형 값;
		//- 박싱(Boxing), 오토박싱
		Object o7 = 10; //new Integer(10); -> 10을 복사하기 위해서 자동으로 메모리 어딘가에 Integer 클래스 타입의 object를 10으로 복사해서 객체 형태로 저장해버림 ->  결국 object의 자식이어서 업캐스팅발생 -> 이것이 박싱
		Object o8 = true;//형변환 아니에용
		
		
		//- 언박싱(Unboxing)
		System.out.println((int)o7 * 2);	//- 참조형이 기본형으로 형변환되어 버렸음 -> 이거 사기침(형변환 아님, 한 것처럼만 보임)
											//- 그냥 객체에서 꺼내기만 한 것
											//- 처음에 에러난 이유 객체에 * 2 를 한 것과 같아짐
		
		
		
	}
	
}//class


class AA {//extends Object
	
}

class BB extends AA {
		
}

class CC extends BB {
	
}