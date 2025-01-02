package com.test.memo.view;

import java.util.Scanner;

import com.test.memo.domain.Memo;
import com.test.memo.repsitory.MemoDAO;

public class MemoView {

	public static void mainMenu() {
		System.out.println("===========");
		System.out.println("  메모장");
		System.out.println("===========");
		System.out.println("1. 메모쓰기");
		System.out.println("2. 메모읽기");
		System.out.println("5. 종료");
		System.out.println("-----------");
		
		System.out.print("선택: ");
	}
	
	public static void pause() {

		Scanner scan = new Scanner(System.in);
		System.out.println();
		
		System.out.println("계속하려면 엔터를 입력하세요.");
		scan.nextLine();
		
		
	}

	public static void end() {
		
		System.out.println();
		System.out.println("메모장을 종료합니다.");
		
	}

	public static void subMenu(String title) {
		
		System.out.println("----------");
		System.out.println("  " + title);
		System.out.println("----------");
		
	}

	public static void list() {
		
		System.out.println();
		System.out.println("[번호]\t[이름]\t[날짜]\t\t\t[메모]");
	

		for (Memo memo: MemoDAO.mlist) {
		
			System.out.printf("%s\t%s\t%s\t%s\r\n"
							, memo.getSeq()
							, memo.getName()
							, memo.getRegdate()
							, memo.getMemo());//여기까지는 메모리에만 저장해서 실행끄면 날아감 -> 동기화 필요
		}
	}
	
	
	
	
}
