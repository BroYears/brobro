package com.system.restaurant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.system.restaurant.domain.Main_Uodol;
import com.system.restaurant.domain.TodaysInfo;
import com.system.restaurant.employee.Admin;
import com.system.restaurant.view.MainScreen;

public class Main {

	public static String PATH = ".\\data\\예약\\예약 더미데이터.txt";
	public static ArrayList<String> days = new ArrayList<>();

	public static String today = ""; // 시작

	public static void main(String[] args) {

		Admin admin = new Admin();
		Main dayEndDayStart = new Main();
		Scanner scan = new Scanner(System.in);
		dayEndDayStart.loadDate();

		List<String> daysModify = days.stream().distinct().sorted((s1, s2) -> s1.compareTo(s2)).toList();

		for (String d : daysModify) {
			today = d;
			
			System.out.println();
			System.out.println("🙂 " + "오늘은 " + "[" + today + "]" + "입니다. 즐거운 하루 보내세요! 🌞");
			System.out.println();

			Main_Uodol uodol = new Main_Uodol();
			boolean result = uodol.helloMain();

			if(!result){
				return;
			}

			dayEndDayStart.pause(scan);
			
			System.out.println();
			System.out.println("Today : " + today);
			TodaysInfo.todaysInfo(today); //알림
			dayEndDayStart.pause(scan);

			admin.todo();
			
			MainScreen.mainScreenload(); //메뉴

			dayEndDayStart.pause(scan);

			System.out.println("Today : " + today);
			System.out.println("-오늘 하루 마감-");
			System.out.println("-오늘 진행시 Enter-");
			scan.nextLine();
		}
	}

	void pause(Scanner scanner){
		System.out.println("계속 하려면 enter");
		scanner.nextLine();
	}

	void loadDate() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(PATH));

			String line = null;
			try {
				while ((line = reader.readLine()) != null) {
					String[] temp = line.split(",");
					String time = temp[4].split(" ")[0];
					days.add(time);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
