package com.test.schhol.domain;

public class Score {

	private int kor;
	private int eng;
	private int math;
	private String type;
	
	private int student_seq;

	public Score(int kor, int eng, int math, String type, int student_seq) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.type = type;
		this.student_seq = student_seq;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStudent_seq() {
		return student_seq;
	}

	public void setStudent_seq(int student_seq) {
		this.student_seq = student_seq;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Score [kor=")
				.append(kor)
				.append(", eng=")
				.append(eng)
				.append(", math=")
				.append(math)
				.append(", type=")
				.append(type)
				.append(", student_seq=")
				.append(student_seq)
				.append("]");
		return builder.toString();
	}
	
	
	
}
