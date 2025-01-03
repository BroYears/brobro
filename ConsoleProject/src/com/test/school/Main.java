package com.test.school;

import java.io.File;
import java.io.IOException;

import com.github.lalyos.jfiglet.FigletFont;
import com.test.school.repository.SchoolDAO;
import com.test.school.view.StudentView;

public class Main {

	public static void main(String[] args) throws Exception {
		SchoolDAO.load();
		
		//System.out.println(SchoolDAO.studentList.get(0));
		
		
		//특정 학생의 성적?
		//- 학생 > 본인의 성적
		//- 선생님 > 특정 학생의 성적
		StudentView.printScore(SchoolDAO.studentList.get(0).getSlist());
		
		//- 선생님 > 반 전체의 성적
		//StudentView.printScoreList(1, 1);
		
		//특정학생의 출결?
		//StudentView.printAttendance(SchoolDAO.studentList.get(0).getAlist());
		
		// using default font standard.flf, obtained from maven artifact
//	    String asciiArt1 = FigletFont.convertOneLine("hello");
//	    System.out.println(asciiArt1);
//	    
//	    // using font font2.flf, located somewhere in classpath under path /flf/font2.flf
//	    String asciiArt2 = FigletFont.convertOneLine(FigletFont.class.getResourceAsStream("/flf/font2.flf"), "hello");
//	    System.out.println(asciiArt2);
//	    
//	    asciiArt2 = FigletFont.convertOneLine("classpath:/flf/font2.flf", "hello");     
//	    System.out.println(asciiArt2);                
	    
//		File file = new File("flf\\cricket.flf");
//	    // using font font3.flf, located in file system under path /opt/font3.flf
//	    String asciiArt3 = FigletFont.convertOneLine(file, "hello");     
//	    System.out.println(asciiArt3);

//	    asciiArt3 = FigletFont.convertOneLine("/opt/font3.flf", "hello");     
//	    System.out.println(asciiArt3);

//	    // using font font4.flf, from www 
//	    String asciiArt4 = FigletFont.convertOneLine("http://myhost.com/font4.flf", "hello");     
//	    System.out.println(asciiArt4);                
		
		
		SchoolDAO.save();
		

	}
	
}
