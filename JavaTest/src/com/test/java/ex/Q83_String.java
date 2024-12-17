package com.test.java.ex;

import java.util.Scanner;

public class Q83_String {

	public static void main(String[] args) {
		
		fileName();
		
	}//main

	
	private static void fileName() {

		int mp3 = 0;
		int jpg = 0;
		int java = 0;
		int hwp = 0;
		int doc = 0;
		String name = "";
		
		Scanner scan = new Scanner(System.in);
		
		for (int i=0; i<10; i++) {
			System.out.print("파일명: ");
			name = scan.nextLine();
			
			if (name.indexOf("mp3") > -1 ) {
				mp3 ++;								
			} else if (name.indexOf("jpg") > -1 ) {
				jpg ++;
			} else if (name.indexOf("java") > -1 ) {
				java ++;
			} else if (name.indexOf("hwp") > -1 ) {
				hwp ++;
			} else if (name.indexOf("doc") > -1 ) {
				doc ++;
			}
					
		}//for
		
		System.out.printf("mp3: %d개\n", mp3);
		System.out.printf("jpg: %d개\n", jpg);
		System.out.printf("java: %d개\n", java);
		System.out.printf("hwp: %d개\n", hwp);
		System.out.printf("doc: %d개\n", doc);

		
		
	}//fileName
	
}
