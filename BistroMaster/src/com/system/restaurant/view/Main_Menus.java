package com.system.restaurant.view;
import java.util.Scanner;

public class Main_Menus {
	private final static String PASSWORD = "123456"; 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println();
        String text1 = "우돌_삼겹살";
        printThickTextBox(text1, 11);
        System.out.println();
        
        String text2 = "환영합니다";
        System.out.print("관리자 코드 입력 : ");
		String code = scan.nextLine();
		String replaceCode = "";
		for (int i = 0; i < code.length(); i++) {
			replaceCode += "*";
		}
		 
		System.out.println();
		
		printThickTextBox(text2 + " : " + replaceCode, 11);
		
		if(!code.equals(PASSWORD)) {
			System.err.println("잘못 입력 하셨습니다~");
		}
		
		
       
    }

    public static void printThickTextBox(String text, int num) {
        int width = text.length() + num;
        System.out.println("╔" + "═".repeat(width - 2) + "╗");;
        System.out.println("║  " + text + "  ║");
        System.out.println("╚" + "═".repeat(width - 2) + "╝");
    }

}
