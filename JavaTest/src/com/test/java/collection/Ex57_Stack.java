package com.test.java.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex57_Stack {

	public static void main(String[] args) {
		
		
		/*
		  
		 	컬렉션
		 	- 순수 배열을 기반(일부 아닌 것도 있음)
		 	1. 사용법 개량
		 	2. 내부 구조 개량
		
			
			Stack
			- 후입선출
			- LIFO, Last input First output
			- 저장소(배열)에 나중에 들어간 요소가 먼저 나온다.
			ex) 출구막힌 파이프
			ex) 메모리 구조(Stack)
			ex) Ctrl + z, Ctrl + y
			ex) 뒤로가기, 앞으로가기
			
						
			Queue
			- 선입선출
			- FIFO, First input First output
			- 저장소(배열)에 먼저 들어간 요소가 먼저 나온다.
			ex) 줄서기
			
			
		*/
				
		//m1();
		m2();
		
	}//main

	private static void m2() {
		
		Stack<String> stack = new Stack<String>();
		Queue<String> queue = new LinkedList<String>();
		
		//1. 요소 추가하기
		//- boolean add(T value)
		queue.add("빨강"); //enqueue()
		queue.add("노랑"); //enqueue()
		queue.add("파랑"); //enqueue()
		
		
		//2. 요소 개수
		System.out.println(queue.size());
		
		
		//3. 요소 읽기(꺼내기)
//		System.out.println(queue.poll()); //dequeue()
//		System.out.println(queue.size());
//
//		System.out.println(queue.poll());
//		System.out.println(queue.size());
//
//		System.out.println(queue.poll());
//		System.out.println(queue.size());
//		
//		System.out.println(queue.poll());//에러가 안나옴

		while (queue.size() > 0) {
			System.out.println(queue.poll());
		}

		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
		//4. 구경하기
		System.out.println(queue.peek());
		
		
	}

	private static void m1() {
		
		//Stack
		Stack<String> stack = new Stack<String>();
		
		//1. 요소 추가하기
		//- T push(T value)
		stack.push("빨강");
		stack.push("노랑");
		stack.push("파랑");

		//2. 요소 개수
		//- int size()
		System.out.println(stack.size());
		
		//3. 요소 읽기
		//- T pop()
//		System.out.println(stack.pop());//후입선출 -> 파랑나와
//		System.out.println(stack.size());//꺼내기로 확인해야 볼 수 있음
//		
//		System.out.println(stack.pop());
//		System.out.println(stack.size());
//		
//		System.out.println(stack.pop());
//		System.out.println(stack.size());
//		
//		//EmptyStackException
//		if (!stack.isEmpty()) {
//			System.out.println(stack.pop());
//		}
		
//		int size = stack.size();
//		
//		for (int i=0; i<size; i++) { //stack.size -> 변수
//			System.out.println(stack.pop());
//		}
		
//		while (stack.size() > 0 ) {
//			System.out.println(stack.pop());
//		}
		
//		while(!stack.isEmpty()) {
//			System.out.println(stack.pop());
//		}
		
		//3. 빈 배열
		System.out.println(stack.isEmpty());
		
		//4. pop() 대상 요소 > 미리 보기
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.peek());//보고만 싶을 떄 쓰면 됨

		
		
	}
	
}//class






