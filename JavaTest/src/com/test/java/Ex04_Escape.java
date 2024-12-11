package com.test.java;

public class Ex04_Escape {
	
	public static void main(String[] args) {
		
		//특수문자 -> Escape Sequence
		//- 컴파일러가 번역 할 때, 특정 문자를 그대로 출력 x, 미리 약속된 표현으로 바꿔서 출력하는 요소
		
		//1. \n -> 한 글자 취급
		//- new line, line feed
		//- 개행문자(=엔터)
		
		char c1 = '\n';
		String s1 = "\n";
		
		//요구사항] "안녕하세요. 홍길동입니다." 출력하세요.
		//수정사항] "안녕하세요."과 "홍길동입니다" 각각 다른 줄에 출력하세요.
		String msg = "안녕하세요.\n\n\n홍길동입니다."; //문자열은 개행 불가 -> \n 사용
		System.out.println(msg);
		
		//A
		//System.out.println(20);
		
		//B
        //int age = 20;
        //System.out.println(age);
		
		System.out.println();//비게 만들면 엔터 공간 만들어줌
		
		System.out.println(100);
		
		//2. \r
		//- carriage return
		//- 캐럿의 위치를 현재 라인의 맨 앞으로 이동
		//- 키보드 -> home
		
		msg = "안녕하세요\r홍길동";//원래는 삽입이 아니라 덮어쓰기라 엔터처럼 보임(이클립스라서) but 터미널에서는 정상 작동
		System.out.println(msg);
		
		//엔터
		//- \r\n -> 정식 엔터 but \n으로도 가능 -> 뜯어보면 \r\n으로 입력 돼있음. -> 운영체제마다 다름

		
		
		//3. \t
		//- 탭문자, tab
		//- 탭이 뭐에요? -> 4칸씩 띄는 것 (O and X)
		//- |	|	|	|현재 캐럿에서 가장가까운 탭으로 이동
		//	탭	탭	탭	탭
		//- 출력 시 열 맞추기
		//- 입출력 -> 편집기에 존재
		//- 브라우저 -> Viewer -> 탭이 존재 x
		msg = "하나 둘		셋";//띄어쓰기인지 탭인지 모름
		System.out.println(msg);
		
		msg = "하나 둘\t\t셋";//가독성 향상
		System.out.println(msg);
		
		
		//4. /b
		//- backspace -> 옛날에는 그냥 캐럿만 옮김 -> 지우려면 옮기고 delete했어야 함
		msg = "홍길동\b입니다.";//홍길입니다.
		System.out.println(msg);
		
		
		//5. \",\',\\
		//- 이미 역할이 있는 문자를 역할이 없게 만드는 작업
		
		//요구사항] 화면 -> 홍길동 : "안녕하세요."
		System.out.println("홍길동 : \"안녕하세요.\"");
		
		//요구사항] 수업 폴더의 경로를 출력하세요.
		//C:\class\code\java
		
		System.out.println("C:\\class\\code\\java");//->\자체도 특수문자로 이해, \를 무효하는 것도 \역할
		//c:\test
		System.out.println("C:\test");//-> \t만 있으면 그걸 인식해버림
		System.out.println("C:\\test");
		
		
	}

}
