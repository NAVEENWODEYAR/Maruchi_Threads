package com.threads.main;

/**
 * @author NaveenWodeyar
 * @date 26-Apr-2025
 */

class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread running: " + i);
            System.out.println( 
                    "Current Thread Name: "
                    + Thread.currentThread().getName()); 
            try {
                Thread.sleep(500); // Sleep for 0.5 seconds
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
    
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // Start the thread
        System.out.println(t1);
    }
}

