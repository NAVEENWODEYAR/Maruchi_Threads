package com.threads;

public class RunnableThread implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<2; i++)
		{
			System.out.println("\nRunnable,"+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println(e.getClass());
			}
		}	
		System.out.println(Thread.currentThread());
	}

}
