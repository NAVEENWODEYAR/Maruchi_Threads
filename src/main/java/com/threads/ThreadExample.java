package com.threads;

/**
 * @author NaveenWodeyar
 * @date 16-May-2025
 */

public class ThreadExample extends Thread {
    public void run() {
        System.out.println("Running in: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadExample t = new ThreadExample();
        t.run();  // Runs in main thread
        t.start(); // Runs in new thread
    }
}

