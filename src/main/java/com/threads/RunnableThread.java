package com.threads;

public class RunnableThread implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<10; i++)
		{
			System.out.println("Thread,"+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println(e.getClass());
			}
		}	
	}

}
