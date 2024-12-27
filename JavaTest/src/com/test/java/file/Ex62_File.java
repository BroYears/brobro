package com.test.java.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Ex62_File {

	
	public static void main(String[] args) {
		
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		//m8();
		m9();
		//m10();
		
		
	}//main

	private static void m10() {
		
		File file = new File(".\\data\\score.txt");
		
		try {
			
			Scanner scan = new Scanner(file);
		
//			String line = scan.nextLine();
//			System.out.println(line);
				
			
			
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				System.out.println(line);
			}
							
			scan.close();//안하면 가끔 꼬여서 안꺼지고 끄지도못하는 상황 발생 할 수 있음 	
			
		} catch(Exception e ) {
			e.printStackTrace();
		}
		
	}

	private static void m9() {

		//성적표
		//- 성적 데이터 > score.txt, score.dat
		
		//데이터 구조 설계(*****) > 데이터베이스 구조 설계(ERD)
		//- 데이터 수집 > 무슨 데이터 사용 or 저장
		//				> 이름, 국어, 영어, 수학, 총점, 평균
		//- 데이터 구조화
		//	- CSV
		//		- 한줄 > 1개의 데이터 집합
		//		- 한 줄 내의 구분자(,) > 각 세부 데이터 저장
		//- 더미 or 테스트용 데이터 생성
		
		System.out.println("====================================================================================");
		System.out.println("                                     성적표");
		System.out.println("====================================================================================");
		System.out.println("[번호]\t[이름]\t[국어]\t[영어]\t[수학]\t[총점]\t[평균]");
		
		try {
			
			//자원 경로
			//1. 절대 경로 > 기준점 고정(우리가 쓰던 거)
			//2. 상대 경로 > 내가 있는 위치를 기준점(".")
			
			File dir = new File(".\\data\\score.txt");
			System.out.println(dir.getAbsolutePath());
		
			ArrayList<Score> list = new ArrayList<Score>();
			
			
			BufferedReader reader = new BufferedReader(new FileReader(".\\data\\score.txt"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				//System.out.println(line);
				//1,홍길동,100,90,80 > 파싱(parse)
				
				String[] temp = line.split(",");
				
				String no = temp[0];
				String name = temp[1];
				int kor = Integer.parseInt(temp[2]);
				int eng = Integer.parseInt(temp[3]);
				int math = Integer.parseInt(temp[4]);
				
				//1회전 == 텍스트 1줄 == 한 사람 == Score 객체 1개
				Score s = new Score(no, name, kor, eng, math);
				list.add(s);
				
				
				
//				int total = kor + eng + math;
//				double avg = total / 3.0;
//				
//				System.out.printf("%5s\t", no);
//				System.out.printf("%s\t", name);
//				System.out.printf("%5d\t", kor);
//				System.out.printf("%5s\t", eng);
//				System.out.printf("%5s\t", math);
//				System.out.printf("%5s\t", total);
//				System.out.printf("%5.1f\r\n", avg);
								
			}//while
			
			reader.close();
			
			//System.out.println(list);
			//성적순으로 정렬
			Collections.sort(list, new Comparator<Score>() {

				@Override
				public int compare(Score o1, Score o2) {
					
					return o2.getTotal() - o1.getTotal();
				}
			});
			
			//출력
			for (Score s: list) {
				System.out.printf("%5s\t", s.getNo());
				System.out.printf("%s\t", s.getName());
				System.out.printf("%5d\t", s.getKor());
				System.out.printf("%5s\t", s.getEng());
				System.out.printf("%5s\t", s.getMath());
				System.out.printf("%5s\t", s.getTotal());
				System.out.printf("%5.1f\r\n", s.getAvg());
			}
						
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	private static void m8() {
		
		try {
			
			Scanner scan = new Scanner(System.in);
			System.out.print("파일명: ");
			String filename = scan.nextLine();
			
			String path = "C:\\Users\\user\\git\\brobro\\JavaTest\\src\\com\\test\\java\\" + filename;
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			String line = null;
			int number = 1; //줄번호
			
			while ((line = reader.readLine())!= null) {
				System.out.printf("%3d: %s\r\n", number,  line);
				number++;
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m7() {

		try {
			
			//파일 쓰기 > FileWriter or BufferedWriter
			//파일 읽기 > BufferedReader or Scanner
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//
			BufferedReader reader2 = new BufferedReader(new FileReader("C:\\Users\\user\\git\\brobro\\JavaTest\\file\\data2.txt"));

			//reader2.read()
//			String line = reader2.readLine();
//			System.out.println(line);
//			
//			line = reader2.readLine();
//			System.out.println(line);
//			
//			line = reader2.readLine();
//			System.out.println(line);
//			
			String line = null;
			
			while ((line = reader2.readLine()) != null) {
				System.out.println(line);
			}
			
			reader2.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m6() {
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\user\\git\\brobro\\JavaTest\\file\\data2.txt"));
			
			writer.write("안녕하세요.");
			writer.newLine(); //write(\r\n)
			writer.write("홍길동입니다.");
						
			writer.close();
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

	private static void m5() {
		
		try {
			
			//FileOutputStream - FileInputStream
			//FileWrieter - FileReader
			//.read -> 문자열 못읽음 
			//BufferedWriter - BufferedReader (Buffer -> 중간 임시 공간)
			
			//FileReader
			//- 문자 단위 읽기(2byte)
			FileReader reader = new FileReader("C:\\Users\\user\\git\\brobro\\JavaTest\\file\\data2.txt");
			
			int code = -1;
			
			while ((code = reader.read()) != -1) {
				System.out.print((char)code);
			}//문자열 못읽어서 반복문으로 다 읽기
			
			code = reader.read();
			System.out.println((char)code);
			
			reader.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}

		
		
	}

	private static void m4() {
		
		
		//콘솔 메모장 구현(쓰기)
		//콘솔은 약간 불편 자바는 특히 불편
		try {
			
			Scanner scan = new Scanner(System.in);
		
			System.out.print("저장할 파일명: ");
			String filename = scan.nextLine();
		
			FileWriter writer = new FileWriter("C:\\Users\\user\\git\\brobro\\JavaTest\\file\\" + filename, true);
			
			boolean loop = true;
			
			while (loop ) {
				String line = scan.nextLine();
				
				if(line.equals("q!")) {
					break;					
				}
			  	writer.write(line);
				writer.write("\r\n");
			}
			
			writer.close();
			
			System.out.println("파일 저장이 완료되었습니다");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void m3() {
		
		
		//파일 쓰기
		//- 좀 더 세련되게
		//FileOutputStream > FileWriter
		//1. 문자 단위 쓰기(2byte) > 한글 편하게
		//2. 문자열 쓰기 지원
		
		try {
			
			FileWriter writer = new FileWriter("C:\\Users\\user\\git\\brobro\\JavaTest\\file\\data2.txt", true);//다이렉트로 경로 적는 거 가능
			
			writer.write("\r\n아파트");
			
			writer.close();
			
			System.out.println("종료");
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private static void m2() {

		//파일 입출력
		//- 파일 읽기(입력)
		
		String path = "C:\\Users\\user\\git\\brobro\\JavaTest\\file\\data.txt";
		
		File file = new File(path);
		
		try {
			
			//읽기 스트림
			FileInputStream stream = new FileInputStream(file);
//			
//			int code = stream.read();
//			System.out.println((char)code);
//			
//			
//			code = stream.read();
//			System.out.println((char)code);
//			
//			code = stream.read();
//			System.out.println((char)code);
//			
//			code = stream.read();
//			System.out.println((char)code);
//			
//			code = stream.read();
//			System.out.println((char)code);
//			
//			code = stream.read();
//			System.out.println((char)code);
//			
//			code = stream.read();
//			System.out.println((char)code);
//			
//			code = stream.read();
//			System.out.println(code);//문자가 없으면 -1이 찍히는데 char 불가라 안보임 
			
			
			//패턴
			int code = -1;
			
			while ((code = stream.read()) != -1) {
				System.out.print((char)code);
			}
			
			stream.close();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m1() {
		
		//파일 입출력
		//- 파일 쓰기(출력)
		
		String path = "C:\\Users\\user\\git\\brobro\\JavaTest\\file\\data.txt";
		
		File file = new File(path);
		
		//스트림 생성
		//- 읽기 스트림
		//- 쓰기 스트림
		//	쓰기 스트림 생성 모드
		//	1. Create Mode(기본값) -> 훨씬 더 많이 씀
		//		- 기존 내용을 없애고 새로운 내용으로 덮어쓰기
		//		- 파일이 있으면 덮어쓰기, 없으면 생성 후 쓰기 작업 진행
		//	2. Append Mode
		//		- 기존 내용에 이어서 새로운 내용을 추가하기
		//		- 파일이 없으면
		
		
		//- 양방향 있기는 함 -> 복잡하고 성능이 별로
		
		try { 
		
			//스트림 (객체) 생성 or 스트림 열었다
			FileOutputStream stream = new FileOutputStream(file, true);//1byte단위 쓰기만 지원 -> 한글작업 할 때 잘 안씀(깨져용)
		
//			stream.write((int)'A'); //문자코드 적으세요
//			stream.write('B'); //문자코드 적으세요
//			stream.write('C'); //문자코드 적으세요
			
			String txt = "\r\n홍길동!!!";//
			
			for (int i=0; i<txt.length(); i++) {
				char c = txt.charAt(i);
				stream.write(c);
			}
			
			stream.close(); //꼭 해야되는 작업
			
			System.out.println();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}//class















