package com.greatlearning.balancingBracket.service;

import java.util.Arrays;

public class Stack {
	
	String[] myStack;
	int top;
	public Stack(int len) {
		this.myStack = new String[len];
		this.top = -1;
	}
	
	public boolean isFull() {
		return (this.myStack.length == this.top-1);
	}
	
	public void push(String c) {
		if(this.isFull()) {
			System.out.println("Stack is full");
		}
		else {
			this.top++;
			this.myStack[top] = c;
		}
		//System.out.println(Arrays.toString(this.myStack));
	}	
	public String pop() {
		if(this.isEmpty()) {
			//System.out.println("Stack underflow");
			return null;
			
		}
		else {
			String tmp;
			//System.out.println(Arrays.toString(this.myStack));
			tmp = this.myStack[top];
			this.myStack[top] = null;
			this.top--;
			return tmp;
		}
		
		
		
	}

	private boolean isEmpty() {
		return this.top == -1;
	}
			
	

}
