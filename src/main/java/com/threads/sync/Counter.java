package com.threads.sync;
/**
 * @author NaveenWodeyar
 * @date 01-Sept-2024
 */
public class Counter {
	
	private int count = 0;
	
	public synchronized void increment() {
		count++;
	}
	
	public void inCrement() {
		synchronized (this) {
			count++;			
		}
	}
	
	public int getCount() {
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("\nSYNCHRONIZATION\n");
	}
}
