package com.threads.sync;

/**
 * @author NaveenWodeyar
 * @date 01-Sept-2024
 */

public class Test {

	public static void main(String[] args) {
		Counter counter = new Counter();
		
		MyThread t1 = new MyThread(counter);
		MyThread t2 = new MyThread(counter);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
			System.out.println("Exception occurred"+e);
			e.printStackTrace();
		}
		System.out.println(counter.getCount());
	}

}
