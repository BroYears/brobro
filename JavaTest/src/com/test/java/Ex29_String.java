package com.test.java;

import java.util.Scanner;

public class Ex29_String {

		public static void main(String[] args) {
			
			//문자열, String
			//1. 문자열의 세부 내용
			//2. 문자열 조작 > JDK 제공
			//String == char[]
			//
			
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
			//m14();
			m15();
			
		}//main

		private static void m15() {
			
			
			//문자열 분리
			//- String[] split(String delimiter)
			String txt = "홍길동■아무,개■하하하■호호호■후후후🙂";
			
			//"홍길동,아무,개,하하하,호호호,후후후" > CSV(comma seperated value)
			
			//문자표 > 자음 + 오른쪽 Ctrl
			//이모지 > win + .
			
			String[] list = txt.split("■"); //구분자는 사라짐
											//|로 하면 이상하게 나옴 다 쪼개버려
			for (int i=0; i<list.length; i++) {
				System.out.printf("%d: %s\n", i, list[i]);
			}
			
			
		}

		private static void m14() {
			
			//문자열 치환(바꾸기)
			//- String replace(char old, char new)
			//- String replace(String old, Sting new)
			
			String txt = "안녕하세요. 홍길동입니다.";
			System.out.println(txt.replace("홍길동", "아무개"));
			
			String content = "게시판 글쓰기입니다. 바보~";
			String stop = "바보";
			
			//System.out.println("게시판 글쓰기입니다. **~");
			//masking, masked text
			System.out.println(content.replace("바보", "**"));
			
			txt = "    하나    둘    셋    ";
			System.out.println(txt.trim());
			System.out.println(txt.replace(" ", ""));//빈 문자열 넣으면 삭제
			System.out.println(txt.replace("하나", ""));//빈 문자열 넣으면 삭제
			
			txt = "오늘은 자바 메서드 수업입니다.";
			String word = "자바메서드";
			
			if(txt.replace(" ","").contains(word.replace(" ", ""))) {
				System.out.println("O"); 		
			} else {
				System.out.println("x");
			}
			
		}

		private static void m13() {
			
			//문자열 검색
			//- int indexOf()
			//- int lastIndexOf()
			//- boolean contains(String s)
			
			String txt = "안녕하세요. 홍길동입니다.";
			
			if (txt.indexOf("홍길동") > -1) {
				System.out.println("0");
			}
			
			if (txt.contains("홍길동")) {
				System.out.println("0");
			}
		}

		private static void m12() {
			//문자열 추출 (*****)
			//- char charAt(int index)
			
			//- String substring(int beginIndex, int endInede)
			//- String substring(int beginIndex)
			//- beginIndex: 포함
			//- endIndex: 미포함
			
			//			  0 1 2 3 4 5  6 7 8 9
			String txt = "가나다라마바사아자차카타파하";
			
			//Parameters:
			//- begin
			
			System.out.println(txt.substring(3, 7));//라마바사
			System.out.println(txt.substring(3));
			
			System.out.println(txt.charAt(3)); //'라'
			System.out.println((int)txt.charAt(3));
			
			System.out.println(txt.substring(3, 4));//"라"
			System.out.println((int)txt.substring(3, 4).charAt(0));
			System.out.println();
			
			String jumin = "971217-1234567";
			
			//성별?
			System.out.println(jumin.charAt(7) == '1' ? "남자" : "여자");
			System.out.println(jumin.substring(7, 8).equals("1") ? "남자" : "여자");
			
			//몇년생?
			System.out.println("" + jumin.charAt(0) + jumin.charAt(1)); //'9' + '7' -> 문자 코드값 정수 더하기
			System.out.println(jumin.substring(0, 2));
			
			//몇월생?
			System.out.println(jumin.substring(2, 4));
			
			//몇일생?
			System.out.println(jumin.substring(4, 6));
			System.out.println();
			
			//수업 중 예제
			//- C:\class\code\java\JavaTest\src\Ex29_String.java
			
			String path = "C:\\class\\code\\java\\JavaTest\\src\\Ex29_String.java";//복붙하면 알아서 이스케이프해줌
			
			//1. 파일명 추출 > Ex29_String.java
			// - 파일명으로는 \가 안됨
			int index = path.lastIndexOf("\\");
			String filename = path.substring(index + 1);
			System.out.println("파일명: " + filename);
			
			//2. 파일명 > 확장자 없는 파일명 추출 > Ex29_String
			index = filename.lastIndexOf(".");
			String filenameWithoutExtension = filename.substring(0, index);
			System.out.println("순수 파일명: " + filenameWithoutExtension);
			
			//3. 확장자만 추출 > .java
			String extension = filename.substring(index);
			System.out.println("확정자: " + extension);
			
			
			
		}

		private static void m11() {
			//문자열 검색(*****)
			//- 문자열내에서 원하는 문자(열)을 검색 > 발견된 위치(index) 반환
			//- int indexOf(char c) 
			//- int indexOf(String s) > indexOf(String s, 0);
			//- int indexOf(char c, int beginIndex)
			//- int indexOf(String s, int beginIndex)
			
			//- 문자열내에서 원하는 문자(열)을 검색 > 발견된 위치(index) 반환
			//- int lastindexOf(char c) 
			//- int lastindexOf(String s) > indexOf(String s, 0);
			//- int lastindexOf(char c, int beginIndex)
			//- int lastindexOf(String s, int beginIndex)
			
			String txt = "안녕. 홍길동. 아무개. 하하하. 홍길동. 강아지";
			
			//왼쪽 오른쪽
			System.out.println(txt.indexOf("홍길동"));		//4
			System.out.println(txt.indexOf("홍길동",7));	//19
					
			//오른쪽 >> 왼쪽
			System.out.println(txt.lastIndexOf("홍길동")); 		//19
			System.out.println(txt.lastIndexOf("홍길동", 18));	//4
		}

		private static void m10() {
			
			//패턴 검색
			//- boolean startsWith(String word)
			//- boolean endsWith(String word)
			
			String input = "홍길동"
;			
			//이름 > '홍'씨 > boolean
			System.out.println(input.startsWith("홍"));
			System.out.println(input.charAt(0) == '홍');
			System.out.println(input.indexOf("홍") == 0);
			System.out.println();
			
			//'동'으로 끝나는지?
			System.out.println(input.endsWith("동"));
			System.out.println(input.charAt(input.length()-1) == '동');
			System.out.println(input.indexOf("동") == input.length() -1);
			
			//파일명? > 자바 소스인지? > 확정자 ".java"
			String filename = "Ex29_String.java";
			
			if (filename.toLowerCase().endsWith(".java")) {
				System.out.println("자바 파일");
			} else {
				System.out.println("다른 파일");
			}
			
			
		}

		private static void m9() {
			
			//문자열 대소문자 변경
			//- String toUpperCase()
			//- String toLowerCase()
			
			String content = "오늘 수업은 Java입니다.";
			String word = "java"; //검색어

//			System.out.println(content.toUpperCase());
//			System.out.println(content.toLowerCase());
//			System.out.println(word.toUpperCase());
//			System.out.println(word.toLowerCase());
			
			//대소문자 구분 x(case insensitive)
			//메서드 체이닝
			//- 문자열.메서드().메서드().메서드()
			//- 검색율 높음
			//- 
			if (content.toUpperCase().indexOf(word.toUpperCase()) > -1) {
				System.out.println("검색 결과 O");
			} else {
				System.out.println("검색 결과 X");
			}
			
			//대소문자 구분 o
			//오늘 수업은 JAVA입니다.
			//java
			if (content.indexOf(word) > -1) {
				System.out.println("검색 결과 O");
			} else {
				System.out.println("검색 결과 X");
			}
			
			
			
		}

		private static void m8() {
			
			//게시판 글쓰기 > 금지어!!
			
			String stop = "바보"; //금지어, 불용어 > Stop word
			String content = "안녕하세요. 저는 자바를 배우는 학생입니다.";
			
			if(content.indexOf(stop)> -1) {
				System.out.println("금지어 처리");
			} else {
				System.out.println("글쓰기 진행!!");
			}
			
			String[] stopList = { "바보", "멍청이", "메롱"};
			
			content = "안녕하세요. 바보야!! 저는 자바를 배우는 학생입니다.";
			
			for (int i=0; i<stopList.length; i++) {
				if (checkStopWord(stopList[i], content)){
					System.out.println("금지어 발견!!!");
					break;
				}
			}
			
			
		}

		
		
		private static boolean checkStopWord(String stop, String content) {
			
			if(content.indexOf(stop) > -1) {
				return true;
			}
			
			return false;
		}

		private static void m7() {
			//문자열 검색(*****)
			//- 문자열내에서 원하는 문자(열)을 검색 > 발견된 위치(index) 반환
			//- int indexOf(char c) 
			//- int indexOf(String s) > indexOf(String s, 0);
			//- int indexOf(char c, int beginIndex)
			//- int indexOf(String s, int beginIndex)
			
			
			//			  0 1 2 3 4 56 7 8 9 10111213
			String txt = "안녕하세요. 홍길동입니다.";
			
			int index = -1;//어떤 값? -> 알기 쉬운 범위 벗어난 값(오류값)
			
			index = txt.indexOf('하');
			System.out.println(index); //2 -> 2번째 문자에용
			
			index = txt.indexOf('홍');
			System.out.println(index);
			
			index = txt.indexOf('프');
			System.out.println(index);
			
			index = txt.indexOf("홍길동");
			System.out.println(index);
			
			txt = "안녕하세요. 홍길동입니다. 반갑습니다. 홍길동입니다. 안녕히가세요. 홍길동이었습니다.";
			
			index = txt.indexOf("홍길동");
			System.out.println(index);
			
			index = txt.indexOf("홍길동", index + "홍길동".length()); //뒤에는 찾기시작하는 자릿 수 
			System.out.println(index);
			
			index = txt.indexOf("홍길동", 25);
			System.out.println(index);
			
			
		}

		private static void m6() {
			
			
			//문자열 공백 제거
			//- String trim()
			//- 문자열에 존재하는 공백(Whitespace > 스페이스, 탭, 개행)을 제거하는 기능
			//- 문자열의 시작과 끝에 존재하는 공백만 제거
			//- 실수, 불필요한 좌/우 공백 제거
			
			String txt = "    하나    둘    셋    ";
			
			System.out.printf("[%s]\n", txt);
			System.out.printf("[%s]\n", txt.trim());
			
			System.out.println(" 자바".equals("자바"));
			
		}

		private static void m5() {
			// 유효성 검사 패턴
			// - 검사하는 구문을 별도의 메서드로 만드는 거 추천
			Scanner scan = new Scanner(System.in);
			
			System.out.print("단어: ");
			String word = scan.nextLine();
			
			if (checkLowerCase(word)) {
				System.out.println("올바른 단어");
			} else {
				System.out.println("올바르지 않은 단어");
			}
			
		}



		private static boolean checkLowerCase(String word) {
			
			for (int i=0; i<word.length(); i++) {
				char c = word.charAt(i);
				
				if (c < 'a' || c > 'z') {
					return false;
				}
			} 
			
			return true;
		}

		private static void m4() {
			
			//단어(아이디) 입력
			//- 영어 소문자만
			
			Scanner scan = new Scanner(System.in);
			
			System.out.print("단어: ");
			String word = scan.nextLine();
			
			//- java
			//- Java
			//- java2
			
			boolean result = false;
			
			for (int i=0; i<word.length(); i++) {
				
				char c = word.charAt(i);
				System.out.println(c);
				
//				if (c >= 'a' && c<= 'z') {
//					System.out.println("소문자 O");
//				} else {
//					System.out.println("소문자 X");
//				}
//				
				//*** 유효성 검사는 잘못된 것을 찾는 조건을 만든다.
				if (c < 'a' || c > 'z') {
					System.out.println("소문자 X");
					result = true;
					break;
				} 
								
				
			}//for
			
			
			if (!result) {
				System.out.println("올바른 단어");
			} else {
				System.out.println("올바르지 않은 단어");	
			}
			
		}

		private static void m3() {
			//주민등록번호 입력
			//ex) 971130-1234567
			
			Scanner scan = new Scanner(System.in);
			
			System.out.print("주민등록번호 입력('-' 필수): ");
			
			String jumin = scan.nextLine();
			
			if (jumin.charAt(6) == '-') {
				System.out.println("올바른 주민등록번호");
			} else {
				System.out.println("올바르지 않은 주민등록번호");
			}
			
			
		}

		private static void m2() {
			//문자열 추출
			//-char charAt(int index)
			//-문자열에서 원하는 위치의 문자를 추출
			
			//			 0 1 2 3 4 567 8 9 10111213
			String txt = "안녕하세요. 홍길동입니다.";
			
			char c = txt.charAt(0);
			System.out.println(c);
		
			c = txt.charAt(10);
			System.out.println(c);
			
			// java.lang.StringIndexOutOfBoundsException: Index 15 out of bounds for length 14
			//c = txt.charAt(15);
			//System.out.println(c);
			c = txt.charAt(txt.length() - 1);
			System.out.println(c);
			
			
			
			
		}

		private static void m1() {
			
			//문자열(참조형) 생성하기 > new 연산자(객체 생성 연산자) 사용
			//1. 리터럴("")
			//2. 객체 생성(new)
			
			String s1 = "홍길동";
			String s2 = new String("홍길동");
			
			System.out.println(s1);
			System.out.println(s2);
			System.out.println(s1.equals(s2));
			
			//문자열 길이
			//- int length()
			//- 문자 수
			//- char[] == 방개수
			
			String txt = "홍길동";
			System.out.println(txt.length());//글자 수
			System.out.println("홍길동".length());
			System.out.println("한글 AB CD1234!@#$#".length());//공백도 글자 - 코드 있음
			
			//요구사항] 사용자 입력 > 문자수 ?
			Scanner scan = new Scanner(System.in);
			
			System.out.print("문장: ");
			String statement = scan.nextLine();
			
			System.out.printf("%s >> %d문자\n", statement, statement.length());
			
			//유효성 검사
			//- 이름 입력
			//- 2자 ~ 5자 >> 서버 전송 >> 데이터베이스에 저장 >> 길면 오버플로우
			System.out.print("이름: ");
			String name = scan.nextLine();
			
			if (name.length() >= 2 && name.length() <= 5) {
				System.out.println("서버 전송");
			} else {
				System.out.println("이름을 2~5자 이내로 입력하세요");
			}
			
			
		}//m1
		
		
}
