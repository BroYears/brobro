package com.test.java.obj.inheritance;

import java.util.Random;

public class Ex54_Dummy {

	public static void main(String[] args) {
		
		/*
		  
		  	프로젝트
		  	- 주제 > 레시피 제공 사이트
		  			- 모든 음식 제공
		  			- 양식,중식, 한식, 일식, 분식, ?, ?, ?, ?
		  			- 한식 > 찌개 > 5개 
		  			- 위에 처럼 합의 금지
		  	
		  	
			학생 관리 프로그램
			- 학교? 초등학교, 중학교, 고등학교, 대학교?
			- 학교 규모? 
			- 학년, 반, 학급당 인원수, 남녀 성비?
			- 학생 데이터(이름, 나이, 성별, 주소, 키, 몸무게 등..)
									
			데이터 생성
			- 난수 생성
			
			더미 데이터 + 테스트(실습)용 데이터
			- 90%		+ 10%
		  	
		  	
		  	
		 
		 */
		
		//m1();
		m2();
		
	}//main
	
	private static void m2() {

		//-학생 데이터(이름, 나이, 성별, 주소)
		
		//100명 > 출력
		int size = 100;
		Random rnd = new Random();
		
		//					0	 1	  2 	3		4
		String[] name1 = {"김", "이", "박", "최", "정", "유", "차", "장", "조", "전"};
		String[] name2 = {"길", "동", "재", "석", "명", "수", "세", "진", "호", "미", "주", "이", "경", "자"};
		
		//서울시 강남구 역삼동 11번지
		String[] address1 = {"서울시", "인천시", "부산시", "강릉시", "대구시", "광주시", "제주시"};
		String[] address2 = {"강남구", "강서구",	 "강동구",	"강북구", "중구"};
		String[] address3 = {"역삼동", "대치동", "압구정동", "천호동", "길동", "명일동"};
		
		for(int i=0; i<size; i++) {
			String name = "";
			int age = 0;
			String gender = "";
			String address = "";
			
			//나이(14~16 >0~2 + 14 > 14 ~ 16)
			age = rnd.nextInt(3) + 14; //0~2
			
			//이름(난수)
			name = name1[rnd.nextInt(name1.length)] 
					+ name2[rnd.nextInt(name2.length)]
				    + name2[rnd.nextInt(name2.length)];
					
					
			//성별(숫자난수)
			gender = rnd.nextInt(2) == 0 ? "남자" : "여자";
			
			address = address1[rnd.nextInt(address1.length)] + " " 
					+ address2[rnd.nextInt(address2.length)] + " "
					+ address3[rnd.nextInt(address3.length)] + " "
					+ (rnd.nextInt(300) + 100) + "번지"
					;
			
			System.out.printf("%s(%d세,%s) %s\n", name, age, gender, address);
		
		}
		
		
	}

	private static void m1() {
		
		System.out.println(Math.random()); //0~1
		
		Random rnd = new Random();
		
		System.out.println(rnd.nextDouble());//0~1
		System.out.println(rnd.nextInt()); //-21억 ~ 21억
		System.out.println(rnd.nextInt(10));
		System.out.println(rnd.nextBoolean());
		System.out.println();
		
	}
	
}//class
