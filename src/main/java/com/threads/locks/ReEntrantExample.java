package com.threads.locks;
/**
 * @author NaveenWodeyar
 * @date 01-Sept-2024
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantExample {
	
	private final Lock lock = new ReentrantLock();
	
	public void outerMethod() {
		lock.lock();
		try {
			System.out.println("Outer Method");
			innerMethod();
		} finally  {
			lock.unlock();
		}
	}
	
	public void innerMethod() {
		lock.lock();
		try {
			System.out.println("Inner Method");
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		ReEntrantExample entrantExample = new ReEntrantExample();
		entrantExample.outerMethod();
	}

}
