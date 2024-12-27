package com.test.java.ex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Q120_ChangeName {

	public static void main(String[] args) {
		
		String path1 = "C:\\Users\\user\\git\\brobro\\파일 입출력 문제\\이름수정.dat";
		File file1 = new File(path1);
		
		String path2 = "C:\\Users\\user\\git\\brobro\\파일 입출력 문제\\이름수정_변환.dat";
		File file2 = new File(path2);
		
		file1.renameTo(file2);
		
		FileReader reader;
		
		
		try {
			
			reader = new FileReader("C:\\Users\\user\\git\\brobro\\파일 입출력 문제\\이름수정_변환.dat");
			
			int code = -1;
			String txt = "";
			
			while ((code = reader.read()) != -1) {
			
				System.out.print((char)code);
				
				if ((char)code == '유') {
					if ((char)code == '재') {
						if ((char)code == '석') {
							
							
						}
					}
				}
				
			}//문자열 못읽어서 반복문으로 다 읽기
			
			
			reader.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
