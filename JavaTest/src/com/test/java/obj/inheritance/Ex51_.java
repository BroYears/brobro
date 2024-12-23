package com.test.java.obj.inheritance;

public class Ex51_ {

	
	public static void main(String[] args) {
		
		
		//OOP > 객체를 위주로 작업진행 > 객체와 객체간의 관계
		
		
//		Hong hong = new Hong();
//		hong.name = "홍길동";
//		hong.age = 20;
//		
//		Lee lee = new Lee();
//		lee.name = "이순신";
//		lee.address = "서울시";
		//-> 결합도가 높다. - 교체가 어려움
		
		storeKeeper hong = new Hong();
		
		storeKeeper lee = new Lee();
		//-> 결합도가 낮다. - 교체가 쉬움 -> 최대한 낮추려고 노력
		
		
		
		
		Anyone one = new Anyone();
		one.name = "아무개";
		one.tel = "010-1234-5678";
		
		String item = one.create();
		
		//*** 객체가 객체에게 업무를 위임 > 일을 시킨다. > 객체와 객체간의 관계
		//hong.save(item);
		//lee.store(item);
		
		//hong.store(item);
		//lee.store(item);
		
		hong.store(item);
		//hong.save(item);
		//System.out.println(hong.age);
		//System.out.println(hong.name);
		
		lee.store(item);
		//lee.save(item);
		//System.out.println(lee.age;);
		//System.out.println(lee.name);
		//System.out.println(lee.address);
		
		
		
		
	}//main
	
}//class

interface storeKeeper {
	void store(String item);
	
}

class Hong implements storeKeeper {
	
	public String name;
	public int age;
	
	public void save(String item) {
		System.out.println(item + "을 저장합니다.");
	}

	@Override
	public void store(String item) {
		System.out.println(item + "을 저장합니다.");
		
	}
	
}

//Hong 클래스 > 대체 클래스
class Lee implements storeKeeper {
	public String name;
	public String address;
	
	public void store(String item) {
		System.out.println(item + "을 가져다 어딘가에 보관합니다.");
	}
}

class Anyone {
	public String name;
	public String tel;
	
	public String create() {
		return "노트북";
	}
	
}









