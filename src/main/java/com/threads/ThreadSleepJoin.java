/**
 * @author NaveenWodeyar
 * @date 16-May-2025
 */
package com.threads;

public class ThreadSleepJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread done sleeping.");
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        });

        t.start();
        t.join(); // Waits for thread to finish
        System.out.println("Main thread continues.");
    }
}
