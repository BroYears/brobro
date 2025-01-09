package com.test.memo.repsitory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.test.memo.domain.Memo;

//데이터 담당
public class MemoDAO {

	//memo.txt > (대신) > 컬렉션
	public static ArrayList<Memo> mlist;
	private final static String PATH;
	
	
	static {
		PATH = ".\\data\\memo.txt";
		mlist = new ArrayList<>();
	}
	
	
	public static void load() throws Exception { //load
		
		//memo.txt > ArrayList<Memo>
		BufferedReader reader = new BufferedReader(new FileReader(PATH));
		
		String line = null;
		
		while ((line = reader.readLine()) != null) {
			
			//line = "1●홍길동●메모입니다.●2025-01-02 12:05:40"
			// > Memo 객체
			String[] temp = line.split("●");
			
			Memo memo = new Memo(temp[0], temp[1], temp[2], temp[3]);
			mlist.add(memo);
			
		}
					
		reader.close();
		
	}

	public static void save() throws IOException {//중간에 저장못하면 날아감

		//ArrayList<Memo> > memo.txt
		BufferedWriter writer = new BufferedWriter(new FileWriter(PATH));
	
		for (Memo memo : mlist) {
			//Memo 객체
			//line = 1●홍길동●메모입니다.●2025-01-02 12:05:40
			writer.write(String.format("%s●%s●%s●%s\r\n"
						, memo.getSeq()
						, memo.getName()
						, memo.getMemo()
						, memo.getRegdate()
						));
		}
	
		writer.close();
	}

}

