package com.threads.main;

import com.threads.DeamonThreadEx;
import com.threads.RunnableThread;
import com.threads.StartThread;

public class EntryPoint {
	
	public static void main(String[] args) {
		StartThread t = new StartThread();
					t.start();	
		System.out.println(t.getName());
					t.setName("START:THREAD");
		System.out.println(t.getName());
		
		Thread t1 = new Thread(new RunnableThread());
				t1.start();
				t1.setName("RUNNABLE:THREAD");
		System.out.println(t1.getName());
		
		DeamonThreadEx dt = new DeamonThreadEx();
		System.out.println(dt.isDaemon());
		System.out.println(t.isAlive());
	}

}
