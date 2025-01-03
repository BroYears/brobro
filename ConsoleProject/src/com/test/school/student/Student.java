package com.test.school.student;

import java.util.List;

import com.test.schhol.domain.Attendance;
import com.test.schhol.domain.Score;
import com.test.school.common.SchoolMember;

/**
 * 학생 정보를 저장하는 클래스
 */

public class Student extends SchoolMember {

		private int no; 				//일련번호
		private int grade; 				//학년
		private int classNumber; 		//반
		private int number;				//번호
		private List<Score> slist; 		//성적
		private List<Attendance> alist; //출결
	
		//생성자 > 기본생성자 + 오버로딩
		public Student() {
			this(0, 0, 0, 0, null, null, null);
		}
		
		
		public Student(int no, int grade, int classNumber, int number, String name, List<Score> slist, List<Attendance> alist) {
			
			super(name);
			
			this.no = no;
			this.grade = grade;
			this.classNumber = classNumber;
			this.number = number;
			this.slist = slist;
			this.alist = alist;
		}


		public int getNo() {
			return no;
		}


		public void setNo(int no) {
			this.no = no;
		}


		public int getGrade() {
			return grade;
		}


		public void setGrade(int grade) {
			this.grade = grade;
		}


		public int getClassNumber() {
			return classNumber;
		}


		public void setClassNumber(int classNumber) {
			this.classNumber = classNumber;
		}


		public String getName() {
			return super.getName();
		}


		public void setName(String name) {
			super.setName(name);
		}


		public List<Score> getSlist() {
			return slist;
		}


		public void setSlist(List<Score> slist) {
			this.slist = slist;
		}


		public List<Attendance> getAlist() {
			return alist;
		}


		public void setAlist(List<Attendance> alist) {
			this.alist = alist;
		}


		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Student [no=")
					.append(no)
					.append(", grade=")
					.append(grade)
					.append(", classNumber=")
					.append(classNumber)
					.append(", number")
					.append(number)
					.append(", name=")
					.append(getName())
					.append(", slist=")
					.append(slist)
					.append(", alist=")
					.append(alist)
					.append("]");
			return builder.toString();
		}


		@Override
		public List<Score> getScroe() {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public List<Attendance> getAttendance() {
			// TODO Auto-generated method stub
			return null;
		}
		
}
