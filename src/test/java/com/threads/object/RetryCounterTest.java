/**
 * @author NaveenWodeyar
 * @date 28-Nov-2025
 */
package com.threads.object;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RetryCounterTest {

    @Test
    void testSuccessBeforeMaxRetries() throws Exception {
        RetryCounter counter = new RetryCounter(3);

        counter.executeWithRetry(() -> {
            if (counter.getAttempts() < 2) {
                throw new RuntimeException("Fail first");
            }
        });

        assertEquals(2, counter.getAttempts());
    }

    @Test
    void testFailsAfterMaxRetries() {
        RetryCounter counter = new RetryCounter(2);

        Exception exception = assertThrows(Exception.class, () ->
            counter.executeWithRetry(() -> {
                throw new RuntimeException("Always fail");
            })
        );

        assertEquals("Always fail", exception.getMessage());
        assertEquals(2, counter.getAttempts());
    }

    @Test
    void testZeroMaxRetries() {
        RetryCounter counter = new RetryCounter(0);
        assertFalse(counter.canRetry());
    }

    @Test
    void testNegativeRetriesThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RetryCounter(-1);
        });
    }
}
