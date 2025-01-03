package com.test.memo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
	
	//모든 기능 공통 > 파일 경로
	private final static String PATH;
	
	//memo.txt > (대신) > 컬렉션
	private static ArrayList<Memo> mlist;
	
	static {
		PATH = ".\\data\\memo.txt";
		mlist = new ArrayList<>();
	}
	
	public static void main(String[] args) throws Exception {
		
		load();
		//System.out.println(mlist);
		
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
			String sel = scan.nextLine();
			
			if (sel.equals("1")) {
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
		
		save();
		
	}//main

	private static void save() throws Exception {
		
		//ArrayList<Memo> > memo.txt
		BufferedWriter writer = new BufferedWriter(new FileWriter(PATH));
		
		for (Memo memo : mlist) {
			
			//Memo 객체
			//line = "1●홍길순●수정된 메모입니다.●2025-01-02 12:05:40"
			writer.write(String.format("%s●%s●%s●%s\r\n"
							, memo.getSeq()
							, memo.getName()
							, memo.getMemo()
							, memo.getRegdate()));
			
		}
		
		writer.close();	
		
	}

	private static void load() throws Exception {
		
		//memo.txt > ArrayList<Memo>
		BufferedReader reader = new BufferedReader(new FileReader(PATH));
		
		String line = null;
		
		while ((line = reader.readLine()) != null) {
			
			//line = "1●홍길순●수정된 메모입니다.●2025-01-02 12:05:40"
			// > Memo 객체
			String[] temp = line.split("●");
			
			Memo memo = new Memo(temp[0], temp[1], temp[2], temp[3]);
			mlist.add(memo);
			
		}
		
		reader.close();
		
	}

	private static void pause() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println();
		
		System.out.println("계속하려면 엔터를 입력하세요.");
		scan.nextLine();
		
	}

	private static void add() throws Exception {
		
		//메모쓰기 > 순서?
		//1. 컨텍스트 > 제목 출력
		//2. 사용자에게 입력
		//3. 파일쓰기
		
		//1.
		System.out.println("-----------");
		System.out.println("  메모쓰기");
		System.out.println("-----------");
		
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
		
		//이전: 파일쓰기 > memo.txt > 새로운 메모를 추가
		//현재: 컬렉셜에 Memo 객체를 추가하기 > 새로운 메모를 추가
		mlist.add(new Memo(seq, name, memo, regdate));
		
		System.out.println();
		System.out.println("메모쓰기가 완료되었습니다.");
		
	}

	private static String getMaxSeq() throws Exception {
		
		return Integer.parseInt(mlist.get(mlist.size()-1).getSeq()) + 1 + "";
	}

	private static void read() throws Exception {
		
		//메모읽기 > 순서?
		//1. 컨텍스트 > 제목 출력
		//2. 파일읽기
		//3. 출력
		
		//1.
		System.out.println("-----------");
		System.out.println("  메모읽기");
		System.out.println("-----------");
		
		System.out.println();
		System.out.println("[번호]\t[이름]\t[날짜]\t\t\t[메모]");
		
		//2.
		for (Memo memo : mlist) {
			System.out.printf("%s\t%s\t%s\t%s\r\n"
								, memo.getSeq()
								, memo.getName()
								, memo.getRegdate()
								, memo.getMemo());
		}
		
		System.out.println();
		System.out.println("메모읽기가 완료되었습니다.");
		
		//메모읽기 > 선택(수정,삭제,귀환)
		
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
			//메인메뉴로 이동~
		}
		
	}//read()

	private static void edit() throws Exception {
		
		//메모수정 > 순서?
		//1. 컨텍스트 > 제목 출력
		//2. 사용자 > 수정 메모 번호 입력
		//3. 파일읽기(선택 메모)
		//4. 출력(기존내용)
		//5. 수정내용 > 입력
		//6. 파일수정
		
		Scanner scan = new Scanner(System.in);
		
		//1.
		System.out.println();
		System.out.println("-----------");
		System.out.println("  메모수정");
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
		name = scan.nextLine(); //name = "";
		
		System.out.print("메모: ");
		memo = scan.nextLine(); //memo = "";
		
		//Calendar now = Calendar.getInstance();
		//String regdate = String.format("%tF %tT", now, now);
		
		//6.
		//수정할 메모 찾기
		for (Memo m : mlist) {
			
			if (m.getSeq().equals(seq)) {
				
				//수정하려는 메모?
				if (!name.equals("")) {
					m.setName(name);
				}
				
				if (!memo.equals("")) {
					m.setMemo(memo);
				}
				
			}
			
		}
		
		
	}

	private static void remove() throws Exception {
		
		//메모삭제 > 순서?
		//1. 컨텍스트 > 제목 출력
		//2. 번호 입력
		//3. 파일읽기 > 2번 메모만 제외 > 나머지 내용 > 파일쓰기
		Scanner scan = new Scanner(System.in);
		
		//1.
		System.out.println();
		System.out.println("-----------");
		System.out.println("  메모삭제");
		System.out.println("-----------");

		//2.
		System.out.print("번호: ");
		String seq = scan.nextLine();
		
		//3.
		for (Memo memo : mlist) {
			if (memo.getSeq().equals(seq)) {
				mlist.remove(memo);
				break;
			}
		}
		
	}

}






























