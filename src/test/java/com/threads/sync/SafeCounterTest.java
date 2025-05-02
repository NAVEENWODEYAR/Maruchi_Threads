package com.threads.sync;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author NaveenWodeyar
 * @date 02-May-2025
 */

public class SafeCounterTest {

    @Test
    public void testSafeCounterMainMethod() throws Exception {
        // Reset the static counter to 0 using reflection before the test
        Field counterField = SafeCounter.class.getDeclaredField("counter");
        counterField.setAccessible(true);
        AtomicInteger counter = (AtomicInteger) counterField.get(null);
        counter.set(0);

        // Call the main method
        SafeCounter.main(null);

        // Verify the final counter value
        assertEquals(2000, counter.get(), "Counter should be 2000 after both threads finish.");
    }
}
