package com.threads.object;

/**
 * @author NaveenWodeyar
 * @date 28-May-2025
 */

public class ThreadObjectDemo {

    static class BankAccount {
        private int balance = 100;

        // Withdraw without synchronization — can cause race condition
        public void withdraw(String threadName, int amount) {
            if (balance >= amount) {
                System.out.println(threadName + " is going to withdraw " + amount);
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}

                balance -= amount;
                System.out.println(threadName + " completed withdrawal. Remaining: " + balance);
            } else {
                System.out.println(threadName + " tried to withdraw but insufficient funds!");
            }
        }

        // Uncomment this method to fix it
		/*
		 * public synchronized void withdraw(String threadName, int amount) { if
		 * (balance >= amount) { System.out.println(threadName +
		 * " is going to withdraw " + amount); try { Thread.sleep(100); } catch
		 * (InterruptedException ignored) {}
		 * 
		 * balance -= amount; System.out.println(threadName +
		 * " completed withdrawal. Remaining: " + balance); } else {
		 * System.out.println(threadName +
		 * " tried to withdraw but insufficient funds!"); } }
		 */

        public int getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount();

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            sharedAccount.withdraw(threadName, 75);
        };

        Thread t1 = new Thread(task, "Alice");
        Thread t2 = new Thread(task, "Bob");

        t1.start();
        t2.start();
    }
}
