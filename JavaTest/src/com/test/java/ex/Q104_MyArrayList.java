package com.test.java.ex;

import java.util.Arrays;

public class Q104_MyArrayList {

	private String[] list;
	private int index; //역할? > 현재 데이터가 들어갈 방번호
	
	public Q104_MyArrayList() {
		this.list = new String[4];
		this.index = 0;
	}

	@Override
	public String toString() {
		
		String temp = "";
		
		temp += "\r\n";
		temp += String.format("length: %d\r\n", this.list.length);
		temp += String.format("index: %d\r\n", this.index);
		temp += "[\r\n";
		for (int i=0; i<this.list.length; i++) {
			temp += String.format("\t%d: %s,\r\n", i, this.list[i]);
		}
		temp += "]";
		temp += "\r\n";
		
		
		return temp;
	}

	public void add(String s) {
		
		//남는 공간이 있는지 확인?
		//1. 없다면 > 공간 x2 
		//2. 있다면 > x
		if (checkLength()) {
			doubleList();
		}
		
		this.list[this.index] = s;
		this.index++;
		
		
	}

	private void doubleList() {
		
		String[] temp = new String[this.list.length * 2];
		
		for (int i=0; i<this.list.length;i++) {
			temp[i] = this.list[i];//깊은 복사
		}
		
		this.list = temp;//배열 교체
		
	}

	private boolean checkLength() {
		//배열에 남는 공간이 있는지? index = length면 자리 없음
		
		if (this.list.length == this.index) {
			return true;
		}
		
		
		return false;
	}

	public String get(int index) {
		
		//list.get(0);
		
		
		return this.list[index];
	}

	
	public int size() {
				
		return this.index;
	}
	
	
	
}
