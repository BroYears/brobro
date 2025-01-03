package com.test.java.obj.inheritance.test;

public class Main {
	
		public static void main(String[] args) {
			
			
		Hong hong = new Hong();
		hong.name = "홍길동";
		
	}
}

interface 사람 {
	void 숨쉰다();
	void 먹는다();
}

interface 부장 extends 사람 {
	void 결재하기();
	void 결산하기();

}

//다중상속
//- 자바는 다중상속을 지원하지 않는다.
//- 클래스끼리는 원래 안되는데 인터페이스에 한해서 다중 상속을 지원.
//집 > 아빠 > 역할
interface 아빠 extends 사람 {
	void 가족을지킨다();
	void 돈을번다();
	void 아이와논다();

}

interface 남자 {
	void 군대를간다();
	void 예비군을간다();
}



class Hong implements 부장, 아빠, 남자 {
	
	public String name;

	public void hello() {
		System.out.println("길동의 특성");
	}
	
	public void 결재하기() {
		
	}

	@Override
	public void 숨쉰다() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void 먹는다() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void 가족을지킨다() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void 돈을번다() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void 아이와논다() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void 결산하기() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void 군대를간다() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void 예비군을간다() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}


