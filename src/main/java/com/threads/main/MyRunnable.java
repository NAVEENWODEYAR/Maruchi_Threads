package com.threads.main;

/**
 * @author NaveenWodeyar
 * @date 26-Apr-2025
 */

class MyRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Runnable thread: " + i);
            System.out.println( 
                    "Current Thread Name: "
                    + Thread.currentThread().getName()); 
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());
        t1.start();
        t2.start();
    }
}
