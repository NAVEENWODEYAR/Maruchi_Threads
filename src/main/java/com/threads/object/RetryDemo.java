package com.threads.object;

/**
 * @author NaveenWodeyar
 * @date 28-Nov-2025
 */

public class RetryDemo {
    public static void main(String[] args) {
        RetryCounter counter = new RetryCounter(3);

        try {
            counter.executeWithRetry(() -> {
                System.out.println("Attempt " + counter.getAttempts());
                if (counter.getAttempts() < 3) {
                    throw new RuntimeException("Simulated failure");
                }
            });
            System.out.println("Task completed successfully!");
        } catch (Exception e) {
            System.out.println("Task failed after retries: " + e.getMessage());
        }
    }
}
