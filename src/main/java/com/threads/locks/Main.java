package com.threads.locks;
/**
 * @author NaveenWodeyar
 * @date 01-Sept-2024
 */
public class Main {

	public static void main(String[] args) {

		BankAccount sbi = new BankAccount();
		Runnable task = new Runnable() {
			@Override
			public void run() {
				sbi.withDraw(500);
			}
		};
		
		Thread t1 = new Thread(task,"Thread_1");
		Thread t2 = new Thread(task,"Thread_2");
		t1.start();
		t2.start();
	}
}
