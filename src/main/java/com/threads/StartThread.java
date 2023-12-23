package com.threads;

public class StartThread extends Thread{
	@Override
	public void run() {
		super.run();
		for(int i=10; i>0; i--)
		{
			System.out.println("Welcome,"+i);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
