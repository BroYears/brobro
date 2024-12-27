package com.test.java.file;

public class Score {

	
	//1.1,홍길동,100,90,80
	private String no;
	private String name;
	private int kor;
	private int eng;
	private int math;

	public Score(String no, String name, int kor, int eng, int math) {
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	public int getTotal() {
		return kor + eng + math;
	}
	
	public double getAvg() {
		return (kor + eng + math) / 3.0;
	}
}
