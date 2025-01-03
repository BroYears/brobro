package com.test.schhol.domain;

import java.util.Calendar;

public class Attendance {
	
	
	private Calendar inTime;
	private Calendar outTime;
	private String state;
	private String reason;
	private int student_seq;
	
	public Attendance(Calendar inTime, Calendar outTime, String state, String reason, int student_seq) {
		super();
		this.inTime = inTime;
		this.outTime = outTime;
		this.state = state;
		this.reason = reason;
		this.student_seq = student_seq;
	}

	public Calendar getInTime() {
		return inTime;
	}

	public void setInTime(Calendar inTime) {
		this.inTime = inTime;
	}

	public Calendar getOutTime() {
		return outTime;
	}

	public void setOutTime(Calendar outTime) {
		this.outTime = outTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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
		builder.append("Attendance [inTime=")
				.append(String.format("%tF %tT", inTime, inTime))
				.append(", outTime=")
				.append(String.format("%tF %tT", outTime, outTime))
				.append(", state=")
				.append(state)
				.append(", reason=")
				.append(reason)
				.append(", student_seq=")
				.append(student_seq)
				.append("]");
		return builder.toString();
	}
	
	
	
	
}
