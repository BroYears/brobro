package com.test.school.common;

import java.util.List;

import com.test.schhol.domain.Attendance;
import com.test.schhol.domain.Score;

public abstract class SchoolMember {

	private String name;
	
	public SchoolMember(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract List<Score> getScroe();
	public abstract List<Attendance> getAttendance();
	
	
}
