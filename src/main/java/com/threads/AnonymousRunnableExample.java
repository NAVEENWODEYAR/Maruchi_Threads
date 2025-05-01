package com.threads;

/**
 * @author NaveenWodeyar
 * @date 01-May-2025
 */

public class AnonymousRunnableExample {
	public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        Thread[] threads = new Thread[100];

        for (int i = 0; i < 100; i++) {
            int id = i + 1;
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    for (int j = 1; j <= 500; j++) {
                        System.out.println("Anonymous Thread " + id + " - Count: " + j);
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            System.out.println("Interrupted: " + e);
                        }
                    }
                }
            });
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread t : threads) {
            t.join();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken (ms): " + (endTime - startTime));
        System.out.println("Total time taken (seconds): " + ((endTime - startTime) / 1000.0));
    }
}

