package com.threads.debug;

public class Calci {
	public int add(int a, int b){
		return a+b;
	}
	
	public float prod(int a, int b) {
		return a*b;
	}
	
	@Override
	public String toString() {
//		return super.toString();
		return "Thread";
	}
}
