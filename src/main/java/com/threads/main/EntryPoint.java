package com.threads.main;

import com.threads.RunnableThread;
import com.threads.StartThread;

public class EntryPoint {

	public static void main(String[] args) {
		StartThread t = new StartThread();
					t.start();					
		Thread t1 = new Thread(new RunnableThread());
				t1.start();
	}

}
