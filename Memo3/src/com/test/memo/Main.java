package com.test.memo;

import java.util.Scanner;

import com.test.memo.repsitory.MemoDAO;
import com.test.memo.service.MemoService;
import com.test.memo.view.MemoView;

public class Main {
	
	//모든 기능 공통 > 파일 경로
	
	
	public static void main(String[] args) throws Exception {
		
		MemoDAO.load();
		
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		while (loop) {

			MemoView.mainMenu();
			
			String sel =scan.nextLine();
			
			if(sel.equals("1")) {//공통코드 다 같이
				//메모쓰기
				MemoService.add();
				MemoView.pause();
			} else if (sel.equals("2")) {
				//메모읽기(목록보기)
				MemoService.read();
				MemoView.pause();
			} 
			
			else {
				//종료
				loop = false;
			}//if
			
		}//while
		
		MemoView.end();
		
		MemoDAO.save();// 중간에 날려먹는거 방지할려면 쓰고나서 저장하게 여러번 해도 됨
				// 대신 그만큼 비용이 늘어남 -> 밸런스 잘 맞추자
		
	}//main
	

}//class
