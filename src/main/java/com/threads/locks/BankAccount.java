package com.threads.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author NaveenWodeyar
 * @date 01-Sept-2024
 */
public class BankAccount {

	private int balance = 1000;

	private final Lock lock = new ReentrantLock();

	/*
	 * using synchronized block(intrinsic lock) public synchronized void
	 * withDraw(int amount) { System.out.println(Thread.currentThread().getName()
	 * +",attempting to withdraw amount "+amount);
	 * 
	 * if (balance >= amount) { System.out.println(Thread.currentThread().getName()
	 * +" proceeding with the withdrawal"); try { Thread.sleep(3000); } catch
	 * (InterruptedException e) { e.printStackTrace(); } balance -= amount;
	 * System.out.println(Thread.currentThread().getName()+" Remaining balance "
	 * +balance); }else {
	 * System.out.println(Thread.currentThread().getName()+" insufficient balance");
	 * } }
	 */

	public void withDraw(int amount) {
		System.out.println(Thread.currentThread().getName() + ",attempting to withdraw amount " + amount);

		try {
			if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
				if (balance >= amount) {
					try {
						System.out.println(Thread.currentThread().getName() + " proceeding with the withdrawal");
						Thread.sleep(3000);
						balance -= amount;
						System.out.println(Thread.currentThread().getName() + " Remaining balance " + balance);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						lock.unlock();
					}
				} else {
					System.out.println(Thread.currentThread().getName() + " insufficient balance");
				}
			} else {
				System.out.println(Thread.currentThread().getName() + ",couldn't acquire the lock");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
}
