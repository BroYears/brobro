package com.test.school.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;

import com.test.schhol.domain.Attendance;
import com.test.schhol.domain.Score;
import com.test.school.staff.Staff;
import com.test.school.student.Student;
import com.test.school.teacher.Teacher;



public class SchoolDAO {

	
	private final static String 교직원;
	private final static String 선생님;
	private final static String 성적;
	private final static String 출결;
	private final static String 학생;
	
	//컬렉션
	public static ArrayList<Student> studentList;
	public static ArrayList<Teacher> teacherList;
	public static ArrayList<Staff> staffList;
	
	
	static {
		교직원 = ".\\data\\교직원.txt";
		선생님 = ".\\data\\선생님;.txt";
		성적 = ".\\data\\성적.txt";
		출결 = ".\\data\\출결.txt";
		학생 = ".\\data\\학생.txt";
		
		studentList = new ArrayList<Student>();
		teacherList = new ArrayList<Teacher>();
		staffList = new ArrayList<Staff>();
		
	}

	public static void load() {

		try {
			
			
			BufferedReader reader = new BufferedReader(new FileReader(학생));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
			
				String[] temp = line.split(",");
				
				Student student = new Student(Integer.parseInt(temp[0]), 
											Integer.parseInt(temp[2]), 
											Integer.parseInt(temp[3]), 
											Integer.parseInt(temp[4]), 
											temp[1], null, null);
				
				studentList.add(student);
			}
				
			reader.close();
				
			//성적정보
			ArrayList<Score> scoreList = new ArrayList<Score>();
			reader = new BufferedReader(new FileReader(성적));
			
			line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				Score score = new Score(Integer.parseInt(temp[0]), 
										Integer.parseInt(temp[1]), 
										Integer.parseInt(temp[2]), 
										temp[3], 
										Integer.parseInt(temp[4]));
				
				scoreList.add(score);
			}
			
			reader.close();
				
			for (Student st : studentList) {
				
				st.setSlist(new ArrayList<Score>());
				st.setAlist(new ArrayList<Attendance>());
				
				int no = st.getNo();
				
				for (Score sc : scoreList) {
					if (sc.getStudent_seq() == no) {
						st.getSlist().add(sc); //학생의 성적을 학생에게 추가
						
					}
				}
				
			}
				
			//while
				
			ArrayList<Attendance> attendanceList = new ArrayList<Attendance>();
			reader = new BufferedReader(new FileReader(출결));
			
			line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				//2025-01-03 09:00:00,2025-01-03 15:00:00,정상,없음,1
				
				//2025-01-03 09:00:00
				Calendar inTime = Calendar.getInstance();
				inTime.set(Calendar.YEAR, Integer.parseInt(temp[0].substring(0, 4)));
				inTime.set(Calendar.MONTH, Integer.parseInt(temp[0].substring(5, 7)) - 1 );
				inTime.set(Calendar.DATE, Integer.parseInt(temp[0].substring(8, 10)));
				inTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(temp[0].substring(11, 13)));
				inTime.set(Calendar.MINUTE, Integer.parseInt(temp[0].substring(14, 16)));
				inTime.set(Calendar.SECOND, Integer.parseInt(temp[0].substring(17)));
				
				Calendar outTime = Calendar.getInstance();
				outTime.set(Calendar.YEAR, Integer.parseInt(temp[1].substring(0, 4)));
				outTime.set(Calendar.MONTH, Integer.parseInt(temp[1].substring(5, 7)) - 1 );
				outTime.set(Calendar.DATE, Integer.parseInt(temp[1].substring(8, 10)));
				outTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(temp[1].substring(11, 13)));
				outTime.set(Calendar.MINUTE, Integer.parseInt(temp[1].substring(14, 16)));
				outTime.set(Calendar.SECOND, Integer.parseInt(temp[1].substring(17)));
				
				String state = temp[2];
				String reason = temp[3];
				int no = Integer.parseInt(temp[4]);
				
				
				Attendance attendance = new Attendance(inTime, outTime, state, reason, no);
				attendanceList.add(attendance);
			}
			
			reader.close();
			
			for (Student st: studentList) {
			
				int no = st.getNo();
				
				for (Attendance at : attendanceList) {
					if (at.getStudent_seq() == no) {
						st.getAlist().add(at);
					}
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void save() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
