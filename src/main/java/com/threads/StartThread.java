package com.threads;

public class StartThread extends Thread{
	@Override
	public void run() {
		super.run();
		for(int i=10; i>0; i--)
		{
			System.out.println("\nThread,"+i);
			try {
				Thread.sleep(000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
