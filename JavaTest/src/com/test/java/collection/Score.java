package com.test.java.collection;

public class Score {

	//번호, 학생명, 국어, 영어, 수학, 총점, 평균
	private int seq;
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	private int total; //-> 계산해야되는 부분은 업무 상황봐서 하자
	private double avg;
	
	public Score(int seq, String name, int kor, int eng, int math) {
		this.seq = seq;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		calc();		
	}

	private void calc() {
		this.total = this.kor + this.eng + this.math;
		this.avg = this.total /3.0;
	}

	public void setKor(int kor) {
		this.kor = kor;
		calc();
	}

	public void setEng(int eng) {
		this.eng = eng;
		calc();
	}

	public void setMath(int math) {
		this.math = math;
		calc();
	}

	public int getSeq() {
		return seq;
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
		return total;
	}

	public double getAvg() {
		return avg;
	}
	
	
	
	
}
