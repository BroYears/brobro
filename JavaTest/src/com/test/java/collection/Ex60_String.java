package com.test.java.collection;

public class Ex60_String {

	
	public static void main(String[] args) {
	
		//m1();
		//m2();
		m3();
		
		
	}

	private static void m3() {
		
		//String > StringBuilder
		
		String s1 = "홍길동";
		System.out.println(s1);
		
		StringBuilder s2 = new StringBuilder("홍길동");
		System.out.println(s2);
		System.out.println(s1.equals(s2));
		System.out.println(s2);
		
		System.out.println(s2.length());
		
		
		s1 = s1 + "님";
		s2.append("님");
		
		System.out.println(s2); 
		System.out.println();
		
		
		//String vs StringBuilder 성능 차이 > 시간 측정
		String txt1 = "홍길동";//10,630ms
		
		long begin = System.currentTimeMillis();
		
		for (int i=0; i<300000; i++) {
			txt1 = txt1 + ".";
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(txt1.length());
		
		System.out.printf("%,dms\n", end - begin);
		
		
		StringBuilder txt2 = new StringBuilder("홍길동");//길어질 거 같으면 무조건 StringBuilder 쓰기 -> 4ms
		
		begin = System.currentTimeMillis();
		
		for (int i=0; i<300000; i++) {
			txt2.append(".");
		}
		
		end = System.currentTimeMillis();
		
		System.out.println(txt2.length());
		
		System.out.printf("%,dms\n", end - begin);
		
		
		
		
	}

	private static void m2() {
		
		//문자열 작업 시 주의 할 점
		
		//1.
		String str1 = "홍길동";
		
		for (int i=0; i<100; i++) {
			str1 += "님";
		}
		
		System.out.println(str1);
		
		//2. 큰 문자열 조작
		String str2 = "홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동";
		
		str2 += ".";
		
	}

	private static void m1() {
		
		//"자바의 문자열은 불변[Immutable]이다."
		String s1 = "홍길동";
		String s2 = "홍길동";
		String s3 = "홍";
		s3 = s3 + "길동"; //연산에의한 문자열 상수는 상수풀에 별도로 보관
		
		System.out.println(s1+ ": " + s1.hashCode());
		System.out.println(s2+ ": " + s2.hashCode());
		System.out.println(s3+ ": " + s3.hashCode()); //근데 또 주소값은 같음
		
		System.out.println(s3);
		System.out.println(s1);
		System.out.println(s1 == s2); //주소값 비교 -> true?
		System.out.println(s1 == s3); //이거는 안됨 
	
		//s1 = s1 + "님";
		System.out.println(s1);
		
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));

		String s5 = "홍길동";
		String s6 = new String("홍길동");
		String s7 = new String("홍길동");
		
		System.out.println(s6 == s7); //new때문에 false
		System.out.println(s6.equals(s7));
		
	}
	
	
}
