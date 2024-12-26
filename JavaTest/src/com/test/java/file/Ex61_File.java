package com.test.java.file;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class Ex61_File {

	private static int fileCount;
	private static int dirCount;
	private static int dirSize;
	
	
	
	static {
		
		fileCount = 0;
		dirCount = 0;
		dirSize = 0;
	
	}
	
	public static void main(String[] args) {
		
		
		/*
		 
		 
		 	1. 파일/디렉토리 조작
		 		- 탐색기 행동
		 	
		 	
		 	2. 파일 > 입출력
		 		- 메모장
		 	
		 	파일 입출력
		 	- 자바 프로그램 <- (데이터) -> 보조기억장치(HDD, SDD)
		 					   인코딩->							: 쓰기(저장, 출력)
		 					   디코딩<-							: 읽기(입력)
		 	
			저장 장치
			- 데이터 0, 1 저장
			- 데이터 자료형 없음
			
			
			인코딩, Encoding
			- 문자 코드(응용 프로그램의 데이터)를 부호화(0, 1) 시키는 작업
			- 자바 프로그램("홍길동", String) > 텍스트 파일(0110110101011)
			
			디코딩, Decoding
			- 부호 데이터를 문자 코드로 변환하는 작업
			- 텍스트 파일(0110110101011) > 자바 프로그램("홍길동", String)

			인코딩/디코딩 규칙
			- 저장 장치(네트워크)에서 데이터를 표현하는 규칙
			
			1. ANSI
			2. URF
				- UTF - 8
				- UTF - 16
			3. ISO-8859-1
			4. EUC-KR
			5. MS949
			
			ANSI(ISO-8859-1, EUC-KR, MS949) -> 한국에서는 같다고 봄
			- 영어(숫자, 특수문자 > ASCII(0~255)): 1byte
			- 한글(한자, 일본어 등): 2byte
			
			UTF-8 -> 국제적으로 제일 많이 씀
			- 영어: 1byte
			- 한글: 3byte
			
			UTF-16 -> 인코딩 정보 삽입돼서 2~3byte 추가
			- 영어: 2byte
			- 한글: 2byte 
			
			
		 */
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		//m8();
		//m9();
		//m10();
		//m11();
		//m12();
		//m13();
		m14();
		
		
		
	}//main

	private static void m14() {//static -> main메서드라 무조건 필요 -> static이 없으면 obj활용 Ex61_File obj = new Ex61_File(); obj.m14();

		//- 795,142,794 바이트
		//- 파일 13,890 
		//- 폴더 2,581
		
		//- 재귀 호출
		
		String path = "C:\\class\\dev\\eclipse";
		File dir = new File(path);
		
		if (dir.exists()) {
			
			count(dir);
			System.out.printf("총 파일의 개수: %d\n", fileCount);
			System.out.printf("총 폴더의 개수: %d\n", dirCount);
			System.out.printf("폴더의 크기: %d", dirSize);
		}
	}

	public static void count(File dir) {
		
		dirCount++;
	
		//1. 목록 가져오기
		File[] list = dir.listFiles();
		
		//2. 목록 > 파일만 추출 > 개수
		for (File file : list) {
			if(file.isFile()) {
				fileCount++;
				dirSize += file.length();
			}
		}
		
		
		//3. 목록 > 폴더 > 1~2 반복
		for (File subdir : list) {
			if(subdir.isDirectory()) {
				count(subdir); //재귀
			}
		}
		
		
	}//dir

	private static void m13() {
		
		//- 795,142,794 바이트
		//- 파일 13,890 
		//- 폴더 2,581
		
		//- 재귀 호출
		String path = "C:\\class\\dev\\eclipse";
		File dir = new File(path);
		
		int count = 0; //파일 개수 > 누적 변수
		
		if (dir.exists()) {
			
			File[] list = dir.listFiles();
			
			for (File file : list) {
				if (file.isFile()) {
					count++;
				}
			}
			
			for (File subdir : list) {
				if (subdir.isDirectory()) {
					
					File[] sublist = subdir.listFiles();
					
					for (File subfile : sublist) {
						if (subfile.isFile()) {
							count++;
						}
					}
					
					for (File subsubdir : sublist) {
						if (subsubdir.isDirectory()) {
							
							File[] subsublist = subsubdir.listFiles();
							
							for (File subsubfile : subsublist) {
								if (subsubfile.isFile()) {
									count++;// 코드가 너무 복잡해짐
								}
							}
						}
					}
									
				}
			}
			
			System.out.printf("총 파일의 개수: %d", count);
			
			
		}
	}

	private static void m12() {
		
		//*** 자주 사용
		//- 특정 폴더의 내용물 보기
		
		String path = "C:\\class\\dev\\eclipse";
		File dir = new File(path);
		
		if (dir.exists()) {
			
			
//			String[] list = dir.list();
//			
//			for (String item : list) {
//				
//				File file = new File(path + "\\" + item);
//				
//				System.out.println(item + ":" + file.isFile());
//			} 
			
//			File[] list = dir.listFiles();
//			
//			for(File item : list) {
//				System.out.println(item.getName() + ":" + item.isFile());
//			}
			
			File[] list = dir.listFiles();
			
			for (File item : list) {
				if(item.isDirectory()) {
					System.out.printf("📁%s\n", item.getName());
				}
			}

			for (File item : list) {
				if(item.isFile()) {
					System.out.printf("📄%s\n", item.getName());
				}
			}
			
			
			
			
		}
		
		
	}

	private static void m11() {
		
		File dir = new File("C:\\Users\\user\\git\\brobro\\JavaTest\\file\\aaa");
		
		//빈 폴더만 삭제가능 -> 아무것도 없어야 함
		System.out.println(dir.delete());
		
	}

	private static void m10() {

		//폴더명 수정 or 폴더 이동
		//- renameTo
		File dir = new File("C:\\Users\\user\\git\\brobro\\JavaTest\\file\\일정");
		File dir2 = new File("C:\\Users\\user\\git\\brobro\\JavaTest\\file\\schedule");
		
		System.out.println(dir.renameTo(dir2));
		
	}

	private static void m9() {
		
		//요구사항] 일정관리 > 날짜별 폴더 생성 
		// > [2025-01-01] ~ [2025-12-31]
		
		Calendar c = Calendar.getInstance();
		c.set(2025, 0, 1);
				
		//System.out.println(c.get(Calendar.DAY_OF_YEAR));
		System.out.println(c.getActualMaximum(Calendar.DAY_OF_YEAR));
		
		for (int i=0; i<c.getActualMaximum(Calendar.DAY_OF_YEAR); i++) {
			
			String name = String.format("%tF", c);
			System.out.println(name);
			
			//C:\\Users\\user\\git\\brobro\\JavaTest\\file\\일정
			File dir = new File("C:\\Users\\user\\git\\brobro\\JavaTest\\file\\일정" + name);
			dir.mkdir();
			
			c.add(Calendar.DATE, 1); //누적
			
		}
		
		
	}

	private static void m8() {

		//요구사항] 회원 > 회원명으로 개인 폴더 생성
		String[] member = {"홍길동", "아무개", "강아지", "고양이", "병아리"};
		String path = "C:\\Users\\user\\git\\brobro\\JavaTest\\file\\회원";
			
		for (String name : member) {
			
			
			//회원\[개인폴더]홍길동님
			//회원\[개인폴더]아무개님
			File dir = new File(path + "\\[개인폴더]" + name + "님");
			System.out.println(dir.mkdir());
			
		}
		
		
		
	}

	private static void m7() {
			
		//폴더 생성
//		String path = "C:\\Users\\user\\git\\brobro\\JavaTest\\file\\aaa";
//		File dir = new File(path);
//		
//		if (!dir.exists()) {
//			
//			boolean result = dir.mkdir(); //make directory
//			System.out.println(result);
//			
//		} else {
//			System.out.println("같은 이름의 폴더가 존재함");
//		}
		
	
		
		String path = "C:\\Users\\user\\git\\brobro\\JavaTest\\file\\ccc\\bbb\\aaa";
		File dir = new File(path);
		
		if (!dir.exists()) {
			
			boolean result = dir.mkdirs(); 	//make directories -> 경로 동안 모두 만들 수 있음 -> 이러면 경로 잘못된 거 모를 수 있음
			System.out.println(result);		
			
		} else {
			System.out.println("같은 이름의 폴더가 존재함");
		}
		

		
		
	}

	private static void m6() {
		
		
		//파일 삭제
		String path = "C:\\Users\\user\\git\\brobro\\JavaTest\\move\\회원.txt";
		File file= new File(path);
		
		if (file.exists()) {
		
			//보통 삭제: 휴지통이라는 폴더로 이동
			//자바 삭제: 완전 삭제
			boolean result = file.delete();
			System.out.println(result);
		}
		
		
	}

	private static void m5() {
		
		//파일 이동
		String path = "C:\\Users\\user\\git\\brobro\\JavaTest\\file\\member.txt";
		File file = new File(path);
		
		String path2 = "C:\\Users\\user\\git\\brobro\\JavaTest\\move\\회원.txt";//폴더를 바꾸면 폴더도 변화를 줌 -> 이동시켜줌 -> 한 번에 이름도 바꿀 수 있음
		File file2 = new File(path2);
		
		boolean result = file.renameTo(file2);//이름만 바꾸는게 아니라 이동할 때도 사용
		System.out.println(result);
		
		
		
	}

	private static void m4() {

		//파일명 수정
		//- memeber.txt > 회원.txt
		//- file.renameTo(file);

		String path = "C:\\Users\\user\\git\\brobro\\JavaTest\\file\\member.txt";
		File file = new File(path);
		
		String path2 = "C:\\Users\\user\\git\\brobro\\JavaTest\\file\\회원.txt";
		File file2 = new File(path2);
		
		boolean result = file.renameTo(file2);//이름바꾸기하면 이런식으로 실행
		System.out.println(result);
		
		  
		
		
	}

	private static void m3() {
			
		
		//파일 조작 > 생성, 복사, 이동, 파일명 수정, 삭제
		
		//새 파일 만들기
		String path = "C:\\Users\\user\\git\\brobro\\JavaTest\\file\\member.txt";
		
		File file = new File(path);
		
		//System.out.println(file.exists()); - false
		
		try {
			boolean result = file.createNewFile();
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	private static void m2() {
		
		//폴더 > 정보
		//- 클래스 이름 왜 File? -> 폴더는 파일이다.
		//- 식별자 없이 이름만 갖는 파일
		//- 비어있어서 크기는 0이라고 나옴
		
		
		//폴더 경로
		//- C:\class\code\java\file
		//- C:\class\code\java\file\
		//- https://naver.com
		//- https://naver.com/ 다들 비슷함 일단
		String path = "C:\\Users\\user\\git\\brobro\\JavaTest\\file";
		
		//폴더 참조 객체
		File dir = new File(path);
		
		if (dir.exists()) {
			
			System.out.println(dir.getName()); 			//data.txt
			System.out.println(dir.isFile());			//false
			System.out.println(dir.isDirectory());		//true
			System.out.println(dir.length());			//0, 4096(메타 데이터) -> 무시
			System.out.println(dir.getAbsolutePath());	//C:\Users\ user\git\brobro\JavaTest\file
			System.out.println(dir.lastModified());		//1735189807670 - 시간(ms)
			System.out.println(dir.isHidden());			//false -> 숨기면 true
			System.out.println(dir.canRead());			//true
			System.out.println(dir.canWrite());			//true -> 읽기전용이면 false
			System.out.println(dir.getParent());	 	//C:\Users\ user\git\brobro\JavaTest
						
			
		} else {
			System.out.println("폴더가 존재하지 않습니다.");
		}
		
	}

	private static void m1() {
		int a = 100; //스캐너 입력(학생 점수)
		
		//파일 > 정보
		//- C:\Users\\user\git\brobro\JavaTest\file\data.txt
	
		//자바 프로그램에서 외부 파일에 접근
		//1. 외부 파일을 참조하는 객체를 생성 > 중계인, 대리자
		//2. 참조 객체 조작 > 실제 파일 대상 진행
		
		String path = "C:\\Users\\user\\git\\brobro\\JavaTest\\file\\data.txt";
		
		//파일 참조 객체
		File file= new File(path);
		
		System.out.println(file != null);
		System.out.println(file);
		System.out.println(file.exists());//true일 떄만
		System.out.println();
		
		if (file.exists()) {
			
			System.out.println(file.getName()); 		//data.txt
			System.out.println(file.isFile());			//true
			System.out.println(file.isDirectory());		//false
			System.out.println(file.length());			//16byte
			System.out.println(file.getAbsolutePath());	//CC:\Users\ user\git\brobro\JavaTest\file\data.txt
			System.out.println(file.lastModified());	//1735189376362 - 시간(ms)
	
			//Unix > 년월일시분초
			Calendar c1 = Calendar.getInstance();
			//c1.getTimeInMillis()
			c1.setTimeInMillis(file.lastModified());	//tick을 Calendar로 바꾸는 방법
			System.out.printf("%tF %tT\n", c1, c1);
			
			System.out.println(file.isHidden());		//false -> 숨기면 true
			System.out.println(file.canRead());			//true
			System.out.println(file.canWrite());		//true -> 읽기전용이면 false
			System.out.println(file.getParent());		//C:\Users\ user\git\brobro\JavaTest\file -> 파일의 경로(폴더)
			
			
			
		} else {
			System.out.println("Data.txt가 없습니다.");
		}
		
		
	}
	
}//class