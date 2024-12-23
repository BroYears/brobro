package com.test.java.obj.inheritance;

public class Ex52_Generic {

	public static void main(String[] args) {
		
		
		//제네릭, Generic
		//- 제네릭 클래스
		//- 제네릭 메서드
		
		//제네릭 클래스
		//- 개발자가 정의하기 위해서
		//- JDK에서 제공되는 클래스 중 일부가 제네릭으로 제공 > 점점 증가
		//- 그나마 새 거
		//- 컬렉션의 기능들
		//- Object의 단점을 보완
		
		//요구사항] 클래스 설게 중..
		//1. 멤버 변수 > int 1개
		//2. 멤버 변수를 중심으로 여러가지 행동을 하는 메서드를 선언
		
		//추가사항] String을 중심으로 하는 클래스 설계
		//추가사항] boolean을 중심으로 하는 클래스 설계    
		//추가사항] double을 중심으로 하는 클래스 설계
		//추가사항] byte를 중심으로 하는 클래스 설계
		//추가사항] Random을 중심으로 하는 클래스 설계
		//추가사항] Student를 중심으로 하는 클래스 설계
		//추가사항] ... 무한대
		
		WrapperInt n1 = new WrapperInt(10);
		System.out.println(n1); //n1.toString()
		System.out.println(n1.getData()* 2);
		System.out.println();
		
		//범용 클래스
		WrapperObject n2 = new WrapperObject(20);//박싱 + 형변환
		System.out.println(n2);
		System.out.println((int)n2.getData()* 2);//언박싱
		System.out.println();
		
		
		//제네릭 클래스
		Wrapper<Integer> n3 = new Wrapper<Integer>(30);//박싱
		System.out.println(n3);
		System.out.println(n3.getData() * 2);
		System.out.println();
		

		
		WrapperString s1 = new WrapperString("홍길동");
		System.out.println(s1);
		System.out.println(s1.getData().length());
		
		WrapperObject s2 = new WrapperObject("홍길동");//박싱(x)
		System.out.println(s2);
		System.out.println(((String)s2.getData()).length());//형변환
		System.out.println();
		
		Wrapper<String> s3 = new Wrapper<String>("강아지");
		System.out.println(s3);
		System.out.println(((String)s3.getData()).length());
		System.out.println();
		
		WrapperBoolean b1 = new WrapperBoolean(true);
		System.out.println(b1);
		System.out.println(b1.getData() ? "참" : "거짓");
		System.out.println();
		
		WrapperObject b2 = new WrapperObject(false);
		System.out.println(b2);
		System.out.println((boolean)b2.getData() ? "참" : "거짓"); //언박싱
		System.out.println();
		
		Wrapper<Boolean> b3 = new Wrapper<Boolean>(true);
		System.out.println(b3);
		System.out.println(b3.getData() ? "참" : "거짓");
		System.out.println();
		
		
		//s2.setData(3.14);
		
		//s2.getData()
		
		
	}//main
	
	
}

class WrapperInt { 
	
	
	private int data; //1. 클래스의 중심 역할
	
	//2. 메서드 > data 중심으로 행동
	public WrapperInt(int data) {
		this.setData(data);
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return String.format("[data=%s]", data);
	}
	
	
}


class WrapperString { 
	
	
	private String data; //1. 클래스의 중심 역할
	
	//2. 메서드 > data 중심으로 행동
	public WrapperString(String data) {
		this.setData(data);
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return String.format("[data=%s]", data);
	}
	
	
}

class WrapperBoolean { 
	
	
	private boolean data; //1. 클래스의 중심 역할
	
	//2. 메서드 > data 중심으로 행동
	public WrapperBoolean(boolean data) {
		this.setData(data);
	}
	
	public boolean getData() {
		return data;
	}
	
	public void setData(boolean data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return String.format("[data=%s]", data);
	}
	
	
}


class WrapperObject { 
	
	
	private Object data; //1. 클래스의 중심 역할
	
	//2. 메서드 > data 중심으로 행동
	public WrapperObject(Object data) {
		this.setData(data);
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return String.format("[data=%s]", data);
	}
	
	
}

//제네릭 클래스
class Wrapper<T> {
	
	private T data;
	
	public Wrapper(T data) {
		this.data = data;
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return String.format("Wrapper [data=%s]", data);
	}
	
	
	
}






