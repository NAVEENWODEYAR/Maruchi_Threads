package com.threads;

/**
 * @author NaveenWodeyar
 * @date 18-Jun-2025
 */

public class MultiThreadExample {

    // Inner worker thread class
    static class InnerWorker extends Thread {
        private int id;

        public InnerWorker(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("Inner Thread " + id + " is running: " + Thread.currentThread().getName());
            try {
                Thread.sleep(500); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Inner Thread " + id + " finished.");
        }
    }

    // Outer thread that creates inner threads
    static class OuterThread extends Thread {

        @Override
        public void run() {
            System.out.println("Outer thread is running: " + Thread.currentThread().getName());

            // Start multiple inner threads
            for (int i = 1; i <= 3; i++) {
                InnerWorker worker = new InnerWorker(i);
                worker.start();
                try {
                    worker.join(); // Optional: wait for each to finish before starting next
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Outer thread finished after all inner threads.");
        }
    }

    public static void main(String[] args) {
        OuterThread outer = new OuterThread();
        outer.setName("Outer-Thread");
        outer.start();
    }
}
