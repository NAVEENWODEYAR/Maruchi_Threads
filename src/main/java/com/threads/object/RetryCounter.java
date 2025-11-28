package com.threads.object;

/**
 * @author NaveenWodeyar
 * @date 28-Nov-2025
 */

public class RetryCounter {

    private final int maxRetries;
    private int attempts;

    public RetryCounter(int maxRetries) {
        if (maxRetries < 0) {
            throw new IllegalArgumentException("maxRetries must be >= 0");
        }
        this.maxRetries = maxRetries;
        this.attempts = 0;
    }

    public int getAttempts() {
        return attempts;
    }

    public boolean canRetry() {
        return attempts < maxRetries;
    }

    /**
     * Attempts to run a task with retry logic.
     *
     * @param task  A functional interface representing a task that may fail
     * @throws Exception if all retries fail
     */
    public void executeWithRetry(RetriableTask task) throws Exception {
        Exception lastException = null;

        while (canRetry()) {
            attempts++;
            try {
                task.run();
                return;   // success
            } catch (Exception e) {
                lastException = e;
            }
        }

        throw lastException;
    }

    @FunctionalInterface
    public interface RetriableTask {
        void run() throws Exception;
    }
}
