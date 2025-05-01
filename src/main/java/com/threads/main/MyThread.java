package com.threads.main;

/**
 * @author NaveenWodeyar
 * @date 26-Apr-2025
 */

class MyThread extends Thread {
    private int threadId;

    public MyThread(int id) {
        this.threadId = id;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread " + threadId + " - Count: " + i +
                ", Thread Name: " + Thread.currentThread().getName());
            try {
                Thread.sleep(500); // Sleep for 0.5 seconds
            } catch (InterruptedException e) {
                System.out.println("Thread " + threadId + " interrupted: " + e);
            }
        }
    }

    public static void main(String[] args) {
        MyThread[] threads = new MyThread[6];

        // Create and start threads
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread(i + 1);
            threads[i].start();
        }

        // Join all threads to ensure main waits for completion
        for (MyThread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Join interrupted: " + e);
            }
        }

        System.out.println("All threads finished.");
    }
}
