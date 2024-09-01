package com.threads.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author NaveenWodeyar
 * @date 01-Sept-2024
 */
public class UnFairLockExample {

	private final Lock unFairLock = new ReentrantLock();
	
	public void accessResource() {
		unFairLock.lock();
		try {
			System.out.println(Thread.currentThread().getName()+",acquired the lock");
			Thread.sleep(1000);
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}finally {
			unFairLock.unlock();
			System.out.println(Thread.currentThread().getName()+",released the lock,");
			
		}
	}
	
	public static void main(String[] args) {

		UnFairLockExample unFairLockExample = new UnFairLockExample();
		
		Runnable task = new Runnable() {
			@Override
			public void run() {
				unFairLockExample.accessResource();
			}
		};
		Thread t1 = new Thread(task,"Thread_1");
		Thread t2 = new Thread(task,"Thread_2");
		Thread t3 = new Thread(task,"Thread_3");
		Thread t4 = new Thread(task,"Thread_4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
