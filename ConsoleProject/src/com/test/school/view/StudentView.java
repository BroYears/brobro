package com.test.school.view;

import java.util.List;

import com.test.schhol.domain.Attendance;
import com.test.schhol.domain.Score;
import com.test.school.repository.SchoolDAO;
import com.test.school.student.Student;

public class StudentView {

	public static void printScore(List<Score> slist) {

		for (Score s: slist) {
			System.out.println(s);
		}
		
	}

	public static void printScoreList(int grade, int classNumber) {


		for (Student s : SchoolDAO.studentList) {
			
			if (s.getGrade() == grade && s.getClassNumber() == classNumber) {
				System.out.println(s.getSlist());
			}
		}
		
		
	}

	public static void printAttendance(List<Attendance> alist) {
		
		for (Attendance a : alist) {
			
			System.out.println(a);
			
		}

		
	}

}
