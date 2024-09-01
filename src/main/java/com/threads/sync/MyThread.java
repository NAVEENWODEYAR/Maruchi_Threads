package com.threads.sync;

import java.util.Iterator;

/**
 * @author NaveenWodeyar
 * @date 01-Sept-2024
 */
public class MyThread extends Thread {

	private Counter counter;
	
	public MyThread(Counter counter) {
		this.counter = counter;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			counter.increment();
			counter.inCrement();
		}
	}
}
