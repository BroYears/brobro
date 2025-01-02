package com.test.memo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
	
	//모든 기능 공통 > 파일 경로
	private final static String PATH;
	
	static {
		PATH = ".\\data\\memo.txt";
	}
	
	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		while (loop) {
			System.out.println("===========");
			System.out.println("  메모장");
			System.out.println("===========");
			System.out.println("1. 메모쓰기");
			System.out.println("2. 메모읽기");
			//System.out.println("3. 메모수정");
			//System.out.println("4. 메모삭제");
			System.out.println("5. 종료");
			System.out.println("-----------");
			
			System.out.print("선택: ");
			String sel =scan.nextLine();
			
			if(sel.equals("1")) {//공통코드 다 같이
				//메모쓰기
				add();
				pause();
			} else if (sel.equals("2")) {
				//메모읽기(목록보기)
				read();
				pause();
			} 
			
//			else if (sel.equals("3")) {
//				//메모수정
//				edit();
//				pause();
//			} else if (sel.equals("4")) {
//				//메모삭제
//				remove();
//				pause();
//			} 
			
			else {
				//종료
				loop = false;
			}//if
			
		}//while
		
		System.out.println();
		System.out.println("메모장을 종료합니다.");
		
	}//main

	private static void pause() {

		Scanner scan = new Scanner(System.in);
		System.out.println();
		
		System.out.println("계속하려면 엔터를 입력하세요.");
		scan.nextLine();
		
		
	}

	private static void add() throws Exception {//업무 분담!

		//메모쓰기 > 순서?
		//1. 컨텍스트 > 제목 출력
		//2. 사용자에게 입력받음
		//3. 파일 쓰기
		
		//1.
		System.out.println("----------");
		System.out.println(" 메모쓰기");
		System.out.println("----------");
		
		//2.
		//1●홍길동●메모입니다.●2025-01-02 12:05:40
		Scanner scan = new Scanner(System.in);
		
		String name = "";
		String memo = "";
		
		System.out.print("이름: ");
		name = scan.nextLine();
		
		System.out.print("메모: ");
		memo = scan.nextLine();
		
		//3.
		Calendar now = Calendar.getInstance();
		String regdate = String.format("%tF %tT", now, now);
		
		String seq = getMaxSeq();
		//System.out.println(seq);
		
		//파일 쓰기 > memo.txt > 새로운 메모를 추가
		BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, true));
		
		//1●홍길동●메모입니다.●2025-01-02 12:05:40
		writer.write(String.format("%s●%s●%s●%s\r\n" 
								, seq, name, memo, regdate));
		
		writer.close();
		
		System.out.println();
		System.out.println("메모쓰기가 완료되었습니다.");
		
	}

	private static String getMaxSeq() throws Exception {
		
		//파일읽기 > memo.txt > 마지막 메모의 seq + 1 반환
		BufferedReader reader = new BufferedReader(new FileReader(PATH));
		
		String line = null;
		String temp = null;
		
		while ((line = reader.readLine()) != null) {
			//System.out.println(line);
			temp = line; 
		}
		
		//System.out.println(temp);
		
		//3●홍길동●메모장 만드는중~●2025-01-02 12:07:25
		reader.close();
		
		//새로운 메모의 번호
		return Integer.parseInt(temp.split("●")[0]) + 1 + "";
	}

	private static void read() throws Exception{
		
		//메모읽기 > 순서?
		//1. 컨텍스트 > 제목 출력
		//2. 파일읽기
		//3. 출력
		
		//1.
		System.out.println("----------");
		System.out.println(" 메모쓰기");
		System.out.println("----------");
		
		System.out.println();
		System.out.println("[번호]\t[이름]\t[날짜]\t\t\t[메모]");
		
		//2.
		BufferedReader reader = new BufferedReader(new FileReader(PATH));
		
		String line = null;
		
		while ((line = reader.readLine()) != null) {
			//3.
			// line = "1●홍길동●메모입니다.●2025-01-02 12:05:40"
			String[] temp = line.split("●");
			
			//System.out.println(Arrays.toString(temp));
			System.out.printf("%s\t%s\t%s\t%s\r\n"
									, temp[0]
									, temp[1]
									, temp[3]
									, temp[2]);
		}
	
		reader.close();
		
		System.out.println();
		System.out.println("메모읽기가 완료되었습니다.");
		//메모 읽기 > 선택(수정, 삭제 , 귀환)
		
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.print("선택(1.수정,2.삭제,3.메뉴): ");
		
		String sel = scan.nextLine();
		
		if (sel.equals("1")) {
			edit();
			pause();
		} else if (sel.equals("2")) {
			remove();
			pause();
		} else {
			//메인메뉴로 이동
		}
		
		
	}//read

	private static void edit() throws Exception {
		
		//메모수정 > 순서?
		//1. 컨텍스트 > 제목 출력
		//2. 사용자 > 수정 메모 번호 입력
		//3. 파일읽기(선택 메모)
		//4. 출력(기존 내용)
		//5. 수정내용 > 입력
		//6. 파일수정
		
		Scanner scan = new Scanner(System.in);
		
		//1.
		System.out.println("-----------");
		System.out.println(" 메모수정");
		System.out.println("-----------");
		System.out.println("수정을 원하지 않는 값은 그냥 엔터를 입력하세요.");
		
		//2.
		System.out.print("번호: ");
		String seq = scan.nextLine();
		
		//5.
		//1●홍길동●메모입니다.●2025-01-02 12:05:40
		String name = "";
		String memo = "";
		
		System.out.print("이름: ");
		name = scan.nextLine();//name = "";
		
		System.out.print("메모: ");
		memo = scan.nextLine();//name = "";
		
		//Calendar now = Calendar.getInstance();
		//String regdate = String.format("%tF %tT", now, now);
		
		
		//6.
		//파일 입출력 > 쓰기O, 읽기O, 내용수정하기X, 내용삭제하기X
		//						- 원래 수정하기, 삭제하기라는 건 없음 -> 쓰기
		//						- 하나만 수정해도 원래 전체 덮어쓰기하는 것
		//						- Append는 원래 중간에 삽입이 안됨 -> Create모드 -> 수정하기 때문에
		BufferedReader reader = new BufferedReader(new FileReader(PATH));//reader 닫히고 writer 써야됨
		
		String line = null;
		String editText = "";//누적변수
		
		while ((line = reader.readLine()) != null) {
			String[] temp = line.split("●");
			String temp2 = "";
			
			if (temp[0].equals(seq)) {
				//수정대상 메모
				temp2 += temp[0];
				temp2 += "●";
				
				if (name.equals("")) {
					temp2 += temp[1];//수정안함
				} else {
					temp2 += name;//수정함
				}
				temp2 += "●";	
				
				if (memo.equals("")) {
					temp2 += temp[2];
				} else {
					temp2 += memo;
				}
				
				temp2 += "●";
				temp2 += temp[3];
				temp2 += "\r\n";
				
				
			} else {
				
				//상관없는 메모
				temp2 = line + "\r\n";
				
				
			}
			
			//System.out.println(temp2);
			editText += temp2;
		}
		
		reader.close();
		
		//기존 > 덮어쓰기 > 새로운 수정 내용
		BufferedWriter writer = new BufferedWriter(new FileWriter(PATH));
		
		writer.write(editText);
		
		writer.close();
	}

	private static void remove() throws Exception {
		
		//메모삭제 > 순서?
		//1. 컨텍스트 > 제목 출력
		//2. 번호 입력
		//3. 파일읽기 > 2번에 메모만 제외 > 나머지 내용 > 파일쓰기
		
		Scanner scan = new Scanner(System.in);
		
		//1.
		System.out.println();
		System.out.println("-----------");
		System.out.println(" 메모삭제");
		System.out.println("-----------");
		
		//2.
		System.out.print("번호: ");
		String seq = scan.nextLine();
		
		//3.
		BufferedReader reader = new BufferedReader(new FileReader(PATH));//reader 닫히고 writer 써야됨
		
		String line = null;
		String editText = "";//누적변수
		
		while ((line = reader.readLine()) != null) {
			String[] temp = line.split("●");
			
			if(temp[0].equals(seq)) {
				//삭제 할 메모
			} else {
				//보존 할 메모
				editText += line + "\r\n";
			}
		}//while
		
		reader.close();
		
		//기존 > 덮어쓰기 > 새로운 수정 내용
		BufferedWriter writer = new BufferedWriter(new FileWriter(PATH));
		
		writer.write(editText);
		
		writer.close();
		
	}

}
