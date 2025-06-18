package com.threads;

/**
 * @author NaveenWodeyar
 * @date 18-Jun-2025
 */

public class OuterThread extends Thread {

    @Override
    public void run() {
        System.out.println("Outer thread is running: " + Thread.currentThread().getName());

        // Creating inner thread inside the outer thread
        Thread innerThread = new Thread(() -> {
            System.out.println("Inner thread is running: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000); // Simulate some work
                System.out.println("Inner thread finished work");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        innerThread.start();

        try {
            innerThread.join();  // Wait for the inner thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Outer thread finished after inner thread");
    }

    public static void main(String[] args) {
        OuterThread outer = new OuterThread();
        outer.setName("Outer-Thread");
        outer.start();
    }
}
