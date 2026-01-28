package com.threads;

/**
 * @author NaveenWodeyar
 * @date 27-Jan-2026
 */

class LengthCounter extends Thread {
    private String part;
    private int count;

    LengthCounter(String part) {
        this.part = part;
    }

    public void run() {
        count = part.length();
    }

    public int getCount() {
        return count;
    }
}

public class StringLengthUsingThreads {
    public static void main(String[] args) throws InterruptedException {

        String text = "MultithreadingInJava";

        // Split string into 3 parts
        int n = text.length();
        String part1 = text.substring(0, n / 3);
        String part2 = text.substring(n / 3, 2 * n / 3);
        String part3 = text.substring(2 * n / 3);

        LengthCounter t1 = new LengthCounter(part1);
        LengthCounter t2 = new LengthCounter(part2);
        LengthCounter t3 = new LengthCounter(part3);

        // Start threads
        t1.start();
        t2.start();
        t3.start();

        // Wait for threads to finish
        t1.join();
        t2.join();
        t3.join();

        int totalLength = t1.getCount() + t2.getCount() + t3.getCount();

        System.out.println("String: " + text);
        System.out.println("Total Length: " + totalLength);
    }
}
