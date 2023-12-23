package com.threads;

public class StartThread extends Thread{
	@Override
	public void run() {
		super.run();
		System.out.println("Inside run(),");
	}
}
